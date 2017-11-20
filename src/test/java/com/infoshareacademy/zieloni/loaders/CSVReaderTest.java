package com.infoshareacademy.zieloni.loaders;

import com.infoshareacademy.zieloni.model.FilePathDTO;
import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CSVReaderTest {


    @Test
    public void csvReader_variant1() throws Exception {
        List<FilePathDTO> filePath = PathFinder.addAllFilesPathToArrayList("rozklady_2015-09-08_13.43.01");
        List<String> variant1RecordArray = CSVReader.convertFileToRecordsArray(filePath.get(0).getVariant1());
        assertThat(variant1RecordArray).isNotEmpty();

    }

    @Test
    public void csvReader_variant2() throws Exception {
        List<FilePathDTO> filePath = PathFinder.addAllFilesPathToArrayList("rozklady_2015-09-08_13.43.01");
        List<String> variant2RecordArray = CSVReader.convertFileToRecordsArray(filePath.get(0).getVariant2());
        assertThat(variant2RecordArray).isNotEmpty();

    }


    @Test
    public void csvReader_getCourse1() throws Exception {
        List<FilePathDTO> filePath = PathFinder.addAllFilesPathToArrayList("rozklady_2015-09-08_13.43.01");
        List<String> course1RecordArray = CSVReader.convertFileToRecordsArray(filePath.get(0).getCourse1());
        assertThat(course1RecordArray).isNotEmpty();

    }

}