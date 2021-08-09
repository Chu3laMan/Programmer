package classes.programmerEngine.controllers.signIn;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import classes.programmerEngine.business.Programmer_2;
import classes.programmerEngine.business.Programming_Language;
import classes.programmerEngine.data.ProgrammerDB;
import classes.programmerEngine.util.PasswordUtil;

/**
 * Servlet implementation class SignInServlet
 */

public class SignInServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignInServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = null;
		String action = request.getParameter("action");
		if(action == null)
			action = "join";
		if(action.equals("add")) {
			url = programmerLogin(request, response);
		}
		
		getServletContext().getRequestDispatcher(url).forward(request, response);
		
	}
	
	public String programmerLogin(HttpServletRequest request, HttpServletResponse response) {
		
		String url = null;
		String message = null;
		HttpSession session = request.getSession();
		Programmer_2 programmer2 = null;
		String lang = null;
		String fwk = null;
		
		String email = request.getParameter("username");
		String originalPassword = request.getParameter("pswd");
		
		try {
			String getHashedAndSaltedPassword = (PasswordUtil.hashPassword(originalPassword) + ProgrammerDB.getSalted(email)).trim();
			String retrievePswd = ProgrammerDB.getPswd(email);
			if(!getHashedAndSaltedPassword.equals(retrievePswd)) {
				url = "/includes/login.jsp";
				message = "Check whether the email address or password.";
			}else if(!ProgrammerDB.checkEmail(email)) {
				url = "/includes/login.jsp";
				message = "Check whether the email address or password.";
			}else if(!getHashedAndSaltedPassword.equals(retrievePswd)|| !ProgrammerDB.checkEmail(email)) {
				url = "/includes/login.jsp";
				message = "Check whether the email address or password.";
			}else {
				if(getHashedAndSaltedPassword.equals(retrievePswd) && ProgrammerDB.checkEmail(email)) {
					url = "/includes/pgmr_profile.jsp";
					programmer2 = ProgrammerDB.selectUser(email);
					lang = programmer2.getProgrammingLanguage();
					fwk = programmer2.getFramework();
					message = "";
				}
			}
				
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		session.setAttribute("fwk", fwk);
		session.setAttribute("lang", lang);
		session.setAttribute("programmer2", programmer2);
		session.setAttribute("message", message);
		
		return url;
		
	}

}
