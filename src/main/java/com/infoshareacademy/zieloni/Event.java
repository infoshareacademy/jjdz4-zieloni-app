package com.infoshareacademy.zieloni;

import java.time.LocalDateTime;

public class Event {
    private LocalDateTime startTime; // Czas rozpoczęcia wydarzenia
    private LocalDateTime endTime; // Czas zakończenia wydarzenia
    private String uid; // UID
    private String location; // Miejsce wydarzenia
    private String summary; // Opis wydarzenia

    public Event(LocalDateTime startTime, LocalDateTime endTime, String uid, String location, String summary) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.uid = uid;
        this.location = location;
        this.summary = summary;
    }
    public LocalDateTime getStartTime() {
        return startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public String getUid() {
        return uid;
    }

    public String getLocation() {
        return location;
    }

    public String getSummary() {
        return summary;
    }
}
