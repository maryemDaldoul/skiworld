package tn.esprit.services;

import java.util.List;

import javax.ejb.Local;


import tn.esprit.entities.Table;

import tn.esprit.entities.Menu;
@Local
public interface GestionTablesLocal {
	
		public Boolean add(Table table);
		public Boolean update(Table table);
		public Boolean delete(Table table);
		public List<Table> getAll();
		public List<Table> findByType(String type);
		//a ajouter pour laffectation 
		boolean TablehasMenu( int Idtable);
	
		
}
