package com.infoshareacademy.zieloni.users.timetable;

import com.infoshareacademy.zieloni.database.BusDataBase;
import com.infoshareacademy.zieloni.ShowPageViewServlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/direct-selector")
public class DirectionSelectorServlet extends ShowPageViewServlet {
    private static final String BUS_NR = "busNr";
    private static final String TYPE_TRANPORT = "type_of_tranport";

    @Override
    public void start(HttpServletRequest req, HttpServletResponse resp) {
        Integer id = null;
        try {
            id = Integer.parseInt(req.getParameter(BUS_NR));

        } catch (Exception e) {
            log("środek transportu jeszcze nie został wybrany");
        }

        log("pokaż kierunek jazdy" + BusDataBase.getDataBase().get(id - 1).getBusNumber());

        resetViewState(req);
        req.getSession().setAttribute(BUS_ID, id - 1);
        req.setAttribute(BUS_NR, BusDataBase.getDataBase().get(id - 1).getBusNumber());
        req.setAttribute(TYPE_TRANPORT, BusDataBase.getDataBase().get(id - 1).getTypeOfTransport());
        req.setAttribute("busStopsV1", BusDataBase.getDataBase().get(id - 1).getBusStopsV2().get(0).getNameOfBusStop());
        req.setAttribute("busStopsV2", BusDataBase.getDataBase().get(id - 1).getBusStopsV1().get(0).getNameOfBusStop());

        showPageView(req, resp, "/index.jsp");
    }

}
