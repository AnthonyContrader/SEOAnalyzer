package it.contrader.view;

import it.contrader.controller.Request;
import it.contrader.main.MainDispatcher;

public class SceltaURLView extends AbstractView{

	String choice;
	String URL; 
	Request request;
	final String REGEX = "^(http|https|ftp)\\://[a-zA-Z0-9\\-\\.]+\\.[a-zA-Z]{2,3}(:[a-zA-Z0-9]*)?/?([a-zA-Z0-9\\-\\._\\?\\,\\'/\\\\\\+&amp;%\\$#\\=~])*$";

	@Override
	public void showResults(Request request) {
		//show la lista
		System.out.println("-------------LISTA URL------------\n");
		this.request = request;
		for(int i=1; i<6; i++)
		{
			System.out.println(i + ") " + this.request.get("URL"+i));
		}
	}

	@Override
	public void showOptions() {
		//scegli se vuoi usare un vecchio url o uno nuovo
		System.out.println("Inserisci il numero dell URL che vuoi cercare o inserisci un nuovo URL");
		choice = this.getInput();
	}

	@Override
	public void submit() {

		switch (choice) {
		
		case "1":
			URL = (String) request.getString("URL1");
			request.put("URL", URL);
			MainDispatcher.getInstance().callAction("URL", "doControl", request);
			break;
		case "2":
			URL = (String) request.getString("URL2");
			request.put("URL", URL);
			MainDispatcher.getInstance().callAction("URL", "doControl", request);
			break;
		case "3":
			URL = (String) request.getString("URL3");
			request.put("URL", URL);
			MainDispatcher.getInstance().callAction("URL", "doControl", request);
			break;
		case "4":
			URL = (String) request.getString("URL4");
			request.put("URL", URL);
			MainDispatcher.getInstance().callAction("URL", "doControl", request);
			break;
		case "5":;
			URL = (String) request.getString("URL5");
			request.put("URL", URL);
			MainDispatcher.getInstance().callAction("URL", "doControl", request);
			break;
		default:
			URL = new String(choice);
			boolean match = URL.matches(REGEX);
			while( !match ) {
				System.out.println("ATTENZIONE! URL scritta in modo errato. Riprovare");
				System.out.println("Versione corretta es: \"http://www.example.com/~joe\"");
				URL = this.getInput();
				match = URL.matches(REGEX);
			}
			
			request.put("URL", URL);
			MainDispatcher.getInstance().callAction("URL", "doControl", request);
			break;
		}
	}

}

