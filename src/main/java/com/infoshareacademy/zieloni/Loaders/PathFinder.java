package com.infoshareacademy.zieloni.Loaders;

import com.infoshareacademy.zieloni.Model.PathToCsvDTO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

/**
 * read and store (in ArrayList<PathToCsvDTO>) the paths to all csv files from resource/rozklady_2015-09-08_13.43.01
 * Assign file path to proper category (opis, wariant, kurs)
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
    private static Logger logger = LogManager.getLogger(PathFinder.class.getName());

    public static ArrayList<PathToCsvDTO> addAllFilesPathToArrayList(String path) {

        File folder = new File(PathFinder.class.getProtectionDomain().getCodeSource().getLocation().getPath());

        System.out.println(PathFinder.class.getProtectionDomain().getCodeSource());
        // DLA JAR jjdz4-zieloni-app/target/planer-cli-1.0-SNAPSHOT-jar-with-dependencies.jar*/
        // DLA IDE znaleziona sicezka jjdz4-zieloni-app\target\classes

        /*Set wszystkich folderów z autobusami*/
        Set<String> directory = new HashSet<>();

        /*ArrayList z plikami csv dla każdego folderu directory*/
        ArrayList<String> files = new ArrayList<>();

        if (folder.isFile()) {  // Run with JAR file

            final JarFile jar;
            try {
                jar = new JarFile(folder);
                final Enumeration<JarEntry> entries = jar.entries();
                while (entries.hasMoreElements()) {
                    final String name = entries.nextElement().getName();
                    if (name.startsWith(path + "/")) { //filter according to the path
                        try {
                            directory.add(name.split("/")[1]);
                        } catch (Exception e) {
                            logger.warn("Run with JAR file - problem with add item to Set<String> directory ");
                        }
                        try {
                            files.add(name.split("/")[2]);
                            //logger.warn(name.split("/")[2]);

                        } catch (Exception e) {
                            //logger.warn("Run with JAR file - problem with add item to  ArrayList<String> files");
                        }
                    }
                }
            } catch (IOException e) {
                logger.warn("Run with JAR file-jar loading problem !!!");
                e.printStackTrace();
            }

        } else { // Run with IDE

            InputStream activitiesStream = PathFinder.class.getClassLoader().getResourceAsStream(path);

            /*Klasa Scanner służy do odczytywania danych *
            useDelimiter -łamie linie po napotkaniu znaku z parametru*/

            Scanner scanner = new Scanner(activitiesStream).useDelimiter("\n");
            boolean isHeader = true;

            /*szukamy w głłownym folderze*/
            while (scanner.hasNext()) {
                String record = scanner.next();

                /*znajdujemy podfoldery z nazwami autobusów*/
                directory.add(record);

                /*przeszukujemy podfolder*/
                InputStream activitiesStream1 = PathFinder.class.getClassLoader().getResourceAsStream(path + "/" + record);
                try {
                    Scanner scanner1 = new Scanner(activitiesStream1).useDelimiter("\n");
                    while (scanner1.hasNext()) {
                        String record1 = scanner1.next();
                        files.add(record1);
                    }

                } catch (Exception e) {
                    logger.warn("Run with IDE file - problem  with scanner!!!");
                }
            }
        }
        return assignPathToDTO(directory, files, path);
    }

    private static ArrayList<PathToCsvDTO> assignPathToDTO(Set<String> directory, ArrayList<String> files, String path) {
        /* ArrayList ze wszyskimi ścieżkami */
        ArrayList<PathToCsvDTO> arrayWithFolderPath = new ArrayList<>();

        for (String dir : directory) {

            PathToCsvDTO csvFile = new PathToCsvDTO();
            csvFile.setFolderName(path + "/" + dir);
            csvFile.setId(dir);
            arrayWithFolderPath.add(csvFile);

            for (int i = 0; i < files.size(); i++) {

                if (files.get(i).indexOf(dir) > -1) {
                    String finalPath = path + "/" + dir + "/" + files.get(i);
                    if (files.get(i).indexOf("kursy1") > -1) {
                        csvFile.setCourse1(finalPath);
                    }

                    if (files.get(i).indexOf("kursy2") > -1) {
                        csvFile.setCourse2(finalPath);
                    }

                    if (files.get(i).indexOf("opisy1") > -1) {
                        csvFile.setDescription1(finalPath);
                    }

                    if (files.get(i).indexOf("opisy2") > -1) {
                        csvFile.setDescription2(finalPath);
                    }

                    if (files.get(i).indexOf("warianty1") > -1) {
                        csvFile.setVariant1(finalPath);
                    }

                    if (files.get(i).indexOf("warianty2") > -1) {
                        csvFile.setVariant2(finalPath);
                    }
                }
            }
        }
        return arrayWithFolderPath;
    }
}


