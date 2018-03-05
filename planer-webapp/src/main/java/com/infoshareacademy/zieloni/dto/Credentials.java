package com.infoshareacademy.zieloni.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Credentials {

    private String user;

    private String password;

    public Credentials() {

    }

    public Credentials(String user, String password) {
        this.user = user;
        this.password = password;
    }

    public String getUser() {
        return user;
    }

    @JsonIgnore
    public String getPassword() {
        return password;
    }

    @JsonProperty
    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Credentials{" +
                "user='" + user + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
