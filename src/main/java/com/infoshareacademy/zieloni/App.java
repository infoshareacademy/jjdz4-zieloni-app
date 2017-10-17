package com.infoshareacademy.zieloni;

import com.infoshareacademy.zieloni.Model.Bus;
import com.infoshareacademy.zieloni.Model.PathToCSVModel;
import com.infoshareacademy.zieloni.Model.InfoFromTabelaCsv;
import com.infoshareacademy.zieloni.Model.VariantCsvModel;

import java.io.File;
import java.util.ArrayList;

public class App {

    public static void main(String[] args) {

        /* MStasiński: bieżący katalog roboczy uzyskujemy  przez System.getProperty("user.dir");*/
        final String currentDirectory = System.getProperty("user.dir");

        final File folder = new File(currentDirectory + "//rozklady_2015-09-08_13.43.01");
        final File tabelaCSVPath = new File(currentDirectory + "//rozklady_2015-09-08_13.43.01//tabela.csv");
        System.out.println("current dir = " + currentDirectory);

        // towrzenie bazy danych z wszystkimi autobusami
        ArrayList<Bus> busDB = new ArrayList<Bus>();


        /* M.Stasiński: ArrayList ze wszystkimi scieżkami do katalogów i znajdujących się w nim plików z rozkładami jazdy */
        ArrayList<PathToCSVModel> filePath = FilesPathReader.addAllFilesPathToArrayList(folder);

        for (PathToCSVModel file : filePath) {

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

                //TODO dodać variant 2
                bus.setBusStopVariant1(variant1);
                bus.setBusStopVariant2(variant2);
                bus.setBusNumber(file.getId().split("_")[0]);
                busDB.add(bus);
            }

        }

        /*TODO
        1) stworzyć klase np SearchBus do wyszukania autobusów ktore zatrzymuja sie na danych przystankach
        2)  metoda klasy otrzymuje (przystanek poczatkowy , przytanek koncowy)  zwraca array autobusów zawierajacych te ulice
        */



        for (int i = 0; i < busDB.size(); i++) {
          //  System.out.println("Autobus o numerze " + busDB.get(i).getBusNumber());
           // System.out.println("Zatrzymuje sie na ulicach_____________________________________");
            for (int k = 0; k < busDB.get(i).getBusStopVariant1().size(); k++) {
              //  System.out.println(k + "    " + busDB.get(i).getBusStopVariant1().get(k).getNameOfBasStop());
                if(busDB.get(i).getBusStopVariant1().get(k).getNameOfBasStop().equals("Ptasia")){
                    System.out.println("Na ulicy "+busDB.get(i).getBusStopVariant1().get(k).getNameOfBasStop()+" zatrzymuje sie autobus nr: " + busDB.get(i).getBusNumber());
                }
            }
            for (int z = 0; z < busDB.get(i).getBusStopVariant2().size(); z++) {
                //  System.out.println(k + "    " + busDB.get(i).getBusStopVariant1().get(k).getNameOfBasStop());
                if(busDB.get(i).getBusStopVariant2().get(z).getNameOfBasStop().equals("Ptasia")){
                    System.out.println("Na ulicy "+busDB.get(i).getBusStopVariant2().get(z).getNameOfBasStop()+" zatrzymuje sie autobus nr: " + busDB.get(i).getBusNumber());
                }
            }
        }




        /*pobranie pliku tabela.csv*/
        File csvFile = new File(tabelaCSVPath.toString());

        /*Wrzucenie poszczególnych linii tablei.csv do Array*/
        ArrayList<String> recordsArray = CSVReader.readCSVfileAndConvertToRecordsArray(tabelaCSVPath.toString());
        ArrayList<InfoFromTabelaCsv> tabelaCSVArray = CSVFileFormater.formatCSVToTimeTableWithExtraInfoRecords(recordsArray);

        /*System.out.println(tabelaCSVArray.get(0).getId());
        System.out.println(tabelaCSVArray.get(0).getLineNr());
        System.out.println(tabelaCSVArray.get(0).getTypeOfTransport());
        System.out.println(tabelaCSVArray.get(0).getIsValidFrom());
        System.out.println(tabelaCSVArray.get(0).isLowRider());*/


    }
}
