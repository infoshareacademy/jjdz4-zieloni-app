package com.infoshareacademy.zieloni.database;

import com.infoshareacademy.zieloni.loaders.CSVFileParser;
import com.infoshareacademy.zieloni.loaders.CSVReader;
import com.infoshareacademy.zieloni.loaders.PathFinder;
import com.infoshareacademy.zieloni.model.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class BusDataBase {

    public static List<BusDTO> getDataBase() {
        return dataBase;
    }
    private final Logger logger = LoggerFactory.getLogger(BusDataBase.class.getName());
    private static List<BusDTO> dataBase = new ArrayList<>();


    public List<BusDTO> createDataBase() {

        List<FilePathDTO> filePaths = PathFinder.addAllFilesPathToArrayList("rozklady_2015-09-08_13.43.01");

        filePaths.sort((o1, o2) -> {
            String s1 = o1.getId();
            String s2 = o2.getId();
            return s1.compareToIgnoreCase(s2);
        });

        List<String> extraTabel = CSVReader.convertFileToRecordsArray("tabela.csv");
        List<ExtraTableCsvDTO> tabelaCSVArray = CSVFileParser.formatCSVToTimeTableWithExtraInfoRecords(extraTabel);

        tabelaCSVArray.sort((o1, o2) -> {
            String s1 = o1.getId();
            String s2 = o2.getId();
            return s1.compareToIgnoreCase(s2);
        });

        try {
            for (int i = 0; i < filePaths.size(); i++) {
                FilePathDTO file = filePaths.get(i);

                List<String> variant1RecordArray = CSVReader.convertFileToRecordsArray(file.getVariant1());
                List<RecordVariantDTO> variant1 = CSVFileParser.formatVarinatCSV(variant1RecordArray);
                List<String> course1RecordArray = CSVReader.convertFileToRecordsArray(file.getCourse1());
                List<RecordCourseDTO> course1 = CSVFileParser.formatCourseCSV(course1RecordArray);
                Map<String, List<String>> map1 = CSVFileParser.columnsMap(variant1RecordArray);

                List<String> variant2RecordArray = CSVReader.convertFileToRecordsArray(file.getVariant2());
                List<RecordVariantDTO> variant2 = CSVFileParser.formatVarinatCSV(variant2RecordArray);
                List<String> course2RecordArray = CSVReader.convertFileToRecordsArray(file.getCourse2());
                List<RecordCourseDTO> course2 = CSVFileParser.formatCourseCSV(course2RecordArray);
                Map<String, List<String>> map2 = CSVFileParser.columnsMap(variant2RecordArray);

                BusDTO bus = new BusDTO();

                bus.setBusStopsV1(variant1);
                bus.setBusStopsV2(variant2);
                bus.setCourseRecordsV1(course1);
                bus.setCourseRecordsV2(course2);
                bus.setColumnsMapV1(map1);
                bus.setColumnsMapV2(map2);
                bus.setBusNumber(file.getId().split("_")[0]);
                bus.setTypeOfTransport(tabelaCSVArray.get(i).getTypeOfTransport());

              //  System.out.println("INSERT INTO bus (id,name,type,status) VALUES (null,'"+bus.getBusNumber()+"','"+bus.getTypeOfTransport()+"',"+"'0');");
                dataBase.add(bus);
            }

            logger.info("Dane zostały załadowane");

        } catch (Exception e) {
            logger.error("Brak folderu z danymi", e);
        }
        return dataBase;
    }
}


