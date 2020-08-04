package it.contrader.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/*
 * Login Servlet
 */
public class UrlServlet extends HttpServlet {
	// UID della servlet
	private static final long serialVersionUID = 1L;

	/**
	 * @param HttpServletRequest request
	 * @param HttpServletResponse response
	 * 
	 * Metodo che gestisce le request che arrivano dalla JSP.
	 */
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		final HttpSession session = request.getSession();
		session.setAttribute("utente", null);

		String url = request.getParameter("linkUrl").toString();
		request.setAttribute("url", url);
		getServletContext().getRequestDispatcher("/urloperazioni.jsp").forward(request, response);

		//			switch (dto.getUsertype().toUpperCase()) {
		//			case "ADMIN":
		//				//questo metodo reindirizza alla JSP tramite URL con una request e una response
		//				getServletContext().getRequestDispatcher("/homeadmin.jsp").forward(request, response);
		//				break;
		//				
		//			case "USER":
		//				getServletContext().getRequestDispatcher("/homeuser.jsp").forward(request, response);
		//				break;
		//				
		//			default:
		//				//di default rimanda al login
		//				getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
		//				break;
		//			}

	}
}
