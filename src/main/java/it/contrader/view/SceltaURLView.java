package it.contrader.view;

import it.contrader.controller.Request;
import it.contrader.main.MainDispatcher;

public class SceltaURLView extends AbstractView{

	String choice;
	String URL; 
	Request request;
	final String REGEX = "^(http|https|ftp)\\://[a-zA-Z0-9\\-\\.]+\\.[a-zA-Z]{2,3}(:[a-zA-Z0-9]*)?/?([a-zA-Z0-9\\-\\._\\?\\,\\'/\\\\\\+&amp;%\\$#\\=~])*$";
	int i;
	@Override
	public void showResults(Request request) {
		//show la lista
		System.out.println("-------------LISTA URL------------\n");
		this.request = request;
		for(i=1; i<6; i++)
		{
			if(this.request.get("URL"+i)!=null)
				System.out.println(i + ") " + this.request.get("URL"+i));
			else break;
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
		int temp = Integer.parseInt(choice);
		if(temp>=1 && temp<=i-1)
		{
			URL = (String) request.getString("URL"+ temp);
			request.put("URL", URL);
			MainDispatcher.getInstance().callAction("URL", "doControl", request);
		}
		else {
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
		}
		
	}

}

