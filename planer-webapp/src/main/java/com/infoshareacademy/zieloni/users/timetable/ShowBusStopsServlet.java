package com.infoshareacademy.zieloni.users.timetable;

import com.infoshareacademy.zieloni.database.BusDataBase;
import com.infoshareacademy.zieloni.model.RecordVariantDTO;
import com.infoshareacademy.zieloni.ShowPageViewServlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@WebServlet("/show-bus-stops")
public class ShowBusStopsServlet extends ShowPageViewServlet {


    @Override
    public void start(HttpServletRequest req, HttpServletResponse resp) {

        String variant = req.getParameter("variant");


        if (variant != null) {
            log("lista przystanków dla wariantu" + variant);
            List<RecordVariantDTO> busStopList;
            Integer ide = (int) req.getSession().getAttribute(BUS_ID);
            if (variant.equals("1")) {
                busStopList = BusDataBase.getDataBase().get(ide).getBusStopsV1();
            } else {
                busStopList = BusDataBase.getDataBase().get(ide).getBusStopsV2();
            }
            req.setAttribute("busStopList", busStopList);
        }

        req.getSession().setAttribute(DIRECTION_VARIANT, Integer.parseInt(variant));
        req.setAttribute(SHOW_BUS_STOPS, true);
        showPageView(req, resp, "/index.jsp");
    }
}
