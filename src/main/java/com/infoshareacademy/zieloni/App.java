package com.infoshareacademy.zieloni;

import com.infoshareacademy.zieloni.Model.Bus;
import com.infoshareacademy.zieloni.Model.PathToTimeTableCSVfile;
import com.infoshareacademy.zieloni.Model.TimeTableRecordWithExtraInfo;
import com.infoshareacademy.zieloni.Model.VariantCsvModel;

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


        /* M.Stasiński: ArrayList ze wszystkimi scieżkami do katalogów i znajdujących się w nim plików z rozkładami jazdy */
        ArrayList<PathToTimeTableCSVfile> filePath = FilesLoader.addAllFilesPathToArrayList(folder);
        int j = 0;

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
                //TODO PRZECZYTAJ PLIK v1, v2 PARSER DLA PLIKÓW


                //ODCZTYAĆ WATIANT 1  I ZAMIENIĆ NA ARRAI LIST RCORD NIE SPARSOWNA
                //ODCZTYAĆ WATIANT 2  I ZAMIENIĆ NA ARRAI LIST RCORD NIE SPARSOWNA
                //System.out.println(file.getId());

                //ArrayList<String> recordsArray = CSVReader.readCSVfileAndConvertToRecordsArray(tabelaCSVPath.toString());
                //FORMATOWANIE  POPARSOWANE I POBRANIE ULICY

                //ArrayList<TimeTableRecordWithExtraInfo> tabelaCSVArray = CSVFileFormater.formatCSVToTimeTableWithExtraInfoRecords(recordsArray);

                //bus.setBusStopVariant1(tu sparsowanyv tabelaCsvArray1)->nazwy sparsowane
                //bus.setBusStopVariant2(tu sparsowanyv tabelaCsvArray2)
                //bus.setBusNumber(file.getId())

                ArrayList<String> variant1RecordAr1 = CSVReader.readCSVfileAndConvertToRecordsArray(file.getVariant1());
                ArrayList<VariantCsvModel> tabelaCSVArray1 = CSVFileFormater.formatCSVBus(variant1RecordAr1);
                Bus bus = new Bus();
                bus.setBusStopVariant1(tabelaCSVArray1);
                bus.setBusNumber(file.getId().split("_")[0]);
                busDB.add(bus);
            }

        }

        for (int i = 0; i < busDB.size(); i++) {
            System.out.println("Autobus o numerze " + busDB.get(i).getBusNumber());
            System.out.println("Zatrzymuje sie na ulicach_____________________________________");
            for (int k = 0; k < busDB.get(i).getBusStopVariant1().size(); k++) {
                System.out.println(k + "    " + busDB.get(i).getBusStopVariant1().get(k).getNameOfBasStop());
            }
            System.out.println("______________________________________________________________");
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


    }
}
