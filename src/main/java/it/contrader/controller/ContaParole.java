package it.contrader.controller;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.Map.Entry;

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

		Argomenti.argomento(request);
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
	private static class Argomenti{
		private static List<String> economia = new ArrayList<String>(){
			{
				add("bilancio"); add("pil"); add("spread"); add("debito"); add("pubblico"); add("reddito");
				add("bitcoin");	add("decreto");	add("socio"); add("recessione"); add("bene"); add("prodotto");
				add("interno"); add("lordo"); add("economico"); add("economia"); add("capitale");
			}
		};

		private static List<String> sport = new ArrayList<String>(){
			{
				add("giochi"); add("olimpici"); add("olimpiadi"); add("sport"); add("calcio"); add("tennis");
				add("basket"); add("nuoto"); add("footbal"); add("champions"); add("league"); add("europa");
				add("mondiale"); add("europeo"); add("gara"); add("match"); add("set"); add("tempo"); add("campionato");
				add("campionati"); add("serie"); add("uefa"); add("girone"); add("gironi"); add("classifica");
				add("punti"); add("punto"); add("squadra"); add("squadre"); add("titolo"); add("titoli");
			}
		};

		private static List<String> salute = new ArrayList<String>(){
			{
				add("coronavirus"); add("vaccino"); add("referto"); add("medico"); add("sanitaria"); add("malattia");
				add("malanno"); add("benessere"); add("salute"); add("mentale"); add("corpo"); add("visita");
				add("prescrizione"); add("anticorpi"); add("antibiodico"); add("medicina"); add("farmacia"); add("medica");
			}
		};

		private static List<String> informatica = new ArrayList<String>(){
			{
				add("programmare"); add("programmazione"); add("linguaggio"); add("computer"); add("dati"); add("gb");
				add("hardware"); add("software"); add("microsoft"); add("apple"); add("ios"); add("desktop");
				add("bit"); add("hacker"); add("frode"); add("informatica"); add("attacco"); add("rete"); add("windows"); 
				add("internet"); add("browser"); add("web"); add("www");
			}
		};

		private static List<String> cibo = new ArrayList<String>(){
			{
				add("food"); add("street"); add("pizza"); add("hamburger"); add("antipasto"); add("primo");
				add("secondo"); add("contorno"); add("frutta"); add("verdura"); add("piatto"); add("bevanda");
				add("liquore"); add("alcolico"); add("conto"); add("ricetta"); add("costo"); add("asporto"); add("supermercato"); 
				add("comprare"); add("alimentare"); add("vitamina"); add("vitamine");
			}
		};

		private static List<String> fitness = new ArrayList<String>(){
			{
				add("palestra"); add("alimentazione"); add("mangiare"); add("sano"); add("pesi"); add("peso");
				add("attrezzi"); add("serie"); add("ripetizioni"); add("abbonamento"); add("tappetino"); add("jogging");
				add("bilanciere"); add("step"); add("allenamento"); add("allenarsi"); add("manubrio"); add("smartwatch"); add("corsa"); 
				add("correre"); 
			}
		};

		private static List<String> viaggi = new ArrayList<String>(){
			{
				add("volo"); add("andata"); add("ritorno"); add("aereo"); add("automobile"); add("macchina");
				add("moto"); add("autobus"); add("treno"); add("posto"); add("luogo"); add("nazione");
				add("regione"); add("città"); add("destinazione"); add("partenza"); add("arrivo"); add("check-in"); add("check-out"); 
				add("valigia"); add("peso"); add("prezzo");
			}
		};


		private static Map<String,List<String>> mappa = new HashMap<String,List<String>>(){
			{
				put("economia",economia);
				put("sport",sport);
				put("salute",salute);
				put("informatica",informatica);
				put("cibo",cibo);
				put("fitness",fitness);
				put("viaggi",viaggi);
			}
		};


		public static void argomento(Request request) {
			Map<String, Word> countMap = (Map<String, Word>) request.get("mappaParoleOccorrenze");
			int numeroParole = (int) request.get("numeroParole");
			int paroleTrovate = 0;
			String argomentoTrovato = "";
			for( Entry<String,List<String>> coppiaArg : mappa.entrySet() ) {
				for( String elem : countMap.keySet()) {
					if( coppiaArg.getValue().contains(elem.toLowerCase()) ) paroleTrovate++;


				}
				if( paroleTrovate >= 15 ) {
					argomentoTrovato = coppiaArg.getKey();
					double percentualeAffidabilitaArg = (paroleTrovate*100)/(double)numeroParole;
					request.put("affidabilitaArgomento", percentualeAffidabilitaArg);
					request.put("argomento", argomentoTrovato);
					return;
				}
				paroleTrovate = 0;
			}
			request.put("affidabilitaArgomento", 0.0);
			request.put("argomento", null);
		}
	}
}
