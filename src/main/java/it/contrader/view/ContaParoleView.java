package it.contrader.view;

import it.contrader.controller.Request;
import it.contrader.main.MainDispatcher;

public class ContaParoleView extends AbstractView {
	private Request request;
	private String choice;

	@Override
	public void showResults(Request request) {
		this.request = request;
		System.out.println("-------------INFORMAZIONI------------\n");
		System.out.println("Il numero di parole all'interno del sito sono: \t" + request.getString("numeroParole") );
		double affidabilitaArgomento = (double) request.get("affidabilitaArgomento");
		String argomento = (String) request.getString("argomento");
		if( argomento == null || affidabilitaArgomento == 0.0 ) {
			System.out.println("ATTENZIONE: non è stato possibile individuare l'argomento trattato nel sito web.");
		}else {
			System.out.printf("L'argomento del sito è: %s con un'affidabilità del: %5.2f%% %n%n", argomento, affidabilitaArgomento );		
		}
	}

	@Override
	public void showOptions() {
	}

	@Override
	public void submit() {
		boolean finito = false;
		while(!finito) {
			System.out.println("-------------MENU------------\n");
			System.out.println("(I)ndietro (E)sci");
			choice = this.getInput();
			switch(choice.toLowerCase()) {
			case "i":
				MainDispatcher.getInstance().callAction("URL", "doControl", request);
				finito = true;
				break;
			case "e":
				System.out.println("Arrivederci!");
				System.exit(0);
			default:
				System.out.println("Scelta errata. Riprovare!");
				break;
			}
		}

	}

}
