package com.infoshareacademy.zieloni.users.events;

import com.infoshareacademy.zieloni.ShowPageViewServlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Addevents")
public class EventsAddServlet extends ShowPageViewServlet {
    private static final String START_TIME = "start_time";
    private static final String STOP_TIME = "stop_time";
    private static final String LOCATIN = "street";
    //private static final String TYPE = "type";
    @Override
    public void start(HttpServletRequest req, HttpServletResponse resp) {
        resetViewState(req);
        showCalendar(req, resp);
    }

private void addEvents(HttpServletRequest req){

        //log(Integer.parseInt(req.getParameter(BUS_PROMOTION)) + " klikniety edycja BUS " + req.getParameter(BUS_PROMOTION));
}
    private void showCalendar(HttpServletRequest req, HttpServletResponse resp) {
        req.setAttribute(ADD_CALENDAR, true);
        //getBusStopList1(req);
        req.setAttribute(LOCATIN,true);
        //req.setAttribute(LOCATIN, true);
        showPageView(req, resp, "/index.jsp");
    }
}
