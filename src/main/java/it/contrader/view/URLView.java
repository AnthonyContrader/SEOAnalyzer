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
		System.out.println("(1)Conta parole (2)Conta link (3)Conta immagini (4)Conta occorenze parole ");
		choice = this.getInput();
	}

	@Override
	public void submit() {
		switch(choice) {
			case "1":
//				System.out.println("Dentro la classe URLView = " + request.get("URL"));
				ContaParole.conta(request);
				MainDispatcher.getInstance().callAction("ContaParole", "doControl", request);
			case "2":
				ContaLink.conta(request);
				MainDispatcher.getInstance().callAction("ContaLink", "doControl", request);
			case "3": 
				ContaImmagini.conta(request);
				MainDispatcher.getInstance().callAction("ContaImmagini", "doControl", request);
			case "4": 
				MainDispatcher.getInstance().callView("HomeAdmin", request);
			default: 
				MainDispatcher.getInstance().callView("HomeAdmin", request);
		}
	}

}
