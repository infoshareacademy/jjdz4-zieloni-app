package com.infoshareacademy.zieloni.loaders;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class CSVReader {

    private CSVReader() {
    }

    private static final Logger logger = LoggerFactory.getLogger(CSVReader.class.getName());


    public static List<String> convertFileToRecordsArray(String path) {

        List<String> records = new ArrayList<>();
        String line = "";
        try {

            InputStream activitiesStream = CSVReader.class.getClassLoader().getResourceAsStream(path);
            BufferedReader br = new BufferedReader(new InputStreamReader(activitiesStream, "windows-1250"));
            while ((line = br.readLine()) != null) {
                records.add(line);
            }
            br.close();

        } catch (IOException e) {
            logger.info("problem z plikiem" + e);

        }

        return records;
    }
}



