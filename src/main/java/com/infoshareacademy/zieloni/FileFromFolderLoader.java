package com.infoshareacademy.zieloni;
/**
 * @author Michał Stasiński
 */
import java.io.File;


public class FileFromFolderLoader {

    public static void listFilesForFolder(final File folder) {

        for (final File fileEntry : folder.listFiles()) {
            if (fileEntry.isDirectory()) {
                listFilesForFolder(fileEntry);
            } else {
                System.out.println(fileEntry.getName());
            }
        }
    }
}
