package com.infoshareacademy.zieloni;
/**
 * @author Michał Stasiński
 */

import com.infoshareacademy.zieloni.Model.PathToTimeTableCSVfile;

import java.io.File;
import java.util.ArrayList;



public class FilesLoader {

   /*load csv files from folder and return ArrayList*/

    public static ArrayList<PathToTimeTableCSVfile> addAllFilesPathToArrayList(final File folder) {

        ArrayList<PathToTimeTableCSVfile> arrayWithFolderPath = new ArrayList<PathToTimeTableCSVfile>();

        /* lista folderów*/
        for (final File fileEntry : folder.listFiles()) {

            PathToTimeTableCSVfile csvFile = new PathToTimeTableCSVfile();
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


