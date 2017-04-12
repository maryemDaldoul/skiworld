package tn.esprit.services;

import javax.ejb.Remote;


import tn.esprit.entities.Menu;

@Remote
public interface GestionMenuRemote {
	
		public Boolean add(Menu menu);
		public Boolean update(Menu menu);
		public Boolean delete(Menu menu);
		
	   
}
