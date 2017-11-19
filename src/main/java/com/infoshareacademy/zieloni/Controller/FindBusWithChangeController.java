package com.infoshareacademy.zieloni.Controller;

import com.infoshareacademy.zieloni.DataBase.BusDataBase;
import com.infoshareacademy.zieloni.Model.BusDTO;
import com.infoshareacademy.zieloni.Model.ChangeConnectionDTO;
import com.infoshareacademy.zieloni.Model.ProposedBusDTO;
import com.infoshareacademy.zieloni.Model.RecordVariantDTO;

import java.util.ArrayList;

public class FindBusWithChangeController {
    private static String initialBusStop;
    private static String finalBusStop;

    /* Lista z wszystkimi autobusami które zawierają przystanek początkowy*/
    private static ArrayList<ProposedBusDTO> busesContainInitialStop = new ArrayList<>();

    /* Lista z wszystkimi autobusami które zawierają przystanek końcowy */
    private static ArrayList<ProposedBusDTO> busesContainFinalStop = new ArrayList<>();

    /*Lista wszystkich mozliwych przesiadek  dla initialStop i inalStop*/
    private static ArrayList<ChangeConnectionDTO> changeConnectionArray = new ArrayList<>();


    /**
     * @param initialStop - przystanek początkowy
     * @param finalStop   - przystanek końcowy
     */
    public static void search(String initialStop, String finalStop) {

        finalBusStop = finalStop;
        initialBusStop = initialStop;

        /* baza wszystkich autobusów*/
        ArrayList<BusDTO> busDB = BusDataBase.DB;

        /* szukam odpowiednich busów i rozdzialam  do odpowiednich Array uwzględniajac ich wariant*/
        for (int i = 0; i < busDB.size(); i++) {
            checkBusForVariant(i, busDB.get(i), initialBusStop, busesContainInitialStop, 1);
            checkBusForVariant(i, busDB.get(i), initialBusStop, busesContainInitialStop, 2);
            checkBusForVariant(i, busDB.get(i), finalBusStop, busesContainFinalStop, 1);
            checkBusForVariant(i, busDB.get(i), finalBusStop, busesContainFinalStop, 2);
        }

        for (int i = 0; i < busesContainInitialStop.size(); i++) {

            for (int j = 0; j < busesContainFinalStop.size(); j++) {

                connectionBusStop(busesContainInitialStop.get(i), busesContainFinalStop.get(j));
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
    private static void connectionBusStop(ProposedBusDTO bus_containInitStop, ProposedBusDTO bus_containFinalStop) {

        /* sprawdzam czy autobus zawierajacy przystanek poczatkowy
        i autobus zawierajacy przystankek koncowy to przypadkiem nie ten sam autobus*/

        if (!bus_containInitStop.getBus().getBusNumber().toString().equals(bus_containFinalStop.getBus().getBusNumber().toString())) {

            /*spawdzam jaki jest wariant proponowanego autobusu*/
            int variant = bus_containInitStop.getVairiant();

            /* pobieram liste przystanków z odpowiedniego wariantu dla autobusu bus_containInitStop*/
            ArrayList<RecordVariantDTO> listBusStop;
            if (bus_containInitStop.getVairiant() == 1) {
                listBusStop = bus_containInitStop.getBus().getBusStops_v1();
            } else {
                listBusStop = bus_containInitStop.getBus().getBusStops_v2();
            }

            for (int i = bus_containInitStop.getBusStopIndex(); i < listBusStop.size(); i++) {
                /*spawdzam wariant dla autobusu bus_containFinalStop*/
                int variant1 = bus_containFinalStop.getVairiant();

                ArrayList<RecordVariantDTO> listBusStop1;
                if (bus_containFinalStop.getVairiant() == 1) {
                    listBusStop1 = bus_containFinalStop.getBus().getBusStops_v1();
                } else {
                    listBusStop1 = bus_containFinalStop.getBus().getBusStops_v2();
                }

                for (int j = 0; j < bus_containFinalStop.getBusStopIndex(); j++) {
                    /*jeśli przystanek znajduje sie zarówno na trasie jednego i drugiego autobusu to mamy przesiadkę*/
                    if (listBusStop.get(i).getNameOfBusStop().equals(listBusStop1.get(j).getNameOfBusStop())) {

                        /*Tworzymy obiekt z informacjami o połaczeniu z przesiadkami*/
                        ChangeConnectionDTO change = new ChangeConnectionDTO();
                        change.setBus0(bus_containInitStop.getBus());
                        change.setBus1(bus_containFinalStop.getBus());
                        change.setConnectionBusStop(listBusStop.get(i).getNameOfBusStop());
                        change.setVairiant0(variant);
                        change.setVairiant1(variant1);

                        /*dodajemy go do tablicy wszystkich proponowanych przesiadek*/
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
        FindBusWithChangeController.changeConnectionArray = changeConnectionArray;
    }
}
