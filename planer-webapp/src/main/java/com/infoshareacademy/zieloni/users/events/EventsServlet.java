package com.infoshareacademy.zieloni.users.events;

import com.infoshareacademy.zieloni.ShowPageViewServlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/events")
public class EventsServlet extends ShowPageViewServlet {

    @Override
    public void start(HttpServletRequest req, HttpServletResponse resp) {
        resetViewState(req);
        setBusStopList(req);
        showCalendar(req, resp);
    }

    private void showCalendar(HttpServletRequest req, HttpServletResponse resp) {
        req.setAttribute(SHOW_CALENDAR, true);
        showPageView(req, resp, "/index.jsp");
    }
}
