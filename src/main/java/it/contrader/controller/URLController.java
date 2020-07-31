package it.contrader.controller;

import it.contrader.dto.URLDTO;
import it.contrader.dto.UserDTO;
import it.contrader.main.MainDispatcher;
import it.contrader.service.URLService;

public class URLController implements Controller {

	private URLService urlService;
	int URLID;
	String URLname;
	int UserID;
	
	
	public URLController() {
		urlService = new URLService();
	}
	@Override
	public void doControl(Request request) {
		// todo chiamiamo il servizio
		URLname = request.get("URL").toString();
		UserID = (int) request.get("userID"); 
		URLDTO urltoinsert = new URLDTO(URLname, UserID);
		urlService.insert(urltoinsert);
		MainDispatcher.getInstance().callView("URL", request);
	}

}
