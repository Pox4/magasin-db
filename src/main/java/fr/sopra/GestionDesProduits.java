package fr.sopra;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

@Stateless
public class GestionDesProduits {

	@PersistenceContext(name = "Catalogue")
	EntityManager em;

	public Produit findById(int id) {

		Produit p = em.find(Produit.class, id);

		return p;
	}

	public Fabriquant ajouterFabriquant() {

		Fabriquant fabriquant = new Fabriquant();
		fabriquant.setNom("Fabriquant" + System.nanoTime());
		fabriquant.setAdresse("AdresseFabriquant" + System.nanoTime());
		em.persist(fabriquant);

		return fabriquant;
	}

	public Categorie ajouterCategorie() {
		Categorie categorie = new Categorie();
		categorie.setNom("Categorie" + System.nanoTime());
		em.persist(categorie);
		return categorie;
	}

	public Produit ajouterProduit(Produit produit) {

		return em.merge(produit);

	}

	public List<Categorie> findAllCategories() {
		TypedQuery<Categorie> query = em.createQuery("from Categorie", Categorie.class);
		return query.getResultList();
	}

	public List<Fabriquant> findAllFabriquants() {
		TypedQuery<Fabriquant> query = em.createQuery("from " + Fabriquant.class.getSimpleName(), Fabriquant.class);
		return query.getResultList();
	}
	
	public List<Produit> findAllProduits() {
		TypedQuery<Produit> query = em.createQuery("from " + Produit.class.getSimpleName(), Produit.class);
		return query.getResultList();
	}

	public void afficherCategorie(int id) {
		Categorie categorie = em.find(Categorie.class, id);
		System.out.println(" Nom Catégorie : " + categorie.getNom());

		for (Produit current : categorie.getProduits()) {
			System.out.println(" Nom Produit : " + current.getNom());
		}

	}
	
	public Categorie findCategorieById(int id){
		Categorie categorie = em.find(Categorie.class, id);
		return categorie;
	}
	
	public Fabriquant findFabriquantById(int id){
		Fabriquant fabriquant = em.find(Fabriquant.class, id);
		return fabriquant;
	}
	
	public void uptdateCategorie(Categorie categorie){
		em.merge(categorie);
	}
	
	public void uptdateFabriquant(Fabriquant fabriquant){
		em.merge(fabriquant);
	}
	
	public void uptdateProduit(Produit produit){
		em.merge(produit);
	}

	public void deleteCategorie(Categorie categorie) {
		em.remove(em.find(Categorie.class, categorie.getId()));
		
	}
	
	public void deleteFabriquant(Fabriquant fabriquant) {
		em.remove(em.find(Fabriquant.class, fabriquant.getId()));
		
	}

	public void deleteProduit(Produit produit) {
		
		em.remove(em.find(Produit.class, produit.getId()));
		
	}
	
	public List<Produit> findAllProduitFromCategorie(Categorie categorie){
		
		Query query = em.createQuery("from Produit p where p.categorie=:categorie").setParameter("categorie", categorie.getProduits());
		List<Produit> listeProduitsCategorie = query.getResultList();
		
		return listeProduitsCategorie;
		
	}
	
public List<Produit> findAllProduitFromFabriquant(Fabriquant fabriquant){
		
		Query query = em.createQuery("from Produit p where p.fabriquant=:fabriquant").setParameter("fabriquant", fabriquant.getProduits());
		List<Produit> listeProduitsFabriquant = query.getResultList();
		
		return listeProduitsFabriquant;
		
	}


public Long nbrProduitParCategorie(Integer id) {
    TypedQuery<Long> query = em.createQuery("select count(p) from Produit p where p.categorie.id=:id", Long.class);
    query.setParameter("id", id);
    return query.getSingleResult();
}

public Long nbrProduitParFabriquant(Integer id) {
    TypedQuery<Long> query = em.createQuery("select count(p) from Produit p where p.fabriquant.id=:id", Long.class);
    query.setParameter("id", id);
    return query.getSingleResult();
}

public List<Produit> findByName(String search) {
    TypedQuery<Produit> query = em.createQuery("select p from Produit p where p.nom like :search", Produit.class);
    query.setParameter("search", "%" + search + "%");
    return query.getResultList();
}

}
