package com.infoshareacademy.zieloni;

import java.util.Date;

public class Event {
    private Date startTime; // Czas rozpoczęcia wydarzenia
    private Date endTime; // Czas zakończenia wydarzenia
    private String uid; // UID
    private String location; // Miejsce wydarzenia
    private String summary; // Opis wydarzenia

    public Event(Date startTime, Date endTime, String uid, String location, String summary) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.uid = uid;
        this.location = location;
        this.summary = summary;
    }
}
