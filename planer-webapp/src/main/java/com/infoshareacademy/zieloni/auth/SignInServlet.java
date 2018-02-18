package com.infoshareacademy.zieloni.auth;

import com.infoshareacademy.zieloni.registration.RolesDao;
import com.infoshareacademy.zieloni.registration.RolesDaoImpl;
import com.infoshareacademy.zieloni.registration.UsersDaoImpl;
import com.infoshareacademy.zieloni.registration.model.Roles;
import com.infoshareacademy.zieloni.registration.model.User;
//import org.jboss.security.auth.spi.Users;


import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/sign-in")
public class SignInServlet extends HttpServlet {

    @EJB
    RolesDao dao;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
           /* if(dao.role_group(req.getSession().getAttribute("login").toString()).equals("admin")) {
                // RequestDispatcher requestDispatcher = req.getRequestDispatcher("/index1.jsp");
                resp.sendRedirect("/index1.jsp");
*/
                signIn(req, resp);

        } catch (Exception e) {
            log("problem with log-in " + e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
          /*  User user =new User();
            String login1=req.getSession().getAttribute("login").toString();
            if(dao.role_group(login1).equals("admin")) {
                // RequestDispatcher requestDispatcher = req.getRequestDispatcher("/index1.jsp");
                resp.sendRedirect("/index1.jsp");*/
                signIn(req, resp);
                req.getSession().setAttribute("user", null);

        } catch (Exception e) {
            log("problem with log-in " + e);
        }
    }


    private void signIn(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            User user =new User();
            String login1=req.getSession().getAttribute("login").toString();
            if(dao.role_group(login1).equals("admin")) {
                // RequestDispatcher requestDispatcher = req.getRequestDispatcher("/index1.jsp");
                resp.sendRedirect("/index1.jsp");
                req.login(req.getParameter("email"), req.getParameter("password"));
            }


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
