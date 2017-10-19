package com.infoshareacademy.zieloni;

import com.infoshareacademy.zieloni.Model.*;

import java.io.File;
import java.util.ArrayList;

public class App {

    public static void main(String[] args) {

        /* MStasiński: bieżący katalog roboczy uzyskujemy  przez System.getProperty("user.dir");*/
        final String currentDirectory = System.getProperty("user.dir");

        final File folder = new File(currentDirectory + "//rozklady_2015-09-08_13.43.01");
        final File tabelaCSVPath = new File(currentDirectory + "//rozklady_2015-09-08_13.43.01//tabela.csv");
        System.out.println("current dir4 = " + currentDirectory);

        // towrzenie bazy danych z wszystkimi autobusami
        ArrayList<Bus> busDB = new ArrayList<Bus>();
        ArrayList<Bus> busDB1 = new ArrayList<Bus>();

        /* M.Stasiński: ArrayList ze wszystkimi scieżkami do katalogów i znajdujących się w nim plików z rozkładami jazdy */
        ArrayList<PathToTimeTableCSVfile> filePath = FilesLoader.addAllFilesPathToArrayList(folder);


        for (PathToTimeTableCSVfile file : filePath) {

            if (file.getIsValidFrom() < 20150908) {

                //  System.out.println("---------------------------------------------------------------------------------------------");
               /* System.out.println("ID :                                      " + file.getId());
                System.out.println("Rozkład obowiązuje od :                   " + file.getIsValidFrom());
                System.out.println("Nazwa folderu :                           " + file.getFolderName());
                System.out.println("plik zakonczone na  kursy1.csv:           " + file.getCourse1());
                System.out.println("plik zakonczone na  kursy2.csv:           " + file.getCourse2());
                System.out.println("plik zakonczone na  opis1.csv:            " + file.getDescription1());
                System.out.println("plik zakonczone na  opis2.csv:            " + file.getDescription2());*/

                ArrayList<String> variant1RecordArray = CSVReader.readCSVfileAndConvertToRecordsArray(file.getVariant1());
                ArrayList<VariantCsvModel> variant1 = CSVFileFormater.formatCSVBus(variant1RecordArray);
                ArrayList<String> variant2RecordArray = CSVReader.readCSVfileAndConvertToRecordsArray(file.getVariant2());
                ArrayList<VariantCsvModel> variant2 = CSVFileFormater.formatCSVBus(variant2RecordArray);

                Bus bus = new Bus();
                Bus bus1 = new Bus();

                //TODO dodać variant 2
                bus.setBusStopVariant1(variant1);
                bus.setBusNumber(file.getId().split("_")[0]);
                busDB.add(bus);
                bus1.setBusStopVariant2(variant2);
                bus1.setBusNumber(file.getId().split("_")[0]);
                busDB1.add(bus1);

            }

        }

        /*TODO
        1) stworzyć klase np SearchBus do wyszukania autobusów ktore zatrzymuja sie na danych przystankach
        2)  metoda klasy otrzymuje (przystanek poczatkowy , przytanek koncowy)  zwraca array autobusów zawierajacych te ulice
        */
        System.out.println("Z jakiej ulicy jest odjazd" );
        ImputStreet input= new ImputStreet();
        String street=input.getOdczyt();
        //System.out.println( input.getOdczyt().toString());




        System.out.println("Na ulicy "+ street+" możesz odjechać  w tę " );

        int i=0;
        for (i = 0; i <= busDB.size(); i++) {


            //System.out.println("Autobus o numerze " + busDB.get(i).getBusNumber());

            //System.out.println("Zatrzymuje sie na ulicach"+  street);
            int k = 0;
            try{
            for (k = 0; k <= busDB.get(i).getBusStopVariant1().size(); k++) {
                String busStop = (busDB.get(i).getBusStopVariant1().get(k).getNameOfBasStop());
                // String busStop = (busDB.get(k).getBusStopVariant1().get(i).getNameOfBasStop());
                if (busStop.equalsIgnoreCase(street)) {
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


        System.out.println("Na ulicy "+ street+" możesz odjechać  w " );

        int j=0;
        for (j = 0; j <= busDB1.size(); j++) {


            //System.out.println("Autobus o numerze " + busDB.get(i).getBusNumber());

            //System.out.println("Zatrzymuje sie na ulicach"+  street);
            int k = 0;
            try{
                for (k = 0; k <= busDB1.get(j).getBusStopVariant2().size(); k++) {
                    String busStop2 = (busDB1.get(j).getBusStopVariant2().get(k).getNameOfBasStop());
                    // String busStop = (busDB.get(k).getBusStopVariant1().get(i).getNameOfBasStop());
                    if (busStop2.equalsIgnoreCase(street)) {
                        //System.out.println("    " + busDB.get(i).getBusStopVariant1().get(k).getNameOfBasStop());
                        System.out.println("Autobus o numerze " + busDB1.get(j).getBusNumber());
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
/*
        for (int i = 0; i < busDB.size(); i++) {
            System.out.println("Autobus o numerze w te     " + busDB.get(i).getBusNumber());
            System.out.println("Zatrzymuje sie na ulicach_******************************************");
            for (int k = 0; k < busDB.get(i).getBusStopVariant2().size(); k++) {
                System.out.println(k + "    " + busDB.get(i).getBusStopVariant2().get(k).getNameOfBasStop());
            }
            System.out.println("********************************************************************");
        }*/


        /*pobranie pliku tabela.csv*/
        File csvFile = new File(tabelaCSVPath.toString());

        /*Wrzucenie poszczególnych linii tablei.csv do Array*/
        ArrayList<String> recordsArray = CSVReader.readCSVfileAndConvertToRecordsArray(tabelaCSVPath.toString());
        ArrayList<TimeTableRecordWithExtraInfo> tabelaCSVArray = CSVFileFormater.formatCSVToTimeTableWithExtraInfoRecords(recordsArray);

        /*System.out.println(tabelaCSVArray.get(0).getId());
        System.out.println(tabelaCSVArray.get(0).getLineNr());
        System.out.println(tabelaCSVArray.get(0).getTypeOfTransport());
        System.out.println(tabelaCSVArray.get(0).getIsValidFrom());
        System.out.println(tabelaCSVArray.get(0).isLowRider());*/


    }
}