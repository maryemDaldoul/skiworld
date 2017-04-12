package tn.esprit.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import tn.esprit.entities.Resto;
import tn.esprit.entities.Worker;

/**
 * Session Bean implementation class GestionResto
 */
@Stateless
public class GestionResto implements GestionRestoRemote,GestionRestoLocal {
	 @PersistenceContext
		EntityManager em;// ntité objet pour parlr managmnt des ntit enregistrmnt ds donee
	 //dans lab ase 
    /**
     * Default constructor. 
     */
    public GestionResto() {
        // TODO Auto-generated constructor stub
    }
	@Override
	public Boolean add(Resto resto) {
		// TODO Auto-generated method stub
		try {
			em.persist(resto);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	@Override
	public Boolean update(Resto resto) {
		try {
			em.merge(resto);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	@Override
	public Boolean delete(Resto resto) {
		// TODO Auto-generated method stub
		
		try {
			em.remove(em.merge(resto));
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public List<Resto> getAll() {
		try {
			Query query = em.createQuery("select r from Resto r");
			return query.getResultList();
		} catch (Exception e) {
			return null;
		}
	}
	@Override
	public List<Resto> findByName(String name) {
		try {
			Query query = em.createQuery("select r from Resto r where r.name like:name").setParameter("name", name);
			return query.getResultList();
		} catch (Exception e) {
			return null;
		}
	}
	@Override
	public Resto findById(int id) {
		try {
			Query query = em.createQuery("select r from Resto r where r.idResto =:id").setParameter("id", id);
			return (Resto) query.getSingleResult();
		} catch (Exception e) {
			return null;
		}
	}// recherche par nom et etoiles //////////////////////
	@Override
	public List<Resto> chercherParNomEtEtoiles(String name,int nbstars) {
		TypedQuery<Resto> query = em.createNamedQuery("bynameAndEtoiles", Resto.class);
		query.setParameter("nom", name);
		query.setParameter("e", nbstars);

		return query.getResultList();
	}
	//////////////////////////////////////////////
	@Override
	public void affecterWorkerResto(Resto resto, Worker worker) {
		
			// //ajouter la chambre la BD
			 em.persist(worker);
			//
			// //récupérer la liste des chambres
			List<Worker> workers = resto.getWorkers();
			 workers.add(worker);
			 resto.setWorkers(workers);
			// //update hotel
			 em.merge(resto);

			// chambre est le bout master, on doit donc affecter l'hotel à la
			// chambre
			// et non l'inverse
			em.persist(worker);
			worker.setResto(resto);

		/////a ajouter pour lestat////
	}
	@Override
	public long getNbrParticipationByCathegory(String cat) {
		//return (int) em.createQuery("Select sum(c.nbrDownloads) from Cursus c where c.cathegory= :s").setParameter(1, cat).getSingleResult();	
		System.out.println("ssssssssssssss");
		long x= (long) em.createQuery("Select sum(c.nbstars) from Resto c where c.name= :s").setParameter("s", cat).setFirstResult(0).setMaxResults(1).getSingleResult();	
		System.out.println("ss"+x);
		return x;
		
	}
	
	@Override
	public Map<Resto, String> test() {
		Query query = em.createQuery("Select l from Resto l Group by l.name",Resto.class);
		 List<Resto> resto = query.getResultList();
		List<String> names = new ArrayList<>();
		for(Resto s:resto){
			names.add(s.getName());
		}
		Map<Resto, String> result = new HashMap<>();
		for(String s:names){
			TypedQuery<Resto> query2 = em.createQuery("Select l from Resto l where l.name:=s Order by l.Nbstars",Resto.class);
			Resto restos = query2.setFirstResult(0).setMaxResults(1).getSingleResult();
			//result.put(restos, s);			
		}
		//return result;
		return null;
	}
	@Override
	public String ReturnDescription(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<Resto> getName() {
		 System.out.println("List rsto");

			return em.createQuery("Select l from Resto l group by l.name",Resto.class).getResultList();
		}
	}
	


