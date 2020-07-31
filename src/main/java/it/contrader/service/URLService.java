package it.contrader.service;

import java.util.List;

import it.contrader.converter.URLConverter;
import it.contrader.dao.URLDAO;
import it.contrader.dto.URLDTO; //URLDTO

/**
 * 
 * @author Vittorio, De Santis
 *
 *Grazie all'ereditariet� mi basta specificare i tipi di questa classe per
 *ereditare i metodi della clase AbstractService. Pertanto la classe risulta meno complicata
 *da scrivere, facendoci risparmiare tempo e fatica!
 */
public class URLService {
	
	private URLDAO urlDAO;
	private URLConverter urlConverter;
	
	//Istanzio DAO  e Converter specifici.
	public URLService(){
		this.urlDAO = new URLDAO();
		this.urlConverter = new URLConverter();
	}
	

	/*public List<UserDTO> getAll() {
		// Ottiene una lista di entit� e le restituisce convertendole in DTO
		return userConverter.toDTOList(userDAO.getAll());
	}*/


	public List<URLDTO> read(int id) {
		// Ottiene un'entit� e la restituisce convertendola in DTO
		return urlConverter.toDTOList(urlDAO.read(id));
	}


	public void insert(URLDTO dto) {
		// Converte un DTO in entit� e lo passa al DAO per l'inserimento
		
		urlDAO.insert(urlConverter.toEntity(dto));
	}
}
