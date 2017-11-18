package com.infoshareacademy.zieloni.Model;

import lombok.Getter;
import lombok.Setter;


/**
 * Model dla przesiadki
 * bus0 -autobus którym zaczynamy podróż
 * variant0 -wariant jaki został wybrany dla bus0
 * bus1 -autobus którym komczymy podróż
 * variant1 -wariant jaki został wybrany dla bus1
 * connectionBusStop- wspólny przystanek na którym następuje przesiadka
 */

public class ChangeConnectionDTO {
    @Getter
    @Setter
    private BusDTO bus0;

    @Getter
    @Setter
    private int vairiant0;

    @Getter
    @Setter
    private String connectionBusStop;

    @Getter
    @Setter
    private BusDTO bus1;

    @Getter
    @Setter
    private int vairiant1;
}
