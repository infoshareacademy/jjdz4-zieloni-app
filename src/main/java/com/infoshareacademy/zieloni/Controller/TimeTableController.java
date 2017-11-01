package com.infoshareacademy.zieloni.Controller;

import com.infoshareacademy.zieloni.DataBase.BusDataBase;
import com.infoshareacademy.zieloni.Model.BusDTO;
import com.infoshareacademy.zieloni.PlanerView;
import com.infoshareacademy.zieloni.View.TimeTableView;

import java.util.ArrayList;

/**
 * @author Michal Stasiński
 */

public class TimeTableController {

    private static final ArrayList<BusDTO> busDB = BusDataBase.getDataBase();
    private static int level = 2;

    public static void show() {

        String text;

        //TimeTableView.startMenu();
        TimeTableView.choiceBus("1");
        while (PlanerView.scanner.hasNextLine()) {
            text = PlanerView.scanner.nextLine();
            if (text.equals("exit")) {
                System.out.println("koniec");
                break;
            }
            if (level == 0) {
                // level = TimeTableView.choiceBus(text);
            } else if (level == 2) {
                try {
                    level = TimeTableView.choiceVariant(Integer.valueOf(text));
                } catch (Exception e) {
                    System.out.println("Musisz wpisać liczbę");
                }

            } else if (level == 3) {
                try {
                    level = TimeTableView.showVariantStreet(Integer.valueOf(text));
                } catch (Exception e) {
                    System.out.println("Musisz wpisać liczbę");
                }
            } else if (level == 4) {
                try {
                    level = TimeTableView.showTimesForBusStop(Integer.valueOf(text));
                } catch (Exception e) {
                    System.out.println("Musisz wpisać liczbę");
                }
            } else if (level == 5) {
                break;
            }
        }
    }
}
