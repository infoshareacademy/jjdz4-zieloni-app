package com.infoshareacademy.zieloni.servlets;


import com.infoshareacademy.zieloni.database.BusDataBase;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/time-schedule")
public class TimeScheduleServlet extends ShowPageViewServlet {
    private static final String BUS_NR = "busNr";

    @Override
    void start(HttpServletRequest req, HttpServletResponse resp) {

        Integer id = null;
        try {
            id = Integer.parseInt(req.getParameter(BUS_NR));
        } catch (Exception e) {
            log("środek transportu jeszcze nie został wybrany");
        }


        if (id == null) {
            log("pokaż listę autobusów");
            resetViewState(req);
            setBusList(req);
            showTimeSchedule(req, resp);
        } else {
            log("wybrano środek transportu o id: " + id);
            req.setAttribute("busNr", id);
            req.setAttribute("busStopsV1", BusDataBase.getDataBase().get(id).getBusStopsV2().get(0).getNameOfBusStop());
            req.setAttribute("busStopsV2", BusDataBase.getDataBase().get(id).getBusStopsV1().get(0).getNameOfBusStop());
            showPageView(req, resp, "/index.jsp");
        }
    }

    void setBusList(HttpServletRequest req) {

        BusDataBase database = new BusDataBase();
        database.createDataBase();
        try {
            req.setAttribute("busList", BusDataBase.getDataBase());
        } catch (Exception e) {
            log(" brak środków");
        }
    }

    private void showTimeSchedule(HttpServletRequest req, HttpServletResponse resp) {
        req.getSession().setAttribute(OPEN_BUS_SCHEDULE, true);
        showPageView(req, resp, "/index.jsp");
    }
}
