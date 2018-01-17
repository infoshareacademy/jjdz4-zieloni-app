package com.infoshareacademy.zieloni.servlets;

import com.infoshareacademy.zieloni.dao.UsersRepositoryDao;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

abstract class ShowPageViewServlet extends HttpServlet {

    @EJB
    UsersRepositoryDao usersRepositoryDao;

    abstract void start(HttpServletRequest req, HttpServletResponse resp);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        start(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        start(req, resp);
    }

    public static final String OPEN_BUS_SCHEDULE = "openBusSchedule";
    public static final String OPEN_STATISTICS_USER = "openStatistics";

    void resetViewState(HttpServletRequest req) {
        req.getSession().setAttribute(OPEN_STATISTICS_USER, false);
        req.getSession().setAttribute(OPEN_BUS_SCHEDULE, false);
    }

    void setUserList(HttpServletRequest req) {
        try {
            req.setAttribute("userList", usersRepositoryDao.getUsersList());
        } catch (Exception e) {
            log(" brak userów");
        }
    }

    void showPageView(HttpServletRequest req, HttpServletResponse resp, String path) {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher(path);
        try {
            requestDispatcher.forward(req, resp);
        } catch (Exception e) {
            log("problem with page: " + e);
        }
    }
}
