package com.infoshareacademy.zieloni.timetable.model;

import lombok.Data;

import javax.persistence.*;


@Entity
@Data
@Table(name = "bus")
@NamedQueries({
        @NamedQuery(name = "getBusByName", query = "from Bus b where b.name=:name"),
        @NamedQuery(name = "getAllBus", query = "from Bus"),
        @NamedQuery(name = "updateBus", query = "update Bus b  set b.name =:name, b.status=:status, b.type=:type where b.id=:id"),
})
public class Bus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, unique = true)
    private Long id;
    private String name;
    private String type;
    private String status;
}
