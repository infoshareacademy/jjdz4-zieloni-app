package com.infoshareacademy.zieloni.loaders;

import com.infoshareacademy.zieloni.model.FilePathDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

@SuppressWarnings({"squid:S1075", "squid:S2095"})
public class PathFinder {
    private PathFinder() {
    }

    private static final Logger logger = LoggerFactory.getLogger(PathFinder.class.getName());

    public static List<FilePathDTO> addAllFilesPathToArrayList(String path) {

        File folder = new File(PathFinder.class.getProtectionDomain().getCodeSource().getLocation().getPath());
        Set<String> directory = new HashSet<>();
        List<String> files = new ArrayList<>();

        if (folder.isFile()) {
            runWithJar(path, folder, directory, files);
        } else {
            runWithIDE(path, directory, files);
        }
        return assignPathToDTO(directory, files, path);
    }

    private static void runWithIDE(String path, Set<String> directory, List<String> files) {
        InputStream activitiesStream = PathFinder.class.getClassLoader().getResourceAsStream(path);
        Scanner scanner = new Scanner(activitiesStream).useDelimiter("\n");

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

    private static void runWithJar(String path, File folder, Set<String> directory, List<String> files) {
        JarFile jar = null;
        try {
            jar = new JarFile(folder);
            final Enumeration<JarEntry> entries = jar.entries();
            while (entries.hasMoreElements()) {
                switchDirectoryAndFiles(path, directory, files, entries);
            }
        } catch (IOException e) {
            logger.warn("Run with JAR file-jar loading problem !!!" + e);

        }
    }

    private static void switchDirectoryAndFiles(String path, Set<String> directory, List<String> files, Enumeration<JarEntry> entries) {
        final String name = entries.nextElement().getName();
        if (name.startsWith(path + "/")) {

            try {
                directory.add(name.split("/")[1]);
            } catch (Exception e) {
                logger.warn("Run with JAR file - problem with add item to Set<String> directory " + e);
            }

            try {
                files.add(name.split("/")[2]);

            } catch (Exception e) {
                logger.debug("Trafił ponownie na folder");
            }

        }
    }

    private static List<FilePathDTO> assignPathToDTO(Set<String> directory, List<String> files, String path) {
        List<FilePathDTO> arrayWithFolderPath = new ArrayList<>();

        for (String dir : directory) {

            FilePathDTO csvFile = new FilePathDTO();
            csvFile.setFolderName(path + "/" + dir);
            csvFile.setId(dir);
            arrayWithFolderPath.add(csvFile);
            swithPath(files, path, dir, csvFile);
        }

        return arrayWithFolderPath;
    }

    private static void swithPath(List<String> files, String path, String dir, FilePathDTO csvFile) {
        for (int i = 0; i < files.size(); i++) {

            if (files.get(i).contains(dir)) {
                setPathToCorrectMethod(files, path, dir, csvFile, i);
            }
        }
    }

    private static void setPathToCorrectMethod(List<String> files, String path, String dir, FilePathDTO csvFile, int i) {

        String finalPath = path + "/" + dir + "/" + files.get(i);
        if (files.get(i).contains("kursy1")) {
            csvFile.setCourse1(finalPath);
        }

        if (files.get(i).contains("kursy2")) {
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


