package it.contrader.main;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class Ciao {
	public static void main(String[] args) {
		Document doc = null;
		
		try {
			doc = Jsoup.connect("https://www.google.it").get();
			System.out.println(doc);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
