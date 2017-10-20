package com.infoshareacademy.zieloni;


import com.infoshareacademy.zieloni.Model.Bus;

import java.util.ArrayList;

public class SerchBus{

    public static  ArrayList<Bus>search(String nazwaUlicy) {
        ArrayList<Bus> nrbus = new ArrayList<Bus>();
 //nrbus=null;
        ArrayList<Bus> busDB = new ArrayList<Bus>();
        int i=0;
        for (i = 0; i <= busDB.size(); i++) {
            int k = 0;
            try{
                for (k = 0; k <= busDB.get(i).getBusStopVariant1().size(); k++) {
                    String busStop = (busDB.get(i).getBusStopVariant1().get(k).getNameOfBasStop());
                    // String busStop = (busDB.get(k).getBusStopVariant1().get(i).getNameOfBasStop());
                    if (busStop.equalsIgnoreCase(nazwaUlicy)) {
                        //System.out.println("    " + busDB.get(i).getBusStopVariant1().get(k).getNameOfBasStop());
                        System.out.println("Autobus o numerze " + busDB.get(i).getBusNumber());
                        k=0;
                        break;
                    }
                }
            } catch (IndexOutOfBoundsException e){
                // System.out.println(" numer i ="+i+", numer k = "+k);
                //System.out.println(k + "    " + busDB.get(i).getBusStopVariant1().get(k).getNameOfBasStop());

            }
            // System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
        }
        System.out.println("********************************************************************");
return nrbus;

    }


}

