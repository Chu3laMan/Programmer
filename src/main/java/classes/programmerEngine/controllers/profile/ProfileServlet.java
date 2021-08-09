package classes.programmerEngine.controllers.profile;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import classes.programmerEngine.business.Framework;
import classes.programmerEngine.business.Programmer_2;
import classes.programmerEngine.business.Programming_Language;
import classes.programmerEngine.data.ProgrammerDB;
import classes.programmerEngine.util.PasswordUtil;

/**
 * Servlet implementation class ProfileServlet
 */

public class ProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProfileServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = null;
		HttpSession session = request.getSession(false);
		//control the search button
		String action = request.getParameter("action2");
		if(action == null)
			action = "join";
		else if(action.equals("search")) {
			url = "/includes/index.jsp";
		}
	    //control the logout button;
		String action2 = request.getParameter("action3");
		if(action2 == null)
			action2 = "join";
		else if(action2.equals("logout")) {
			if(session != null) {
				session.invalidate();
				url = "/includes/login.jsp";
			}
		}
		
		
		getServletContext().getRequestDispatcher(url).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		String url = null;
		if(action == null)
			action = "join";
		else if(action.equals("add")) {
			try {
				url = updateProgrammer(request, response);
			} catch (NoSuchAlgorithmException e) {
				System.err.println(e);
			} 
		}
		
		getServletContext().getRequestDispatcher(url).forward(request, response);	
	}
	
	
	public String updateProgrammer(HttpServletRequest request, HttpServletResponse response) throws NoSuchAlgorithmException {
		Programmer_2 programmer = null;
		String url = null ;
		String message = null;
		HttpSession session = request.getSession(false);
		//get parameters from the request
	    String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String confirmPassword = request.getParameter("confirm_password");
		String lang = request.getParameter("lang");
		String framework_name = request.getParameter("fwk");
		String github_account = request.getParameter("github_account");
		String saltPswd = PasswordUtil.getSalt();
		String hashAndSaltPassword = (PasswordUtil.hashPassword(password) + saltPswd).trim();
		
		if(password.equals(confirmPassword)) {
			programmer = new Programmer_2(firstName, lastName, email, hashAndSaltPassword, github_account, saltPswd, lang, framework_name);
			ProgrammerDB.update(programmer);
			if(session != null) {
				session.invalidate();
				url = "/includes/login.jsp";
				message = "Update was successful.";
			}
		}else {
			message = "Password does not match.";
			url = "/includes/pgmr_profile.jsp";
		}
		
		request.setAttribute("message", message);
		return url;
		
		
	}
	
	
	
	
	
	
	
	
	

}
