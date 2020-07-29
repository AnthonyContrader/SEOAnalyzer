package it.contrader.controller;

import it.contrader.main.MainDispatcher;

public class URLController implements Controller {

	@Override
	public void doControl(Request request) {
		MainDispatcher.getInstance().callView("URL", request);
	}

}
