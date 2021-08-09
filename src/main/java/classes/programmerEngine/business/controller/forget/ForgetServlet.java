package classes.programmerEngine.business.controller.forget;

import java.io.IOException;

import javax.mail.MessagingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import classes.programmerEngine.data.ProgrammerDB;
import classes.programmerEngine.util.MailUtil;

/**
 * Servlet implementation class ForgetServlet
 */

public class ForgetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ForgetServlet() {
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
		String message = null;
		boolean isExist;
		if(action == null)
			action = "join";
		else if(action.equals("add")) {
			  String email = request.getParameter("email");
			  isExist = ProgrammerDB.checkEmail(email);
 			 if(isExist) {
 				 message = "";
 				 url = "/includes/pgmr_profile.jsp";
 			 }else {
 				message = "The email address does not exist.";
 				url = "/includes/forgot.jsp";
 			 }
			  
		}
		
		request.setAttribute("message", message);
		request.getRequestDispatcher(url).forward(request, response);
	}

}
