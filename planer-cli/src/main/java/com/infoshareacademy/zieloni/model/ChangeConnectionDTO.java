package com.infoshareacademy.zieloni.model;

import lombok.Data;

@Data
public class ChangeConnectionDTO {
    private BusDTO bus0;
    private int vairiant0;
    private String connectionBusStop;
    private BusDTO bus1;
    private int vairiant1;
}
