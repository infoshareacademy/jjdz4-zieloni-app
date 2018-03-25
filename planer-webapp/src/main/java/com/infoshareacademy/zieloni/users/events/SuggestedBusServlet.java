package com.infoshareacademy.zieloni.users.events;

import com.infoshareacademy.zieloni.ShowPageViewServlet;
import com.infoshareacademy.zieloni.controller.FindBusController;
import com.infoshareacademy.zieloni.controller.FindBusWithChangeController;
import com.infoshareacademy.zieloni.model.ChangeConnectionDTO;
import com.infoshareacademy.zieloni.model.ProposedBusDTO;
import com.infoshareacademy.zieloni.users.events.model.Events;
import com.infoshareacademy.zieloni.utils.TimeLimiter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.LocalTime;

@WebServlet("/suggestedBusServlet")
public class SuggestedBusServlet extends ShowPageViewServlet {

    @Override
    public void start(HttpServletRequest req, HttpServletResponse resp) {
        String txt = "nie ma  propozycji - programista się nie popisał ... szybko robił  i ślepe zrobił";
        int eventId = Integer.parseInt(req.getParameter("eventId"));
        req.setAttribute(SUGGESTED_BUS, true);


        Events selectedEvent = eventsDao.getEventsList().get(eventId);
        Events nextEvent = eventsDao.getEventsList().get(eventId+1);
        FindBusController.search(selectedEvent.getLocation(), nextEvent.getLocation());


        if (nextEvent != null) {
            FindBusController.search(selectedEvent.getLocation().toString(), nextEvent.getLocation().toString());
            LocalTime endEventTime = selectedEvent.getEndTime().toLocalTime();
            LocalTime startEventTime = nextEvent.getStartTime().toLocalTime();


            if (FindBusController.getProposedBusArr().size() > 0) {
                ProposedBusDTO bus = FindBusController.getProposedBusArr().get(0);
                TimeLimiter showTime = new TimeLimiter(endEventTime, startEventTime, bus);
                txt = showTime.getTextInfo().toString();

            } else {
                FindBusWithChangeController.search(selectedEvent.getLocation().toString(), nextEvent.getLocation().toString());

                ChangeConnectionDTO bus = FindBusWithChangeController.getChangeConnectionArray().get(0);
                txt = ("Proponowanie połacznie  to  " + bus.getBus0().getTypeOfTransport() +
                        " nr : " + bus.getBus0().getBusNumber() + "<br/>" + " przesiadka na przystanku " + bus.getConnectionBusStop()
                        + "<br/>" + " w " + bus.getBus1().getTypeOfTransport() + " nr : " + bus.getBus1().getBusNumber());
            }
        }
        req.setAttribute("textInfo", txt);
        showPageView(req, resp, "/index.jsp");
    }
}
