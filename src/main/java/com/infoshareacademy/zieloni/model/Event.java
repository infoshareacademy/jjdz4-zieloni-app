package com.infoshareacademy.zieloni.model;

import lombok.Getter;

import java.time.LocalDateTime;

public class Event {
    @Getter
    private LocalDateTime startTime; // Czas rozpoczęcia wydarzenia
    @Getter
    private LocalDateTime endTime; // Czas zakończenia wydarzenia
    @Getter
    private String uid; // UID
    @Getter
    private String location; // Miejsce wydarzenia
    @Getter
    private String summary; // Opis wydarzenia

    public Event(LocalDateTime startTime, LocalDateTime endTime, String uid, String location, String summary) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.uid = uid;
        this.location = location;
        this.summary = summary;
    }
}