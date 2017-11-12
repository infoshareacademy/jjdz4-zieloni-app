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

    /*Lista z proponowanymi autobusami*/
    private static ArrayList<ProposedBusDTO> proposedBusArr;


    /**
     * @param startBusStop - przystanek początkowy
     * @param endBusStop   - przystanek końcowy
     */
    public static void search(String startBusStop, String endBusStop) {

        end_BusStop = endBusStop;
        start_BusStop = startBusStop;
        proposedBusArr = new ArrayList<>();

        /*baza wszystkich autobusów*/
        ArrayList<BusDTO> busDB = BusDataBase.DB;

        for (int i = 0; i < busDB.size(); i++) {
            checkBusForVariant(i, busDB.get(i), 1);
            checkBusForVariant(i, busDB.get(i), 2);
        }
    }

    /*spawdzamy czy rozkład jazdy danego autobusu zawiera przystanek poczatkowy i koncowy*/
    private static void checkBusForVariant(int id, BusDTO busDTO,  int variant) {

        ArrayList<RecordVariantCsvDTO> busStops;
        if(variant ==1){
            busStops = busDTO.getBusStops_v1();
        }else {
            busStops = busDTO.getBusStops_v2();
        }
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


