package com.infoshareacademy.zieloni.Loaders;

import com.infoshareacademy.zieloni.Model.PathToCsvDTO;
import org.junit.Test;

import java.util.ArrayList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;

public class PathFinderTest {
    @Test
    public void addAllFilesPathToArrayList() throws Exception {

        ArrayList<PathToCsvDTO> filePath = PathFinder.addAllFilesPathToArrayList("rozklady_2015-09-08_13.43.01");
        assertThat(filePath).isNotEmpty();
    }

}