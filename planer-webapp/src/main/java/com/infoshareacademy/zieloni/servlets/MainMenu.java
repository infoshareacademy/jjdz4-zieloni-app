package com.infoshareacademy.zieloni.servlets;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/main-menu")
public class MainMenu extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        if (req.getParameter("button1") != null) {
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/main-menu.jsp");
            requestDispatcher.forward(req, resp);

        } else if (req.getParameter("button2") != null) {

            log("2");
            RequestDispatcher requestDispatcher1 = req.getRequestDispatcher("/search-transport.jsp");
            requestDispatcher1.forward(req, resp);
        } else if (req.getParameter("button3") != null) {

            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/main-menu.jsp");
            requestDispatcher.forward(req, resp);
        } else {
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/main-menu.jsp");
            requestDispatcher.forward(req, resp);

        }
    }
}
