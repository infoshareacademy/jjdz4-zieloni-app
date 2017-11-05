package com.infoshareacademy.zieloni.Loaders;

import com.infoshareacademy.zieloni.DataBase.BusDataBase;
import com.infoshareacademy.zieloni.Model.PathToCsvDTO;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;

public class CSVReaderTest {

    /*@BeforeClass
    public static void csvReader_filePathExist() throws Exception {
        assertThat(BusDataBase.folder).exists();
    }

    @Test
    public void csvReader_variant1() throws Exception {
        ArrayList<PathToCsvDTO> filePath = PathFinder.addAllFilesPathToArrayList(BusDataBase.folder);
        for (int i = 0; i < filePath.size(); i++) {
            ArrayList<String> result = CSVReader.readCSVfileAndConvertToRecordsArray(filePath.get(i).getVariant1());
            assertThat(result).isNotEmpty();
        }
    }

    @Test
    public void csvReader_variant2() throws Exception {
        ArrayList<PathToCsvDTO> filePath = PathFinder.addAllFilesPathToArrayList(BusDataBase.folder);
        for (int i = 0; i < filePath.size(); i++) {
            ArrayList<String> result = CSVReader.readCSVfileAndConvertToRecordsArray(filePath.get(i).getVariant2());
            assertThat(result).isNotEmpty();
        }

    }

    @Test
    public void csvReader_course1() throws Exception {
        ArrayList<PathToCsvDTO> filePath = PathFinder.addAllFilesPathToArrayList(BusDataBase.folder);
        for (int i = 0; i < filePath.size(); i++) {
            ArrayList<String> result = CSVReader.readCSVfileAndConvertToRecordsArray(filePath.get(i).getCourse1());
            assertThat(result).isNotEmpty();
        }

    }

    @Test
    public void csvReader_course2() throws Exception {
        ArrayList<PathToCsvDTO> filePath = PathFinder.addAllFilesPathToArrayList(BusDataBase.folder);
        for (int i = 0; i < filePath.size(); i++) {
            ArrayList<String> result = CSVReader.readCSVfileAndConvertToRecordsArray(filePath.get(i).getCourse2());
            assertThat(result).isNotEmpty();
        }

    }*/

}