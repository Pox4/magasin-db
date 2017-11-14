package fr.sopra;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@SuppressWarnings("serial")
@WebServlet("/edition.html")
public class EditionCategorieServlet extends HttpServlet {

	@EJB
	private GestionDesProduits gestion;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		Categorie categorie = new Categorie();

		if (req.getParameterMap().containsKey("categorie")) {

			categorie = gestion.findCategorieById(Integer.parseInt(req.getParameter("categorie")));

		} else {
			categorie = gestion.ajouterCategorie();
			categorie.setNom("Entrez un nom");
		}

		req.setAttribute("categorie", categorie);
		req.getRequestDispatcher("/WEB-INF/categoriesEdition.jsp").forward(req, resp);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		Categorie categorie = gestion.findCategorieById(Integer.parseInt(req.getParameter("categorieId")));
		categorie.setNom(req.getParameter("categorieName"));
		gestion.uptdateCategorie(categorie);
		resp.sendRedirect("http://localhost:8080/jpa-101-1.0-SNAPSHOT/categories.html");

	}

}
