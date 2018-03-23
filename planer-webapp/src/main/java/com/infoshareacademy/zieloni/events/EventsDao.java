package com.infoshareacademy.zieloni.events;

import com.infoshareacademy.zieloni.events.model.BusStop;
import com.infoshareacademy.zieloni.events.model.Events;
import com.infoshareacademy.zieloni.registration.model.User;

import javax.ejb.Local;
import java.util.List;


@Local
public interface EventsDao {

    boolean addEvents(Events events);

    boolean editEvents(Events events);

    boolean removeEvents(Events events);

   Events getEventsById(int id);

    Events getEventsByLogin(String login);

    List<Events> getEventsList();


}