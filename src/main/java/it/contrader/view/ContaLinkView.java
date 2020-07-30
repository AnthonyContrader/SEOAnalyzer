package it.contrader.view;

import it.contrader.controller.Request;

public class ContaLinkView extends AbstractView {

	@Override
	public void showResults(Request request) {
		// TODO Auto-generated method stub
		String numLink = request.getString("numLink").toString();
		
		System.out.println("Numero di link trovati alla pagina " + request.getString("URL") + " : " + numLink);
		
		
	}

	@Override
	public void showOptions() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void submit() {
		// TODO Auto-generated method stub

	}

}
