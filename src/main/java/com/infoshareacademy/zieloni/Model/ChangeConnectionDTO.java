package com.infoshareacademy.zieloni.Model;

import lombok.Getter;
import lombok.Setter;

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
