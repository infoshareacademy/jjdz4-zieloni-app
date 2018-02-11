package com.infoshareacademy.zieloni.auth;


import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.security.Principal;

@WebFilter(
        filterName = "AuthenticationFilter",
        urlPatterns = {"/*"})
public class AuthenticationFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        Principal user = ((HttpServletRequest) servletRequest).getUserPrincipal();
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpSession session = req.getSession();

        if (user != null) {
            String userName = user.getName();
            session.setAttribute("loggedUser", userName);
            session.setAttribute("isLogged", true);

        } else {
            session.setAttribute("loggedUser", null);
            session.setAttribute("isLogged", false);
        }

        filterChain.doFilter(servletRequest, servletResponse);
    }
}
