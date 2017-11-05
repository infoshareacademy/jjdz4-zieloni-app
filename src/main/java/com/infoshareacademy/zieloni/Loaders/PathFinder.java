package com.infoshareacademy.zieloni.Loaders;

import com.infoshareacademy.zieloni.Model.PathToCsvDTO;

import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * read and store in array  paths to all csv files in resource/rozklady_2015-09-08_13.43.01
 * checks all folders and subfolders
 * Also check the categories which the file belongs (opis, wariant, kurs)
 * <p>
 * <p>
 * Ta klasa pobiera folder resource/rozklady_2015-09-08_13.43.01  i przeszukuje podfoldery
 * Sprawdza do której kategorii należą pliki w podfolderach  tzn czy jest to opis, kurs, czy wariant
 * Tworzy obiekt typu PathToCsvDTO który zawiera absolutne ściezki do poszczególnych plików w danym folderze
 *
 * @author Michal Stasiński
 * @see PathToCsvDTO
 * <p>
 * " Rozkład obowiązuje                        " + file.getIsValidFrom());
 * " Nazwa folderu :                           " + file.getFolderName());
 * " plik zakonczone na  kursy1.csv:           " + file.getCourse1());
 * " plik zakonczone na  kursy2.csv:           " + file.getCourse2());
 * " plik zakonczone na  opis1.csv:            " + file.getDescription1());
 * " plik zakonczone na  opis2.csv:            " + file.getDescription2());
 */

public class PathFinder {

    /**
     * @param @param folder  it is  folder in resource/rozklady_2015-09-08_13.43.01
     * @return array with paths to all csv files in folder
     */

    public static ArrayList<PathToCsvDTO> addAllFilesPathToArrayList(final File folder) {
        // public static final File folder = new File("rozklady_2015-09-08_13.43.01");
        ArrayList<PathToCsvDTO> arrayWithFolderPath = new ArrayList<>();

        String pathMain = "rozklady_2015-09-08_13.43.01/";
        InputStream activitiesStream = PathFinder.class.getClassLoader().getResourceAsStream("rozklady_2015-09-08_13.43.01");


        Scanner scanner = new Scanner(activitiesStream).useDelimiter("\n");
        boolean isHeader = true;

        while (scanner.hasNext()) {

            PathToCsvDTO csvFile = new PathToCsvDTO();
            String record = scanner.next();
            // System.out.println("rozklady_2015-09-08_13.43.01/" + record);
            //System.out.println(record);

            csvFile.setFolderName("rozklady_2015-09-08_13.43.01/" + record);
            csvFile.setId(record);
            arrayWithFolderPath.add(csvFile);

            InputStream activitiesStream1 = PathFinder.class.getClassLoader().getResourceAsStream("rozklady_2015-09-08_13.43.01//" + record);
            try {
                Scanner scanner1 = new Scanner(activitiesStream1).useDelimiter("\n");
                while (scanner1.hasNext()) {
                    String record1 = scanner1.next();

                    //  System.out.println(paaaa + record1);
                    if (record1.indexOf("kursy1") > -1) {
                        csvFile.setCourse1(pathMain + record + "/" + record1);
                    }

                    if (record1.indexOf("kursy2") > -1) {
                        csvFile.setCourse2(pathMain + record + "/" + record1);
                    }

                    if (record1.indexOf("opisy1") > -1) {
                        csvFile.setDescription1(pathMain + record + "/" + record1);
                    }

                    if (record1.indexOf("opisy2") > -1) {
                        csvFile.setDescription2(pathMain + record + "/" + record1);
                    }

                    if (record1.indexOf("warianty1") > -1) {
                        csvFile.setVariant1(pathMain + record + "/" + record1);
                    }

                    if (record1.indexOf("warianty2") > -1) {
                        csvFile.setVariant2(pathMain + record + "/" + record1);
                    }
                }
            } catch (Exception e) {
            }

        }


        return arrayWithFolderPath;

        /* lista folderów*/

/*
        for (final File fileEntry : folder.listFiles()) {

            PathToCsvDTO csvFile = new PathToCsvDTO();
            if (fileEntry.isDirectory()) {

                csvFile.setFolderName(fileEntry.getAbsolutePath());
                csvFile.setId(fileEntry.getName());
                // System.out.println(fileEntry.getAbsolutePath());
                //  System.out.println(fileEntry.getName());
                arrayWithFolderPath.add(csvFile);

                /*  lista plików w folderze*/
               /* File[] contentInFolder = fileEntry.listFiles();

                for (int i = 0; i < contentInFolder.length; i++) {
                    if (contentInFolder[i].getName().indexOf("kursy1") > -1) {
                        csvFile.setCourse1(contentInFolder[i].getAbsolutePath());
                    }

                    if (contentInFolder[i].getName().indexOf("kursy2") > -1) {
                        csvFile.setCourse2(contentInFolder[i].getAbsolutePath());
                    }

                    if (contentInFolder[i].getName().indexOf("opisy1") > -1) {
                        csvFile.setDescription1(contentInFolder[i].getAbsolutePath());
                    }

                    if (contentInFolder[i].getName().indexOf("opisy2") > -1) {
                        csvFile.setDescription2(contentInFolder[i].getAbsolutePath());
                    }

                    if (contentInFolder[i].getName().indexOf("warianty1") > -1) {
                        csvFile.setVariant1(contentInFolder[i].getAbsolutePath());
                    }

                    if (contentInFolder[i].getName().indexOf("warianty2") > -1) {
                        csvFile.setVariant2(contentInFolder[i].getAbsolutePath());
                    }
                }
            }
        }*/

    }
}


