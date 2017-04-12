package tn.esprit.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

import tn.esprit.entities.Client;
import tn.esprit.entities.Resto;
import tn.esprit.entities.ReservationPk;

/**
 * Entity implementation class for Entity: Reservation
 *
 *
 */
@Entity
//ski projct
public class Reservation implements Serializable {
	@EmbeddedId
	@GeneratedValue(strategy = GenerationType.AUTO)
	private ReservationPk reservationPk;
	private String date;
	private String endHour;
	private String starthour;
	
	@ManyToOne
	@JoinColumn(name = "resto")
	private Resto resto;
	@ManyToOne
	@JoinColumn(name = "client")
	private Client client;
	

	private static final long serialVersionUID = 1L;

	public Reservation() {
		super();
	}

	public ReservationPk getReservationPk() {
		return reservationPk;
	}

	public void setReservationPk(ReservationPk reservationPk) {
		this.reservationPk = reservationPk;
	}

	public Resto getResto() {
		return resto;
	}

	public void setResto(Resto resto) {
		this.resto = resto;
	}
	
	public String getEndHour() {
		return endHour;
	}

	public void setEndHour(String endHour) {
		this.endHour = endHour;
	}

	public String getStarthour() {
		return starthour;
	}

	public void setStarthour(String starthour) {
		this.starthour = starthour;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

}
