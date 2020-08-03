package it.contrader.controller;

import it.contrader.controller.utils.Request;
import it.contrader.main.MainDispatcher;

public class ContaImmaginiController implements Controller {
	@Override
	public void doControl(Request request) {
		MainDispatcher.getInstance().callView("ContaImmagini", request);

	}
}
