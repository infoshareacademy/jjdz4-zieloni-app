package com.infoshareacademy.zieloni;

import com.infoshareacademy.zieloni.DataBase.BusDataBase;
import com.infoshareacademy.zieloni.Model.BusDTO;
import com.infoshareacademy.zieloni.Model.VariantCsvDTO;

import java.util.ArrayList;


public class SearchBus {

    public void search(String start_BusStop, String end_BusStop) {

        ArrayList<BusDTO> busDB = BusDataBase.getDataBase();

        for (int i = 0; i < busDB.size(); i++) {
            checkBusForVaraint(busDB.get(i), busDB.get(i).getBusStopVariant1(), start_BusStop, end_BusStop, "dla wariantu 1");
            checkBusForVaraint(busDB.get(i), busDB.get(i).getBusStopVariant2(), start_BusStop, end_BusStop, "dla wariantu 2");
        }
    }

    private void checkBusForVaraint(BusDTO busDTO, ArrayList<VariantCsvDTO> busStopVariant, String start_bs, String end_bs, String info) {

        int find_startBusStop_index = -1;
        int find_endBusStop_index = -1;

        for (int z = 0; z < busStopVariant.size(); z++) {
            //  System.out.println(k + "    " + busDB.get(i).getBusStopVariant1().get(k).getNameOfBasStop());

            String busStop = busStopVariant.get(z).getNameOfBasStop();
            String idBusStop = busStopVariant.get(z).getIdVariant();

            if (busStop.equals(start_bs)) {
                find_startBusStop_index = z;
                // System.out.println(idBusStop + " Na ulicy " + busStop + " zatrzymuje sie autobus nr: " + busDB.get(i).getBusNumber() );
            }

            if (busStop.equals(end_bs)) {
                find_endBusStop_index = z;
                //System.out.println(idBusStop + " Na ulicy " + busStop + " zatrzymuje sie autobus nr: " + busDB.get(i).getBusNumber() );
            }
        }

        if (find_startBusStop_index < find_endBusStop_index && find_startBusStop_index > -1) {

            System.out.println("zobacz autobus nr : " + busDTO.getBusNumber() + "    " + info);
        }

    }

}
