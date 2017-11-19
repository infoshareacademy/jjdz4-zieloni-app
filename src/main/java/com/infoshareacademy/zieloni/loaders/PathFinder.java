package com.infoshareacademy.zieloni.loaders;

import com.infoshareacademy.zieloni.model.FilePathDTO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

public class PathFinder {

    private static Logger logger = LogManager.getLogger(PathFinder.class.getName());


    public static ArrayList<FilePathDTO> addAllFilesPathToArrayList(String path) {

        File folder = new File(PathFinder.class.getProtectionDomain().getCodeSource().getLocation().getPath());
        Set<String> directory = new HashSet<>();
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

                        } catch (Exception e) {

                        }
                    }
                }
            } catch (IOException e) {
                logger.warn("Run with JAR file-jar loading problem !!!");
                e.printStackTrace();
            }

        } else { // Run with IDE

            InputStream activitiesStream = PathFinder.class.getClassLoader().getResourceAsStream(path);

            Scanner scanner = new Scanner(activitiesStream).useDelimiter("\n");
            boolean isHeader = true;

            while (scanner.hasNext()) {
                String record = scanner.next();

                directory.add(record);

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

    private static ArrayList<FilePathDTO> assignPathToDTO(Set<String> directory, ArrayList<String> files, String path) {
        ArrayList<FilePathDTO> arrayWithFolderPath = new ArrayList<>();

        for (String dir : directory) {

            FilePathDTO csvFile = new FilePathDTO();
            csvFile.setFolderName(path + "/" + dir);
            csvFile.setId(dir);
            arrayWithFolderPath.add(csvFile);

            for (int i = 0; i < files.size(); i++) {

                if (files.get(i).contains(dir)) {
                    String finalPath = path + "/" + dir + "/" + files.get(i);
                    if (files.get(i).contains("kursy1")) {
                        csvFile.setCourse1(finalPath);
                    }

                    if (files.get(i).contains("kursy2") ) {
                        csvFile.setCourse2(finalPath);
                    }

                    if (files.get(i).contains("opisy1")) {
                        csvFile.setDescription1(finalPath);
                    }

                    if (files.get(i).contains("opisy2")) {
                        csvFile.setDescription2(finalPath);
                    }

                    if (files.get(i).contains("warianty1")) {
                        csvFile.setVariant1(finalPath);
                    }

                    if (files.get(i).contains("warianty2")) {
                        csvFile.setVariant2(finalPath);
                    }
                }
            }
        }

        return arrayWithFolderPath;
    }
}


