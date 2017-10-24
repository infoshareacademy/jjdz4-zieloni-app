package com.infoshareacademy.zieloni;

import com.infoshareacademy.zieloni.DataBase.BusDataBase;
import com.infoshareacademy.zieloni.Model.BusDTO;
import com.infoshareacademy.zieloni.Model.VariantCsvDTO;

import java.util.ArrayList;


public class SearchBus {

    public static void search(String start_BusStop, String end_BusStop) {

        ArrayList<BusDTO> busDB = BusDataBase.getDataBase();

        for (int i = 0; i < busDB.size(); i++) {

            checkBusForVaraint(busDB.get(i), busDB.get(i).getBusStopVariant1(), start_BusStop, end_BusStop, "dla wariantu 1");
            checkBusForVaraint(busDB.get(i), busDB.get(i).getBusStopVariant2(), start_BusStop, end_BusStop, "dla wariantu 2");
        }
    }




    private static void checkBusForVaraint(BusDTO busDTO, ArrayList<VariantCsvDTO> busStopVariant, String start_bs, String end_bs, String info) {

        int find_startBusStop_index = -1;
        int find_endBusStop_index = -1;


        for (int z = 0; z < busStopVariant.size(); z++) {

            String busStop = busStopVariant.get(z).getNameOfBasStop();

           // System.out.println(busStopVariant.get(z).getTimes_X0_XX());


            if (busStop.equals(start_bs)) {
                find_startBusStop_index = z;
            }
            if (busStop.equals(end_bs)) {
                find_endBusStop_index = z;
            }
        }

        if (find_startBusStop_index < find_endBusStop_index && find_startBusStop_index > -1) {


            System.out.println("zobacz autobus nr : " + busDTO.getBusNumber() + "    " + info);
            //if(info.equals(dla wariantu 1))
        }

    }

}
