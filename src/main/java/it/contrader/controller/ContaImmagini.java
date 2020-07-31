package it.contrader.controller;
import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class ContaImmagini {
	public static void conta(Request request){
		
		Document doc = null;
		try {
			doc = Jsoup.connect((String) request.getString("URL")).get();
		} catch (IOException e) {
			e.printStackTrace();
		}
		Elements immagini = doc.getElementsByTag("img");
		request.put("numero immagini", immagini.size());
	}
}
