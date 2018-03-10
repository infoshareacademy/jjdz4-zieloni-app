package com.infoshareacademy.zieloni.auth;

import com.infoshareacademy.zieloni.ShowPageViewServlet;
import com.infoshareacademy.zieloni.raport.RestClient;
import com.infoshareacademy.zieloni.registration.UsersDao;
import com.infoshareacademy.zieloni.registration.model.User;

import javax.ejb.EJB;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.security.Principal;

@WebServlet("/logout")
public class LogoutServlet extends ShowPageViewServlet {


    @Override
    public void start(HttpServletRequest req, HttpServletResponse resp) {
        try {

            log("LOGOUT" + req.getSession().getAttribute("loggedUser"));

            setInfoAboutActivity(req, resp,"LOG_OUT");
            req.logout();
            req.getSession().invalidate();

            resetViewState(req);
            resp.sendRedirect("/index.jsp");

        } catch (Exception e) {
            log("problem with logout " + e);
        }
    }

}
