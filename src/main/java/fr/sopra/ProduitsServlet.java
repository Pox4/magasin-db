package fr.sopra;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/produits.html")
public class ProduitsServlet extends HttpServlet {

	@EJB
	private GestionDesProduits gestion;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		List<Produit> listeProduits;

		String search = req.getParameter("search");
		if (search != null && !search.isEmpty()) {

			listeProduits = gestion.findByName(search);
			req.setAttribute("listeProduits", gestion.findByName(search));
		}

		else {
			listeProduits = gestion.findAllProduits();
			req.setAttribute("listeProduits", gestion.findAllProduits());
		}

		req.getRequestDispatcher("/WEB-INF/produits.jsp").forward(req, resp);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		Produit produit = gestion.findById(Integer.parseInt(req.getParameter("produitId")));
		produit.setNom(req.getParameter("produitName"));
		produit.setReference(req.getParameter("referenceName"));
		produit.setFabriquant(gestion.findFabriquantById(Integer.parseInt(req.getParameter("fabriquantName"))));
		produit.setCategorie(gestion.findCategorieById(Integer.parseInt(req.getParameter("categorieName"))));

		gestion.uptdateProduit(produit);
		resp.sendRedirect("produits.html");

	}

}
