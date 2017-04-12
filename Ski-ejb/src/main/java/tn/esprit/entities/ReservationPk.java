package tn.esprit.entities;

import java.io.Serializable;
import javax.persistence.Embeddable;

import tn.esprit.entities.ReservationPk;

@Embeddable
public class ReservationPk implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int Idresto;
	private int idClient;
	
	
	public int getIdresto() {
		return Idresto;
	}
	public void setIdresto(int idresto) {
		Idresto = idresto;
	}
	public int getIdClient() {
		return idClient;
	}
	public void setIdClient(int idClient) {
		this.idClient = idClient;
	}
	
	public ReservationPk(int idresto, int idClient) {
		super();
		Idresto = idresto;
		this.idClient = idClient;
	}
	public ReservationPk() {
		super();
	}
	
}