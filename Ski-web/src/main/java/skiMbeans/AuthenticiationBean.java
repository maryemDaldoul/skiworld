package skiMbeans;


import java.io.Serializable;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import tn.esprit.entities.Admin;
import tn.esprit.entities.Personne;
import tn.esprit.services.IGestionUsers;

@ManagedBean
@SessionScoped // tous ce qui est sssion 
public class AuthenticiationBean implements Serializable{

	private String login;
	private String password;
	private Personne personne;
	@EJB
	private IGestionUsers gestionUsers;

	public String login() {
		personne = gestionUsers.authentifier(login, password);
		if (personne != null) {
			if (personne instanceof Admin) {
				return "client/reserverHotel?faces-redirect=true";
			
			} else
				return "login?faces-redirect=true";
		} else
			return "login?faces-redirect=true";
	}

	public String logout() {
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		return "/login?faces-redirect=true";
	}

	public IGestionUsers getGestionUsers() {
		return gestionUsers;
	}

	public void setGestionUsers(IGestionUsers gestionUsers) {
		this.gestionUsers = gestionUsers;
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

	public Personne getPersonne() {
		return personne;
	}

	public void setPersonne(Personne personne) {
		this.personne = personne;
	}

}
