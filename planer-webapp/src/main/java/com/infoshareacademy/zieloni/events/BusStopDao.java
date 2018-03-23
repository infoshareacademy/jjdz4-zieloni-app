package com.infoshareacademy.zieloni.events;

import com.infoshareacademy.zieloni.events.model.BusStop;
import com.infoshareacademy.zieloni.events.model.Events;

import javax.ejb.Local;
import java.util.List;


@Local
public interface BusStopDao {



    List <BusStop> getBusstopList();

}