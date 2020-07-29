package it.contrader.view;

import it.contrader.controller.Request;
import it.contrader.main.MainDispatcher;

public class InitView extends AbstractView {
	private String choice;
	private Request request;
	
	@Override
	public void showResults(Request request) {
		// TODO Auto-generated method stub

	}

	@Override
	public void showOptions() {
		System.out.println("-------------MENU------------\n");
        System.out.println(" Benvenuto. Cosa vuoi fare?");
        System.out.println("[L]ogin  [E]sci");
        //Il metodo che salva l'input nella stringa choice.
        //getInput() è definito in AbstractView.
        choice = this.getInput();

	}

	@Override
	public void submit() {
		switch (choice.toLowerCase()) {
        case "l":
//        	this.request.put("mode", "USERLIST");
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
