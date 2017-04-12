package tn.esprit.services;

import java.util.Date;

import javax.ejb.Local;

import tn.esprit.entities.Client;
import tn.esprit.entities.Resto;

@Local
public interface IGestionReservationLocal {


	void reserverResto( Resto resto, String date, String startHour,String endHour);
}
