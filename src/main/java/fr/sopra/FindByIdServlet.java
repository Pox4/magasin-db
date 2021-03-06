package fr.sopra;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/FindByIdServlet")
public class FindByIdServlet extends HttpServlet {

	@EJB
	private GestionDesProduits gestionDesProduits;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		int id = Integer.parseInt(req.getParameter("id"));

		Produit p = gestionDesProduits.findById(id);

		System.out.println(p.getNom() + " " + p.getCategorie().getNom() + " " + p.getFabriquant().getNom());

	}

}