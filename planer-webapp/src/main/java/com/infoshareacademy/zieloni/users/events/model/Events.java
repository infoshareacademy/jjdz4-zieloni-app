package com.infoshareacademy.zieloni.users.events.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "events")
@NamedQueries({
        @NamedQuery(name = "getEventsByLogin", query = "from Events u where u.login=:login"),
        @NamedQuery(name = "getEventsById", query = "from Events u where u.id=:id"),
        @NamedQuery(name = "getAllEvents", query = "from Events"),
        @NamedQuery(name = "updateEvents", query = "update Events u  set u.startTime =:startTime, u.endTime=:endTime, u.uid=:uid, u.location=:location, u.summary=:summary,u.login=:login where " +
                "(u.id=:id)"),
})
public class Events {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, unique = true)
    private Long id;

    private LocalDateTime startTime; // Czas rozpoczęcia wydarzenia

    private LocalDateTime endTime; // Czas zakończenia wydarzenia

    private String uid; // UID

    private String location; // Miejsce wydarzenia

    private String summary; // Opis wydarzenia
    private String login;
}