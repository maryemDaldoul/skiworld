package tn.esprit.services;

import javax.ejb.Remote;


import tn.esprit.entities.Resto;

@Remote
public interface GestionRestoRemote {
	
		public Boolean add(Resto resto);
		public Boolean update(Resto resto);
		public Boolean delete(Resto resto);
		
	   
}
