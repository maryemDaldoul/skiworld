package tn.esprit.services;

import java.util.Date;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import tn.esprit.entities.Client;
import tn.esprit.entities.Resto;
import tn.esprit.entities.Reservation;
import tn.esprit.entities.ReservationPk;

@Stateless
public class GestionReservation implements IGestionReservationLocal {
	@PersistenceContext
	EntityManager em;

	@Override
	public void reserverResto( Resto resto, String date, String startHour,String endHour) {
		ReservationPk pk = new ReservationPk();
		//pk.setIdClient(client.getCin());
		//pk.setIdresto(resto);
		//pk.setDateDebut(dateDebut);
		//pk.setDateFin(dateFin);
		// hna ta3ml 3amalyet ettissal :
		//gedhali enti kima fahem wtaw n3awedha bil porteuse
		
		
		
		Reservation reservation = new Reservation();
		
		//reservation.setClient(client); //
		reservation.setResto(resto); // hadhom ya3MLou relation
		
		reservation.setDate(date); // w hadhom les données lo5rin
		reservation.setEndHour(endHour);
		reservation.setStarthour(startHour);
		
		reservation.setReservationPk(pk);
		em.persist(reservation);
	}

}
