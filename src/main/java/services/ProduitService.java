package services;

import model.Produit;
import java.util.List;

public interface ProduitService {
    void addProduit(Produit p);
    void updateProduit(Produit p);
    void deleteProduit(Long id);
    Produit getProduit(Long id);
    List<Produit> getAllProduits();
}