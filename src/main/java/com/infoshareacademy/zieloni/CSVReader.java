package com.infoshareacademy.zieloni;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Read csv file line by line an put in into an arrayList.
 *
 * @author Michal Stasiński
 * @return ArrayList of records that are lines of text from a csv file
 */

public class CSVReader {
    /**
     * @param path an absolute URL giving the base location of the csv file (FilesPathFinder)
     * @return ArrayList of records - record is single line of text from a csv file
     */
    public static ArrayList<String> readCSVfileAndConvertToRecordsArray(String path) {
        ArrayList<String> records = new ArrayList<String>();
        String line = "";
        try {
            BufferedReader br = new BufferedReader(new FileReader(path));
            while ((line = br.readLine()) != null) {
                records.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return records;
    }
}



