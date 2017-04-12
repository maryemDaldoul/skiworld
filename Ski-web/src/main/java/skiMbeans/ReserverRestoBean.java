package skiMbeans;


import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import tn.esprit.entities.Client;
import tn.esprit.entities.Resto;
import tn.esprit.services.GestionRestoLocal;

import tn.esprit.services.IGestionReservationLocal;

@ManagedBean// pour voir html 
@ViewScoped
public class ReserverRestoBean {

	private List<Resto> restos;
	private Resto selectedResto;
	private Boolean renderReserver=false;
	private String date; // nasi7a e5dem b string w 5alik min Object Date 3la 5ater 9erbela fih 
							// thama 7kayet converion w tnajem tdhaya3lk wa9tek, just n7ottou pattern fi lcomposant primefaces
	private String startHour;
	private String endHour;
	@EJB //appl srvice 
	GestionRestoLocal adminResto;
	@EJB
	IGestionReservationLocal gestionReservationLocal;
	@ManagedProperty(value = "#{authenticiationBean}")
	private AuthenticiationBean authenticiationBean;

	
	public String reserver(){
		// w hna a3Mlou appel (getByLogin) w 7otou fi object client 
		// w mba3ed 7otou en parametre kif tji ta3ml fi reservation
		//?? fhemt ? nhotou en parametre fi heki?, oui ok w mba3ed?  a3ml reservation 3la ro7ek w twali temchi man
		//eni nheb nefhem est ce que tnajemtmachi reservation ma8ir login sa3a wahadha 9bel wela ? 
		// eyh eli kont nekteblk fih tawa ymachilk reservation blech login
		gestionReservationLocal.reserverResto( selectedResto, date, startHour,endHour);
		// (Client) authenticiationBean.getPersonne() hadha tba9a min 5edmt login
		// tba9a kan fazet deja reservé hadhika lazmna net7aslou 3La reservation temchi sa3
		// ey w reservation temchi wela? eyh mais tba9a 7kayet login hadhika 3endk enti 
		System.out.println(date);
		//ey fhemtek mais tawa ki testi 3al page tet3ada? sans login 
		return null;
	}

	@PostConstruct// pour l run d projet jboss ylawj 3al managedban 
	public void init() {
		restos = adminResto.getAll();
	}

	public List<Resto> getRestos() {
		return restos;
	}

	public void setRestos(List<Resto> restos) {
		this.restos = restos;
	}

	public Resto getSelectedResto() {
		return selectedResto;
	}

	public void setSelectedResto(Resto selectedResto) {
		this.selectedResto = selectedResto;
	}
	public Boolean getRenderReserver() {
		return renderReserver;
	}
	public void setRenderReserver(Boolean renderReserver) {
		this.renderReserver = renderReserver;
	}

	public AuthenticiationBean getAuthenticiationBean() {
		return authenticiationBean;
	}

	public void setAuthenticiationBean(AuthenticiationBean authenticiationBean) {
		this.authenticiationBean = authenticiationBean;
	}

	public String getStartHour() {
		return startHour;
	}

	public void setStartHour(String startHour) {
		this.startHour = startHour;
	}

	public String getEndHour() {
		return endHour;
	}

	public void setEndHour(String endHour) {
		this.endHour = endHour;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
}
