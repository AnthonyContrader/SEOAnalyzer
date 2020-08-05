package it.contrader.servlets.utils;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

import javax.servlet.http.HttpServletRequest;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Ottimizzazione {
	public static void ottimizza(HttpServletRequest request) {
		Document doc = null;
		try {
			String url = request.getAttribute("url").toString();
			doc = Jsoup.connect(url).get();
			Elements elements = doc.select("p");
			int paroleFrase = 0;
			int nFrasiMeno25Parole = 0;
			int nFrasiMeno8Parole = 0;
			int nFrasiTot = 0;
			int nParagrafiTot = 0;
			int nParoleParagrafo = 0;
			int nParagrafiMeno150parole = 0;
			BufferedReader reader = null;
			for(Element elem : elements) {
				nParagrafiTot++;
				reader = new BufferedReader(new InputStreamReader(new ByteArrayInputStream(elem.text().getBytes(StandardCharsets.UTF_8))));
				String line;
				
				while ((line = reader.readLine()) != null) {
					String[] words = line.split(" ");
					for( String word : words ) {
						nParoleParagrafo++;
						char c = word.charAt(word.length()-1);
						switch(c) {
							case ';':
							case '!':
							case '?':
							case '.':
							case ':':
								paroleFrase++;
								nFrasiTot++;
		
								if( paroleFrase < 25 ) nFrasiMeno25Parole++;
								if( paroleFrase < 8 ) nFrasiMeno8Parole++;
								
								paroleFrase = 0;							
								break;
							default:
								paroleFrase++;
						}//switch	
					}//for
				}//while
				
				if( nParoleParagrafo < 150 ) nParagrafiMeno150parole++;
				nParoleParagrafo = 0;
			}
			reader.close();
			
			double percentualeFrasiMeno25Parole = (nFrasiMeno25Parole * 100) / (double)nFrasiTot;
			
			double percentualeFrasiMeno8Parole = (nFrasiMeno8Parole * 100) / (double)nFrasiTot;
			
			double percentualeParagrafiMeno150Parole = (nParagrafiMeno150parole * 100) / (double)nParagrafiTot;
			
			request.setAttribute("percentualeFrasiMeno25Parole", percentualeFrasiMeno25Parole);
			request.setAttribute("percentualeFrasiMeno8Parole", percentualeFrasiMeno8Parole);
			request.setAttribute("percentualeParagrafiMeno150Parole", percentualeParagrafiMeno150Parole);

		}catch(IOException e) {
			e.printStackTrace();
		}		
	}
	
}
