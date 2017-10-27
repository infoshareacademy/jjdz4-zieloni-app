package com.infoshareacademy.zieloni.DataBase;

import com.infoshareacademy.zieloni.CSVFileParser;
import com.infoshareacademy.zieloni.CSVReader;
import com.infoshareacademy.zieloni.FilesPathFinder;
import com.infoshareacademy.zieloni.Model.BusDTO;
import com.infoshareacademy.zieloni.Model.CourseDTO;
import com.infoshareacademy.zieloni.Model.PathToCsvDTO;
import com.infoshareacademy.zieloni.Model.VariantCsvDTO;

import java.io.File;
import java.util.ArrayList;

/**
 * @author Michał Stasiński
 */
public class BusDataBase {

    public static ArrayList<BusDTO> getDataBase() {
    /* bieżący katalog roboczy uzyskujemy  przez System.getProperty("user.dir");*/
        final String currentDirectory = System.getProperty("user.dir");

        final File folder = new File(currentDirectory + "//src//main//resource//rozklady_2015-09-08_13.43.01");
        //System.out.println("current dir = " + folder);

        // towrzenie bazy danych z wszystkimi autobusami
        ArrayList<BusDTO> busDB = new ArrayList<BusDTO>();

    /* M.Stasiński: ArrayList ze wszystkimi scieżkami do katalogów i znajdujących się w nim plików z rozkładami jazdy */
        ArrayList<PathToCsvDTO> filePath = FilesPathFinder.addAllFilesPathToArrayList(folder);
        for (PathToCsvDTO file : filePath) {

            // if (file.getIsValidFrom() < 20150908) {
            //  System.out.println("---------------------------------------------------------------------------------------------");
               /* System.out.println("ID :                                      " + file.getId());
                System.out.println("Rozkład obowiązuje od :                   " + file.getIsValidFrom());
                System.out.println("Nazwa folderu :                           " + file.getFolderName());
                System.out.println("plik zakonczone na  kursy1.csv:           " + file.getCourse1());
                System.out.println("plik zakonczone na  kursy2.csv:           " + file.getCourse2());
                System.out.println("plik zakonczone na  opis1.csv:            " + file.getDescription1());
                System.out.println("plik zakonczone na  opis2.csv:            " + file.getDescription2());*/

           // System.out.println("ID :                                      " + file.getId());

            ArrayList<String> variant1RecordArray = CSVReader.readCSVfileAndConvertToRecordsArray(file.getVariant1());
            ArrayList<VariantCsvDTO> variant1 = CSVFileParser.formatVarinatCSV(variant1RecordArray);
            ArrayList<String> course1RecordArray = CSVReader.readCSVfileAndConvertToRecordsArray(file.getCourse1());
            ArrayList<CourseDTO> course1 = CSVFileParser.formatCourseCSV(course1RecordArray);

            ArrayList<String> variant2RecordArray = CSVReader.readCSVfileAndConvertToRecordsArray(file.getVariant2());
            ArrayList<VariantCsvDTO> variant2 = CSVFileParser.formatVarinatCSV(variant2RecordArray);
            ArrayList<String> course2RecordArray = CSVReader.readCSVfileAndConvertToRecordsArray(file.getCourse2());
            ArrayList<CourseDTO> course2 = CSVFileParser.formatCourseCSV(course2RecordArray);

            BusDTO bus = new BusDTO();

            bus.setBusStopVariant1(variant1);
            bus.setBusStopVariant2(variant2);
            bus.setCourseVariant1(course1);
            bus.setCourseVariant2(course2);
            bus.setBusNumber(file.getId().split("_")[0]);
            busDB.add(bus);
        }

        return busDB;
    }
}
