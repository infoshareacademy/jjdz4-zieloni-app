package com.infoshareacademy.zieloni;

import java.io.File;

/**
 * Hello world!
 */
public class App {

    private static final File folder = new File("/home/you/Desktop");
    public static void main(String[] args) {
        System.out.println("Hello World!");

        FileFromFolderLoader.listFilesForFolder(folder);
    }
}
