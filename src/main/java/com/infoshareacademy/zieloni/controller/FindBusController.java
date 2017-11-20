package com.infoshareacademy.zieloni.controller;

import com.infoshareacademy.zieloni.database.BusDataBase;
import com.infoshareacademy.zieloni.model.BusDTO;
import com.infoshareacademy.zieloni.model.ProposedBusDTO;
import com.infoshareacademy.zieloni.model.RecordVariantDTO;

import java.util.ArrayList;
import java.util.List;

public class FindBusController {

    private static String initialBusStop;
    private static String finalBusStop;
    private static ArrayList<ProposedBusDTO> proposedBusArr;

    private FindBusController() {
    }

    public static void search(String initialStop, String finalStop) {

        finalBusStop = finalStop;
        initialBusStop = initialStop;
        proposedBusArr = new ArrayList<>();

        List<BusDTO> busDB = BusDataBase.getDataBase();

        for (int i = 0; i < busDB.size(); i++) {
            checkBusForVariant(i, busDB.get(i), 1);
            checkBusForVariant(i, busDB.get(i), 2);
        }
    }

    private static void checkBusForVariant(int id, BusDTO busDTO, int variant) {

        List<RecordVariantDTO> busStops;
        if (variant == 1) {
            busStops = busDTO.getBusStopsV1();
        } else {
            busStops = busDTO.getBusStopsV2();
        }

        int findInitialStopIndex = -1;
        int findFinalStopIndex = -1;

        for (int z = 0; z < busStops.size(); z++) {

            String busStop = busStops.get(z).getNameOfBusStop();
            if (busStop.equals(initialBusStop)) {
                findInitialStopIndex = z;
            }
            if (busStop.equals(finalBusStop)) {
                findFinalStopIndex = z;
            }
        }

        if (findInitialStopIndex < findFinalStopIndex && findInitialStopIndex > -1) {

            ProposedBusDTO proposedBus = new ProposedBusDTO();
            proposedBus.setId(id);
            proposedBus.setBus(busDTO);
            proposedBus.setBusStopIndex(findInitialStopIndex);
            proposedBus.setVairiant(variant);
            proposedBusArr.add(proposedBus);

        }
    }

    public static List<ProposedBusDTO> getProposedBusArr() {
        return proposedBusArr;
    }


}


