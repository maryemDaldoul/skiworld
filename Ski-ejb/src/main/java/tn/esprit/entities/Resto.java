package tn.esprit.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

//import persistance.Reservation;

/**
 * Entity implementation class for Entity: Resto
 *
 */
@Entity

public class Resto implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int Idresto;
	private String name;
	private String location;
	private String description;
	private int nbstars;
	private int nbtables;
	
	@OneToMany(mappedBy = "resto", cascade = CascadeType.ALL)
	private List<Reservation> reservations;
	

	@OneToMany(mappedBy = "resto", cascade = CascadeType.ALL)
	private List<Table> tables;

	@OneToMany(mappedBy = "resto", cascade = CascadeType.ALL)
	private List<Worker> workers;
	


	public Resto() {
		super();
	}

	public Resto(int Idresto, String name, String location, String description, int nbstars, int nbtables) {

		this.Idresto = Idresto;
		this.name = name;
		this.location = location;
		this.description = description;
		this.nbstars = nbstars;
		this.nbtables = nbtables;
	}
	

	public int getIdresto() {
		return Idresto;
	}

	public void setIdresto(int idresto) {
		Idresto = idresto;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getNbstars() {
		return nbstars;
	}

	public void setNbstars(int nbstars) {
		this.nbstars = nbstars;
	}

	public int getNbtables() {
		return nbtables;
	}

	public void setNbtables(int nbtables) {
		this.nbtables = nbtables;
	}

	public List<Table> getTables() {
		return tables;
	}

	public void setTables(List<Table> tables) {
		this.tables = tables;
	}

	public List<Worker> getWorkers() {
		return workers;
	}

	public void setWorkers(List<Worker> workers) {
		this.workers = workers;
	}

	public List<Reservation> getReservations() {
		return reservations;
	}

	public void setReservations(List<Reservation> reservations) {
		this.reservations = reservations;
	}

	
	
	
	
	
}
