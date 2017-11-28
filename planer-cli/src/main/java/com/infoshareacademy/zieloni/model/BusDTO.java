package com.infoshareacademy.zieloni.model;

import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class BusDTO {

    private String busNumber;
    private List<RecordVariantDTO> busStopsV1;
    private List<RecordVariantDTO> busStopsV2;
    private List<RecordCourseDTO> courseRecordsV1;
    private List<RecordCourseDTO> courseRecordsV2;
    private Map<String, List<String>> columnsMapV1;
    private Map<String, List<String>> columnsMapV2;
    private String typeOfTransport;
}
