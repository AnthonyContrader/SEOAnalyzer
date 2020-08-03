package it.contrader.controller;

import it.contrader.controller.utils.Request;
import it.contrader.main.MainDispatcher;

public class ContaLinkController implements Controller {

	@Override
	public void doControl(Request request) {
		// TODO Auto-generated method stub
		MainDispatcher.getInstance().callView("ContaLink", request);
	}

}
