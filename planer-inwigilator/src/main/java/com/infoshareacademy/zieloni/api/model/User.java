package com.infoshareacademy.zieloni.api.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "user")
@NamedQueries({
        @NamedQuery(name = "getAll", query = "from User"),
        @NamedQuery(name = "updateUser", query = "update User u  set u.name =:name, u.surname=:surname where u.id=:id"),
        @NamedQuery(name = "children", query = "select  login from User u  where u.age >=0 and u.age <15 and u.activity='LOG_IN'"),
        @NamedQuery(name = "teenage", query = "select  login from User u  where u.age >=15 and u.age <19 and u.activity='LOG_IN'"),
        @NamedQuery(name = "adult", query = "select  login from User u  where u.age >=19 and u.age <60 and u.activity='LOG_IN'"),
        @NamedQuery(name = "senior", query = "select  login from User u  where u.age >=60 and u.activity='LOG_IN' "),
        @NamedQuery(name = "man", query = "select  login from User u  where u.gender='MAN' and u.activity='LOG_IN' "),
        @NamedQuery(name = "woman", query = "select  login from User u  where u.gender='WOMAN'and u.activity='LOG_IN'  ")

})
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, unique = true)
    private int id;
    private String name;
    private String surname;
    private String login;
    private String logTime;
    private String activity;
    private String gender;
    private int age;
}
