package it.contrader.converter;

import java.util.ArrayList;
import java.util.List;

import it.contrader.dto.URLDTO;
import it.contrader.model.URL;

/**
 * 
 * @author Vittorio, De Santis 
 *
 */
public class URLConverter   { //TODO
	
	/**
	 * Crea un oggetto di tipo UserDTO e lo riempie con i campi del parametro user di tipo User.
	 * Notare l'uso del metodo get() per ottenere il valore dell'attributo-
	 */
	public URLDTO toDTO(URL url) {
		URLDTO urlDTO = new URLDTO(url.getURLID(), url.getURLname(), url.getUserID());
		return urlDTO;
	}

	/**
	 * Crea un oggetto di tipo User e lo riempie con i campi del parametro user di tipo UserDTO.
	 * Notare l'uso del metodo get() per ottenere il valore dell'attributo-
	 */
	public URL toEntity(URLDTO urlDTO) {
		URL url = new URL(urlDTO.getURLID(), urlDTO.getURLname(), urlDTO.getUserID());
		return url;
	}
	
	/**
	 * Metodo per convertire le liste di User.
	 */
	public List<URLDTO> toDTOList(List<URL> urlList) {
		//Crea una lista vuota.
		List<URLDTO> urlDTOList = new ArrayList<URLDTO>();
		
		//Cicla tutti gli elementi della lista e li converte uno a uno
		for(URL url : urlList) {
			//Utilizza il metodo toDTO per convertire ogni singolo elemento della lista
			//e lo aggiunge adda lista di DTO
			urlDTOList.add(toDTO(url));
		}
		return urlDTOList;
	}

	
	
}
