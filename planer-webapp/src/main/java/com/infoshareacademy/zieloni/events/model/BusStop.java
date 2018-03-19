package com.infoshareacademy.zieloni.events.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "busstop")
@NamedQueries({
        @NamedQuery(name = "getBusstopById", query = "from BusStop u where u.id=:id"),
        @NamedQuery(name = "getAllBusstop", query = "from BusStop"),

})
public class BusStop {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, unique = true)
    private Long id;
    private String street; // UID


}