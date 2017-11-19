package com.infoshareacademy.zieloni.controller;

import com.infoshareacademy.zieloni.database.BusDataBase;
import com.infoshareacademy.zieloni.model.BusDTO;
import com.infoshareacademy.zieloni.model.ChangeConnectionDTO;
import com.infoshareacademy.zieloni.model.ProposedBusDTO;
import com.infoshareacademy.zieloni.model.RecordVariantDTO;

import java.util.ArrayList;
import java.util.List;

public class FindBusWithChangeController {


    private static List<ProposedBusDTO> busesContainInitialStop = new ArrayList<>();
    private static List<ProposedBusDTO> busesContainFinalStop = new ArrayList<>();
    private static List<ChangeConnectionDTO> changeConnectionArray = new ArrayList<>();

    private FindBusWithChangeController() {
    }

    public static void search(String initialStop, String finalStop) {
        String initialBusStop = initialStop;
        String finalBusStop = finalStop;

        List<BusDTO> busDB = BusDataBase.getBusDataBase();

        for (int i = 0; i < busDB.size(); i++) {
            checkBusForVariant(i, busDB.get(i), initialBusStop, busesContainInitialStop, 1);
            checkBusForVariant(i, busDB.get(i), initialBusStop, busesContainInitialStop, 2);
            checkBusForVariant(i, busDB.get(i), finalBusStop, busesContainFinalStop, 1);
            checkBusForVariant(i, busDB.get(i), finalBusStop, busesContainFinalStop, 2);
        }

        for (int i = 0; i < busesContainInitialStop.size(); i++) {

            for (int j = 0; j < busesContainFinalStop.size(); j++) {

                connectionStop(busesContainInitialStop.get(i), busesContainFinalStop.get(j));
            }
        }
    }

    private static void checkBusForVariant(int id,
                                           BusDTO busDTO,
                                           String itContainBusStop,
                                           List<ProposedBusDTO> busArray,
                                           int variant) {

        List<RecordVariantDTO> busStops;

        if (variant == 1) {
            busStops = busDTO.getBusStops_v1();
        } else {
            busStops = busDTO.getBusStops_v2();
        }

        int index = -1;

        for (int z = 0; z < busStops.size(); z++) {
            String busStop = busStops.get(z).getNameOfBusStop();
            if (busStop.equals(itContainBusStop)) {
                index = z;
            }
        }

        if (index > 0) {
            ProposedBusDTO proposedBus = new ProposedBusDTO();
            proposedBus.setId(id);
            proposedBus.setBus(busDTO);
            proposedBus.setBusStopIndex(index);
            proposedBus.setVairiant(variant);
            busArray.add(proposedBus);
        }
    }

    private static void connectionStop(ProposedBusDTO busContainInitStop, ProposedBusDTO busContainFinalStop) {

        if (!busContainInitStop.getBus().getBusNumber().equals(busContainFinalStop.getBus().getBusNumber())) {

            int variant = busContainInitStop.getVairiant();

            List<RecordVariantDTO> listBusStop;
            if (busContainInitStop.getVairiant() == 1) {
                listBusStop = busContainInitStop.getBus().getBusStops_v1();
            } else {
                listBusStop = busContainInitStop.getBus().getBusStops_v2();
            }

            for (int i = busContainInitStop.getBusStopIndex(); i < listBusStop.size(); i++) {
                int variant1 = busContainFinalStop.getVairiant();

                List<RecordVariantDTO> listBusStop1;
                if (busContainFinalStop.getVairiant() == 1) {
                    listBusStop1 = busContainFinalStop.getBus().getBusStops_v1();
                } else {
                    listBusStop1 = busContainFinalStop.getBus().getBusStops_v2();
                }

                for (int j = 0; j < busContainFinalStop.getBusStopIndex(); j++) {
                    if (listBusStop.get(i).getNameOfBusStop().equals(listBusStop1.get(j).getNameOfBusStop())) {

                        ChangeConnectionDTO change = new ChangeConnectionDTO();
                        change.setBus0(busContainInitStop.getBus());
                        change.setBus1(busContainFinalStop.getBus());
                        change.setConnectionBusStop(listBusStop.get(i).getNameOfBusStop());
                        change.setVairiant0(variant);
                        change.setVairiant1(variant1);

                        changeConnectionArray.add(change);
                    }
                }
            }
        }
    }

    public static List<ChangeConnectionDTO> getChangeConnectionArray() {
        return changeConnectionArray;
    }

}
