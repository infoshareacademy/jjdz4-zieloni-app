package com.infoshareacademy.zieloni.events;

import com.infoshareacademy.zieloni.ShowPageViewServlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Addevents")
public class EventsAddServlet extends ShowPageViewServlet {

    @Override
    public void start(HttpServletRequest req, HttpServletResponse resp) {
        resetViewState(req);
        showCalendar(req, resp);
    }


    private void showCalendar(HttpServletRequest req, HttpServletResponse resp) {
        req.setAttribute(ADD_CALENDAR, true);
        showPageView(req, resp, "/index.jsp");
    }
}
