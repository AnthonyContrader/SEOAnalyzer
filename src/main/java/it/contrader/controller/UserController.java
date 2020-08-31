package it.contrader.controller;


import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import it.contrader.service.StatisticheService;
import it.contrader.controller.utils.*;
import it.contrader.dto.StatisticheDTO;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private StatisticheService statisticheService;
	
	@PostMapping("/analyze")
	public String urlAnalyze(HttpServletRequest request, @RequestParam(value = "linkUrl", required = true) String linkUrl) {
		request.getSession().setAttribute("linkurl", linkUrl);
		request.setAttribute("url", linkUrl);
		
		ContaParole.conta(request);
		ContaImmagini.conta(request);
		ContaLink.conta(request);
		Ottimizzazione.ottimizza(request);
		
		StatisticheDTO statisticheDTO = statisticheService.read(1);
		statisticheDTO.setNumeroUrl(statisticheDTO.getNumeroUrl()+1);
		statisticheDTO.setNumeroParole(statisticheDTO.getNumeroParole() + (int)request.getAttribute("numeroParole"));
		statisticheDTO.setNumeroImmagini(statisticheDTO.getNumeroImmagini() + (int)request.getAttribute("numImg"));
		statisticheDTO.setNumeroLink(statisticheDTO.getNumeroLink() + (int)request.getAttribute("numLink"));
		statisticheService.update(statisticheDTO);
		
		return "homeurl";
	}
	
	@GetMapping("/logout")
	public String logout(HttpServletRequest request) {
		request.getSession().invalidate();
		return "index";
	}

}
