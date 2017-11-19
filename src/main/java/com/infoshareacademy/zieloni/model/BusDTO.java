package com.infoshareacademy.zieloni.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import lombok.Getter;
import lombok.Setter;

public class BusDTO {

    @Getter
    @Setter
    private String busNumber;

    @Getter
    @Setter
    private List<RecordVariantDTO> busStops_v1;

    @Getter
    @Setter
    private List<RecordVariantDTO> busStops_v2;


    @Getter
    @Setter
    private List<RecordCourseDTO> courseRecords_v1;

    @Getter
    @Setter
    private List<RecordCourseDTO> courseRecords_v2;

    @Getter
    @Setter
    private Map<String, List<String>> columnsMap_v1;

    @Getter
    @Setter
    private Map<String, List<String>> columnsMap_v2;


    @Getter
    @Setter
    private String typeOfTransport;



}
