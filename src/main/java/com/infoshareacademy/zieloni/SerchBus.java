package com.infoshareacademy.zieloni;


import com.infoshareacademy.zieloni.Model.Bus;

import java.util.ArrayList;

public class SerchBus{
    public static String busNumber1(String streetBus){
        String number1= new String(String.valueOf(busNumber1(streetBus)));
        ArrayList<Bus> busDB = new ArrayList<Bus>();
       // ArrayList<Bus> busDB1 = new ArrayList<Bus>();

        int i=0;
        for (i = 0; i <= busDB.size(); i++) {


            //System.out.println("Autobus o numerze " + busDB.get(i).getBusNumber());

            //System.out.println("Zatrzymuje sie na ulicach"+  street);
            int k = 0;
            try {
                for (k = 0; k <= busDB.get(i).getBusStopVariant1().size(); k++) {
                    String busStop = (busDB.get(i).getBusStopVariant1().get(k).getNameOfBasStop());
                    // String busStop = (busDB.get(k).getBusStopVariant1().get(i).getNameOfBasStop());
                    if (busStop.equalsIgnoreCase(streetBus)) {
                        //System.out.println("    " + busDB.get(i).getBusStopVariant1().get(k).getNameOfBasStop());
                        number1 = busDB.get(i).getBusNumber();
                        k = 0;
                        break;
                    }
                }
            }
            catch (IndexOutOfBoundsException e){
                // System.out.println(" numer i ="+i+", numer k = "+k);
                //System.out.println(k + "    " + busDB.get(i).getBusStopVariant1().get(k).getNameOfBasStop());

            }
        }





        return number1;
    }
}

