package com.infoshareacademy.zieloni.Model;

import java.util.ArrayList;

import lombok.Getter;
import lombok.Setter;

public class BusDTO {

    @Getter
    @Setter
    private String busNumber;

    @Getter
    @Setter
    private ArrayList<RecordVariantCsvDTO> busStopVariant1;

    @Getter
    @Setter
    private ArrayList<RecordVariantCsvDTO> busStopVariant2;


    @Getter
    @Setter
    private ArrayList<RecordCourseDTO> courseVariant1;

    @Getter
    @Setter
    private ArrayList<RecordCourseDTO> courseVariant2;



}
