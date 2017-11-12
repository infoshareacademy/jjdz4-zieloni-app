package com.infoshareacademy.zieloni.Controller;

import com.infoshareacademy.zieloni.DataBase.BusDataBase;
import com.infoshareacademy.zieloni.Model.BusDTO;
import com.infoshareacademy.zieloni.Model.ProposedBusDTO;
import com.infoshareacademy.zieloni.Model.RecordCourseDTO;
import com.infoshareacademy.zieloni.Model.RecordVariantCsvDTO;

import java.util.ArrayList;
import java.util.Map;


public class FindBusController {

    private static String start_BusStop;
    private static String end_BusStop;
    private static ArrayList<ProposedBusDTO> proposedBusArr;

    public static void search(String startBusStop, String endBusStop) {

        end_BusStop = endBusStop;
        start_BusStop = startBusStop;
        proposedBusArr = new ArrayList<>();


        ArrayList<BusDTO> busDB = BusDataBase.getDataBase();

        for (int i = 0; i < busDB.size(); i++) {
            checkBusForVaraint(i, busDB.get(i), busDB.get(i).getBusStops_v1(), busDB.get(i).getCourseRecords_v1(), busDB.get(i).getColumnsMap_v1(), 1);
            checkBusForVaraint(i, busDB.get(i), busDB.get(i).getBusStops_v2(), busDB.get(i).getCourseRecords_v2(), busDB.get(i).getColumnsMap_v2(), 2);
        }
    }

    private static void checkBusForVaraint(int id, BusDTO busDTO, ArrayList<RecordVariantCsvDTO> busStops, ArrayList<RecordCourseDTO> courseRecords, Map<String, ArrayList<String>> columnMap, int variant) {

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

            ProposedBusDTO proposedBus = new ProposedBusDTO();
            proposedBus.setId(id);
            proposedBus.setBus(busDTO);
            proposedBus.setBusStopIndex(find_startBusStop_index);
            proposedBus.setVairiant(variant);
            proposedBusArr.add(proposedBus);
            //TimeTableView.showTimesForBusStop(id,find_startBusStop_index,variant);
        }
    }

    public static ArrayList<ProposedBusDTO> getProposedBusArr() {
        return proposedBusArr;
    }

    public static void setProposedBusArr(ArrayList<ProposedBusDTO> proposedBus) {
        FindBusController.proposedBusArr = proposedBus;
    }

}


