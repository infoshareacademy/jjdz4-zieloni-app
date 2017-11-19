package com.infoshareacademy.zieloni.Utils;

import static com.infoshareacademy.zieloni.DataBase.BusDataBase.DB;

 /*sprawdzam czy wpisany z klawiatury tekst to numer autobusu
 *
 * isExist 0-nie istnieje 1-istnieje
 * id na której pozycji w bazie
 *
 */

public class IsBusExist {

    public static int[] check(String txt) {
        int isExist = 0;
        int id = -1;
        for (int i = 0; i < DB.size(); i++) {
            if (txt.equals(DB.get(i).getBusNumber())) {
                isExist = 1;
                id = i;
            }
        }

        return new int[]{isExist, id};
    }
}
