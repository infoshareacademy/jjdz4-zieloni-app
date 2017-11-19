package com.infoshareacademy.zieloni.Controller;

import com.infoshareacademy.zieloni.DataBase.BusDataBase;
import com.infoshareacademy.zieloni.Model.BusDTO;
import com.infoshareacademy.zieloni.Model.ChangeConnectionDTO;
import com.infoshareacademy.zieloni.Model.ProposedBusDTO;
import com.infoshareacademy.zieloni.Model.RecordVariantDTO;

import java.util.ArrayList;


public class FindBusChangesController {
    private static String start_BusStop;
    private static String end_BusStop;

    /* Lista z wszystkimi autobusami które zawierają przystanek początkowy*/
    private static ArrayList<ProposedBusDTO> startBusArray = new ArrayList<>();

    /* Lista z wszystkimi autobusami które zawierają przystanek końcowy */
    private static ArrayList<ProposedBusDTO> endBusArray = new ArrayList<>();

    /*Lista wszystkich mozliwych przesiadek  miedzy startBusStop a endBusStop*/
    private static ArrayList<ChangeConnectionDTO> changeConnectionArray = new ArrayList<>();


    /**
     * @param startBusStop - przystanek początkowy
     * @param endBusStop   - przystanek końcowy
     */
    public static void search(String startBusStop, String endBusStop) {

        end_BusStop = endBusStop;
        start_BusStop = startBusStop;

        /* baza wszystkich autobusów*/
        ArrayList<BusDTO> busDB = BusDataBase.DB;

        for (int i = 0; i < busDB.size(); i++) {
            checkBusForVariant(i, busDB.get(i), start_BusStop, startBusArray, 1);
            checkBusForVariant(i, busDB.get(i), start_BusStop, startBusArray, 2);
            checkBusForVariant(i, busDB.get(i), end_BusStop, endBusArray, 1);
            checkBusForVariant(i, busDB.get(i), end_BusStop, endBusArray, 2);
        }

         /*wszystkie autobusy kótre w swoim rozkładzie zawieraja startBusStop*/
        ArrayList<ProposedBusDTO> busArr_start = startBusArray;

        /*wszystkie autobusy kótre w swoim rozkładzie zawieraja endBusStop*/
        ArrayList<ProposedBusDTO> busArr_end = endBusArray;


        for (int i = 0; i < busArr_start.size(); i++) {

            for (int j = 0; j < busArr_end.size(); j++) {

                connectionBusStop(busArr_start.get(i), busArr_end.get(j));
            }
        }
    }

    /*szukamy wszystkich autobusów które posiadaja przystanek taki jaki został podany w parametrze   itContainBusStop  */
    private static void checkBusForVariant(int id,
                                           BusDTO busDTO,
                                           String itContainBusStop,
                                           ArrayList<ProposedBusDTO> busArray,
                                           int variant) {

        ArrayList<RecordVariantDTO> busStops;

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


    /* porównujemy liste z autobusami zawierjącymi przystanek początkowy  z autobusami zawierającymi przystane koncowy i sprawdzamy czy maja przystanki wspólne*/
    private static void connectionBusStop(ProposedBusDTO b0, ProposedBusDTO b1) {


        if (!b0.getBus().getBusNumber().toString().equals(b1.getBus().getBusNumber().toString())) {

            int variant = b0.getVairiant();
            ArrayList<RecordVariantDTO> listBusStop;
            if (b0.getVairiant() == 1) {
                listBusStop = b0.getBus().getBusStops_v1();
            } else {
                listBusStop = b0.getBus().getBusStops_v2();
            }

            for (int i = b0.getBusStopIndex(); i < listBusStop.size(); i++) {
                int variant1 = b1.getVairiant();
                ArrayList<RecordVariantDTO> listBusStop1;
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
                        changeConnectionArray.add(change);

                    }
                }
            }
        }
    }

    public static ArrayList<ChangeConnectionDTO> getChangeConnectionArray() {
        return changeConnectionArray;
    }

    public static void setChangeConnectionArray(ArrayList<ChangeConnectionDTO> changeConnectionArray) {
        FindBusChangesController.changeConnectionArray = changeConnectionArray;
    }
}
