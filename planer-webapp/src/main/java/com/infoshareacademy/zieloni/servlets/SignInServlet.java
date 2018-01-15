package com.infoshareacademy.zieloni.servlets;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/sign-in")
public class SignInServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            signIn(req, resp);
        } catch (Exception e) {
            log("problem with log-in " + e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            signIn(req, resp);
            req.getSession().setAttribute("user", null);
        } catch (Exception e) {
            log("problem with log-in " + e);
        }
    }


    private void signIn(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            req.login(req.getParameter("email"), req.getParameter("password"));

        } catch (ServletException e) {
            req.setAttribute("errorMessageSignIn", "Podałeś błędny login lub hasło");
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/index.jsp");
            requestDispatcher.forward(req, resp);
            return;
        }

        if (req.getHeader("Referer").contains("index.jsp")) {
            resp.sendRedirect("/index.jsp");
            return;
        }
        resp.sendRedirect(req.getHeader("Referer"));
    }
}
