package it.contrader.view;

import it.contrader.controller.utils.Request;
import it.contrader.main.MainDispatcher;

public class OttimizzazioneView extends AbstractView {
	private Request request;
	private String choice;

	@Override
	public void showResults(Request request) {
		this.request = request;
		System.out.println("-------------COSA MIGLIORARE???------------");		
		double percentualeFrasiMeno25Parole = (double) request.get("percentualeFrasiMeno25Parole");
		System.out.printf("Numero frasi con meno di 25 parole: %5.2f%%%n%n", percentualeFrasiMeno25Parole );		
		if( percentualeFrasiMeno25Parole > 75.0 ) {
			System.out.println("Sito ottimizzato in lettura\n\n");			
		}else {
			System.out.println("ATTENZIONE: per una maggiore leggibilità si consiglia di spezzettare l'informazione su più frasi.\n\n");			
		}


		double percentualeFrasiMeno8Parole = (double)request.get("percentualeFrasiMeno8Parole");
		System.out.printf("Numero frasi con meno di 8 parole: %5.2f%%%n%n", percentualeFrasiMeno8Parole);
		if( percentualeFrasiMeno8Parole > 75.0 ) {
			System.out.println("Sito ottimizzato in lettura\n\n");			
		}else {
			System.out.println("ATTENZIONE: per una maggiore leggibilità si consiglia di spezzettare l'informazione su più frasi.\n\n");			
		}


		double percentualeParagrafiMeno150Parole = (double)request.get("percentualeParagrafiMeno150Parole");
		System.out.printf("Paragrafi con meno 150 parole: %5.2f%%%n%n", percentualeParagrafiMeno150Parole);	
		if( percentualeParagrafiMeno150Parole > 75.0 ) {
			System.out.println("Sito ottimizzato in lettura\n\n");			
		}else {
			System.out.println("ATTENZIONE: per una maggiore leggibilità si consiglia di spezzettare l'informazione su più paragrafi.\n\n");			
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
			}
		}

	}
}
