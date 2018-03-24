package com.infoshareacademy.zieloni.users.events;


import com.infoshareacademy.zieloni.users.events.model.Events;

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
        return (Events) entityManager.createNamedQuery("getEventsById")
                .setParameter("id", id)
                .getSingleResult();
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
