package com.infoshareacademy.zieloni.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/statistic")
public class StatisticServlet extends ShowPageViewServlet {


    @Override
    void start(HttpServletRequest req, HttpServletResponse resp) {
        resetViewState(req);
        setUserList(req);
        showStatistics(req, resp);
    }


    private void showStatistics(HttpServletRequest req, HttpServletResponse resp) {
        req.getSession().setAttribute(OPEN_STATISTICS_USER, true);
        showPageView(req, resp, "/index.jsp");
    }
}
