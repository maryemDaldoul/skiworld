package tn.esprit.services;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import tn.esprit.entities.Table;

import tn.esprit.entities.Menu;
import tn.esprit.entities.Table;



/**
 * Session Bean implementation class GestionMenu
 */
@Stateless
public class GestionMenu implements GestionMenuRemote,GestionMenuLocal {
	 @PersistenceContext
		EntityManager em;
    /**
     * Default constructor. 
     */
    public GestionMenu() {
        // TODO Auto-generated constructor stub
    }
	@Override
	public List<Menu> getAll() {
		try {
			Query query = em.createQuery("select m from Menu m ");
			return query.getResultList();
		} catch (Exception e) {
			return null;
		}
	}
	
	@Override
	public Boolean add(Menu menu) {
		
		try {
			em.persist(menu);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	@Override
	public Boolean update(Menu menu) {
		try {
			em.merge(menu);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	@Override
	public Boolean delete(Menu menu) {
		try {
			em.remove(em.merge(menu));
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	@Override
	public List<Menu> findByPrice(String price) {
	
		try {
			Query query = em.createQuery("select m from Menu m where m.price like:price").setParameter("price", price);
			return query.getResultList();
		} catch (Exception e) {
			return null;
		}
	}
	@Override
	public void affecterMenuTable(Menu menu, Table table) {
		// TODO Auto-generated method stub

        	table = em.find(Table.class, table.getIdtable());
        	// A Vrifier 
			table.setMenus((List<Menu>) menu);
			
		}
	////////// most active users///////
	@Override
	public List<Menu> getMostActiveUsers() {
	
			Query query= em.createQuery("SELECT m FROM Menu m order by Idmenu desc").setMaxResults(5);
			return query.getResultList();
		
		
	}
	///////////////// affctation menu table 
	
	}

	
	

