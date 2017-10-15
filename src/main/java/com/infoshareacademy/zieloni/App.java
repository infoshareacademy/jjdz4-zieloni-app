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
// towrzenie bazy danych bus
        ArrayList<Bus> busDB = new ArrayList<>();




        /* M.Stasiński: ArrayList ze wszystkimi scieżkami do katalogów i znajdujących się w nim plików z rozkładami jazdy */
        ArrayList<PathToTimeTableCSVfile> filePath = FilesLoader.addAllFilesPathToArrayList(folder);
        int j = 0;

        for (PathToTimeTableCSVfile file : filePath) {

            if (file.getIsValidFrom() < 20150908) {

              //  System.out.println("---------------------------------------------------------------------------------------------");
/*                System.out.println("ID :                                      " + file.getId());
                System.out.println("Rozkład obowiązuje od :                   " + file.getIsValidFrom());
                System.out.println("Nazwa folderu :                           " + file.getFolderName());
                System.out.println("plik zakonczone na  kursy1.csv:           " + file.getCourse1());
                System.out.println("plik zakonczone na  kursy2.csv:           " + file.getCourse2());
                System.out.println("plik zakonczone na  opis1.csv:            " + file.getDescription1());
                System.out.println("plik zakonczone na  opis2.csv:            " + file.getDescription2());
  */              //TODO PRZECZYTAJ PLIK v1, v2 PARSER DLA PLIKÓW


                //ODCZTYAĆ WATIANT 1  I ZAMIENIĆ NA ARRAI LIST RCORD NIE SPARSOWNA
                //ODCZTYAĆ WATIANT 2  I ZAMIENIĆ NA ARRAI LIST RCORD NIE SPARSOWNA
                //System.out.println(file.getId());

                ArrayList<String> variant1RecordAr1 = CSVReader.readCSVfileAndConvertToRecordsArray(file.getVariant1());
                ArrayList<WariantCsvModel> tabelaCSVArray1 = CSVFileFormaterBus.formatCSVBus(variant1RecordAr1);
                //System.out.println(file.getId());
                Bus bus = new Bus();
                bus.setBusNumber(file.getId());
                bus.setBusStopVariant1(tabelaCSVArray1);
                busDB.add(bus);

                //ArrayList<String> recordsArray = CSVReader.readCSVfileAndConvertToRecordsArray(tabelaCSVPath.toString());
                //FORMATOWANIE  POPARSOWANE I POBRANIE ULICY

                //ArrayList<TimeTableRecordWithExtraInfo> tabelaCSVArray = CSVFileFormater.formatCSVToTimeTableWithExtraInfoRecords(recordsArray);

                //bus.setBusStopVariant1(tu sparsowanyv tabelaCsvArray1)->nazwy sparsowane
                //bus.setBusStopVariant2(tu sparsowanyv tabelaCsvArray2)
                //bus.setBusNumber(file.getId())

                //busDB.setBus(bus);
             /*   System.out.println("plik zakonczone na  warianty1.csv:        " + file.getVariant1());
                System.out.println("plik zakonczone na  warianty2.csv:        " + file.getVariant2());*/

               // System.out.println(" ile elementow   " + tabelaCSVArray1.size());
            }

        }

        for (int i = 0; i <busDB.size() ; i++) {
            System.out.println(busDB.get(i).getBusStopVariant1());
        }


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
        //TODO
        //i=
        //for (int i = 0; i < ; i++) {

        //}


    }
}
