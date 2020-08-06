package it.contrader.model;

public class Statistiche {

	private int id;

	private int numeroUrl;

	private int numeroParole;

	private int numeroImmagini;

	private int numeroLink;

	private int numeroRicercaParole;

	public Statistiche() {

	}

	public Statistiche(int numeroUrl, int numeroParole, int numeroImmagini, int numeroLink, int numeroRicercaParole) {
		this.numeroUrl = numeroUrl;
		this.numeroParole = numeroParole;
		this.numeroImmagini = numeroImmagini;
		this.numeroLink = numeroLink;
		this.numeroRicercaParole = numeroRicercaParole;
	}

	public int getId() {
		return this.id;
	}
	public void setId(int id) {
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

	public String toString() {
		return  id + "\t"  + numeroUrl +"\t\t" + numeroParole + "\t\t" + numeroImmagini + "\t\t" + numeroLink + "\t\t" + numeroRicercaParole;
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Statistiche other = (Statistiche) obj;
		return 	id == other.id &&
				numeroParole == other.numeroParole &&
				numeroUrl == other.numeroUrl &&
				numeroImmagini == other.numeroImmagini &&
				numeroLink == other.numeroLink &&
				numeroRicercaParole == other.numeroRicercaParole;
	}

}
