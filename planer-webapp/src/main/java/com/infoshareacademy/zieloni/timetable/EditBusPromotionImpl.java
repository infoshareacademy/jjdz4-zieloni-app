package com.infoshareacademy.zieloni.timetable;


import com.infoshareacademy.zieloni.timetable.model.Bus;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public class EditBusPromotionImpl implements BusPromotionDao {


    @PersistenceContext(unitName = "pUnit")
    private EntityManager entityManager;
    private static final String BUS_PROMOTION= "promotion";
    @Override
    public boolean editBusPromotion(Bus bus) {

            entityManager.createNamedQuery("updateBus")
                    .setParameter("id", bus.getId())
                    .setParameter("name", bus.getName())
                    .setParameter("status", bus.getStatus())
                    .setParameter("type", bus.getType())
                    .executeUpdate();

            return true;
        }

    @Override
    public Bus getBusById(int id) {
        {
            return entityManager.find(Bus.class, id);
        }
    }

    @Override
    public List<Bus> getBusList() {
        return entityManager.createNamedQuery("getAllBus").getResultList();
    }
}


