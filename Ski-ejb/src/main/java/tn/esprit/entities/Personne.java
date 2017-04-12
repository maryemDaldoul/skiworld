package tn.esprit.entities;

import java.io.Serializable;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;


@Entity
@Inheritance(strategy=InheritanceType.JOINED)
public class Personne implements Serializable {

	private String cin;
	private String nom;
	private String prenom;
	private String login;
	private String password;
	
	
	private static final long serialVersionUID = 1L;

	public Personne() {
		super();
	}
	@Id    
	@GeneratedValue(strategy=GenerationType.AUTO)
	public String getCin() {
		return cin;
	}

	public void setCin(String cin) {
		this.cin = cin;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	public Personne(String cin, String nom, String prenom, String login, String password) {
		super();
		this.cin = cin;
		this.nom = nom;
		this.prenom = prenom;
		this.login = login;
		this.password = password;
	}   
	
	
	
	
}
