package com.infoshareacademy.zieloni.database;

import com.infoshareacademy.zieloni.loaders.CSVFileParser;
import com.infoshareacademy.zieloni.loaders.CSVReader;
import com.infoshareacademy.zieloni.loaders.PathFinder;
import com.infoshareacademy.zieloni.model.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class BusDataBase {

    private static Logger logger = LogManager.getLogger(BusDataBase.class.getName());

    private BusDataBase() {
    }

    public static List<BusDTO> getBusDataBase() {
        return busDataBase;
    }

    private static List<BusDTO> busDataBase;

    public static List<BusDTO> createDataBase() {
        busDataBase = new ArrayList<>();

        List<FilePathDTO> filePaths = PathFinder.addAllFilesPathToArrayList("rozklady_2015-09-08_13.43.01");

        filePaths.sort((o1, o2) -> {
            String s1 = o1.getId();
            String s2 = o2.getId();
            return s1.compareToIgnoreCase(s2);
        });

        List<String> extraTabel = CSVReader.readCSVfileAndConvertToRecordsArray("tabela.csv");
        List<ExtraTableCsvDTO> tabelaCSVArray = CSVFileParser.formatCSVToTimeTableWithExtraInfoRecords(extraTabel);

        tabelaCSVArray.sort((o1, o2) -> {
            String s1 = o1.getId();
            String s2 = o2.getId();
            return s1.compareToIgnoreCase(s2);
        });

        try {
            for (int i = 0; i < filePaths.size() ; i++) {
                FilePathDTO file = filePaths.get(i);

                List<String> variant1RecordArray = CSVReader.readCSVfileAndConvertToRecordsArray(file.getVariant1());
                List<RecordVariantDTO> variant1 = CSVFileParser.formatVarinatCSV(variant1RecordArray);
                List<String> course1RecordArray = CSVReader.readCSVfileAndConvertToRecordsArray(file.getCourse1());
                List<RecordCourseDTO> course1 = CSVFileParser.formatCourseCSV(course1RecordArray);
                Map<String, List<String>> map1 = CSVFileParser.columns_X0XX_Map(variant1RecordArray);

                List<String> variant2RecordArray = CSVReader.readCSVfileAndConvertToRecordsArray(file.getVariant2());
                List<RecordVariantDTO> variant2 = CSVFileParser.formatVarinatCSV(variant2RecordArray);
                List<String> course2RecordArray = CSVReader.readCSVfileAndConvertToRecordsArray(file.getCourse2());
                List<RecordCourseDTO> course2 = CSVFileParser.formatCourseCSV(course2RecordArray);
                Map<String, List<String>> map2 = CSVFileParser.columns_X0XX_Map(variant2RecordArray);


                BusDTO bus = new BusDTO();

                bus.setBusStops_v1(variant1);
                bus.setBusStops_v2(variant2);
                bus.setCourseRecords_v1(course1);
                bus.setCourseRecords_v2(course2);
                bus.setColumnsMap_v1(map1);
                bus.setColumnsMap_v2(map2);
                bus.setBusNumber(file.getId().split("_")[0]);
                bus.setTypeOfTransport(tabelaCSVArray.get(i).getTypeOfTransport());
                busDataBase.add(bus);
            }

            logger.info("Dane zostały  załadowane");

        } catch (Exception e) {
            logger.fatal("Brak folderu z danymi");
        }
        return busDataBase;
    }
}


