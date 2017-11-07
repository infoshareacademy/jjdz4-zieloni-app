package com.infoshareacademy.zieloni.Loaders;

import com.infoshareacademy.zieloni.Model.PathToCsvDTO;
import sun.misc.Launcher;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.*;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

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

        String path = "rozklady_2015-09-08_13.43.01";
        File folder1 = new File(PathFinder.class.getProtectionDomain().getCodeSource().getLocation().getPath());

        ArrayList<PathToCsvDTO> arrayWithFolderPath = new ArrayList<>();


        if (folder1.isFile()) {  // Run with JAR file

            Set<String> directory = new HashSet<>();
            ArrayList<String> files = new ArrayList<>();


            final JarFile jar;
            try {
                jar = new JarFile(folder1);
                final Enumeration<JarEntry> entries = jar.entries(); //gives ALL entries in jar
                while (entries.hasMoreElements()) {
                    final String name = entries.nextElement().getName();
                    if (name.startsWith(path + "/")) { //filter according to the path
                        try {
                            // System.out.println(name.split("/")[1]);
                            directory.add(name.split("/")[1]);

                        } catch (Exception e) {


                        }

                        try {
                            files.add(name.split("/")[2]);
                           // System.out.println("plik"+name.split("/")[2]);

                        } catch (Exception e) {

                        }


                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }


            for (String die : directory) {

               // System.out.println("rozklady_2015-09-08_13.43.01/" + die);
                PathToCsvDTO csvFile = new PathToCsvDTO();
                csvFile.setFolderName(path + "/" + die);
                csvFile.setId(die);
                arrayWithFolderPath.add(csvFile);


                for (int i = 0; i < files.size(); i++) {



                    if (files.get(i).indexOf(die) > -1) {
                        System.out.println(die);
                        System.out.println(files.get(i));
                        //System.out.println(files.get(i));



                        if (files.get(i).indexOf("kursy1") > -1) {
                            csvFile.setCourse1(path + "/" + die + "/"  + files.get(i));
                        }

                        if (files.get(i).indexOf("kursy2") > -1) {
                            csvFile.setCourse2(path + "/" + die + "/"  + files.get(i));
                        }

                        if (files.get(i).indexOf("opisy1") > -1) {
                            csvFile.setDescription1(path + "/" + die + "/"  + files.get(i));
                        }

                        if (files.get(i).indexOf("opisy2") > -1) {
                            csvFile.setDescription2(path + "/" + "/"  + die + files.get(i));
                        }

                        if (files.get(i).indexOf("warianty1") > -1) {
                            csvFile.setVariant1(path + "/" + die+ "/"  + files.get(i));
                        }

                        if (files.get(i).indexOf("warianty2") > -1) {
                            csvFile.setVariant2(path + "/" + die+ "/"  +  files.get(i));
                        }
                    }

                }
            }


        } else { // Run with IDE
            final URL url = Launcher.class.getResource("/" + path);
            if (url != null) {
                try {
                    final File apps = new File(url.toURI());
                    for (File app : apps.listFiles()) {
                        // System.out.println(app);
                    }
                } catch (URISyntaxException ex) {
                    // never happens
                }
            }

        }



        InputStream activitiesStream = PathFinder.class.getClassLoader().getResourceAsStream(path);
       // System.out.println("activitiesStream " + activitiesStream);

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

            InputStream activitiesStream1 = PathFinder.class.getClassLoader().getResourceAsStream(path + "/" + record);
            try {
                Scanner scanner1 = new Scanner(activitiesStream1).useDelimiter("\n");
                while (scanner1.hasNext()) {
                    String record1 = scanner1.next();

                    //  System.out.println(paaaa + record1);
                    if (record1.indexOf("kursy1") > -1) {
                        csvFile.setCourse1(path + "/" + record + "/" + record1);
                    }

                    if (record1.indexOf("kursy2") > -1) {
                        csvFile.setCourse2(path + "/" + record + "/" + record1);
                    }

                    if (record1.indexOf("opisy1") > -1) {
                        csvFile.setDescription1(path + "/" + record + "/" + record1);
                    }

                    if (record1.indexOf("opisy2") > -1) {
                        csvFile.setDescription2(path + "/" + record + "/" + record1);
                    }

                    if (record1.indexOf("warianty1") > -1) {
                        csvFile.setVariant1(path + "/" + record + "/" + record1);
                    }

                    if (record1.indexOf("warianty2") > -1) {
                        csvFile.setVariant2(path + "/" + record + "/" + record1);
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

                csvFile.setFolderName(fileEntry.getPath());
                csvFile.setId(fileEntry.getName());
                // System.out.println(fileEntry.getAbsolutePath());
                //  System.out.println(fileEntry.getName());
                arrayWithFolderPath.add(csvFile);

                /*  lista plików w folderze*/
               /* File[] contentInFolder = fileEntry.listFiles();

                for (int i = 0; i < contentInFolder.length; i++) {
                    if (contentInFolder[i].getName().indexOf("kursy1") > -1) {
                        csvFile.setCourse1(contentInFolder[i].getPath());
                    }

                    if (contentInFolder[i].getName().indexOf("kursy2") > -1) {
                        csvFile.setCourse2(contentInFolder[i].getPath());
                    }

                    if (contentInFolder[i].getName().indexOf("opisy1") > -1) {
                        csvFile.setDescription1(contentInFolder[i].getPath());
                    }

                    if (contentInFolder[i].getName().indexOf("opisy2") > -1) {
                        csvFile.setDescription2(contentInFolder[i].getPath());
                    }

                    if (contentInFolder[i].getName().indexOf("warianty1") > -1) {
                        csvFile.setVariant1(contentInFolder[i].getPath());
                    }

                    if (contentInFolder[i].getName().indexOf("warianty2") > -1) {
                        csvFile.setVariant2(contentInFolder[i].getPath());
                    }
                }
            }
        }*/

    }
}


