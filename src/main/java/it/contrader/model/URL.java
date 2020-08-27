package it.contrader.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "url")
public class URL {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String URLname;
	
	@OneToOne(targetEntity = User.class)
	@JoinColumn(name = "id")
	private Long userID;

	public URL() {
		
	}

	public URL(Long URLID, String URLname, Long UserID)
	{
		this.id = URLID;
		this.URLname = URLname;
		this.userID = UserID;
	}
	
	public URL(String URLname, Long UserID)
	{
		this.URLname = URLname;
		this.userID = UserID;
	}
	
	public Long getURLID() {
		return id;
	}
	public void setURLID(Long urlID) {
		id = urlID;
	}
	public String getURLname() {
		return URLname;
	}
	public void setURLname(String uRLname) {
		URLname = uRLname;
	}
	public Long getUserID() {
		return userID;
	}
	
	public void setUserID(Long userID) {
		this.userID = userID;
	}
}
