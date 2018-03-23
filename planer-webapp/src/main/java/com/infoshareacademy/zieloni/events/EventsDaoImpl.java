package com.infoshareacademy.zieloni.events;


import com.infoshareacademy.zieloni.events.model.BusStop;
import com.infoshareacademy.zieloni.events.model.Events;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class EventsDaoImpl implements EventsDao {


    @PersistenceContext(unitName = "pUnit")
    private EntityManager entityManager;


    @Override
    public boolean addEvents(Events events) {
        entityManager.persist(events);
        return true;
    }

    @Override
    public boolean editEvents(Events events) {
        return false;
    }

    @Override
    public boolean removeEvents(Events events) {
        return false;
    }

    @Override
    public Events getEventsById(int id) {
        return null;
    }

    @Override
    public Events getEventsByLogin(String login) {
        return (Events) entityManager.createNamedQuery("getEventsByLogin")
                .setParameter("login", login)
                .getSingleResult();
    }

    @Override
    public List<Events> getEventsList() {
        return entityManager.createNamedQuery("getAllEvents").getResultList();
    }


}
