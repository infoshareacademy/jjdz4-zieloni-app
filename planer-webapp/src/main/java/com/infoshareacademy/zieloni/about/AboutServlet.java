package com.infoshareacademy.zieloni.about;

import com.infoshareacademy.zieloni.ShowPageViewServlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/about")
public class AboutServlet extends ShowPageViewServlet {

    @Override
    public void start(HttpServletRequest req, HttpServletResponse resp) {
        resetViewState(req);
        showCalendar(req, resp);
        setInfoAboutActivity(req, resp,"O nas");
    }


    private void showCalendar(HttpServletRequest req, HttpServletResponse resp) {
        req.setAttribute(SHOW_ABOUT, true);
        showPageView(req, resp, "/index.jsp");
    }
}
