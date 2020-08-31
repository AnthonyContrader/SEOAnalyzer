package it.contrader.dto;

public class StatisticheDTO {

	private Long id;

	private int numeroUrl;

	private int numeroParole;

	private int numeroImmagini;

	private int numeroLink;

	private int numeroRicercaParole;

	private int numeroUtenti;

	private int numeroUtentiAdmin;

	private int numeroUtentiUser;


	public StatisticheDTO() {

	}

	public StatisticheDTO(Long id, int numeroUrl, int numeroParole, int numeroImmagini, int numeroLink, int numeroRicercaParole,
			int numeroUtenti, int numeroUtentiAdmin, int numeroUtentiUser) {
		this.id = id;
		this.numeroUrl = numeroUrl;
		this.numeroParole = numeroParole;
		this.numeroImmagini = numeroImmagini;
		this.numeroLink = numeroLink;
		this.numeroRicercaParole = numeroRicercaParole;
		this.numeroUtenti = numeroUtenti;
		this.numeroUtentiAdmin = numeroUtentiAdmin;
		this.numeroUtentiUser = numeroUtentiUser;
	}

	public Long getId() {
		return this.id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public int getNumeroUrl() {
		return numeroUrl;
	}
	public void setNumeroUrl(int numeroUrl) {
		this.numeroUrl = numeroUrl;
	}
	public int getNumeroParole() {
		return numeroParole;
	}
	public void setNumeroParole(int numeroParole) {
		this.numeroParole = numeroParole;
	}
	public int getNumeroImmagini() {
		return numeroImmagini;
	}
	public void setNumeroImmagini(int numeroImmagini) {
		this.numeroImmagini = numeroImmagini;
	}
	public int getNumeroLink() {
		return numeroLink;
	}
	public void setNumeroLink(int numeroLink) {
		this.numeroLink = numeroLink;
	}
	public int getNumeroRicercaParole() {
		return numeroRicercaParole;
	}
	public void setNumeroRicercaParole(int numeroRicercaParole) {
		this.numeroRicercaParole = numeroRicercaParole;
	}
	

	public int getNumeroUtenti() {
		return numeroUtenti;
	}

	public void setNumeroUtenti(int numeroUtenti) {
		this.numeroUtenti = numeroUtenti;
	}

	public int getNumeroUtentiAdmin() {
		return numeroUtentiAdmin;
	}

	public void setNumeroUtentiAdmin(int numeroUtentiAdmin) {
		this.numeroUtentiAdmin = numeroUtentiAdmin;
	}

	public int getNumeroUtentiUser() {
		return numeroUtentiUser;
	}

	public void setNumeroUtentiUser(int numeroUtentiUser) {
		this.numeroUtentiUser = numeroUtentiUser;
	}
	

}
