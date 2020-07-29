package it.contrader.view;


import it.contrader.controller.Request;
import it.contrader.main.MainDispatcher;

public class HomeUserView extends AbstractView{

	String choice;
	String URL; 
	Request request = new Request();

	@Override
	public void showResults(Request request) {
	}

	@Override
	public void showOptions() {
		System.out.println("-------------MENU------------\n");
		System.out.println("(I)nserisci URL (E)sci");
		choice = this.getInput();

	}

	@Override
	public void submit() {

		switch (choice.toLowerCase()) {

		case "e":
			MainDispatcher.getInstance().callAction("Init", "doControl", null);
			break;
		case "i":
			URL = this.getInput();
			request.put("URL", URL);
			MainDispatcher.getInstance().callAction("URL", "doControl", request);
		default:
			MainDispatcher.getInstance().callAction("Init", "doControl", null);
		}
	}

}
