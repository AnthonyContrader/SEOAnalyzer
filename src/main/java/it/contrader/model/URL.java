package it.contrader.model;

public class URL {

	/**
	 * Qui sotto definisco gli attributi di User. 
	 */
	private int URLID;

	private String URLname;
	
	private int UserID;

	/**
	 * Definisco i due costruttori, uno vuoto e uno con tre parametri per costrire oggetti di tipo User
	 */
	public URL() {
		
	}

	public URL(int URLID, String URLname, int UserID)
	{
		this.URLID = URLID;
		this.URLname = URLname;
		this.UserID = UserID;
	}
	
	public URL(String URLname, int UserID)
	{
		this.URLname = URLname;
		this.UserID = UserID;
	}
	
	public int getURLID() {
		return URLID;
	}
	public void setURLID(int uRLID) {
		URLID = uRLID;
	}
	public String getURLname() {
		return URLname;
	}
	public void setURLname(String uRLname) {
		URLname = uRLname;
	}
	public int getUserID() {
		return UserID;
	}
	public void setUserID(int userID) {
		UserID = userID;
	}
	
	@Override
	public String toString() {
		return  URLID + "\t"  + URLname +"\t\t" +   UserID;
	}

	//Metodo per il confronto degli oggetti
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		URL other = (URL) obj;
		if (URLID != other.URLID)
			return false;
		if (URLname == null) {
			if (other.URLname != null)
				return false;
		} else if (!URLname.equals(other.URLname))
			return false;
		if (UserID != other.UserID)
			return false;
		return true;
	}
}
