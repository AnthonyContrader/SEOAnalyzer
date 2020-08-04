package it.contrader.servlets.utils;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class ContaLink {
	public static void conta(HttpServletRequest request) {
	
		System.out.println(request.getAttribute("url").toString());
		String URL = request.getAttribute("url").toString();
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
			
	}
}
