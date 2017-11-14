package fr.sopra;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/index.html")
public class TestServlet extends HttpServlet {

	@EJB
	private GestionDesProduits gestionDesProduits;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		List<Fabriquant> listeFabriquants = gestionDesProduits.findAllFabriquants();
				if (listeFabriquants.isEmpty()) {

					listeFabriquants = new ArrayList<>();
					
		for (int i = 0; i < 10; i++) {

			listeFabriquants.add(gestionDesProduits.ajouterFabriquant());

		}
				}

		
		List<Categorie> listeCategories = gestionDesProduits.findAllCategories();

		if (listeCategories.isEmpty()) {

			listeCategories = new ArrayList<>();
			for (int i = 0; i < 10; i++) {

				listeCategories.add(gestionDesProduits.ajouterCategorie());

			}

		}

		for (int i = 0; i < 100; i++) {

			Produit produit = new Produit();
			Categorie categorie = listeCategories.get(new Random().nextInt(listeCategories.size()));
			produit.setCategorie(categorie);
			Fabriquant fabriquant = listeFabriquants.get(new Random().nextInt(listeFabriquants.size()));
			produit.setFabriquant(fabriquant);
			produit.setNom("Produit" + System.nanoTime());
			produit.setReference(UUID.randomUUID().toString());
			gestionDesProduits.ajouterProduit(produit);

		}

	}

}
