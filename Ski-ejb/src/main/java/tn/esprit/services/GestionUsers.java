package tn.esprit.services;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;


import tn.esprit.entities.Personne;

@Stateless
public class GestionUsers implements IGestionUsers {

	@PersistenceContext
	EntityManager em;

	@Override
	public Personne authentifier(String login, String pwd) {
		TypedQuery<Personne> query = em.createQuery("Select p from Personne p where p.login=:login and p.password=:pwd",
				Personne.class);
		query.setParameter("login", login);
		query.setParameter("pwd", pwd);
		return query.getSingleResult();
	}

	

	@Override
	public void ajouterPersonne(Personne personne) {
		em.persist(personne);
		
	}

}
