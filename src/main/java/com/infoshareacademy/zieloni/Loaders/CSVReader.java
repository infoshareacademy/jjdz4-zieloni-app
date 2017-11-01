package com.infoshareacademy.zieloni.Loaders;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Read csv file line by line an put in into an arrayList.
 *
 * @author Michal Stasiński
 * @return ArrayList of records that are lines of text from a csv file
 */

public class CSVReader {
    /**
     * @param path an absolute URL giving the base location of the csv file (PathFinder)
     * @return ArrayList of records - record is single line of text from a csv file
     */
    public static ArrayList<String> readCSVfileAndConvertToRecordsArray(String path) {
        ArrayList<String> records = new ArrayList<String>();
        String line = "";

        try {

            /*kodowanie polskich znaków*/
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(path), "windows-1250"));
            //BufferedReader br = new BufferedReader(new FileReader(path));
            while ((line = br.readLine()) != null) {
                //System.out.println(line);
                records.add(line.toString());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return records;
    }
}



