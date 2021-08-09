package classes.programmerEngine.controllers.signup;

import java.io.IOException;

import javax.servlet.ServletException;
//import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import classes.programmerEngine.business.Framework;
import classes.programmerEngine.business.Programmer_2;
import classes.programmerEngine.business.Programming_Language;
import classes.programmerEngine.data.ProgrammerDB;
//import classes.programmerEngine.util.MailUtil;
import classes.programmerEngine.util.PasswordUtil;

/**
 * Servlet implementation class Signup2Servlet
 */

public class Signup2Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Signup2Servlet() {
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
		String url = null;
		//get current action
		if(action == null)
			action = "join";
		if(action.equals("add")) {
			try {
				url = registerProgrammer(request, response);
			} catch (Exception e) {
				System.err.println(e);

			}
		}
			
		//forward the user to successfully registration page
		getServletContext().getRequestDispatcher(url).forward(request, response);	
					
	}
	
	public String registerProgrammer(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
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
		
		Programmer_2 programmer2 = null;
		Programming_Language programmingLanguage = null;
		Framework framework = null;
		String message;
		String url;
		
		//data validation
		if(!password.equals(confirmPassword)) {
			url = "/includes/registration_2.jsp";
			message = "Password does not match.";
		}else if(password.length() < 8) {
			url = "/includes/registration_2.jsp";
			message = "Weak Password.";
		}else if(ProgrammerDB.checkEmail(email)) {
			url = "/includes/registration_2.jsp";
			message = "This email address already exists.";
		}
		else {
			message = "";
			//store data in Programmer_2 object
			programmer2 = new Programmer_2(firstName, lastName, email, hashAndSaltPassword, github_account, saltPswd);
			//store data in Programming_Language object
			programmingLanguage = new Programming_Language(lang);
			//store data in Framework object
			framework = new Framework(framework_name);
			//store programmer2 into programmersDB's programmersDetail
			ProgrammerDB.insert(programmer2);
			//store programmingLanguage into ProgrammersDB's programming_language
			ProgrammerDB.insertProgrammingLang(programmingLanguage);
			//store programmingLanguage into ProgrammersDB's programmer_framework
			ProgrammerDB.insertFramework(framework);
			/**
			String to = email;
			String from = "elmansouri.houssam@gmail.com";
			String subject = "Welcome to our Programmer Web site";
			String body = "Dear " + firstName + " " + lastName + ", \n\n"
					+ "Thanks for joining our Programmer web site. We'll make sure to send "
					+ "Have a gread day and thanks again! \n\n"
					+ "Houssam EL Mansouri"
					+ "https://twitter.com/ElManHou";
			boolean isbodyHTML = false;
			MailUtil.sendEmail(to, from, subject, body, isbodyHTML);
			**/
			url = "/includes/success.jsp";
		}
		
		
		request.setAttribute("programmer2", programmer2);
		request.setAttribute("programminglanguage", programmingLanguage);
		request.setAttribute("framework", framework);
		request.setAttribute("message", message);
		
		//Set cookie
		/**
		Cookie emailCookie = new Cookie("emailCookie", email);
		emailCookie.setMaxAge(60 * 60 * 24 * 365 * 2);
		emailCookie.setPath("/");
		response.addCookie(emailCookie);
		**/
		return url;
		
	}
	
	
	
	

}
