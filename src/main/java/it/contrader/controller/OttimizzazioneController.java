package it.contrader.controller;

import it.contrader.main.MainDispatcher;

public class OttimizzazioneController implements Controller {
	public OttimizzazioneController() {
	
	}
	@Override
	public void doControl(Request request) {
		MainDispatcher.getInstance().callView("Ottimizzazione", request);

	}
}
