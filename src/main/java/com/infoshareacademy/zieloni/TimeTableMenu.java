package com.infoshareacademy.zieloni;

import com.infoshareacademy.zieloni.DataBase.BusDataBase;
import com.infoshareacademy.zieloni.Model.BusDTO;
import com.infoshareacademy.zieloni.Model.RecordCourseDTO;
import com.infoshareacademy.zieloni.Utils.FormatTime;

import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

/**
 * @author Michal Stasiński
 */


public class TimeTableMenu {
    private static final ArrayList<BusDTO> busDB = BusDataBase.getDataBase();
    private static int level = 0;
    private static int choiceBus = -1;
    private static int street = -1;
    private static int variant = -1;

    public static void show() {

        String text;
        Scanner scanner = new Scanner(System.in);
        startMenu();

        while (scanner.hasNextLine()) {
            text = scanner.nextLine();
            if (text.equals("exit")) {
                System.out.println("koniec");
                break;
            }

            if (level == 0) {

                if (text.equals("1")) {
                    choiceBus();
                }else{
                    System.out.println("Wpisz 1 lub exit");
                }
            } else if (level == 2) {
                try {
                    if (Integer.valueOf(text) > -1 && Integer.valueOf(text) < busDB.size()) {
                        choiceVariant(Integer.valueOf(text));
                    } else {
                        System.out.println("Wybierz od 0 do " + (busDB.size() - 1));
                    }

                } catch (Exception e) {

                }
            } else if (level == 3) {
                try {
                    if (text.equals("1") || text.equals("2")) {
                        showVariantStreet(Integer.valueOf(text));
                    } else {
                        System.out.println("Wybierz od 1 do 2");
                    }

                } catch (Exception e) {

                }

            } else if (level == 4) {

                int busStopArrSize = -1;
                if (variant == 1) {
                    busStopArrSize = busDB.get(choiceBus).getBusStops_v1().size();
                }

                if (variant == 2) {
                    busStopArrSize = busDB.get(choiceBus).getBusStops_v2().size();
                }

                if (Integer.valueOf(text) > -1 && Integer.valueOf(text) < busStopArrSize) {
                    showTimesForBusStop(Integer.valueOf(text));
                } else {
                    System.out.println("Wybierz od 0 do " + (busStopArrSize - 1));
                }
            }

        }
    }

    private static void showTimesForBusStop(Integer integer) {

        street = integer;

        ArrayList<RecordCourseDTO> courseRecord = null;
        Map<String, ArrayList<String>> map = null;

        if (variant == 1) {
            courseRecord = busDB.get(choiceBus).getCourseRecords_v1();
            map = busDB.get(choiceBus).getColumnsMap_v1();
            System.out.println("chce zobaczyc rozkład autobusu nr " + busDB.get(choiceBus).getBusNumber() + " na ulicy " + busDB.get(choiceBus).getBusStops_v1().get(street).getNameOfBusStop());

        } else if (variant == 2) {
            courseRecord = busDB.get(choiceBus).getCourseRecords_v2();
            map = busDB.get(choiceBus).getColumnsMap_v2();
            System.out.println("chce zobaczyc rozkład autobusu nr " + busDB.get(choiceBus).getBusNumber() + " na ulicy " + busDB.get(choiceBus).getBusStops_v2().get(street).getNameOfBusStop());
        }

        for (int i = 0; i < courseRecord.size(); i++) {
            int minutes = 0;
            String symbolColumnX0XX = courseRecord.get(i).getCourseX0_XX();

            for (int j = 0; j < street; j++) {

                try {
                    minutes += Integer.valueOf(map.get(symbolColumnX0XX).get(j));
                } catch (Exception e) {
                    minutes += 1;
                }
            }
            try {
                if (courseRecord.get(i).getCourseX0_XX().split("X")[0].equals("")) {
                    System.out.println(courseRecord.get(i).getDepartureTime() + " " + minutes + "  " + FormatTime.dateFromTo(courseRecord.get(i).getDepartureTime() + " " + minutes));
                    //System.out.println("Tabela minut"+symbolColumnX0XX + "" + map.get(symbolColumnX0XX));
                }

            } catch (Exception e) {

            }
        }
    }

    private static void startMenu() {
        System.out.println("#################################################");
        // System.out.println("# Wpisz '1' jeśli chcesz zobaczyć wydarzenia    #");
        System.out.println("# Wpisz '1' jeśli chcesz zobaczyć rozkład jazdy #");
        System.out.println("#       Wpisz 'exit' aby wyjść z programu       #");
        System.out.println("#################################################");
    }

    private static void choiceBus() {
        level = 2;
        System.out.println("#################################################");
        System.out.println("#          Wpisz nr porzadkowy autobusu         #");
        System.out.println("#       Wpisz 'exit' aby wyjść z programu       #");
        System.out.println("#################################################");
        for (int i = 0; i < busDB.size(); i++) {
            System.out.println(i + ") " + busDB.get(i).getBusNumber());
        }
    }

    private static void choiceVariant(Integer integer) {
        level = 3;
        System.out.println("#################################################");
        System.out.println("#          Wybrałeś autobus nr " + busDB.get(integer).getBusNumber() + "              #");
        System.out.println("#                                               #");
        System.out.println("#     Wpisz 1) jeśli chcesz jechać 'tam'        #");
        System.out.println("#     Wpisz 2) jeśli chcesz jechać 'z powrotem' #");
        System.out.println("#################################################");
        choiceBus = integer;
    }

    private static void showVariantStreet(Integer integer) {
        level = 4;
        System.out.println("#################################################");
        // System.out.println("# Wpisz '1' jeśli chcesz zobaczyć wydarzenia  #");
        System.out.println("#       Wybierz nr porzadkowy przystanku        #");
        System.out.println("#       Wpisz 'exit' aby wyjść z programu       #");
        System.out.println("#################################################");
        variant = integer;

        if (integer == 1) {
            for (int i = 0; i < busDB.get(choiceBus).getBusStops_v1().size(); i++) {
                System.out.println(i + ") " + busDB.get(choiceBus).getBusStops_v1().get(i).getNameOfBusStop());
            }
        }

        if (integer == 2) {
            for (int i = 0; i < busDB.get(choiceBus).getBusStops_v2().size(); i++) {
                System.out.println(i + ") " + busDB.get(choiceBus).getBusStops_v2().get(i).getNameOfBusStop());
            }
        }
    }
}
