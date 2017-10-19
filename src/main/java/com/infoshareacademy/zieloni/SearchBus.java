package com.infoshareacademy.zieloni;

import com.infoshareacademy.zieloni.Model.BusDTO;
import com.infoshareacademy.zieloni.Model.PathToCsvDTO;
import com.infoshareacademy.zieloni.Model.VariantCsvDTO;

import java.io.File;
import java.nio.charset.Charset;
import java.util.ArrayList;


public class SearchBus {

    public static void search(String startBusStop, String finalBusStop) {

        System.out.println(startBusStop);
        /* bieżący katalog roboczy uzyskujemy  przez System.getProperty("user.dir");*/
        final String currentDirectory = System.getProperty("user.dir");

        final File folder = new File(currentDirectory + "//src//main//resource//rozklady_2015-09-08_13.43.01");
        //System.out.println("current dir = " + folder);

        // towrzenie bazy danych z wszystkimi autobusami
        ArrayList<BusDTO> busDB = new ArrayList<BusDTO>();

        /* M.Stasiński: ArrayList ze wszystkimi scieżkami do katalogów i znajdujących się w nim plików z rozkładami jazdy */
        ArrayList<PathToCsvDTO> filePath = FilesPathFinder.addAllFilesPathToArrayList(folder);

        for (PathToCsvDTO file : filePath) {

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
                ArrayList<VariantCsvDTO> variant1 = CSVFileParser.formatCSVBus(variant1RecordArray);

                ArrayList<String> variant2RecordArray = CSVReader.readCSVfileAndConvertToRecordsArray(file.getVariant2());
                ArrayList<VariantCsvDTO> variant2 = CSVFileParser.formatCSVBus(variant2RecordArray);

                BusDTO bus = new BusDTO();

                bus.setBusStopVariant1(variant1);
                bus.setBusStopVariant2(variant2);
                bus.setBusNumber(file.getId().split("_")[0]);
                busDB.add(bus);
            }
        }


        for (int i = 0; i < busDB.size(); i++) {
            //  System.out.println("Autobus o numerze " + busDB.get(i).getBusNumber());
            // System.out.println("Zatrzymuje sie na ulicach_____________________________________");
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
