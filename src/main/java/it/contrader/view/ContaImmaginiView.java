package it.contrader.view;
import it.contrader.controller.*;
import it.contrader.main.MainDispatcher;

public class ContaImmaginiView extends AbstractView {
	String choice;
	String URL; 
	Request request = new Request();

	@Override
	public void showResults(Request request) {
		System.out.println("ci sono " +  request.getString("numero immagini") + " immagini in questo sito!");
	}

	@Override
	public void showOptions() {
		System.out.println("-------------MENU------------\n");
		System.out.println("(1)Conta parole (2)Conta link (3)Conta immagini (4)Conta occorenze parole ");
		choice = this.getInput();

	}

	@Override
	public void submit() {
		/*switch(choice) {
			case "1":
				ContaParole.conta(request);
				MainDispatcher.getInstance().callView("ContaParole", request);
			case "2": 
				MainDispatcher.getInstance().callView("HomeAdmin", request);
			case "3": 
				ContaImmagini.conta(request);
				MainDispatcher.getInstance().callView("ContaImmagini", "doControl", request);
			case "4": 
				MainDispatcher.getInstance().callView("HomeAdmin", request);
			default: 
				MainDispatcher.getInstance().callView("HomeAdmin", request);
		}*/
	}
}
