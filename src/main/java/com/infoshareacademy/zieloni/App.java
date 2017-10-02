package com.infoshareacademy.zieloni;

import com.infoshareacademy.zieloni.Model.PathToTimeTableCSVfile;

import java.io.File;
import java.util.ArrayList;

public class App {

    public static void main(String[] args) {

        /* MStasiński: bieżący katalog roboczy uzyskujemy  przez System.getProperty("user.dir");*/
        final String currentDirectory = System.getProperty("user.dir");

        final File folder = new File(currentDirectory + "\\rozklady_2015-09-08_13.43.01");
        System.out.println("current dir = " + currentDirectory);

        /* M.Stasiński: ArrayList ze wszystkimi scieżkami do katalogów i znajdujących się w nim plików z rozkładami jazdy */
        ArrayList<PathToTimeTableCSVfile> filePath = FilesLoader.addAllFilesPathToArrayList(folder);

        for (PathToTimeTableCSVfile file : filePath) {

            if (file.getIsValidFrom() < 20150908) {

                System.out.println("---------------------------------------------------------------------------------------------");
                System.out.println("ID :                                      " + file.getId());
                System.out.println("Rozkład obowiązuje od :                   " + file.getIsValidFrom());
                System.out.println("Nazwa folderu :                           " + file.getFolderName());
                System.out.println("plik zakonczone na  kursy1.csv:           " + file.getCourse1());
                System.out.println("plik zakonczone na  kursy2.csv:           " + file.getCourse2());
                System.out.println("plik zakonczone na  opis1.csv:            " + file.getDescription1());
                System.out.println("plik zakonczone na  opis2.csv:            " + file.getDescription2());
                System.out.println("plik zakonczone na  warianty1.csv:        " + file.getVariant1());
                System.out.println("plik zakonczone na  warianty2.csv:        " + file.getVariant2());

            }
        }
    }
}
