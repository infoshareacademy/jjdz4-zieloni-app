package com.infoshareacademy.zieloni;


import com.infoshareacademy.zieloni.timetable.model.Bus;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/bus-promotion")
public class BusPromotion extends ShowPageViewServlet {
    private static final String BUS_PROMOTION = "promotion";
    private static final String NAME = "name";
    private static final String STATUS = "status";
    private static final String TYPE = "type";


    @Override
    public void start(HttpServletRequest req, HttpServletResponse resp) {

        setBusList(req);
        editBus(req);
        setBusList(req);


        showPageView1(req, resp);
    }

    private void editBus(HttpServletRequest req) {
        log(Integer.parseInt(req.getParameter(BUS_PROMOTION)) + " klikniety edit " + req.getParameter(BUS_PROMOTION));
        int id = Integer.parseInt(req.getParameter(BUS_PROMOTION));
        String name = String.valueOf(req.getParameter(NAME));
        String status = String.valueOf(req.getParameter(STATUS));
        String type = String.valueOf(req.getParameter(TYPE));
        Bus editBus =  busPromotionDao.getBusById(id);
        editBus.setName(name);
        editBus.setStatus(status);
        editBus.setType(type);


        busPromotionDao.editBusPromotion(editBus);
    }
}


