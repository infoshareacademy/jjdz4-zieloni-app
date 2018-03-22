package com.infoshareacademy.zieloni.admin.promotion;

import com.infoshareacademy.zieloni.ShowPageViewServlet;
import com.infoshareacademy.zieloni.users.timetable.model.Bus;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/edit-bus")
public class EditBusServlet extends ShowPageViewServlet {
    private static final String BUS_PROMOTION = "promotion";
    private static final String STATUS = "status";

    @Override
    public void start(HttpServletRequest req, HttpServletResponse resp) {
        editBus(req);
        setBusList(req);
        req.setAttribute(BUS_PROMOTION_id, true);
        showPageView(req, resp, "/index.jsp");
    }

    private void editBus(HttpServletRequest req) {

        log(Integer.parseInt(req.getParameter(BUS_PROMOTION)) + " klikniety edycja BUS " + req.getParameter(BUS_PROMOTION));
        Long id = Long.valueOf(Integer.parseInt(req.getParameter(BUS_PROMOTION)));
        String status = String.valueOf(req.getParameter(STATUS));
        Bus editBus = busPromotionDao.getBusById(id);
        editBus.setStatus(status);
        busPromotionDao.editBusPromotion(editBus);
    }
}


