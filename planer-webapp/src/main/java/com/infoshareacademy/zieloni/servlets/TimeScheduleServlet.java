package com.infoshareacademy.zieloni.servlets;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/time-schedule")
public class TimeScheduleServlet extends ShowPageViewServlet {


    @Override
    void start(HttpServletRequest req, HttpServletResponse resp) {
        resetViewState(req);
        setUserList(req);
        showTimeSchedule(req, resp);
    }

    private void showTimeSchedule(HttpServletRequest req, HttpServletResponse resp) {
        req.getSession().setAttribute(OPEN_BUS_SCHEDULE, true);
        showPageView(req, resp, "/index.jsp");
    }
}
