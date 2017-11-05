package com.infoshareacademy.zieloni.Loaders;

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
    public static ArrayList<String> readCSVfileAndConvertToRecordsArray(String path) {
        ArrayList<String> records = new ArrayList<>();
        String line = "";
        System.out.println("Reader   "  +path);
        try{
            //InputStream activitiesStream = PathFinder.class.getClassLoader().getResourceAsStream("//rozklady_2015-09-08_13.43.01//622_20150501warianty1.csv");
            InputStream activitiesStream = PathFinder.class.getClassLoader().getResourceAsStream(path);

            Scanner scanner = new Scanner(activitiesStream).useDelimiter("\n");
            //System.out.println("REC" +scanner);
            while (scanner.hasNext()) {
                String record = scanner.next();
              //  System.out.println("REC" +record);
                records.add(record);
            }
        }catch (Exception e){
            System.out.println("cos nie tak");
        }



        /*try {


            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(path), "windows-1250"));
            while ((line = br.readLine()) != null) {

                records.add(line.toString());
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
*/
        return records;
      //  ArrayList<String> ff =new  ArrayList<String>();

       // return ff;
    }
}



