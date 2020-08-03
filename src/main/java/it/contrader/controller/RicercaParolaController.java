package it.contrader.controller;

import it.contrader.controller.utils.Request;
import it.contrader.main.MainDispatcher;

public class RicercaParolaController implements Controller{

	@Override
	public void doControl(Request request) {
		MainDispatcher.getInstance().callView("RicercaParola", request);
		
	}

}
