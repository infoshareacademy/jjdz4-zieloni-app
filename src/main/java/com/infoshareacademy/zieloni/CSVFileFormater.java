package com.infoshareacademy.zieloni;

import com.infoshareacademy.zieloni.Model.TimeTableRecordWithExtraInfo;
import com.infoshareacademy.zieloni.Model.VariantCsvModel;

import java.util.ArrayList;

/**
 * @author Michal Stasiński
 */
public class CSVFileFormater {

    public static ArrayList<TimeTableRecordWithExtraInfo> formatCSVToTimeTableWithExtraInfoRecords(ArrayList<String> stringArray) {

        ArrayList<TimeTableRecordWithExtraInfo> formattedRecordsArray = new ArrayList<TimeTableRecordWithExtraInfo>();

        for (String filter : stringArray) {
            String[] records = filter.split("\\|");
            TimeTableRecordWithExtraInfo formattedRecord = new TimeTableRecordWithExtraInfo();
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

