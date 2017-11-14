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
@WebServlet("/editionfab.html")
public class EditionFabriquantsServlet extends HttpServlet {

	@EJB
	private GestionDesProduits gestion;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		
		
		Fabriquant fabriquant = new Fabriquant();

		if (req.getParameterMap().containsKey("fabriquant")) {

			fabriquant = gestion.findFabriquantById(Integer.parseInt(req.getParameter("fabriquant")));

		} else {
			fabriquant = gestion.ajouterFabriquant();
			fabriquant.setNom("Entrez un nom");
		}
		
		req.setAttribute("fabriquant", fabriquant);
		req.getRequestDispatcher("/WEB-INF/fabriquantsEdition.jsp").forward(req, resp);

		

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		Fabriquant fabriquant = gestion.findFabriquantById(Integer.parseInt(req.getParameter("fabriquantId")));
		fabriquant.setNom(req.getParameter("fabriquantName"));
		gestion.uptdateFabriquant(fabriquant);
		resp.sendRedirect("http://localhost:8080/jpa-101-1.0-SNAPSHOT/fabriquants.html");

	}

}
