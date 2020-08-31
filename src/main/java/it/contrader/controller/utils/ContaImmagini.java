package it.contrader.controller.utils;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class ContaImmagini {
	public static void conta(HttpServletRequest request){
		
		String URL = request.getAttribute("url").toString();
		Document doc = null;
		try {
			doc = Jsoup.connect(URL).get();
		} catch (IOException e) {
			e.printStackTrace();
		}
		Elements immagini = doc.getElementsByTag("img");
		request.setAttribute("numImg", immagini.size());
	}
}
