package fr.sopra.utilisateurs;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import fr.sopra.Categorie;

@Stateless
public class GestionUtilisateur {

	@PersistenceContext(name = "Catalogue") // EJB
	EntityManager em; // JPA, Base de données

	public Utilisateurs login(String login, String password) {

		TypedQuery<Utilisateurs> query = em
				.createQuery("select u from Utilisateurs u where u.login=:login and u.password=:password" ,Utilisateurs.class)
				.setParameter("login", login).setParameter("password", password);

		return query.getSingleResult();
	}
	
	


	public Utilisateurs findByLogin(String login) {
		
		Utilisateurs utilisateur = em.find(Utilisateurs.class, login);
		return utilisateur;

	}

	public void add(Utilisateurs utilisateur) {
		em.persist(utilisateur);

	}




	public List<Utilisateurs> findAllUtilisateurs() {
		TypedQuery<Utilisateurs> query = em.createQuery("from Utilisateurs", Utilisateurs.class);
		return query.getResultList();
	}
}
