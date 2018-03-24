package com.infoshareacademy.zieloni.users.events;

import com.infoshareacademy.zieloni.users.events.model.Events;

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