package filter;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class AuthFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;

        HttpSession session = req.getSession(false);

        boolean loggedIn = (session != null && session.getAttribute("user") != null);

        String loginURI = req.getContextPath() + "/login.jsp";
        String authURI = req.getContextPath() + "/auth";

        boolean loginRequest = req.getRequestURI().equals(loginURI) ||
                               req.getRequestURI().equals(authURI);

        if (loggedIn || loginRequest) {
            chain.doFilter(request, response);
        } else {
            resp.sendRedirect("login.jsp");
        }
    }
}