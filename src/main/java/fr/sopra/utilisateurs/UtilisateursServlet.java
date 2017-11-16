package fr.sopra.utilisateurs;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.sopra.Categorie;
import fr.sopra.GestionDesProduits;

@WebServlet("/utilisateurs.html")
public class UtilisateursServlet extends HttpServlet {

	@EJB
	private GestionUtilisateur gestion;
	

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		
		List<Utilisateurs> listeUtilisateur = gestion.findAllUtilisateurs();
		
		req.setAttribute("listeUtilisateur", listeUtilisateur);

		req.getRequestDispatcher("/WEB-INF/utilisateurs.jsp").forward(req, resp);

	}



}
