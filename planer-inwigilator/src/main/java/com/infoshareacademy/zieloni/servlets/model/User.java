package com.infoshareacademy.zieloni.servlets.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "user")
@NamedQueries({
        @NamedQuery(name = "getAll", query = "from User")
})
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, unique = true)
    private int id;
    private String name;
    private String surname;
    private int logCounter;

}
