package com.infoshareacademy.zieloni.users.events;


import com.infoshareacademy.zieloni.users.events.model.BusStop;

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
