package tn.esprit.entities;

import java.io.Serializable;
import javax.persistence.*;
import tn.esprit.entities.Personne;
/**
 * Entity implementation class for Entity: Admin
 *
 */
@Entity

public class Admin extends Personne implements Serializable {

	
	private int codeAdmin;
	private static final long serialVersionUID = 1L;

	public Admin() {
		super();
	}   
	public int getCodeAdmin() {
		return this.codeAdmin;
	}

	public void setCodeAdmin(int codeAdmin) {
		this.codeAdmin = codeAdmin;
	}
	//public Admin(String nom, String pwd, String login, int codeAdmin) {
		//super(nom, pwd, login);
		//this.codeAdmin = codeAdmin;
	//}
	public Admin(String cin, String nom, String prenom, String login, String password, int codeAdmin) {
		super(cin, nom, prenom, login, password);
		this.codeAdmin = codeAdmin;
		
	}
	
	
}
