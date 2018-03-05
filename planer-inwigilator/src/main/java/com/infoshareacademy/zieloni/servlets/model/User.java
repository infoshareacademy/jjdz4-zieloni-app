package com.infoshareacademy.zieloni.servlets.model;

public class User {

    private String name;

    private String surname;

    private int id;

    private Credentials credentials;

    public User(String name, String surname, int id, Credentials credentials) {
        this.name = name;
        this.surname = surname;
        this.id = id;
        this.credentials = credentials;
    }

    public User() {
    }


    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getId() {
        return id;
    }

    public Credentials getCredentials() {
        return credentials;
    }

    @Override
    public String toString() {
        return name + " " + surname;
    }

}
