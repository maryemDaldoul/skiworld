package tn.esprit.services;

import javax.ejb.Local;

import tn.esprit.entities.Personne;

@Local
public interface IGestionUsers {

	Personne authentifier(String login, String pwd);

	void ajouterPersonne(Personne personne);
}
