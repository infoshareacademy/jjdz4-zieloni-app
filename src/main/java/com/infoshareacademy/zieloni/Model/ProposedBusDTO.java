package com.infoshareacademy.zieloni.Model;

import lombok.Getter;
import lombok.Setter;


/* Model dla proponowanego aoutobusu*/
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
