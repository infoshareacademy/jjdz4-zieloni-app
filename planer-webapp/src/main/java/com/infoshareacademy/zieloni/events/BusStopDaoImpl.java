package com.infoshareacademy.zieloni.events;


import com.infoshareacademy.zieloni.events.model.BusStop;
import com.infoshareacademy.zieloni.events.model.Events;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class BusStopDaoImpl implements BusStopDao {


    @PersistenceContext(unitName = "pUnit")
    private EntityManager entityManager;


    @Override
    public List<BusStop> getBusstopList() {
        return entityManager.createNamedQuery("getAllBusstop").getResultList();

    }
}
