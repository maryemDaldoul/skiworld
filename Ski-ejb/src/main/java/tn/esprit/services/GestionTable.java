package tn.esprit.services;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import tn.esprit.entities.Menu;
import tn.esprit.entities.Table;

/**
 * Session Bean implementation class GestionResto
 */
@Stateless
public class GestionTable implements GestionTablesRemote,GestionTablesLocal {
	 @PersistenceContext
		EntityManager em;
    /**
     * Default constructor. 
     */
    public GestionTable() {
        // TODO Auto-generated constructor stub
    }
	@Override
	public List<Table> getAll() {
		try {
			Query query = em.createQuery("select t from Table t");
			return query.getResultList();
		} catch (Exception e) {
			return null;
		}
	}
	@Override
	public List<Table> findByType(String type) {
		try {
			Query query = em.createQuery("select t from Table t where t.type like:type").setParameter("type", type);
			return query.getResultList();
		} catch (Exception e) {
			return null;
		}
	}
	@Override
	public Boolean add(Table table) {
		try {
			em.persist(table);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	@Override
	public Boolean update(Table table) {
		try {
			em.merge(table);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	@Override
	public Boolean delete(Table table) {
		try {
			em.remove(em.merge(table));
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	// pour affecter menu to table 

	@Override
	public boolean TablehasMenu( int Idtable) {
		TypedQuery<Menu> query = em.createQuery("select m from Menu m where m.Table.Idtable=:Idtable", Menu.class);
		query.setParameter("Idtable", Idtable);
		if(query.getSingleResult()!=null){
			return true;
		}
		return false;
	}
	

}





	