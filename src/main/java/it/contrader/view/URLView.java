package it.contrader.view;

import it.contrader.controller.ContaLink;
import it.contrader.controller.ContaParole;
import it.contrader.controller.Request;
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
				request = ContaParole.conta(request);
				System.out.println("Terminata conta");
				MainDispatcher.getInstance().callView("ContaParole", request);
			case "2": 
				request = ContaLink.conta(request);
				MainDispatcher.getInstance().callView("ContaLink", request);
			case "3": 
				MainDispatcher.getInstance().callView("HomeAdmin", request);
			case "4": 
				MainDispatcher.getInstance().callView("HomeAdmin", request);
			default: 
				MainDispatcher.getInstance().callView("HomeAdmin", request);
		}
	}

}
