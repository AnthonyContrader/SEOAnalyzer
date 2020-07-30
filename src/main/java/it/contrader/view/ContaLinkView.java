package it.contrader.view;

import it.contrader.controller.Request;
import it.contrader.main.MainDispatcher;

public class ContaLinkView extends AbstractView {

	private String choice;
	private Request request;

	@Override
	public void showResults(Request request) {
		this.request = request;
		// TODO Auto-generated method stub
		String numLink = request.getString("numLink").toString();
		
		System.out.println("Numero di link trovati alla pagina " + request.getString("URL") + " : " + numLink);
		
		
	}

	@Override
	public void showOptions() {
		// TODO Auto-generated method stub
		System.out.println("-------------MENU------------\n");
		System.out.println("(I)ndietro (E)sci");
		choice = this.getInput();
	}

	@Override
	public void submit() {
		// TODO Auto-generated method stub

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
