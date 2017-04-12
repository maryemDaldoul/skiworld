package tn.esprit.services;

import javax.ejb.Remote;


import tn.esprit.entities.Worker;

@Remote
public interface GestionWorkerRemote {
	
		public Boolean add(Worker worker);
		public Boolean update(Worker worker);
		public Boolean delete(Worker worker);
		
	   
}
