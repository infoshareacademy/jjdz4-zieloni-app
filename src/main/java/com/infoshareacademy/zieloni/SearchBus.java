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
            int variantX0_XX = 0;
            if (info.equals("dla wariantu 1")) {
                for (int i = 0; i < busDTO.getCourseVariant1().size(); i++) {
                    int minutes = 0;
                    try {
                        /* zmienna mówi o tym z którekgo wariantu X0,X1-XX pobierać minuty */
                        variantX0_XX = Integer.valueOf(busDTO.getCourseVariant1().get(i).getTimeBetweenStops_X0_XX().split("X")[1]);
                        //System.out.println( variantX0_XX );
                    } catch (Exception e) {
                        System.out.println(busDTO.getCourseVariant1().get(i).getTimeBetweenStops_X0_XX());
                        //  variantX0_XX = 0;
                    }

                    /* pętla - dodawaj minuty aż nie dojdzie do  przystanku startowego  find_startBusStop_index*/
                    for (int j = 0; j < find_startBusStop_index; j++) {

                        //System.out.println(busStopVariant.get(busStopV).getTimes_X0_XX().get(vart).size());
                        try {
                            /* jesli w bazie nie ma minuty a jest puste pole to dodaje  defaultowo 1 minut*/
                            if (busStopVariant.get(busStopV).getTimes_X0_XX().get(variantX0_XX).get(j).equals("")) {
                                minutes += 1;
                            } else {
                                minutes += Integer.valueOf(busStopVariant.get(busStopV).getTimes_X0_XX().get(variantX0_XX).get(j));
                            }
                        } catch (Exception e) {
                            //System.out.println("Wystąpił  problem z sumowaniem czasu przejazdu");
                        }

                    }
                        if(!busDTO.getCourseVariant1().get(i).getDepartureTime().equals("99"))
                        System.out.println(busDTO.getCourseVariant1().get(i).getDepartureTime() + " + " + minutes + " minut ");

                    //System.out.println("który wariant"+ busDTO.getCourseVariant1().get(i).getTimeBetweenStops_X0_XX());
                    // System.out.println(minutes);
                    // System.out.println(busStopVariant.get(busStopV).getTimes_X0_XX().get(1));
                    //TODO po odznaczeniu linii pozniżej pokaze czasu

                }
            }

            if (info.equals("dla wariantu 2")) {
                for (int i = 0; i < busDTO.getCourseVariant2().size(); i++) {
                    //System.out.println(busDTO.getCourseVariant2().get(i).getDepartureTime() + " " + busDTO.getCourseVariant2().get(i).getTimeBetweenStops_X0_XX());
                }
            }
            //TODO zrobić formater czasu np 27:51 zamienić na 03:51 a 26:80  na 03:20
        }

    }

}
