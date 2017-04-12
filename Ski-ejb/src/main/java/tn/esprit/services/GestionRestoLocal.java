package tn.esprit.services;

import java.util.List;
import java.util.Map;

import javax.ejb.Local;


import tn.esprit.entities.Resto;
import tn.esprit.entities.Worker;

@Local
public interface GestionRestoLocal {
	
		public Boolean add(Resto resto);
		public Boolean update(Resto resto);
		public Boolean delete(Resto resto);
		public List<Resto> getAll();
		public List<Resto> findByName(String name);
		public Resto findById(int id);
		//rechercher par nom et nbr star 
		public List<Resto> chercherParNomEtEtoiles(String name,int nbrstars );
		void affecterWorkerResto(Resto resto, Worker worker);
		 
		 //statistique
		 long getNbrParticipationByCathegory(String cat);
		 
		//More participated Cursus at every category
		 Map<Resto,String> test();
		 
		 String ReturnDescription(int id );
		public List<Resto> getName();
		
		

}
