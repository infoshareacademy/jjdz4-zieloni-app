package com.infoshareacademy.zieloni;

import com.infoshareacademy.zieloni.admin.raport.RestClient;
import com.infoshareacademy.zieloni.users.events.BusStopDao;
import com.infoshareacademy.zieloni.users.events.EventsDao;
import com.infoshareacademy.zieloni.registration.UsersDao;
import com.infoshareacademy.zieloni.registration.model.User;
import com.infoshareacademy.zieloni.users.timetable.BusPromotionDao;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public abstract class ShowPageViewServlet extends HttpServlet {

    public static final String TIME_TABLE_BASE = "showTimeTableBase";
    public static final String SHOW_TIME_TABLE = "showTimeTable";
    public static final String SHOW_CALENDAR = "showCalendar";
    public static final String ADD_CALENDAR = "addCalendar";
    public static final String SHOW_ABOUT = "showAbout";
    public static final String SHOW_CHART_DEPENDING_ON_GENDER = "chartDependingOnGender";
    public static final String SHOW_CHART_DEPENDING_ON_AGE = "chartDependingOnAge";
    public static final String SHOW_STATISTICS_USER = "showStatistics";
    public static final String SHOW_BUS_STOPS = "busStops";
    public static final String BUS_ID = "bus_id";
    public static final String DIRECTION_VARIANT = "variant";
    public static final String BUS_PROMOTION_id = "showBusPromotion";
    public static final String EVENTS_LIST = "eventslist";
    public static final String SUGGESTED_BUS = "suggestedBus";


    public static final String RAPORT = "showRaport";

    @EJB
    protected BusPromotionDao busPromotionDao;

    @EJB
    protected UsersDao usersRepositoryDao;

    @EJB
    protected EventsDao eventsDao;

    @EJB
    BusStopDao busStopDao;

    public abstract void start(HttpServletRequest req, HttpServletResponse resp);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        start(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        start(req, resp);
    }

    public User getUserByLogin(String login) {
        try {
            return usersRepositoryDao.getUserByLogin(login);
        } catch (NullPointerException e) {
            log("nie znaleziono uzytkownika o podanym logine " + e);
            return null;
        }
    }

    public void resetViewState(HttpServletRequest req) {
    }

    public void setBusList(HttpServletRequest req) {
            req.setAttribute("buslist", busPromotionDao.getBusList());
    }

    public void setUserList(HttpServletRequest req) {
            req.setAttribute("userList", usersRepositoryDao.getUsersList());
    }

    public void setBusStopList(HttpServletRequest req) {

        req.setAttribute("eventslist", eventsDao.getEventsList());
    }

    public void showPageView(HttpServletRequest req, HttpServletResponse resp, String path) {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher(path);
        try {
            requestDispatcher.forward(req, resp);
        } catch (Exception e) {
            log("problem with page: " + e);
        }
    }

    public void setInfoAboutActivity(HttpServletRequest req, String activity) {

        String email = req.getSession().getAttribute("loggedUser").toString();
        User user = getUserByLogin(email);
        RestClient client = new RestClient();
        client.infoAboutUserActivity(user, activity);
    }
}
