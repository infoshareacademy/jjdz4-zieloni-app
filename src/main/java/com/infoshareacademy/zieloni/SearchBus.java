package com.infoshareacademy.zieloni;

import com.infoshareacademy.zieloni.DataBase.BusDataBase;
import com.infoshareacademy.zieloni.Model.BusDTO;
import com.infoshareacademy.zieloni.Model.PathToCsvDTO;
import com.infoshareacademy.zieloni.Model.VariantCsvDTO;

import java.io.File;
import java.nio.charset.Charset;
import java.util.ArrayList;


public class SearchBus {

    public static void search(String startBusStop, String finalBusStop) {

        ArrayList<BusDTO> busDB = BusDataBase.getDataBase();

        for (int i = 0; i < busDB.size(); i++) {
            for (int k = 0; k < busDB.get(i).getBusStopVariant1().size(); k++) {
                //  System.out.println(k + "    " + busDB.get(i).getBusStopVariant1().get(k).getNameOfBasStop());
                //  System.out.println(busDB.get(i).getBusStopVariant1().get(k).getNameOfBasStop());
                String busStop = busDB.get(i).getBusStopVariant1().get(k).getNameOfBasStop();
                String idbusStop = busDB.get(i).getBusStopVariant1().get(k).getIdVariant();
                if (busStop.equals(startBusStop)) {
                    System.out.println(idbusStop + " Na ulicy " + busStop + " zatrzymuje sie autobus nr: " + busDB.get(i).getBusNumber() + " tam");
                }
                if (busStop.equals(finalBusStop)) {
                    System.out.println(idbusStop + " Na ulicy " + busStop + " zatrzymuje sie autobus nr: " + busDB.get(i).getBusNumber() + " tam");
                }
            }

            for (int z = 0; z < busDB.get(i).getBusStopVariant2().size(); z++) {
                //  System.out.println(k + "    " + busDB.get(i).getBusStopVariant1().get(k).getNameOfBasStop());
                if (busDB.get(i).getBusStopVariant2().get(z).getNameOfBasStop().equals(startBusStop)) {
                    System.out.println("Na ulicy " + busDB.get(i).getBusStopVariant2().get(z).getNameOfBasStop() + " zatrzymuje sie autobus nr: " + busDB.get(i).getBusNumber() + " z powrotem");
                }
            }
        }
    }
}
