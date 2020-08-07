package it.contrader.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.contrader.dto.StatisticheDTO;
import it.contrader.service.StatisticheService;
import it.contrader.servlets.utils.*;

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
		StatisticheService statisticheService = new StatisticheService();
		StatisticheDTO statisticheDTO = null;
		switch( choice ) {
		case "parole":
			ContaParole.conta(request);
			statisticheDTO = new StatisticheDTO(1, 0, (int)request.getAttribute("numeroParole"), 0, 0, 0);		
			statisticheService.update(statisticheDTO);
			getServletContext().getRequestDispatcher("/urloperazioni.jsp").forward(request, response);
			break;
		case "immagini":
			ContaImmagini.conta(request);
			statisticheDTO = new StatisticheDTO(1, 0, 0, (int)request.getAttribute("numImg"), 0, 0);		
			statisticheService.update(statisticheDTO);
			getServletContext().getRequestDispatcher("/urloperazioni.jsp").forward(request, response);
			break;
		case "link":
			ContaLink.conta(request);
			statisticheDTO = new StatisticheDTO(1, 0, 0, 0, (int)request.getAttribute("numLink"), 0);		
			statisticheService.update(statisticheDTO);
			getServletContext().getRequestDispatcher("/urloperazioni.jsp").forward(request, response);
			break;
		case "parola":
			if(request.getParameter("test")!=null)
			{
				request.setAttribute("cerca", request.getParameter("cercaparola").toString());
				ContaParole.cerca(request);
				statisticheDTO = new StatisticheDTO(1, 0, 0, 0, 0, 1);		
				statisticheService.update(statisticheDTO);
			}
			request.setAttribute("parolaTest", "yes");
			getServletContext().getRequestDispatcher("/urloperazioni.jsp").forward(request, response);
			break;
		case "ottimizza":
			Ottimizzazione.ottimizza(request);
			getServletContext().getRequestDispatcher("/urloperazioni.jsp").forward(request, response);
			break;
		}
	}
}