package com.infoshareacademy.zieloni.servlets.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "user")
@NamedQueries({
        @NamedQuery(name = "getAll", query = "from User"),
        @NamedQuery(name = "updateUser", query = "update User u  set u.name =:name, u.surname=:surname where u.id=:id"),
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

}
