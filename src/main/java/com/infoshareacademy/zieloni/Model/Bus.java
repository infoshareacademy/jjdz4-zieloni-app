package com.infoshareacademy.zieloni.Model;

import java.util.ArrayList;

/**
 * @author Michal Stasiński
 */
public class Bus {

    private String busNumber;
    private ArrayList<VariantCsvModel> busStopVariant1;
    private ArrayList<VariantCsvModel> busStopVariant2;

    /*private ArrayList<Coures> typeOfCourse1;
    private ArrayList<Coures> typeOfCourse2;*/


    public String getBusNumber() {
        return busNumber;
    }

    public void setBusNumber(String busNumber) {
        this.busNumber = busNumber;
    }

    public ArrayList<VariantCsvModel> getBusStopVariant1() {
        return busStopVariant1;
    }

    public void setBusStopVariant1(ArrayList<VariantCsvModel> busStopVariant1) {
        this.busStopVariant1 = busStopVariant1;
    }

    public ArrayList<VariantCsvModel> getBusStopVariant2() {
        return busStopVariant2;
    }

    public void setBusStopVariant2(ArrayList<VariantCsvModel> busStopVariant2) {
        this.busStopVariant2 = busStopVariant2;
    }
}
