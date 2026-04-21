package services;

import dao.UserDAO;
import dao.UserDAOImpl;
import model.User;

public class UserServiceImpl implements UserService {

    private UserDAO dao = new UserDAOImpl();

    @Override
    public User login(String username, String password) {
        return dao.login(username, password);
    }
}