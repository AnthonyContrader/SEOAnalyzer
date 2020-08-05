package it.contrader.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import it.contrader.servlets.utils.ContaImmagini;
import it.contrader.servlets.utils.ContaLink;
import it.contrader.servlets.utils.ContaParole;
import it.contrader.servlets.utils.Ottimizzazione;

/**
 * Servlet implementation class UrlSceltaServlet
 */
public class UrlSceltaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		final HttpSession session = request.getSession();
		String choice = request.getParameter("scelta");
		request.setAttribute("url", session.getAttribute("url").toString());
		switch( choice ) {
		case "parole":
			ContaParole.conta(request);
			getServletContext().getRequestDispatcher("/urloperazioni.jsp").forward(request, response);
			break;
		case "immagini":
			ContaImmagini.conta(request);
			getServletContext().getRequestDispatcher("/urloperazioni.jsp").forward(request, response);
			break;
		case "link":
			ContaLink.conta(request);
			getServletContext().getRequestDispatcher("/urloperazioni.jsp").forward(request, response);
			break;
		case "parola":
			//TODO
			getServletContext().getRequestDispatcher("/urloperazioni.jsp").forward(request, response);
			break;
		case "ottimizza":
			Ottimizzazione.ottimizza(request);
			getServletContext().getRequestDispatcher("/urloperazioni.jsp").forward(request, response);
			break;
		}
	}
}