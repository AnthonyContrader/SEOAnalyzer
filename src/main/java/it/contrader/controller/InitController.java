package it.contrader.controller;

import it.contrader.controller.utils.Request;
import it.contrader.main.MainDispatcher;

public class InitController implements Controller {
	public InitController() {
	
	}
	@Override
	public void doControl(Request request) {
		MainDispatcher.getInstance().callView("Init", request);

	}

}
