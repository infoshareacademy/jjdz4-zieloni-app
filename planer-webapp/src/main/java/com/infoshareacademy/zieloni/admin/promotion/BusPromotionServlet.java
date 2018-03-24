package com.infoshareacademy.zieloni.admin.promotion;


import com.infoshareacademy.zieloni.ShowPageViewServlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/bus-promotion")
public class BusPromotionServlet extends ShowPageViewServlet {

    private void showStatistics(HttpServletRequest req, HttpServletResponse resp) {
        req.setAttribute(BUS_PROMOTION_id, true);
        setBusList(req);
        showPageView(req, resp, "/index.jsp");
    }

    @Override
    public void start(HttpServletRequest req, HttpServletResponse resp) {
        resetViewState(req);
        showStatistics(req, resp);
    }
}


