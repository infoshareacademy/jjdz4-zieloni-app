package com.infoshareacademy.zieloni.Model;

import java.util.ArrayList;

import lombok.Getter;
import lombok.Setter;

public class VariantCsvDTO {

    @Getter
    @Setter
    private String idVariant;
    @Getter
    @Setter
    private String flags;
    @Getter
    @Setter
    private String nameOfTheCommunity;
    @Getter
    @Setter
    private String nameOfBasStop;
    @Getter
    @Setter
    private ArrayList<ArrayList<String>> times_X0_XX = new ArrayList<>();
}


