package com.infoshareacademy.zieloni.Loaders;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

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
    private static Logger logger = LogManager.getLogger(CSVReader.class.getName());

    public static ArrayList<String> readCSVfileAndConvertToRecordsArray(String path) {


        ArrayList<String> records = new ArrayList<>();
        String line = "";
        try {

            InputStream activitiesStream = PathFinder.class.getClassLoader().getResourceAsStream(path);
            BufferedReader br = new BufferedReader(new InputStreamReader(activitiesStream, "windows-1250"));
            while ((line = br.readLine()) != null) {

                records.add(line.toString());
            }

            br.close();
        } catch (IOException e) {
            logger.warn("Problem with csv reading");
            e.printStackTrace();
        }

        return records;

    }
}



