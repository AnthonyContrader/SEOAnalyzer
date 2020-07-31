package it.contrader.view;


import it.contrader.controller.*;
import it.contrader.main.MainDispatcher;

public class URLView extends AbstractView {
	
	private Request request;
	private String choice;

	@Override
	public void showResults(Request request) {
		this.request = request;

	}

	@Override
	public void showOptions() {
		System.out.println("-------------MENU------------\n");
		System.out.println("(1)Conta parole (2)Conta link (3)Conta immagini (4)Cerca parola (5)Consigli di ottimizzazione (6)Ricerca nuovo URL (7)Logout (8)Esci");
		choice = this.getInput();
	}

	@Override
	public void submit() {
		switch(choice) {
			case "1":
				ContaParole.conta(request);
				MainDispatcher.getInstance().callAction("ContaParole", "doControl", request);
				break;
			case "2":
				ContaLink.conta(request);
				MainDispatcher.getInstance().callAction("ContaLink", "doControl", request);
				break;
			case "3": 
				ContaImmagini.conta(request);
				MainDispatcher.getInstance().callAction("ContaImmagini", "doControl", request);
				break;
			case "4": 
				System.out.println("Inserisci la parola da ricercare:");
				String cercaParola = this.getInput();
				request.put("cercaParola", cercaParola);
				MainDispatcher.getInstance().callAction("RicercaParola", "doControl", request);
				break;
			case "5":
				Ottimizzazione.ottimizza(request);
				MainDispatcher.getInstance().callAction("Ottimizzazione", "doControl", request);
				break;
			case "6":
				MainDispatcher.getInstance().callAction("Home", "doControl", request);
			case "7":
				MainDispatcher.getInstance().callAction("Init", "doControl", null);
			case "8":
				System.out.println("Arrivederci!");
				System.exit(0);
			default: 
				System.out.println("Scelta errata. Riprovare!");
				MainDispatcher.getInstance().callAction("URL", "doControl", request);
		}
	}

}
