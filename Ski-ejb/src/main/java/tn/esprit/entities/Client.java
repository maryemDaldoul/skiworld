package tn.esprit.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

import tn.esprit.entities.Reservation;
//import tn.esprit.entities.Reservation;
import tn.esprit.entities.Personne;
/**
 * Entity implementation class for Entity: Client
 *
 */
@Entity

public class Client extends Personne implements Serializable  {
	//@Id
	//@GeneratedValue(strategy = GenerationType.AUTO)
	//private int idClient;
	//private int codeClient;

	//@OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
	//private List<Reservation> reservations;
	


	//private static final long serialVersionUID = 1L;

	//public Client() {
	//	super();
	//}   
	//public int getCodeClient() {
	//	return codeClient;
	//}
	//public void setCodeClient(int codeClient) {
	//	this.codeClient = codeClient;
	//}
	//public Client( int codeClient) {
	
	//	this.codeClient = codeClient;
	//}
	
	
	
	//public int getIdClient() {
	//	return idClient;
	//}
	//public void setIdClient(int idClient) {
	//	this.idClient = idClient;
	//}
	//public List<Reservation> getReservations() {
	//	return reservations;
	//}
	//public void setReservations(List<Reservation> reservations) {
	//	this.reservations = reservations;
	//}
	
	

		private List<Reservation> reservation;

		@OneToMany(mappedBy = "client")
		public List<Reservation> getReservation() {
			return reservation;
		}

		public void setReservation(List<Reservation> reservation) {
			this.reservation = reservation;
		}

	
}
