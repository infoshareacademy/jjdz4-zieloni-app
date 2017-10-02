package com.infoshareacademy.zieloni;

/**
 * @author Michal Stasiński
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class CSVReader {


    public static ArrayList<String> readCSVRead(String path, String cvsSplitBy) {

        ArrayList<String> records = new ArrayList<String>();
        String line = "";


        try {
            BufferedReader br = new BufferedReader(new FileReader(path));

            while ((line = br.readLine()) != null) {
                //System.out.println(line);
                // use comma as separator
                    records.add(line);

            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return records;
    }
}



