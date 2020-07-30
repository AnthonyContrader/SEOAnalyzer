package it.contrader.view;

import it.contrader.controller.Request;
import it.contrader.main.MainDispatcher;

public class ContaParoleView extends AbstractView {
	private Request request;
	private String choice;

	@Override
	public void showResults(Request request) {
		this.request = request;
		System.out.println("-------------CONTEGGIO PAROLE------------\n");
		System.out.println("Il numero di parole all'interno del sito sono: \t" + request.getString("numeroParole") );
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
