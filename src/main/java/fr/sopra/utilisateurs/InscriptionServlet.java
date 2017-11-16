package fr.sopra.utilisateurs;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.sopra.GestionDesProduits;

@WebServlet("/inscription.html")
public class InscriptionServlet extends HttpServlet {

	@EJB
	private GestionUtilisateur gestionUtilisateur;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		
		req.getRequestDispatcher("/WEB-INF/inscription.jsp").forward(req, resp);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String email = req.getParameter("email");
		String login = req.getParameter("login");
		String password = req.getParameter("password");
		String nom = req.getParameter("nom");
		String prenom = req.getParameter("prenom");

		

		Utilisateurs utilisateur = new Utilisateurs();
		utilisateur.setNom(nom);
		utilisateur.setPrenom(prenom);
		utilisateur.setEmail(email);
		utilisateur.setLogin(login);
		utilisateur.setPassword(password);
		
		
		

		gestionUtilisateur.add(utilisateur);
		Session.setUtilisateurConnecte(req.getSession(), utilisateur);

		resp.sendRedirect("categories.html");

	}

}
