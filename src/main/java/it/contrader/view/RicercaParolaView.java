package it.contrader.view;

import java.util.Map;

import it.contrader.controller.utils.Request;
import it.contrader.controller.utils.ContaParole.Word;
import it.contrader.main.MainDispatcher;

public class RicercaParolaView extends AbstractView {
	Request request;
	String choice;

	@Override
	public void showResults(Request request) {
		this.request = request;

	}

	@Override
	public void showOptions() {
		Map<String, Word> countMap = (Map<String, Word>) request.get("mappaParoleOccorrenze");
		if( countMap == null ) {
			System.out.println("ATTENZIONE: devi prima contare le parole...");
			MainDispatcher.getInstance().callAction("URL", "doControl", request);
		}
		String parola = (String) request.getString("cercaParola");
		if( countMap.containsKey(parola) ) {
			System.out.println("Parola trovata! Viene ripetuta " + countMap.get(parola).getCount() + " volte.");
		}else {
			System.out.println("ATTENZIONE: la parola non è presente all'interno del sito.");
		}

		
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
