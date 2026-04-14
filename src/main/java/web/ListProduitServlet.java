package web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.ArrayList;
import java.util.List;

import dao.Produit;
import services.ProduitMetier;
import services.ProduitMetierImpl;

/**
 * Servlet implementation class ListProduitServlet
 */
@WebServlet("/ListProduitServlet")
public class ListProduitServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final ProduitMetier metier = ProduitMetierImpl.getInstance();

       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListProduitServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String idParam = request.getParameter("idProduit");

		List<Produit> liste = new ArrayList<>();

	        if (idParam != null && !idParam.isEmpty()) {

	            try {
	                Long id = Long.parseLong(idParam);

	                Produit p = metier.getProduitById(id);

	                if (p != null) {
	                    liste.add(p);
	                }

	            } catch (NumberFormatException e) {
	                liste = metier.getAllProduits();
	            }

	        } else {
	            liste = metier.getAllProduits();
	        }

	        request.setAttribute("listeProduits", liste);
	        request.getRequestDispatcher("index.jsp").forward(request, response);
	    
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
