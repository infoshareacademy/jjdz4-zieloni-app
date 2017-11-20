package com.infoshareacademy.zieloni.model;

import lombok.Data;

@Data
public class ProposedBusDTO {
    private int id;
    private BusDTO bus;
    private int vairiant;
    private int busStopIndex;
}
