package fr.sopra;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.UUID;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.sopra.utilisateurs.GestionUtilisateur;
import fr.sopra.utilisateurs.Utilisateurs;

@WebServlet("/categories.html")
public class CategoriesServlet extends HttpServlet {

	@EJB
	private GestionDesProduits gestion;
	

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		
		List<Categorie> categories = gestion.findAllCategories();
		Map<Integer, Long> nbrProduitsParCategorie = new HashMap<>();

		for (Categorie current : categories) {
			nbrProduitsParCategorie.put(current.getId(), gestion.nbrProduitParCategorie(current.getId()));
		}

		req.setAttribute("nbrProduitsParCategorie", nbrProduitsParCategorie);
		req.setAttribute("listeCategories", gestion.findAllCategories());

		req.getRequestDispatcher("/WEB-INF/categories.jsp").forward(req, resp);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		Categorie categorie = gestion.findCategorieById(Integer.parseInt(req.getParameter("categorieId")));
		categorie.setNom(req.getParameter("categorieName"));

		gestion.uptdateCategorie(categorie);
		resp.sendRedirect("/categories");

	}

}
