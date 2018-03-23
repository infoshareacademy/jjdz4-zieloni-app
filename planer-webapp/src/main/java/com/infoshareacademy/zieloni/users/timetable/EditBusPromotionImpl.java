package com.infoshareacademy.zieloni.users.timetable;


import com.infoshareacademy.zieloni.users.timetable.model.Bus;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
@Stateless
public class EditBusPromotionImpl implements BusPromotionDao {


    @PersistenceContext(unitName = "pUnit")
    private EntityManager entityManager;
    //private static final String BUS_PROMOTION_id= "promotion";
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
    public Bus getBusById(Long id) {
        return entityManager.find(Bus.class, id);
    }



    @Override
    public List<Bus> getBusList() {
        return entityManager.createNamedQuery("getAllBus").getResultList();
    }
}


