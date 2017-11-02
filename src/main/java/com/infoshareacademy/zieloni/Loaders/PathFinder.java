package com.infoshareacademy.zieloni.Loaders;

import com.infoshareacademy.zieloni.Model.PathToCsvDTO;

import java.io.File;
import java.util.ArrayList;

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

        ArrayList<PathToCsvDTO> arrayWithFolderPath = new ArrayList<>();

        /* lista folderów*/
        for (final File fileEntry : folder.listFiles()) {

            PathToCsvDTO csvFile = new PathToCsvDTO();
            if (fileEntry.isDirectory()) {

                csvFile.setFolderName(fileEntry.getAbsolutePath());
                csvFile.setId(fileEntry.getName());
                arrayWithFolderPath.add(csvFile);

                /*  lista plików w folderze*/
                File[] contentInFolder = fileEntry.listFiles();

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
        }
        return arrayWithFolderPath;
    }
}


