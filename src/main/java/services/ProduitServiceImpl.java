package services;

import dao.ProduitDAO;
import dao.ProduitDAOImpl;
import model.Produit;

import java.util.List;

public class ProduitServiceImpl implements ProduitService {

    private ProduitDAO dao = new ProduitDAOImpl();

    public void addProduit(Produit p) { dao.add(p); }

    public void updateProduit(Produit p) { dao.update(p); }

    public void deleteProduit(Long id) { dao.delete(id); }

    public Produit getProduit(Long id) { return dao.get(id); }

    public List<Produit> getAllProduits() { return dao.getAll(); }
}