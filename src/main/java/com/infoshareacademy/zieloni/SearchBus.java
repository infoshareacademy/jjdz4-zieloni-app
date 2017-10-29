package com.infoshareacademy.zieloni;

import com.infoshareacademy.zieloni.DataBase.BusDataBase;
import com.infoshareacademy.zieloni.Model.BusDTO;
import com.infoshareacademy.zieloni.Model.RecordVariantCsvDTO;

import java.util.ArrayList;


public class SearchBus {

    public static void search(String start_BusStop, String end_BusStop) {

        ArrayList<BusDTO> busDB = BusDataBase.getDataBase();

        for (int i = 0; i < busDB.size(); i++) {

            checkBusForVaraint(busDB.get(i), busDB.get(i).getBusStopVariant1(), start_BusStop, end_BusStop, "dla wariantu 1");
            checkBusForVaraint(busDB.get(i), busDB.get(i).getBusStopVariant2(), start_BusStop, end_BusStop, "dla wariantu 2");
        }
    }

    private static void checkBusForVaraint(BusDTO busDTO, ArrayList<RecordVariantCsvDTO> busStopVariant, String start_bs, String end_bs, String info) {

        int find_startBusStop_index = -1;
        int find_endBusStop_index = -1;
        int busStopV = -1;

        for (int z = 0; z < busStopVariant.size(); z++) {

            String busStop = busStopVariant.get(z).getNameOfBasStop();
            busStopV = z;

            //System.out.println(busStopVariant.get(z).getTimes_X0_XX());
            if (busStop.equals(start_bs)) {
                find_startBusStop_index = z;
            }
            if (busStop.equals(end_bs)) {
                find_endBusStop_index = z;
            }
        }

        if (find_startBusStop_index < find_endBusStop_index && find_startBusStop_index > -1) {


            System.out.println("zobacz autobus nr : " + busDTO.getBusNumber() + "    " + info);
            String symbol_X0_XX = null;

            if (info.equals("dla wariantu 1")) {
                for (int i = 0; i < busDTO.getCourseVariant1().size(); i++) {
                    int minutes = 0;


                    for (int j = 0; j < find_startBusStop_index; j++) {

                        try {
                            minutes += Integer.valueOf(busStopVariant.get(0).getMapTimes_X0_XX().get(symbol_X0_XX).get(j));

                        } catch (Exception e) {
                            // System.out.println("Wystąpił  problem z sumowaniem czasu przejazdu");
                            minutes += 1;
                        }

                    }

                    try {
                        /* zmienna mówi o tym z którekgo wariantu X0,X1-XX pobierać minuty */
                        if (busDTO.getCourseVariant1().get(i).getVariantSymbol_X0_XX().split("X")[0].equals("")) {
                            symbol_X0_XX = busDTO.getCourseVariant1().get(i).getVariantSymbol_X0_XX();
                            //System.out.println(busDTO.getCourseVariant1().get(i).getDepartureTime()+" "+minutes+ " "+symbol_X0_XX+""+ busStopVariant.get(0).getMapTimes_X0_XX().get(symbol_X0_XX));
                        }
                        //  System.out.println(variantX0_XX);
                    } catch (Exception e) {
                        //System.out.println(busDTO.getCourseVariant1().get(i).getVariantSymbol_X0_XX());
                        //  variantX0_XX = 0;
                    }


                  /*  try {
                        System.out.println(busDTO.getCourseVariant1().get(i).getDepartureTime().equals("99"));
                        if(!busDTO.getCourseVariant1().get(i).getDepartureTime().equals("99")) {
                            System.out.println(busDTO.getCourseVariant1().get(i).getDepartureTime() + "   " + symbol_X0_XX + "" + busDTO.getBusStopVariant1().get(i).getMapTimes_X0_XX());
                        }
                        // System.out.println(busDTO.getCourseVariant1().get(i).getDepartureTime() + " " + minutes + "   " + symbol_X0_XX + "" + busDTO.getBusStopVariant1().get(i).getMapTimes_X0_XX().get(symbol_X0_XX));
                    } catch (Exception e) {
                        System.out.println("Wystąpił  problem z sumowaniem czasu przejazdu" +i);
                    }*/
                }
            }


        }
    }

}


