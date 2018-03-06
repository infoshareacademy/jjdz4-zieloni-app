package com.infoshareacademy.zieloni.servlets.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, unique = true)
    private int id;
    private String name;
    private String surname;
    private Credentials credentials;

    public User(String name, String surname, int id, Credentials credentials) {
        this.name = name;
        this.surname = surname;
        this.id = id;
        this.credentials = credentials;
    }

}
