package com.infoshareacademy.zieloni.model;

import lombok.Getter;
import lombok.Setter;

public class ProposedBusDTO {
    @Getter
    @Setter
    private int id;

    @Getter
    @Setter
    private BusDTO bus;

    @Getter
    @Setter
    private int vairiant;

    @Getter
    @Setter
    private int busStopIndex;
}
