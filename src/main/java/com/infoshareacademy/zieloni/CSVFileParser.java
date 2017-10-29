package com.infoshareacademy.zieloni;

import com.infoshareacademy.zieloni.Model.RecordCourseDTO;
import com.infoshareacademy.zieloni.Model.ExtraTableCsvDTO;
import com.infoshareacademy.zieloni.Model.RecordVariantCsvDTO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Michal Stasiński
 */

public class CSVFileParser {


    public static ArrayList<ExtraTableCsvDTO> formatCSVToTimeTableWithExtraInfoRecords(ArrayList<String> stringArray) {

        /**
         * @param this method get file tabela.csv(converted to ArrayList<String>) from  resource\rozklady_2015-09-08_13.43.01
         * and set value to ExtraTableCsvDTO object
         * @return array with ExtraTableCsvDTO objects
         */

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

    public static ArrayList<RecordVariantCsvDTO> formatVarinatCSV(ArrayList<String> stringArray) {

        /**
         * @param this method get other files csv (converted to ArrayList<String>) from resource\rozklady_2015-09-08_13.43.01
         * and set value to RecordVariantCsvDTO object
         * @return array with RecordVariantCsvDTO objects
         */


        ArrayList<RecordVariantCsvDTO> parseRecordsArray = new ArrayList<>();
        String[] header = stringArray.get(0).split("\\;");

        for (int i = 1; i < stringArray.size(); i++) {
            String[] records = stringArray.get(i).split("\\;");

            RecordVariantCsvDTO parseRecord = new RecordVariantCsvDTO();
            parseRecord.setIdVariant(records[0]);
            parseRecord.setFlags(records[1]);
            parseRecord.setCommunity(records[2]);
            parseRecord.setNameOfBusStop(records[3]);
            parseRecordsArray.add(parseRecord);
        }

        return parseRecordsArray;
    }


    public static Map<String, ArrayList<String>> columns_X0XX_Map(ArrayList<String> stringArray) {

        ArrayList<ArrayList<String>> columns_X0XX = new ArrayList<>();
        String[] lengthRecord = stringArray.get(0).split("\\;");

        Map<String, ArrayList<String>> mapa = new HashMap<String, ArrayList<String>>();

        for (int i = 4; i < lengthRecord.length; i++) {
            columns_X0XX.add(new ArrayList<String>());
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


    public static ArrayList<RecordCourseDTO> formatCourseCSV(ArrayList<String> stringArray) {
        ArrayList<RecordCourseDTO> parseRecordsArray = new ArrayList<>();

        for (int i = 0; i < stringArray.size(); i++) {
            String[] records = stringArray.get(i).split("\\;");
            RecordCourseDTO parseRecord = new RecordCourseDTO();
            try {
                parseRecord.setDepartureTime(records[0]);
                parseRecord.setCourseX0_XX(records[1]);
            } catch (Exception e) {
                System.out.println("Brakuje rekordu dla " + i);
            }
            parseRecordsArray.add(parseRecord);
        }

        return parseRecordsArray;
    }

}

