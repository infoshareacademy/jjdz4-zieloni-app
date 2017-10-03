package com.infoshareacademy.zieloni;

import com.infoshareacademy.zieloni.Model.TimeTableRecordWithExtraInfo;

import java.util.ArrayList;

/**
 * @author Michal Stasiński
 */
public class CSVFileFormater {

    public static ArrayList<TimeTableRecordWithExtraInfo> formatCSVToTimeTableWithExtraInfoRecords(ArrayList<String> stringArray) {

        ArrayList<TimeTableRecordWithExtraInfo> formattedRecordsArray = new ArrayList<TimeTableRecordWithExtraInfo>();

        for (String filer : stringArray) {
            String[] records = filer.split("\\|");
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
}

