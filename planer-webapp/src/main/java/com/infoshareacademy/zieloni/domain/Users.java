package com.infoshareacademy.zieloni.domain;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "users")
@NamedQueries({
        @NamedQuery(name = "getUserByLogin", query = "from Users u where u.login=:login"),
        @NamedQuery(name = "getAll", query = "from Users"),
        @NamedQuery(name = "updateUser", query = "update Users u  set u.name =:name, u.surname=:surname, u.age=:age, u.gender=:gender where u.id=:id"),
})

public class Users implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, unique = true)
    private int id;


    private String name;

    private String surname;
    private String login;
    private String email;
    private String password;
    private int age;

    @OneToOne(fetch = FetchType.LAZY,
            cascade = CascadeType.ALL,
            mappedBy = "user")
    private Roles role;


    @OneToOne(fetch = FetchType.LAZY,
            cascade = CascadeType.ALL,
            mappedBy = "user")
    private Statistic statistic;

    @Enumerated(EnumType.STRING)
    private Gender gender;
}
