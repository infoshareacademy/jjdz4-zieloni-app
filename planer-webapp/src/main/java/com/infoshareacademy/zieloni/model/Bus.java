package com.infoshareacademy.zieloni.model;

import lombok.Data;

import javax.persistence.*;


@Entity
@Data
@Table(name = "bus")
public class Bus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, unique = true)
    private Long id;
    private String name;
    private String type;
    private String status;
}
