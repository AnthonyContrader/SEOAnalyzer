package it.contrader.view;


import it.contrader.controller.Request;
import it.contrader.main.MainDispatcher;

public class HomeUserView extends AbstractView{

	String choice;
	String URL; 
	Request request;
	final String REGEX = "^(http|https|ftp)\\://[a-zA-Z0-9\\-\\.]+\\.[a-zA-Z]{2,3}(:[a-zA-Z0-9]*)?/?([a-zA-Z0-9\\-\\._\\?\\,\\'/\\\\\\+&amp;%\\$#\\=~])*$";

	@Override
	public void showResults(Request request) {
		this.request = request;
	}

	@Override
	public void showOptions() {
		System.out.println("-------------MENU------------\n");
		System.out.println("(I)nserisci URL (L)ogout (E)sci");
		choice = this.getInput();
	}

	@Override
	public void submit() {

		switch (choice.toLowerCase()) {
		
		case "l":
			MainDispatcher.getInstance().callAction("Init", "doControl", null);
			break;
		case "i":
			System.out.println("Inserisci link URL:");
			URL = this.getInput();
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
		case "e":
			System.out.println("Arrivederci!");
			System.exit(0);
		default:
			System.out.println("Scelta errata. Riprovare!");
			MainDispatcher.getInstance().callAction("Home", "doControl", request);
			break;
		}
	}

}
