package com.infoshareacademy.zieloni.Model;

import java.util.ArrayList;

public class VariantCsvDTO {

    private String idVariant;
    private String flags;
    private String nameOfTheCommunity;
    private String nameOfBasStop;
    private ArrayList<String> times_X0_XX;

    public ArrayList<String> getTimes_X0_XX() {
        return times_X0_XX;
    }

    public void setTimes_X0_XX(ArrayList<String> timeX0_XX_Array) {
        this.times_X0_XX = times_X0_XX;
    }

    public String getIdVariant() {
        return idVariant;
    }

    public void setIdVariant(String idVariant) {
        this.idVariant = idVariant;
    }

    public String getFlags() {
        return flags;
    }

    public void setFlags(String flags) {
        this.flags = flags;
    }

    public String getNameOfTheCommunity() {
        return nameOfTheCommunity;
    }

    public void setNameOfTheCommunity(String nameOfTheCommunity) {
        this.nameOfTheCommunity = nameOfTheCommunity;
    }

    public String getNameOfBasStop() {
        return nameOfBasStop;
    }

    public void setNameOfBasStop(String nameOfBasStop) {
        this.nameOfBasStop = nameOfBasStop;
    }
}
