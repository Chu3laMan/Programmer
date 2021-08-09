package classes.programmerEngine.controllers.signup;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import classes.programmerEngine.business.Programmer_1;
import classes.programmerEngine.data.ProgrammerDB;

/**
 * Servlet implementation class SignupServlet
 */



public class SignupServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignupServlet() {
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
		String url = "/includes/registration_1.jsp";
		//get current action
		String action = request.getParameter("action");
		if(action == null)
			action = "join";
		
		String message = null;
		//perform action and set appropriate URL
		if(action.equals("join"))
			url = "/includes/registration_1.jsp";
		else if(action.equals("add")) {
			//get parameters from the request
			String firstName = request.getParameter("firstName");
			String lastName = request.getParameter("lastName");
			String email = request.getParameter("email");
			
			//store data in the Programmer_1 object
			Programmer_1 programmer = new Programmer_1(firstName, lastName, email);
			//Validate parameters
			if(ProgrammerDB.checkEmail(email)) {
				url = "/includes/registration_1.jsp";
				message = "This email address already exists.";
			}else {
				url = "/includes/registration_2.jsp";
			}
			
			request.setAttribute("programmer", programmer);
			request.setAttribute("message", message);
			getServletContext().getRequestDispatcher(url).forward(request, response);
			
			
		}
	}

}
