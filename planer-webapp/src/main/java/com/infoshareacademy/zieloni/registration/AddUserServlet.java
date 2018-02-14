package com.infoshareacademy.zieloni.registration;

import com.infoshareacademy.zieloni.ShowPageViewServlet;

import javax.ejb.EJB;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/add-user")
public class AddUserServlet extends ShowPageViewServlet {

    @EJB
    RegistrationService addUserService;


    @Override
    public void start(HttpServletRequest req, HttpServletResponse resp) {
        addUserService.init(req);
        showPageView(req, resp, "/index.jsp");

    }
}
