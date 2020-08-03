package it.contrader.view;

import it.contrader.controller.utils.Request;
import it.contrader.main.MainDispatcher;

public class ContaParoleView extends AbstractView {
	private Request request;
	private String choice;

	@Override
	public void showResults(Request request) {
		this.request = request;
		System.out.println("-------------INFORMAZIONI------------\n");
		System.out.println("Il numero di parole all'interno del sito sono: \t" + request.getString("numeroParole") );
		String argomento = (String) request.getString("argomento");
		System.out.println("Argomento in conta parole view = " + argomento);

		if( argomento == null) {
			System.out.println("Non è stato possibile trovare l'argomento del sito.");
		}else {
			System.out.println("Dalla ricerca si presume che argomento del sito sia: " + argomento);
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
