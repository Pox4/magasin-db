package fr.sopra;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/suppressionFabriquant.html")
public class SupprimerFabriquantsServlet extends HttpServlet {

	
	
	@EJB
	private GestionDesProduits gestion;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		
		Fabriquant fabriquant = gestion.findFabriquantById(Integer.parseInt(req.getParameter("fabriquantSupprimer")));
		
		gestion.deleteFabriquant(fabriquant);
		

		resp.sendRedirect("fabriquants.html");
	}
	
	
	
}
