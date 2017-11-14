package fr.sopra;

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
import javax.servlet.http.HttpSession;

@WebServlet("/fabriquants.html")
public class FabriquantsServlet extends HttpServlet {

	@EJB
	private GestionDesProduits gestion;
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		List<Fabriquant> fabriquants = gestion.findAllFabriquants();
		Map<Integer, Long> nbrProduitsParFabriquants = new HashMap<>();

		for (Fabriquant current : fabriquants){
		 nbrProduitsParFabriquants.put(current.getId(), gestion.nbrProduitParFabriquant(current.getId()));
		}
		
		
		req.setAttribute("nbrProduitsParFabriquant", nbrProduitsParFabriquants);
		req.setAttribute("listeFabriquants", gestion.findAllFabriquants());
		req.getRequestDispatcher("/WEB-INF/fabriquants.jsp").forward(req, resp);

		HttpSession session = req.getSession();
	}
	
}
