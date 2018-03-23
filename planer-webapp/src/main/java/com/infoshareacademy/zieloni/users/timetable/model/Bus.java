package com.infoshareacademy.zieloni.users.timetable.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Data
@Table(name = "bus")

@NamedQueries({
        @NamedQuery(name = "getBusByName", query = "from Bus b where b.name=:name"),
        @NamedQuery(name = "getAllBus", query = "from Bus order by name"),
        @NamedQuery(name = "updateBus", query = "update Bus b  set b.name =:name, b.status=:status, b.type=:type where b.id=:id"),
})
public class Bus implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, unique = true)
    private Long id;
    private String name;
    private String status;
    private String type;
    @Override
    public String toString() {
        return "Bus{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", status='" + status + '\'' +
                ", type='" + type+ '\'' +
                '}';
    }

}
