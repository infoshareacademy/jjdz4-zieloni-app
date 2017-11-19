package com.infoshareacademy.zieloni.utils;

import com.infoshareacademy.zieloni.database.BusDataBase;


public class IsBusExist {

    public static int[] check(String txt) {
        int isExist = 0;
        int id = -1;
        for (int i = 0; i < BusDataBase.getBusDataBase().size(); i++) {
            if (txt.equals(BusDataBase.getBusDataBase().get(i).getBusNumber())) {
                isExist = 1;
                id = i;
            }
        }

        return new int[]{isExist, id};
    }
}
