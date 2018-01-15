package com.infoshareacademy.zieloni.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            req.logout();
            req.getSession().invalidate();
            log("LOGOUT"+req.getSession().getAttribute("loggedUser"));
            resp.sendRedirect("/index.jsp");
        } catch (Exception e) {
            log("problem with logout " + e);
        }
    }
}
