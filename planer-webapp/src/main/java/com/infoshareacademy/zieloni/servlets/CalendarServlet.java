package com.infoshareacademy.zieloni.servlets;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/calendar")
public class CalendarServlet extends ShowPageViewServlet {

    @Override
    public void start(HttpServletRequest req, HttpServletResponse resp) {
        resetViewState(req);
        showCalendar(req, resp);
    }


    private void showCalendar(HttpServletRequest req, HttpServletResponse resp) {
        req.setAttribute(SHOW_CALENDAR, true);
        showPageView(req, resp, "/index.jsp");
    }
}
