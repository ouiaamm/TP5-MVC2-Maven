package dao;

import model.User;
import org.hibernate.Session;
import util.HibernateUtil;

public class UserDAOImpl implements UserDAO {

    @Override
    public User login(String username, String password) {

        Session session = HibernateUtil.getSessionFactory().openSession();

        User user = (User) session.createQuery(
                "FROM User u WHERE u.username=:u AND u.password=:p")
                .setParameter("u", username)
                .setParameter("p", password)
                .uniqueResult();

        session.close();

        return user;
    }
}