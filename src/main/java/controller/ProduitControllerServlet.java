package controller;

import model.Produit;
import services.*;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class ProduitControllerServlet extends HttpServlet {

    private ProduitService service = new ProduitServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String action = req.getParameter("action");
        HttpSession session = req.getSession(false);
        String role = (session != null) ? (String) session.getAttribute("role") : null;

        if (action == null) action = "list";

        switch (action) {

            case "list":
                req.setAttribute("listeProduits", service.getAllProduits());
                req.getRequestDispatcher("index.jsp").forward(req, resp);
                break;

            case "delete":

                if (!"ADMIN".equals(role)) {
                    resp.sendRedirect("controller?action=list");
                    return;
                }

                Long id = Long.parseLong(req.getParameter("id"));
                service.deleteProduit(id);
                resp.sendRedirect("controller?action=list");
                break;

            case "edit":

                if (!"ADMIN".equals(role)) {
                    resp.sendRedirect("controller?action=list");
                    return;
                }

                Long idEdit = Long.parseLong(req.getParameter("id"));
                req.setAttribute("produitEdit", service.getProduit(idEdit));
                req.setAttribute("listeProduits", service.getAllProduits());
                req.getRequestDispatcher("index.jsp").forward(req, resp);
                break;

            default:
                resp.sendRedirect("controller?action=list");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {

        String action = req.getParameter("action");

        String nom = req.getParameter("nom");
        String desc = req.getParameter("description");

        // SAFE parsing (fix null crash)
        String prixStr = req.getParameter("prix");
        Double prix = (prixStr == null || prixStr.isEmpty()) ? 0.0 : Double.parseDouble(prixStr);

        Produit p = new Produit(nom, desc, prix);

        if ("update".equals(action)) {
            p.setIdProduit(Long.parseLong(req.getParameter("idProduit")));
            service.updateProduit(p);
        } else {
            service.addProduit(p);
        }

        resp.sendRedirect("controller?action=list");
    }
}