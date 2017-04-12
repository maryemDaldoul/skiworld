package tn.esprit.services;

import javax.ejb.Remote;


import tn.esprit.entities.Table;

@Remote
public interface GestionTablesRemote {
	
		public Boolean add(Table table);
		public Boolean update(Table table);
		public Boolean delete(Table table);
		
	   
}
