package com.infoshareacademy.zieloni;

import com.infoshareacademy.zieloni.DataBase.BusDataBase;
import com.infoshareacademy.zieloni.Model.BusDTO;
import com.infoshareacademy.zieloni.Model.RecordCourseDTO;
import com.infoshareacademy.zieloni.Model.RecordVariantCsvDTO;

import java.util.ArrayList;
import java.util.Map;


public class SearchBus {

    public static void search(String start_BusStop, String end_BusStop) {

        ArrayList<BusDTO> busDB = BusDataBase.getDataBase();

        for (int i = 0; i < busDB.size(); i++) {

            checkBusForVaraint(busDB.get(i), busDB.get(i).getBusStops_v1(), busDB.get(i).getCourseRecords_v1(), busDB.get(i).getColumnsMap_v1(), start_BusStop, end_BusStop, "dla wariantu 1");
            checkBusForVaraint(busDB.get(i), busDB.get(i).getBusStops_v2(), busDB.get(i).getCourseRecords_v2(), busDB.get(i).getColumnsMap_v2(), start_BusStop, end_BusStop, "dla wariantu 2");
        }
    }

    private static void checkBusForVaraint(BusDTO busDTO, ArrayList<RecordVariantCsvDTO> busStops, ArrayList<RecordCourseDTO> courseRecords, Map<String, ArrayList<String>> columnMap, String start_bs, String end_bs, String info) {

        int find_startBusStop_index = -1;
        int find_endBusStop_index = -1;

        for (int z = 0; z < busStops.size(); z++) {

            String busStop = busStops.get(z).getNameOfBusStop();

            if (busStop.equals(start_bs)) {
                find_startBusStop_index = z;
            }
            if (busStop.equals(end_bs)) {
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
                        System.out.println(courseRecords.get(i).getDepartureTime() + " " + minutes + " " + symbolColumnX0XX + "" + columnMap.get(symbolColumnX0XX));
                    }

                } catch (Exception e) {

                }

            }


        }
    }

}


