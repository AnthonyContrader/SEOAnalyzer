/**
 * Manage a Business Owner view
 */

package it.contrader.view;


import it.contrader.controller.utils.Request;
import it.contrader.main.MainDispatcher;

public class HomeAdminView extends AbstractView {

    private String choice;
    
	private Request request;

	/**
	 * Se la request non è nulla mostra un messaggio di benvenuto
	 */
    public void showResults(Request request) {
    	if(request!=null) {
    	System.out.println("\n Benvenuto in SAMPLE PROJECT "+request.get("username").toString() + "\n");
    	}
    }


    /**
     * Chiede all'utente di effettuare una scelta (da console)
     */
    public void showOptions() {
        System.out.println("-------------MENU------------\n");
        System.out.println(" Seleziona cosa vuoi gestire:");
        System.out.println("[U]tenti [R]icerche [L]ogout [E]sci ");
        //Il metodo che salva l'input nella stringa choice.
        //getInput() è definito in AbstractView.
        choice = this.getInput();
    }

    /**
     * Impacchetta una request (in base alla scelta sarà diversa) che invia ai controller tramite il
     * Dispatcher
     */
    public void submit() {    
    	//crea una nuova Request (vedi classe Request)
    	request = new Request();
        switch (choice.toLowerCase()) {
        case "u":
        	this.request.put("mode", "USERLIST");
        	MainDispatcher.getInstance().callAction("User", "doControl", request);
        	break;
        
        case "l":
        	MainDispatcher.getInstance().callAction("Login", "doControl", null);
        	break;
        case "e":
        	System.out.println("Arrivederci!");
        	System.exit(0);
        	
        case "r":
        	MainDispatcher.getInstance().callAction("URL", "readAdmin", request);
        	break;
        default:
   
            request.put("choice", choice);
        	MainDispatcher.getInstance().callAction("Login", "doControl", null);
        }
    }
}
