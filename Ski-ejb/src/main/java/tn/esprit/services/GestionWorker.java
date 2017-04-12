package tn.esprit.services;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import tn.esprit.entities.Worker;



/**
 * Session Bean implementation class GestionWorker
 */
@Stateless
public class GestionWorker implements GestionWorkerRemote,GestionWorkerLocal {
	 @PersistenceContext
		EntityManager em;
    /**
     * Default constructor. 
     */
    public GestionWorker() {
        // TODO Auto-generated constructor stub
    }
	
	
	@Override
	public Boolean add(Worker worker) {
		try {
			em.persist(worker);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	@Override
	public Boolean update(Worker worker) {
		try {
			em.merge(worker);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	@Override
	public Boolean delete(Worker worker) {
		try {
			em.remove(em.merge(worker));
			return true;
		} catch (Exception e) {
			return false;
		}
}
	@Override
	public List<Worker> getAll() {
		try {
			Query query = em.createQuery("select w from Worker w");
			return query.getResultList();
		} catch (Exception e) {
			return null;
		}
	}
	@Override
	public List<Worker> findByName(String name) {
		try {
			Query query = em.createQuery("select w from Worker w where w.name like:name").setParameter("name", name);
			return query.getResultList();
		} catch (Exception e) {
			return null;
		}
	}
	
	

}
