package com.infoshareacademy.zieloni;

import com.infoshareacademy.zieloni.Model.InfoFromTabelaCsv;
import com.infoshareacademy.zieloni.Model.VariantCsvModel;

import java.util.ArrayList;

/**
 * get ArrayList of records (that are lines of text from a csv file) bind with object entity
 * records are converted into strnig[] by split method
 * and then each value of string [] is set in the object entity
 *
 * Klasa ma dwie metody w zależności od tego czy otrzymamy plik tabela.csv czy plik csv z folderu z rozkładami
 * Plik jest wprowadzony w postaci stringów znajdujacych sie w ArrayListcie
 * Każdy string jest zamieniany metodą split (usuwajaca separator) na String[] i przypisywany
 * w zalezności od tego czy to tabela csv czy inny plik csw do obiektów InfoFromTabelaCsv
 * VariantCsvModel(tu potrzbujemy na razie tylko ulic ale moziwe że bedziemy to roszerzać)
 *
 * @author Michal Stasiński
 *
 */

public class CSVFileFormater {


    public static ArrayList<InfoFromTabelaCsv> formatCSVToTimeTableWithExtraInfoRecords(ArrayList<String> stringArray) {

        /**
         * @param this method get file tabela.csv(converted to ArrayList<String>) from  resource\rozklady_2015-09-08_13.43.01
         * and set value to ExtraInfoModel object
         * @return array with ExtraInfoModel objects
         */

        ArrayList<InfoFromTabelaCsv> formattedRecordsArray = new ArrayList<InfoFromTabelaCsv>();

        for (String filter : stringArray) {
            String[] records = filter.split("\\|");
            InfoFromTabelaCsv formattedRecord = new InfoFromTabelaCsv();
            formattedRecord.setId(records[0]);
            formattedRecord.setLineNr(records[1]);
            formattedRecord.setTypeOfTransport(records[2]);
            formattedRecord.setInfoAboutRouteInHTMLformat(records[3]);
            formattedRecord.setIsValidFrom(records[4]);
            formattedRecord.setIsValidTo(records[5]);
            formattedRecord.setLowRider(records[6] == "1" ? true : false);
            formattedRecord.setCommentsHTML0(records[7]);
            formattedRecord.setCommentsHTML1(records[8]);
            formattedRecord.setCarrier(records[9]);

            formattedRecordsArray.add(formattedRecord);

        }

        return formattedRecordsArray;
    }

    public static ArrayList<VariantCsvModel> formatCSVBus(ArrayList<String> stringArray) {

        /**
         * @param this method get other files csv (converted to ArrayList<String>) from resource\rozklady_2015-09-08_13.43.01
         * and set value to VariantCsvModel object
         * @return array with VariantCsvModel objects
         */
        ArrayList<VariantCsvModel> formattedRecordsArray = new ArrayList<VariantCsvModel>();

        for (int i = 1; i < stringArray.size(); i++) {
            String[] records = stringArray.get(i).split("\\;");
            VariantCsvModel formattedRecord = new VariantCsvModel();
            formattedRecord.setIdVariant(records[0]);
            formattedRecord.setFlags(records[1]);
            formattedRecord.setNameOfTheMunicipality(records[2]);
            formattedRecord.setNameOfBasStop(records[3]);

            formattedRecordsArray.add(formattedRecord);
        }
        return formattedRecordsArray;
    }
}

