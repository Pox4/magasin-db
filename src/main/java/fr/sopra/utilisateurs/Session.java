package fr.sopra.utilisateurs;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class Session {

	   private static String utilisateurConnecte = "utilisateurConnecte";

	    public static void setUtilisateurConnecte(HttpSession session, Utilisateurs utilisateur) {
	        session.setAttribute(utilisateurConnecte, utilisateur);
	    }

	    public static Utilisateurs getUtilisateurConnecte(HttpSession session) {
	        return (Utilisateurs) session.getAttribute(utilisateurConnecte);
	    }

	    public static boolean estConnecte(HttpServletRequest request) {
	        return getUtilisateurConnecte(request.getSession()) != null;
	    }
	}