package com.infoshareacademy.zieloni.utils;


public class FormatTime {
    private FormatTime() {
    }

    public static String dateFromTo(String a) {

        Integer allTime;
        String hoursInString;
        String minutsInString;
        String numer = a.replace("+", ":");
        String[] numer1 = numer.split(":");

        allTime = (Integer.valueOf((numer1[2])) + Integer.valueOf((numer1[1])) + (Integer.valueOf((numer1[0])) * 60));

        if ((allTime / 60) >= 24) {
            hoursInString = String.valueOf((allTime / 60) - 24);
            minutsInString = String.valueOf(allTime % 60);

        } else {
            hoursInString = String.valueOf(allTime / 60);
            minutsInString = String.valueOf(allTime % 60);
        }

        if (hoursInString.length() < 2) {
            hoursInString = "0" + hoursInString;
        }
        if (minutsInString.length() < 2) {
            minutsInString = "0" + minutsInString;
        }
        return (hoursInString + ":" + minutsInString);
    }
}









