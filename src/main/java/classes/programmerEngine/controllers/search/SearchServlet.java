package classes.programmerEngine.controllers.search;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import classes.programmerEngine.business.Programmer_2;
import classes.programmerEngine.data.ProgrammerDB;

/**
 * Servlet implementation class SearchServlet
 */

public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getParameter("action");
		boolean isExit;
		String url = null;
		String message = null;
		List<Programmer_2> list = null;
		String keyword = null;
		String requestURI = request.getRequestURI();
		if(requestURI.endsWith("/includes/SearchPage2"))
			url = "/includes/login.jsp";
		if(requestURI.endsWith("/includes/SearchPage3"))
			url = "/includes/registration_1.jsp";
		
		if(action == null)
			action = "join";
		else if(action.equals("add")) {
			keyword = request.getParameter("searchKeyword");
			isExit = ProgrammerDB.findProgrammingLangOrFwk(keyword).isEmpty();
			if(isExit) {
				url = "/includes/index.jsp";
				message = "Not Found!, Please try again";
			}else {
				message = "";
				url = "/includes/result.jsp";
				list = ProgrammerDB.findProgrammingLangOrFwk(keyword);
			}
			
		}
		
		request.setAttribute("list", list);
		request.setAttribute("keyword", keyword);
		request.setAttribute("message", message);
		
		getServletContext().getRequestDispatcher(url).forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	
	
	

}
