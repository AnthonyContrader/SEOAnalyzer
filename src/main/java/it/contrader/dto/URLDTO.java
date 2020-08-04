package it.contrader.dto;

public class URLDTO implements DTO {
	private int URLID;
	private String URLname;
	private int UserID;
	
	public URLDTO(int URLID, String URLname, int UserID)
	{
		this.URLID = URLID;
		this.URLname = URLname;
		this.UserID = UserID;
	}
	
	public URLDTO(String URLname, int UserID)
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
}
