package com.infoshareacademy.zieloni.users.calendar;

import com.infoshareacademy.zieloni.Events;
import com.infoshareacademy.zieloni.ShowPageViewServlet;
import net.fortuna.ical4j.data.ParserException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.ParseException;

@WebServlet("/calendar")
public class CalendarServlet extends ShowPageViewServlet {
    private Events events = new Events();
    @Override
    public void start(HttpServletRequest req, HttpServletResponse resp) {

        try {
            events.loadEvents();
        } catch (ParserException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        resetViewState(req);
        setInfoAboutActivity(req, "O nas");
    }
}