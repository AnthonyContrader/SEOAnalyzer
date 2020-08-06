package it.contrader.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.jsoup.Jsoup;

import it.contrader.converter.URLConverter;
import it.contrader.dto.*;
import it.contrader.model.*; 
import it.contrader.service.URLService;


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
		UserDTO utente = (UserDTO)session.getAttribute("utente");
		String mode = request.getParameter("mode");
		URLService urlService = new URLService(); 
		
		switch (mode.toLowerCase()) {
		case "link":
			String linkUrl = request.getParameter("linkUrl").toString();
			
			try {
				Jsoup.connect(linkUrl).get();
			}catch(IOException ioe) {
				request.setAttribute("urlErrato", true);
				getServletContext().getRequestDispatcher("/homeuser.jsp").forward(request, response);
				return;
			}
			
			URLConverter converter = new URLConverter();

			session.setAttribute("url", linkUrl);
			URL URL = new URL((String)session.getAttribute("url"), utente.getId());
			URLDTO urldto = converter.toDTO(URL);
			urlService.insert(urldto);
			
			getServletContext().getRequestDispatcher("/urloperazioni.jsp").forward(request, response);
			break;

		case "home":
			int id = (int)session.getAttribute("id");
			List<URLDTO> dtoUrl = urlService.read(id);
			session.setAttribute("listaCronologia", dtoUrl);
			getServletContext().getRequestDispatcher("/homeuser.jsp").forward(request, response);
			break;

		default:
			//di default rimanda al login
			//			getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
			//			break;
		}

	}
}