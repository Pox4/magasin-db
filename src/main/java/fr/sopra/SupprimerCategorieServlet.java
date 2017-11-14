package fr.sopra;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/suppressionCategorie.html")
public class SupprimerCategorieServlet extends HttpServlet {
	@EJB
	private GestionDesProduits gestion;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		Categorie categorie = gestion.findCategorieById(Integer.parseInt(req.getParameter("categorieSupprimer")));

		gestion.deleteCategorie(categorie);

		resp.sendRedirect("categories.html");
	}

}
