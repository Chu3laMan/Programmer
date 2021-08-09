package classes.programmerEngine.business.controller.forget;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import classes.programmerEngine.data.ProgrammerDB;
import classes.programmerEngine.util.PasswordUtil;

/**
 * Servlet implementation class SetupPassword
 */

public class SetupPassword extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SetupPassword() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		String url;
		if(action == null)
			action = "null";
		else if(action.equals("add")) {
			String pswd = request.getParameter("pswd");
			String confirm_pswd = request.getParameter("confirm_pswd");
			
			if(pswd.equals(confirm_pswd)) {
				String saltPswd;
				try {
					saltPswd = PasswordUtil.getSalt();
					String hashAndSaltPassword = (PasswordUtil.hashPassword(pswd) + saltPswd).trim();
					
				} catch (NoSuchAlgorithmException e) {
					e.printStackTrace();
				}
				
			}
		}
	}

}
