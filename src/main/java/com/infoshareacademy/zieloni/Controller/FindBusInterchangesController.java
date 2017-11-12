package com.infoshareacademy.zieloni.Controller;

import com.infoshareacademy.zieloni.DataBase.BusDataBase;
import com.infoshareacademy.zieloni.Model.*;

import java.util.ArrayList;
import java.util.Map;

public class FindBusInterchangesController {
    private static String start_BusStop;
    private static String end_BusStop;
    private static ArrayList<ProposedBusDTO> startBusrArray = new ArrayList<>();
    private static ArrayList<ProposedBusDTO> endBusrArray = new ArrayList<>();
    private static ArrayList<ChangeConnectionDTO> interChangeArray = new ArrayList<>();

    public static void search(String startBusStop, String endBusStop) {

        end_BusStop = endBusStop;
        start_BusStop = startBusStop;
        ArrayList<BusDTO> busDB = BusDataBase.getDataBase();

        for (int i = 0; i < busDB.size(); i++) {
            checkBusForVaraint_start(i, busDB.get(i), busDB.get(i).getBusStops_v1(), busDB.get(i).getCourseRecords_v1(), busDB.get(i).getColumnsMap_v1(), 1);
            checkBusForVaraint_start(i, busDB.get(i), busDB.get(i).getBusStops_v2(), busDB.get(i).getCourseRecords_v2(), busDB.get(i).getColumnsMap_v2(), 2);
            checkBusForVaraint_stop(i, busDB.get(i), busDB.get(i).getBusStops_v1(), busDB.get(i).getCourseRecords_v1(), busDB.get(i).getColumnsMap_v1(), 1);
            checkBusForVaraint_stop(i, busDB.get(i), busDB.get(i).getBusStops_v2(), busDB.get(i).getCourseRecords_v2(), busDB.get(i).getColumnsMap_v2(), 2);
        }

        ArrayList<ProposedBusDTO> busArr_start = startBusrArray;
        ArrayList<ProposedBusDTO> busArr_end = endBusrArray;


        for (int i = 0; i < busArr_start.size(); i++) {

            for (int j = 0; j < busArr_end.size(); j++) {
                commonStopForTwoLine(busArr_start.get(i), busArr_end.get(j));
            }
        }
    }

    private static void checkBusForVaraint_start(int id, BusDTO busDTO, ArrayList<RecordVariantCsvDTO> busStops, ArrayList<RecordCourseDTO> courseRecords, Map<String, ArrayList<String>> columnMap, int variant) {
        int index = -1;
        for (int z = 0; z < busStops.size(); z++) {
            String busStop = busStops.get(z).getNameOfBusStop();
            if (busStop.equals(start_BusStop)) {
                index = z;
            }
        }

        if (index > 0) {
            ProposedBusDTO proposedBus = new ProposedBusDTO();
            proposedBus.setId(id);
            proposedBus.setBus(busDTO);
            proposedBus.setBusStopIndex(index);
            proposedBus.setVairiant(variant);
            startBusrArray.add(proposedBus);
        }
    }

    private static void checkBusForVaraint_stop(int id, BusDTO busDTO, ArrayList<RecordVariantCsvDTO> busStops, ArrayList<RecordCourseDTO> courseRecords, Map<String, ArrayList<String>> columnMap, int variant) {
        int index = -1;
        for (int z = 0; z < busStops.size(); z++) {
            String busStop = busStops.get(z).getNameOfBusStop();
            if (busStop.equals(end_BusStop)) {
                index = z;
            }
        }

        if (index > 0) {
            ProposedBusDTO proposedBus = new ProposedBusDTO();
            proposedBus.setId(id);
            proposedBus.setBus(busDTO);
            proposedBus.setBusStopIndex(index);
            proposedBus.setVairiant(variant);
            endBusrArray.add(proposedBus);
        }
    }

    public static void commonStopForTwoLine(ProposedBusDTO b0, ProposedBusDTO b1) {

        if (!b0.getBus().getBusNumber().toString().equals(b1.getBus().getBusNumber().toString())) {
            int variant = b0.getVairiant();
            ArrayList<RecordVariantCsvDTO> listBusStop;
            if (b0.getVairiant() == 1) {
                listBusStop = b0.getBus().getBusStops_v1();
            } else {
                listBusStop = b0.getBus().getBusStops_v2();
            }

            for (int i = b0.getBusStopIndex(); i < listBusStop.size(); i++) {
                int variant1 = b1.getVairiant();
                ArrayList<RecordVariantCsvDTO> listBusStop1;
                if (b1.getVairiant() == 1) {
                    listBusStop1 = b1.getBus().getBusStops_v1();
                } else {
                    listBusStop1 = b1.getBus().getBusStops_v2();
                }
                for (int j = 0; j < b1.getBusStopIndex(); j++) {
                    if (listBusStop.get(i).getNameOfBusStop().equals(listBusStop1.get(j).getNameOfBusStop())) {
                        ChangeConnectionDTO change = new ChangeConnectionDTO();
                        change.setBus0(b0.getBus());
                        change.setBus1(b1.getBus());
                        change.setConnectionBusStop(listBusStop.get(i).getNameOfBusStop());
                        change.setVairiant0(variant);
                        change.setVairiant1(variant1);

                        interChangeArray.add(change);

                    }
                }
            }

        }
    }

    public static ArrayList<ChangeConnectionDTO> getInterChangeArray() {
        return interChangeArray;
    }

    public static void setInterChangeArray(ArrayList<ChangeConnectionDTO> interChangeArray) {
        FindBusInterchangesController.interChangeArray = interChangeArray;
    }
}
