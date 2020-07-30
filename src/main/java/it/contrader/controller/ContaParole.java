package it.contrader.controller;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class ContaParole {
	private long parole;
	
	
	public static void conta(Request request) {
		Document doc = null;
		try {
			String URL = (String) request.getString("URL");
			doc = Jsoup.connect(URL).get();
			String html = doc.title();
			
			request.put("contaParole", 3);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
