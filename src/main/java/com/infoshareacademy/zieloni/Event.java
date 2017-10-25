package com.infoshareacademy.zieloni;

import java.time.LocalDateTime;

class Event {
    private LocalDateTime startTime; // Czas rozpoczęcia wydarzenia
    private LocalDateTime endTime; // Czas zakończenia wydarzenia
    private String uid; // UID
    private String location; // Miejsce wydarzenia
    private String summary; // Opis wydarzenia

    Event(LocalDateTime startTime, LocalDateTime endTime, String uid, String location, String summary) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.uid = uid;
        this.location = location;
        this.summary = summary;
    }
    LocalDateTime getStartTime() {
        return startTime;
    }

    LocalDateTime getEndTime() {
        return endTime;
    }

    private String getUid() {
        return uid;
    }

    String getLocation() {
        return location;
    }

    String getSummary() {
        return summary;
    }
}
