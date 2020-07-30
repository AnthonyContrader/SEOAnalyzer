package it.contrader.controller;

import it.contrader.main.MainDispatcher;

public class ContaParoleController implements Controller {

	@Override
	public void doControl(Request request) {
		MainDispatcher.getInstance().callView("ContaParole", request);

	}

}
