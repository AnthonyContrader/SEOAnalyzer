package it.contrader.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import it.contrader.dto.StatisticheDTO;
import it.contrader.dto.UserDTO;
import it.contrader.service.StatisticheService;
import it.contrader.service.LoginService;

@Controller
@RequestMapping("/home")
public class HomeController {
	
	@Autowired
	private LoginService service;
	
	@Autowired
	private StatisticheService statisticheService;

	@PostMapping("/login")
	public String login(HttpServletRequest request, @RequestParam(value = "username", required = true) String username,
			@RequestParam(value = "password", required = true) String password) {

		UserDTO userDTO = service.findByUsernameAndPassword(username, password);
		request.getSession().setAttribute("user", userDTO);

		switch (userDTO.getUsertype().toString()) {
		case "ADMIN":
			StatisticheDTO statisticheDTO = statisticheService.findByID(new Long(1));
			request.getSession().setAttribute("numeroImmagini", statisticheDTO.getNumeroImmagini());
			request.getSession().setAttribute("numeroLink", statisticheDTO.getNumeroLink());
			request.getSession().setAttribute("numeroParole", statisticheDTO.getNumeroParole());
			request.getSession().setAttribute("numeroRicercaParole", statisticheDTO.getNumeroRicercaParole());
			request.getSession().setAttribute("numeroUrl", statisticheDTO.getNumeroUrl());
			request.getSession().setAttribute("numeroUtenti", statisticheDTO.getNumeroUtenti());
			request.getSession().setAttribute("numeroUtentiAdmin", statisticheDTO.getNumeroUtentiAdmin());
			request.getSession().setAttribute("numeroUtentiUser", statisticheDTO.getNumeroUtentiUser());
			return "homeadmin";

		case "USER":
			return "homeuser";

		default:
			return "index";
		}
	}
	@GetMapping("/index")
	public String home(HttpServletRequest request) {
		
		UserDTO userDTO = (UserDTO)request.getSession().getAttribute("user");
		switch (userDTO.getUsertype().toString()) {
		case "ADMIN":
			StatisticheDTO statisticheDTO = statisticheService.findByID(new Long(1));
			request.getSession().setAttribute("numeroUtenti", statisticheDTO.getNumeroUtenti());
			request.getSession().setAttribute("numeroUtentiAdmin", statisticheDTO.getNumeroUtentiAdmin());
			request.getSession().setAttribute("numeroUtentiUser", statisticheDTO.getNumeroUtentiUser());
			return "homeadmin";

		case "USER":
			return "homeuser";

		default:
			return "index";
		}
	}
}
