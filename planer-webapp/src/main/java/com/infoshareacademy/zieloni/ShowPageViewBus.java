package com.infoshareacademy.zieloni;

import com.infoshareacademy.zieloni.registration.UsersDao;
import com.infoshareacademy.zieloni.timetable.BusPromotionDao;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public abstract class ShowPageViewBus extends HttpServlet {

    private static final String BUS_PROMOTION = "promotion";
    private static final String NAME = "name";
    private static final String STATUS = "status";
    private static final String TYPE = "type";

    @EJB

    BusPromotionDao busPromotionDao;


    public abstract void start1(HttpServletRequest req, HttpServletResponse resp);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        start1(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        start1(req, resp);
    }

    public void resetViewState(HttpServletRequest req) {
    }



    public void showPageView(HttpServletRequest req, HttpServletResponse resp, String path) {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher(path);
        try {
            requestDispatcher.forward(req, resp);
        } catch (Exception e) {
            log("problem with page: " + e);
        }
    }

    public void setBusList(HttpServletRequest req) {
        try {
            req.setAttribute("buslist", busPromotionDao.getBusList());
        } catch (Exception e) {
            log(" brak Autobusu");
        }
    }
    public void showPageView1(HttpServletRequest req, HttpServletResponse resp) {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/index.jsp");
        try {
            requestDispatcher.forward(req, resp);
        } catch (Exception e) {
            log("problem with page: " + e);
        }
    }


}
