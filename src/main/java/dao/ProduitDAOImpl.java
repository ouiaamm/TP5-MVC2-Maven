package dao;

import model.Produit;
import util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class ProduitDAOImpl implements ProduitDAO {

    public void add(Produit p) {
        Session s = HibernateUtil.getSessionFactory().openSession();
        Transaction t = s.beginTransaction();
        s.save(p);
        t.commit();
        s.close();
    }

    public void update(Produit p) {
        Session s = HibernateUtil.getSessionFactory().openSession();
        Transaction t = s.beginTransaction();
        s.update(p);
        t.commit();
        s.close();
    }

    public void delete(Long id) {
        Session s = HibernateUtil.getSessionFactory().openSession();
        Transaction t = s.beginTransaction();
        Produit p = s.get(Produit.class, id);
        if (p != null) s.delete(p);
        t.commit();
        s.close();
    }

    public Produit get(Long id) {
        Session s = HibernateUtil.getSessionFactory().openSession();
        Produit p = s.get(Produit.class, id);
        s.close();
        return p;
    }

    public List<Produit> getAll() {
        Session s = HibernateUtil.getSessionFactory().openSession();
        List<Produit> list = s.createQuery("from Produit", Produit.class).list();
        s.close();
        return list;
    }
}