package it.contrader.controller;

import java.util.List;

import it.contrader.dto.URLDTO;
import it.contrader.dto.UserDTO;
import it.contrader.main.MainDispatcher;
import it.contrader.model.URL;
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
	
	public void readCronologia(Request request)
	{
		//System.out.println("test riuscito");
		UserID = (int) request.get("userID"); 
		List<URLDTO> cronologia = urlService.read(UserID);
		int i= 1;
		for(URLDTO url:cronologia)
		{
			if(i<6 )
			{
				//System.out.println(i+1 + ") " + url.getURLname());
				request.put("URL" + i, url.getURLname());
				//request.put("url2", url.getURLname());
				//System.out.println(i+1 + ") " + request.get("URL"+i+1));
				
				
			}
			else break;
			i++;
		}
		
		MainDispatcher.getInstance().callView("SceltaURL", request);
		//return cronologia;
	}
	
	public void readAdmin(Request request)
	{
		List<String> adminList = urlService.readAdmin();
		System.out.println(request);
		request.put("adminlist", adminList);
		System.out.println(request.get("adminlist"));
		MainDispatcher.getInstance().callView("AdminURL", request);
	
	}

}
