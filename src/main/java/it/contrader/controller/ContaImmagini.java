package it.contrader.controller;
import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class ContaImmagini {
	public static Request conta(Request request){
		
		Document doc = null;
		try {
			doc = Jsoup.connect((String) request.getString("URL")).get();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Elements immagini = doc.getElementsByTag("img");
		int img = 0;
		for (Element immagine: immagini) img++;
		//System.out.println("ci sono " + img + " immagini in questo sito!");
		request.put("numero immagini", img);
		return request;
	}
}
