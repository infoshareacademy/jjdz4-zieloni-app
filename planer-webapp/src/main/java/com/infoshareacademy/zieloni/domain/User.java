package com.infoshareacademy.zieloni.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
//@NamedQueries({
  //      @NamedQuery(name = "getUserByLogin", query = "from User u where u.email_as_login=:login"),
    //    @NamedQuery(name = "getAll", query = "from User")
//}
//)
public class User {

    public User() {
    }

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(nullable=false, unique=true)
    private int id;

    private String name;

    private String surname;

    private String email_as_login;





    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail_as_login() {
        return email_as_login;
    }

    public void setEmail_as_login(String login) {
        this.email_as_login = login;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }



    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", login='" + email_as_login + '\'' +
                '}';
    }
}