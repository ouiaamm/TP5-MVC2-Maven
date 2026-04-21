package dao;

import model.Produit;
import java.util.List;

public interface ProduitDAO {

    void add(Produit p);
    void update(Produit p);
    void delete(Long id);
    Produit get(Long id);
    List<Produit> getAll();
}