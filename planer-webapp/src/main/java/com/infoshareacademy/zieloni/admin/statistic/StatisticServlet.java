package com.infoshareacademy.zieloni.admin.statistic;

import com.infoshareacademy.zieloni.ShowPageViewServlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/statistic")
public class StatisticServlet extends ShowPageViewServlet {

    @Override
    public void start(HttpServletRequest req, HttpServletResponse resp) {
        resetViewState(req);
        setUserList(req);
        showStatistics(req, resp);
    }

    private void showStatistics(HttpServletRequest req, HttpServletResponse resp) {
        req.setAttribute(SHOW_STATISTICS_USER, true);
        showPageView(req, resp, "/index.jsp");
    }
}
