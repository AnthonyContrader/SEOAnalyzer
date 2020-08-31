package it.contrader.model;

import javax.persistence.Entity;

import java.util.Date;

import javax.persistence.*;
import javax.persistence.GenerationType;
import javax.persistence.Id;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Statistiche {
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_statistiche")
	private long id;
	
	@Column(name = "id_url")
	private long idUrl;
	
	@Column(name = "numero_parole")
	private int numeroParole;
	
	@Column(name = "numero_immagini")
	private int numeroImmagini;
	
	@Column(name = "numero_link")
	private int numeroLink;
	
	@Column(name = "dataRicerca")
	private Date dataRicerca;
	
	
}
