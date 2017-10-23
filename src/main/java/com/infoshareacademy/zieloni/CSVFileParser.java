package com.infoshareacademy.zieloni;

import com.infoshareacademy.zieloni.Model.ExtraTableCsvDTO;
import com.infoshareacademy.zieloni.Model.VariantCsvDTO;

import java.util.ArrayList;

/**
 * get ArrayList of records (that are lines of text from a csv file) bind with object entity
 * records are converted into strnig[] by split method
 * and then each value of string [] is set in the object entity
 * <p>
 * Klasa ma dwie metody w zależności od tego czy otrzymamy plik tabela.csv czy plik csv z folderu z rozkładami
 * Plik jest wprowadzony w postaci stringów znajdujacych sie w ArrayLiscie
 * Każdy string jest zamieniany metodą split (usuwajaca separator) na String[] i przypisywany
 * w zalezności od tego czy to tabela csv czy inny plik csw do obiektów ExtraTableCsvDTO lub
 * VariantCsvDTO(tu potrzbujemy na razie tylko ulic ale moziwe że bedziemy to roszerzać)
 *
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

    public static ArrayList<VariantCsvDTO> formatCSVBus(ArrayList<String> stringArray) {

        /**
         * @param this method get other files csv (converted to ArrayList<String>) from resource\rozklady_2015-09-08_13.43.01
         * and set value to VariantCsvDTO object
         * @return array with VariantCsvDTO objects
         */
        ArrayList<VariantCsvDTO> parseRecordsArray = new ArrayList<>();

        for (int i = 1; i < stringArray.size(); i++) {
            String[] records = stringArray.get(i).split("\\;");

            VariantCsvDTO parseRecord = new VariantCsvDTO();

            parseRecord.setIdVariant(records[0]);
            parseRecord.setFlags(records[1]);
            parseRecord.setNameOfTheCommunity(records[2]);
            parseRecord.setNameOfBasStop(records[3]);
            ArrayList<String> time_X0XX_Array = new ArrayList<>();

            for (int j = 4; j < records.length; j++) {
                time_X0XX_Array.add(records[j]);
            }

            //System.out.println( time_X0XX_Array);
            parseRecord.setTimes_X0_XX(time_X0XX_Array);
           // System.out.println( parseRecord.getTimes_X0_XX());
            parseRecordsArray.add(parseRecord);
        }
        return parseRecordsArray;
    }
}

