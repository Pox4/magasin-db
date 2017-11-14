package fr.sopra;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/editionprod.html")
public class EditionProduitServlet extends HttpServlet {

	@EJB
	private GestionDesProduits gestion;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Produit produit = new Produit();
		if (req.getParameterMap().containsKey("produit")){
			
			produit = gestion.findById(Integer.parseInt(req.getParameter("produit")));
		} else {
			produit = gestion.ajouterProduit(produit);
			produit.setNom("Entre un nouveau nom de produit");
			produit.setReference("Reference");
			
		}
		
		
		 
		req.setAttribute("produit", produit);
		req.setAttribute("listeCategories", gestion.findAllCategories());
		req.setAttribute("listeFabriquants", gestion.findAllFabriquants());
		req.getRequestDispatcher("/WEB-INF/produitsEdition.jsp").forward(req, resp);

		HttpSession session = req.getSession();
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		Produit produit = gestion.findById(Integer.parseInt(req.getParameter("produitId")));
		produit.setNom(req.getParameter("produitName"));
		gestion.ajouterProduit(produit);
		resp.sendRedirect("produits.html");

	}
	
	
	
}
