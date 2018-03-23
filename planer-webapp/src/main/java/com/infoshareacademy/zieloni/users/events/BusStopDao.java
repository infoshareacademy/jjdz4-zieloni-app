package com.infoshareacademy.zieloni.users.events;

import com.infoshareacademy.zieloni.users.events.model.BusStop;

import javax.ejb.Local;
import java.util.List;


@Local
public interface BusStopDao {



    List <BusStop> getBusstopList();

}