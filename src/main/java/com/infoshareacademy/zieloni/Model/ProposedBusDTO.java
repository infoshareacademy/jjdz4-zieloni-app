package com.infoshareacademy.zieloni.Model;

import lombok.Getter;
import lombok.Setter;


/* Model dla proponowanego aoutobusu*/
public class ProposedBusDTO {
    @Getter
    @Setter
    private int id; //na której pozycji znajduje sie autobus w bazie danych

    @Getter
    @Setter
    private BusDTO bus;

    @Getter
    @Setter
    private int vairiant; //wariant jaki został wybrany dla proponowanego autobusu

    @Getter
    @Setter
    private int busStopIndex;//jak daleko przystanek poczatkowy znajduje sie od pętli autobusowej
}
