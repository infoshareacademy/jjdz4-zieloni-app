package com.infoshareacademy.zieloni.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "events")
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

}