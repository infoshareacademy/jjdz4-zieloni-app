package com.infoshareacademy.zieloni.Model;

import java.util.ArrayList;

/**
 * @author Michal Stasiński
 */
public class BusDTO {

    private String busNumber;
    private ArrayList<VariantCsvDTO> busStopVariant1;
    private ArrayList<VariantCsvDTO> busStopVariant2;

    /*private ArrayList<CouresDTO> typeOfCourse1;
    private ArrayList<CouresDTO> typeOfCourse2;*/


    public String getBusNumber() {
        return busNumber;
    }

    public void setBusNumber(String busNumber) {
        this.busNumber = busNumber;
    }

    public ArrayList<VariantCsvDTO> getBusStopVariant1() {
        return busStopVariant1;
    }

    public void setBusStopVariant1(ArrayList<VariantCsvDTO> busStopVariant1) {
        this.busStopVariant1 = busStopVariant1;
    }

    public ArrayList<VariantCsvDTO> getBusStopVariant2() {
        return busStopVariant2;
    }

    public void setBusStopVariant2(ArrayList<VariantCsvDTO> busStopVariant2) {
        this.busStopVariant2 = busStopVariant2;
    }
}
