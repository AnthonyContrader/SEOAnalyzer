package it.contrader.view;

import it.contrader.controller.utils.Request;
import it.contrader.main.MainDispatcher;

public class InitView extends AbstractView {
	private String choice;
	
	@Override
	public void showResults(Request request) {}

	@Override
	public void showOptions() {
		System.out.println("-------------MENU------------\n");
        System.out.println(" Benvenuto. Cosa vuoi fare?");
        System.out.println("[L]ogin  [E]sci");
        choice = this.getInput();
	}

	@Override
	public void submit() {
		switch (choice.toLowerCase()) {
        case "l":
        	MainDispatcher.getInstance().callAction("Login", "doControl", null);
        	break;
 
        case "e":
        	System.out.println("Arrivederci!");
        	System.exit(0);
        	break;
        	
        default:
        	System.out.println("Scelta sbagliata. Riprovare!");
        	MainDispatcher.getInstance().callView("Init", null);
        }
	}

}
