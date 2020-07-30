package it.contrader.controller;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class ContaLink {
	public static Request conta(Request request) {
	
		
		String URL = request.getString("URL").toString();
		Document doc = null;
		
		try {
			doc = Jsoup.connect(URL).get();
			//System.out.println("URL presa");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//Element content = doc.getElementById("content");
		//System.out.println("content");
		
		Elements links = doc.select("a[href]");
		//System.out.println("a");
		
		int count = links.size();
		
		//System.out.println("\nLinks: " + count);
	        
//		for (Element link : links) {
//	        	System.out.println(link);
//	        }

		
		request.put("numLink", count);
		
		return request;
		
	}
}
