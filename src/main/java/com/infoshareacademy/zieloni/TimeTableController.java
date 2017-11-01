package com.infoshareacademy.zieloni;

import com.infoshareacademy.zieloni.DataBase.BusDataBase;
import com.infoshareacademy.zieloni.Model.BusDTO;
import com.infoshareacademy.zieloni.Model.RecordCourseDTO;
import com.infoshareacademy.zieloni.Utils.FormatTime;
import com.infoshareacademy.zieloni.View.TimeTableView;

import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

/**
 * @author Michal Stasiński
 */

public class TimeTableController {
    private static final ArrayList<BusDTO> busDB = BusDataBase.getDataBase();
    private static int level = 0;
    private static int choiceBus = -1;
    private static int street = -1;
    private static int variant = -1;

    public static void show() {

        String text;
        Scanner scanner = new Scanner(System.in);

        TimeTableView.startMenu();

        while (scanner.hasNextLine()) {
            text = scanner.nextLine();
            if (text.equals("exit")) {
                System.out.println("koniec");
                break;
            }

            if (level == 0) {
                level = TimeTableView.choiceBus(text);
            } else if (level == 2) {
                level = TimeTableView.choiceVariant(Integer.valueOf(text));
            } else if (level == 3) {
                level = TimeTableView.showVariantStreet(Integer.valueOf(text));
            } else if (level == 4) {
                level = TimeTableView.showTimesForBusStop(Integer.valueOf(text));
            } else if (level == 5) {
                break;
            }
        }
    }
}
