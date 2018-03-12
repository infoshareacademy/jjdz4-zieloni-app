package com.infoshareacademy.zieloni;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/piechart")
public class PieChartsServlet extends ShowPageViewServlet {

    private void showCharts(HttpServletRequest req, HttpServletResponse resp) {
        req.setAttribute(SHOW_PIE_CHART, true);
        showPageView(req, resp, "/index.jsp");
    }

    @Override
    public void start(HttpServletRequest req, HttpServletResponse resp) {
        resetViewState(req);
        showCharts(req, resp);
    }
}