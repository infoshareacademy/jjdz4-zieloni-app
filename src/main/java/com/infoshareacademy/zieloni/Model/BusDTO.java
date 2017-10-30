package com.infoshareacademy.zieloni.Model;

import java.util.ArrayList;
import java.util.Map;

import lombok.Getter;
import lombok.Setter;

public class BusDTO {

    @Getter
    @Setter
    private String busNumber;

    @Getter
    @Setter
    private ArrayList<RecordVariantCsvDTO> busStops_v1;

    @Getter
    @Setter
    private ArrayList<RecordVariantCsvDTO> busStops_v2;


    @Getter
    @Setter
    private ArrayList<RecordCourseDTO> courseRecords_v1;

    @Getter
    @Setter
    private ArrayList<RecordCourseDTO> courseRecords_v2;

    @Getter
    @Setter
    private Map<String, ArrayList<String>> columnsMap_v1;

    @Getter
    @Setter
    private Map<String, ArrayList<String>> columnsMap_v2;



}
