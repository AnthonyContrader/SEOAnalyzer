package it.contrader.view;
import it.contrader.controller.*;
import it.contrader.main.MainDispatcher;

public class ContaImmaginiView extends AbstractView {
	String choice;
	String URL; 
	Request request = new Request();

	@Override
	public void showResults(Request request) {
		System.out.println("-------------CONTEGGIO IMMAGINI------------\n");
		System.out.println("Ci sono " +  request.getString("numero immagini") + " immagini in questo sito!");
	}

	@Override
	public void showOptions() {
		System.out.println("-------------MENU------------\n");
		System.out.println("(I)ndietro (E)sci");
		choice = this.getInput();
	}

	@Override
	public void submit() {
		switch(choice.toLowerCase()) {
		case "i":
			MainDispatcher.getInstance().callAction("URL", "doControl", request);
		case "e":
			System.out.println("Arrivederci!");
			System.exit(0);
		default:
			System.out.println("Scelta errata. Riprovare!");
	}
	}
}
