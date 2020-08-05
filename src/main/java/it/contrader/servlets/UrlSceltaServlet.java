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

import it.contrader.servlets.utils.ContaLink;

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
		
		switch( choice ) {
		case "parole":
			//TODO
			getServletContext().getRequestDispatcher("/urloperazioni.jsp").forward(request, response);
			break;
		case "immagini":
			//TODO
			getServletContext().getRequestDispatcher("/urloperazioni.jsp").forward(request, response);
			break;
		case "link":
			//TODO
			
			//String URL = request.getString("URL").toString();
			String URL = request.getParameter("url").toString();
			System.out.println("url = " + URL);
			Document doc = null;
			
			try {
				doc = Jsoup.connect(URL).get();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Elements links = doc.select("a[href]");
			int count = links.size();
			request.setAttribute("numLink", count);
			//System.out.println("url = ");
			//ContaLink.conta(request);
			getServletContext().getRequestDispatcher("/urloperazioni.jsp").forward(request, response);
			break;
		case "parola":
			//TODO
			getServletContext().getRequestDispatcher("/urloperazioni.jsp").forward(request, response);
			break;
		case "ottimizza":
			//TODO
			getServletContext().getRequestDispatcher("/urloperazioni.jsp").forward(request, response);
			break;
		}
	}
}
