package com.infoshareacademy.zieloni.auth;

import com.infoshareacademy.zieloni.ShowPageViewServlet;
import com.infoshareacademy.zieloni.raport.RestClient;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/logout")
public class LogoutServlet extends ShowPageViewServlet {
    @Override
    public void start(HttpServletRequest req, HttpServletResponse resp) {
        try {
            req.logout();
            req.getSession().invalidate();
            log("LOGOUT" + req.getSession().getAttribute("loggedUser"));
            RestClient client = new RestClient();
            client.infoAboutUserActivity("LOG_OUT");
            resetViewState(req);
            resp.sendRedirect("/index.jsp");
        } catch (Exception e) {
            log("problem with logout " + e);
        }
    }

}
