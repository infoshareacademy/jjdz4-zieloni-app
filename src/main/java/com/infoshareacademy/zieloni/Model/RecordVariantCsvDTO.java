package com.infoshareacademy.zieloni.Model;

import java.util.ArrayList;
import java.util.Map;

import lombok.Getter;
import lombok.Setter;

public class RecordVariantCsvDTO {

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
    private Map<String, ArrayList<String>> mapTimes_X0_XX;
}


