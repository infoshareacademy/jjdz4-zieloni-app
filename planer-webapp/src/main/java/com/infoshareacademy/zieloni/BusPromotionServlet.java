package com.infoshareacademy.zieloni;


import com.infoshareacademy.zieloni.timetable.BusPromotionDao;
import com.infoshareacademy.zieloni.timetable.model.Bus;

import javax.ejb.EJB;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/bus-promotion")
public class BusPromotionServlet extends ShowPageViewServlet {
    @EJB
    private
    BusPromotionDao busPromotionDao;
    private static final String BUS_PROMOTION = "promotion";
    private static final String NAME = "name";
    private static final String STATUS = "status";
    private static final String TYPE = "type";


    @Override
    public void start(HttpServletRequest req, HttpServletResponse resp) {

        setBusList(req);
        editBus1(req);
        setBusList(req);


        showPageView1(req, resp);
    }

    private void editBus1(HttpServletRequest req) {

        Bus bus=new Bus();

        busPromotionDao.getBusList();
        log(Integer.parseInt(req.getParameter(BUS_PROMOTION)) + " klikniety edycja BUS " + req.getParameter(BUS_PROMOTION));
        Long id = Long.valueOf(Integer.parseInt(req.getParameter(BUS_PROMOTION)));
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


