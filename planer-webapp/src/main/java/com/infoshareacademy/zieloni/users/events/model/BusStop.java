package com.infoshareacademy.zieloni.users.events.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@Table(name = "busstop")
@NamedQueries({
        @NamedQuery(name = "getBusstopById", query = "from BusStop u where u.id=:id"),
        @NamedQuery(name = "getAllBusstop", query = "from BusStop"),

})
public class BusStop implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, unique = true)
    private Long id;

    private String street;


}