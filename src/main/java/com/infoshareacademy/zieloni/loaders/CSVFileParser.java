package com.infoshareacademy.zieloni.loaders;

import com.infoshareacademy.zieloni.model.RecordCourseDTO;
import com.infoshareacademy.zieloni.model.ExtraTableCsvDTO;
import com.infoshareacademy.zieloni.model.RecordVariantDTO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CSVFileParser {


    public static List<ExtraTableCsvDTO> formatCSVToTimeTableWithExtraInfoRecords(List<String> stringArray) {

        ArrayList<ExtraTableCsvDTO> parseRecordsArray = new ArrayList<ExtraTableCsvDTO>();

        for (String filter : stringArray) {
            String[] records = filter.split("\\|");
            ExtraTableCsvDTO parseRecord = new ExtraTableCsvDTO();
            parseRecord.setId(records[0]);
            parseRecord.setLineNr(records[1]);
            parseRecord.setTypeOfTransport(records[2]);
            parseRecord.setInfoAboutRouteInHTMLformat(records[3]);
            parseRecord.setIsValidFrom(records[4]);
            parseRecord.setIsValidTo(records[5]);
            parseRecord.setLowRider(records[6] == "1" ? true : false);
            parseRecord.setCommentsHTML0(records[7]);
            parseRecord.setCommentsHTML1(records[8]);
            parseRecord.setCarrier(records[9]);
            parseRecordsArray.add(parseRecord);
        }

        return parseRecordsArray;
    }

    public static List<RecordVariantDTO> formatVarinatCSV(List<String> stringArray) {

        ArrayList<RecordVariantDTO> parseRecordsArray = new ArrayList<>();
        String[] header = stringArray.get(0).split("\\;");

        for (int i = 1; i < stringArray.size(); i++) {
            String[] records = stringArray.get(i).split("\\;");

            RecordVariantDTO parseRecord = new RecordVariantDTO();
            parseRecord.setIdVariant(records[0]);
            parseRecord.setFlags(records[1]);
            parseRecord.setCommunity(records[2]);
            parseRecord.setNameOfBusStop(records[3]);
            parseRecordsArray.add(parseRecord);
        }

        return parseRecordsArray;
    }


    public static Map<String, List<String>> columns_X0XX_Map(List<String> stringArray) {

       List<List<String>> columns_X0XX = new ArrayList<>();
        String[] lengthRecord = stringArray.get(0).split("\\;");

        Map<String, List<String>> mapa = new HashMap<>();

        for (int i = 4; i < lengthRecord.length; i++) {
            columns_X0XX.add(new ArrayList<>());
        }

        String[] header = stringArray.get(0).split("\\;");

        for (int i = 1; i < stringArray.size(); i++) {
            String[] records = stringArray.get(i).split("\\;");


            for (int j = 0; j < lengthRecord.length; j++) {
                try {
                    columns_X0XX.get(j).add(records[j + 4]);

                } catch (Exception e) {

                }
            }
        }
        for (int j = 0; j < columns_X0XX.size(); j++) {
            mapa.put(header[j + 4].replace("(00:00-29:59)", ""), columns_X0XX.get(j));
        }

        return mapa;
    }


    public static List<RecordCourseDTO> formatCourseCSV(List<String> stringArray) {


        ArrayList<RecordCourseDTO> parseRecordsArray = new ArrayList<>();

        for (int i = 0; i < stringArray.size(); i++) {
            String[] records = stringArray.get(i).split("\\;");
            RecordCourseDTO parseRecord = new RecordCourseDTO();
            try {
                parseRecord.setDepartureTime(records[0]);
                parseRecord.setTypeOfCourse(records[1]);
            } catch (Exception e) {
                System.out.println("Brakuje rekordu dla " + i);
            }
            parseRecordsArray.add(parseRecord);
        }

        return parseRecordsArray;
    }

}

