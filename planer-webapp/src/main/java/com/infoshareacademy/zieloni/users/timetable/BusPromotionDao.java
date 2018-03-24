package com.infoshareacademy.zieloni.users.timetable;


import com.infoshareacademy.zieloni.users.timetable.model.Bus;

import javax.ejb.Local;
import java.util.List;

@Local
public interface BusPromotionDao {

    boolean editBusPromotion(Bus bus);

    Bus getBusById(Long id);
    List<Bus> getBusList();
}
