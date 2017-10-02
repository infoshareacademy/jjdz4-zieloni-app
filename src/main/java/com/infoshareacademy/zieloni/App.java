package com.infoshareacademy.zieloni;

import java.io.File;

/**
 * Hello world!
 */
public class App {

    private static final File folder = new File("C:\\Users\\mstasinski\\Desktop\\ISAcademy\\rozklady_2015-09-08_13.43.01");
    public static void main(String[] args) {
        System.out.println("Hello World!");

       FileFromFolderLoader.listFilesForFolder(folder);
    }
}
