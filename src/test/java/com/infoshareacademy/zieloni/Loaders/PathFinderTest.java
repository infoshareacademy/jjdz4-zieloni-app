package com.infoshareacademy.zieloni.Loaders;

import com.infoshareacademy.zieloni.Model.FilePathDTO;
import org.junit.Test;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;

public class PathFinderTest {
    @Test
    public void addAllFilesPathToArrayList() throws Exception {
        ArrayList<FilePathDTO> filePath = PathFinder.addAllFilesPathToArrayList("rozklady_2015-09-08_13.43.01");
        assertThat(filePath).isNotEmpty();
    }

}