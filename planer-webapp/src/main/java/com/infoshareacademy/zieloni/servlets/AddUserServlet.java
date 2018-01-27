package com.infoshareacademy.zieloni.servlets;

import com.infoshareacademy.zieloni.services.IAddUserDao;

import javax.ejb.EJB;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/add-user")
public class AddUserServlet extends ShowPageViewServlet {

    @EJB
    IAddUserDao addUserService;


    @Override
    public void start(HttpServletRequest req, HttpServletResponse resp) {
        addUserService.init(req, resp);
        showPageView(req, resp, "/index.jsp");

    }
}
