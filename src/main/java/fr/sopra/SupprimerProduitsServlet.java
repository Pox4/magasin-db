package fr.sopra;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/supprimerProduit")
public class SupprimerProduitsServlet extends HttpServlet {

	@EJB
	private GestionDesProduits gestion;
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Produit produit = gestion.findById(Integer.parseInt(req.getParameter("produitSupprimer")));
		gestion.deleteProduit(produit);
		resp.sendRedirect("produits.html");
		
		
	}
	
	
}
