package com.infoshareacademy.zieloni;

import com.infoshareacademy.zieloni.DataBase.BusDataBase;
import com.infoshareacademy.zieloni.Model.BusDTO;
import com.infoshareacademy.zieloni.Model.RecordCourseDTO;
import com.infoshareacademy.zieloni.Model.RecordVariantCsvDTO;

import java.util.ArrayList;
import java.util.Map;


public class FindBus {

    private static String start_BusStop;
    private static String end_BusStop;

    public static void search(String startBusStop, String endBusStop) {

        end_BusStop = endBusStop;
        start_BusStop = startBusStop;

        ArrayList<BusDTO> busDB = BusDataBase.getDataBase();

        for (int i = 0; i < busDB.size(); i++) {
            checkBusForVaraint(busDB.get(i), busDB.get(i).getBusStops_v1(), busDB.get(i).getCourseRecords_v1(), busDB.get(i).getColumnsMap_v1(), "dla wariantu 1");
            checkBusForVaraint(busDB.get(i), busDB.get(i).getBusStops_v2(), busDB.get(i).getCourseRecords_v2(), busDB.get(i).getColumnsMap_v2(), "dla wariantu 2");
        }
    }

    private static void checkBusForVaraint(BusDTO busDTO, ArrayList<RecordVariantCsvDTO> busStops, ArrayList<RecordCourseDTO> courseRecords, Map<String, ArrayList<String>> columnMap, String info) {

        int find_startBusStop_index = -1;
        int find_endBusStop_index = -1;

        for (int z = 0; z < busStops.size(); z++) {

            String busStop = busStops.get(z).getNameOfBusStop();

            if (busStop.equals(start_BusStop)) {
                find_startBusStop_index = z;
            }
            if (busStop.equals(end_BusStop)) {
                find_endBusStop_index = z;
            }
        }

        if (find_startBusStop_index < find_endBusStop_index && find_startBusStop_index > -1) {


            System.out.println("zobacz autobus nr : " + busDTO.getBusNumber() + "    " + info);
            String symbolColumnX0XX;

            for (int i = 0; i < courseRecords.size(); i++) {
                int minutes = 0;
                symbolColumnX0XX = courseRecords.get(i).getCourseX0_XX();

                for (int j = 0; j < find_startBusStop_index; j++) {

                    try {
                        minutes += Integer.valueOf(columnMap.get(symbolColumnX0XX).get(j));
                    } catch (Exception e) {
                        minutes += 1;
                    }
                }
                try {

                    if (courseRecords.get(i).getCourseX0_XX().split("X")[0].equals("")) {
                        //TODO wywietlić zaproponowane autobusy--odkomentowac
                        //System.out.println(courseRecords.get(i).getDepartureTime() + " " + minutes + " minut ");
                        //System.out.println("Tabela minut"+symbolColumnX0XX + "" + columnMap.get(symbolColumnX0XX));
                    } else {
                        //TODO wywietlić zaproponowane autobusy
                        //System.out.println(courseRecords.get(i).getCourseX0_XX());
                        //  System.out.println("            "+courseRecords.get(i).getCourseX0_XX()+"             ");
                    }

                } catch (Exception e) {

                }
            }
        }
    }
}


