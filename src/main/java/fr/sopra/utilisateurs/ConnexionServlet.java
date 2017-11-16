package fr.sopra.utilisateurs;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/connexion.html")
public class ConnexionServlet extends HttpServlet {

	@EJB
	private GestionUtilisateur gestionUtilisateur;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		if (Session.estConnecte(req))
			resp.sendRedirect("categories.html");
		else
			req.getRequestDispatcher("/WEB-INF/login.jsp").forward(req, resp);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		Utilisateurs utilisateur = gestionUtilisateur.login(req.getParameter("login"), req.getParameter("password"));

		if (utilisateur == null) {

		} else {
			Session.setUtilisateurConnecte(req.getSession(), utilisateur);
			resp.sendRedirect("categories.html");

		}

	}

}
