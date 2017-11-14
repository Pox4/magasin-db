package fr.sopra;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Produit {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@ManyToOne(cascade={CascadeType.PERSIST,CascadeType.MERGE})
	private Categorie categorie;
	
	@ManyToOne(cascade={CascadeType.PERSIST,CascadeType.MERGE})
	private Fabriquant fabriquant;

	private String nom;
	private String reference;

	
	public Fabriquant getFabriquant() {
		return fabriquant;
	}

	public void setFabriquant(Fabriquant fabriquant) {
		this.fabriquant = fabriquant;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Categorie getCategorie() {
		return categorie;
	}

	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getReference() {
		return reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}

}
