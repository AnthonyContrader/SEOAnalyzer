package it.contrader.controller;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class ContaParole {
	
	
	public static void conta(Request request) {
		Document doc = null;
		Map<String, Word> countMap = new HashMap<String, Word>();
		int contaParole = 0;
		try {
			String URL = (String) request.getString("URL");
			doc = Jsoup.connect(URL).get();
			String text = doc.body().text();
			System.out.println("Scansione del sito...");
			BufferedReader reader = new BufferedReader(new InputStreamReader(new ByteArrayInputStream(text.getBytes(StandardCharsets.UTF_8))));
			String line;
			while ((line = reader.readLine()) != null) {
				String[] words = line.split("[ ,.\":()/%£$&\\/()=?!|]+");
				for (String word : words) {
					if ("".equals(word)) {
						continue;
					}
					Word wordObj = countMap.get(word);
					if (wordObj == null) {
						wordObj = new Word();
						wordObj.word = word;
						wordObj.count = 0;
						countMap.put(word, wordObj);
					}
					contaParole++;
					wordObj.count++;
				}
			}
			reader.close();
		}catch(IOException e) {
			e.printStackTrace();
		}
		List<Word> list = new ArrayList<>(countMap.values());
		Collections.sort(list);
		int max = 0;
		for(Word w: list) {
			max++;
			if( max > 10 )
				break;
			if( w.word.length() >= 8 )
				System.out.println(max + ")\t\t" + w.word + "\t\t|" + w.count);
			else
				System.out.println(max + ")\t\t" + w.word + "\t\t\t|" + w.count);

		}
		request.put("numeroParole", contaParole);
		request.put("mappaParoleOccorrenze", countMap);
	}
	public static class Word implements Comparable<Word> {
		private String word;
		private int count;

		@Override
		public int hashCode() { return word.hashCode(); }

		@Override
		public boolean equals(Object obj) { return word.equals(((Word)obj).word); }

		@Override
		public int compareTo(Word b) { return b.count - count; }
		
		public int getCount() { return count; }
		public String getWord() { return word; }
	}
}
