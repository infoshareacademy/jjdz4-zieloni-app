package com.infoshareacademy.zieloni.Loaders;

import com.infoshareacademy.zieloni.Model.PathToCsvDTO;
import org.junit.Test;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;

public class CSVReaderTest {


    @Test
    public void csvReader_variant1() throws Exception {
        ArrayList<PathToCsvDTO> filePath = PathFinder.addAllFilesPathToArrayList("rozklady_2015-09-08_13.43.01");
        ArrayList<String> variant1RecordArray = CSVReader.readCSVfileAndConvertToRecordsArray(filePath.get(0).getVariant1());
        assertThat(variant1RecordArray).isNotEmpty();

    }

    @Test
    public void csvReader_variant2() throws Exception {
        ArrayList<PathToCsvDTO> filePath = PathFinder.addAllFilesPathToArrayList("rozklady_2015-09-08_13.43.01");
        ArrayList<String> variant2RecordArray = CSVReader.readCSVfileAndConvertToRecordsArray(filePath.get(0).getVariant2());
        assertThat(variant2RecordArray).isNotEmpty();

    }


    @Test
    public void csvReader_getCourse1() throws Exception {
        ArrayList<PathToCsvDTO> filePath = PathFinder.addAllFilesPathToArrayList("rozklady_2015-09-08_13.43.01");
        ArrayList<String> course1RecordArray = CSVReader.readCSVfileAndConvertToRecordsArray(filePath.get(0).getCourse1());
        assertThat(course1RecordArray).isNotEmpty();

    }

}