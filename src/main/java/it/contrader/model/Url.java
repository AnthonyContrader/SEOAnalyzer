package it.contrader.model;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Url {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_url")
	private long id;
	
	@Column(name = "url_name")
	private String urlName;
	
	@ManyToOne(optional=false, targetEntity=User.class)
    @JoinColumn(name="idUser",referencedColumnName="id_user")
	private long idUser;
	
}
