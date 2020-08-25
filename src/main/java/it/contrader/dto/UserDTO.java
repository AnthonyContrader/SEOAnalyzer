package it.contrader.dto;

import it.contrader.model.User.Usertype;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class UserDTO {

	private Long id;

	private String username;

	private String password;

	private Usertype usertype;

	public UserDTO(Long id, String username, String password, Usertype usertype) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.usertype = usertype;
	}

	public UserDTO() {
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public Usertype getUsertype() {
		return usertype;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setUsertype(Usertype usertype) {
		this.usertype = usertype;
	}

	
	
}
