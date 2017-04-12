package tn.esprit.services;

import java.util.List;

import javax.ejb.Local;


import tn.esprit.entities.Worker;

@Local
public interface GestionWorkerLocal {
	
		public Boolean add(Worker worker);
		public Boolean update(Worker worker);
		public Boolean delete(Worker worker);
		public List<Worker> getAll();
		public List<Worker> findByName(String name);
		
	   
}
