package com.infoshareacademy.zieloni.Model;

import java.util.ArrayList;

/**
 * @author Michal Stasiński
 */
public class CouresDTO {

    private String whenIsRunning;
    private ArrayList<ArrayList<String>> travelTimes;

    public String getWhenIsRunning() {
        return whenIsRunning;
    }

    public void setWhenIsRunning(String whenIsRunning) {
        this.whenIsRunning = whenIsRunning;
    }

    public ArrayList<ArrayList<String>> getTravelTimes() {
        return travelTimes;
    }

    public void setTravelTimes(ArrayList<ArrayList<String>> travelTimes) {
        this.travelTimes = travelTimes;
    }
}
