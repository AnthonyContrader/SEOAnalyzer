package it.contrader.controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import it.contrader.service.UserService;
import it.contrader.controller.utils.*;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService service;
	
	@PostMapping("/analyze")
	public String urlAnalyze(HttpServletRequest request) {
		final HttpSession session = request.getSession();
		request.setAttribute("url", session.getAttribute("linkurl").toString());
		System.out.println("analisi");
		//ContaParole.conta(request);
		ContaImmagini.conta(request);
		System.out.println("ho contato le immagini");
		ContaLink.conta(request);
		//Ottimizzazione.ottimizza(request);
		System.out.println("fine analisi");
		return "homeurl";
	}
	
	@GetMapping("/logout")
	public String logout(HttpServletRequest request) {
		request.getSession().invalidate();
		return "index";
	}

}
