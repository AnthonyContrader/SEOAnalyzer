package it.contrader.servlets.utils;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class ContaImmagini {
	public static void conta(HttpServletRequest request){
		
		Document doc = null;
		try {
			doc = Jsoup.connect((String) request.getAttribute("URL")).get();
		} catch (IOException e) {
			e.printStackTrace();
		}
		Elements immagini = doc.getElementsByTag("img");
		request.setAttribute("numero immagini", immagini.size());
	}
}
