package it.contrader.view;

import java.util.List;

import it.contrader.controller.Request;
import it.contrader.dto.UserDTO;
import it.contrader.main.MainDispatcher;


/**
 * 
 * @author Vittorio
 *
 * Si osservi che alla View arrivano solo oggetti di tipo DTO!
 */
public class AdminURLView extends AbstractView {

	private Request request;
	private String choice;

	public AdminURLView() {
		
	}

	/**
	 * Mostra la lista utenti
	 */
	@Override
	public void showResults(Request request) {
		if (request != null) {
			System.out.println("\n----------------- Pannello Admin ------------------\n");
			System.out.println("ID\t\tUsername\t\tURL");
			System.out.println("----------------------------------------------------\n");
			
			@SuppressWarnings("unchecked")
			List<String> record = (List<String>) request.get("adminlist");
			for (String r: record)
			{
				String[] temp = r.split(",");
				System.out.println(temp[0] + "\t\t" + temp[1] + "\t\t" + temp[2]);
			}
		}
	}

	/**
	 * Chiede all'utente un input (lettera da tastiera) per la choice (vedi UserController). 
	 * Mette la modalità GETCHOICE nella mode.
	 */
	@Override
	public void showOptions() {
		System.out.println("Scegli l'operazione da effettuare:");
		System.out.println("[B]ack [E]sci");

		this.choice = getInput();

		
	}
	
	/**
	 * Impacchetta la request e la manda allo UserController.
	 */
	@Override
	public void submit() {
		
		switch (choice.toLowerCase()) 
		{
		
		case "b":
			MainDispatcher.getInstance().callView("HomeAdmin", null);
			break;
		case "e":
			System.out.println("Arrivederci!");
			System.exit(0);
		default:
			System.out.println("Scelta errata. Riprovare!");
			break;
		}

		}
	}


