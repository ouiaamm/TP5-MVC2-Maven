package web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import services.ProduitMetier;
import services.ProduitMetierImpl;

/**
 * Servlet implementation class DeleteProduitServlet
 */
@WebServlet("/DeleteProduitServlet")
public class DeleteProduitServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static final ProduitMetier metier = ProduitMetierImpl.getInstance();

       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteProduitServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Long id = Long.parseLong(request.getParameter("id"));

        metier.deleteProduit(id);

        response.sendRedirect("ListProduitServlet");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
