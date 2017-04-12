package tn.esprit.services;

import java.util.List;

import javax.ejb.Local;
import javax.persistence.Query;


/*import persistance.Agence;
/*import persistance.Manager;*/
import tn.esprit.entities.Menu;
import tn.esprit.entities.Table;

@Local
public interface GestionMenuLocal {


	    public Boolean add(Menu menu);
		public Boolean update(Menu menu);
		public Boolean delete(Menu menu);
		public List<Menu> getAll();
		public List<Menu> findByPrice(String price);
		void affecterMenuTable(Menu menu, Table table);
	////// get 5 most active user////   
		public List<Menu> getMostActiveUsers();

////////////////affct table to menu jdida /////
		//// pour laffectation 
		
}