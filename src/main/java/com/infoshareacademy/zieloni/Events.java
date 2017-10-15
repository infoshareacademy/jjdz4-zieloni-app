package com.infoshareacademy.zieloni;

import java.util.ArrayList;
import java.util.Date;

public class Events {
    private ArrayList<Event> events = new ArrayList<>();

    public void loadEvents(){
        // metoda wczytująca wydarzenia z pliku ical
        // ..


//        add();
    }

    public void add(Date startTime, Date endTime, String uid, String location, String summary) {
        events.add(new Event(startTime, endTime, uid, location, summary));
    }
}
