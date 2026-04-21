package controller;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

import model.User;
import services.UserService;
import services.UserServiceImpl;

public class AuthControllerServlet extends HttpServlet {

    private UserService userService = new UserServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String action = req.getParameter("action");

        if (!"login".equals(action)) {
            resp.sendRedirect("login.jsp");
            return;
        }

        String username = req.getParameter("username");
        String password = req.getParameter("password");

        if (username == null || password == null) {
            resp.sendRedirect("login.jsp?error=1");
            return;
        }

        HttpSession session = req.getSession(true);

        // =========================
        // 1. ADMIN (SPECIAL CASE)
        // =========================
        if ("admin".equals(username) && "admin".equals(password)) {

            session.setAttribute("user", username);
            session.setAttribute("role", "ADMIN");

            resp.sendRedirect("controller?action=list");
            return;
        }

        // =========================
        // 2. CHECK DATABASE USERS
        // =========================
        User user = userService.login(username, password);

        if (user != null) {

            session.setAttribute("user", user.getUsername());
            session.setAttribute("role", "USER");

            resp.sendRedirect("controller?action=list");

        } else {
            // =========================
            // 3. INVALID USER
            // =========================
            resp.sendRedirect("login.jsp?error=1");
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {

        resp.sendRedirect("login.jsp");
    }
}