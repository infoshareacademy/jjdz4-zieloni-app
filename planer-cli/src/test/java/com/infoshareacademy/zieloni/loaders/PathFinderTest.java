package com.infoshareacademy.zieloni.loaders;

import com.infoshareacademy.zieloni.model.FilePathDTO;
import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class PathFinderTest {
    @Test
    public void addAllFilesPathToArrayList() throws Exception {
        List<FilePathDTO> filePath = PathFinder.addAllFilesPathToArrayList("rozklady_2015-09-08_13.43.01");
        assertThat(filePath).isNotEmpty();
    }

}