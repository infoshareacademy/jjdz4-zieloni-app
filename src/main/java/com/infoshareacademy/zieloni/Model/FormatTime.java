package com.infoshareacademy.zieloni.Model;



import java.util.ArrayList;


public class FormatTime {

    private static Integer m;

    private static Integer ddd;
    private static Integer wynik;
    private static String Ost;
    private static String Ost1;

    public static String dateFromTo(String a) {
        ArrayList<Integer> timeStringInt = new ArrayList<Integer>();


        for (int i = 0; i < a.length(); i++) {
            if (Character.isDigit(a.charAt(i))) {
                String num = "";

                while (i < a.length() && Character.isDigit(a.charAt(i))) {
                    num += a.charAt(i++);

                }
                timeStringInt.add(Integer.parseInt(num));
            }


        }


        m = (timeStringInt.get(1) + timeStringInt.get(2) + (timeStringInt.get(0) * 60));

        if ((m / 60) >= 24) {
            wynik = (m / 60) - 24;
            ddd = (m % 60);
            Ost = String.valueOf(wynik);
            Ost1 = String.valueOf(ddd);
        } else {
            wynik = (m / 60);
            ddd = (m % 60);
            Ost1 = String.valueOf(ddd);
            Ost = String.valueOf(wynik);
        }

        if (Ost.length() < 2) {
            Ost = "0" + Ost;
        }
        if (Ost1.length() < 2) {
            Ost1 = "0" + Ost1;
        }
        return (Ost + ":" + Ost1);
    }
}









