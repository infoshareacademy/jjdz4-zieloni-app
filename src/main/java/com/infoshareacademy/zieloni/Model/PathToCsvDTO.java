package com.infoshareacademy.zieloni.Model;

import lombok.Getter;
import lombok.Setter;

/**
 * path to files in folder rozklady_2015-09-08_13.43.01
 * Model dla scieżki która prowdzi do poszczególnych pilków w folderze rozklady_2015-09-08_13.43.01
 *
 * @see  com.infoshareacademy.zieloni.Loaders.PathFinder
 * @author Michał Stasiński
 */
/*
 * id - 124_20150905
 * folderName - rozklady_2015-09-08_13.43.01/124_20150905
 * course1 - rozklady_2015-09-08_13.43.01/N13_20140726/N13_20140726kursy1.csv
 * course2 - rozklady_2015-09-08_13.43.01/N13_20140726/N13_20140726kursy2.csv
 * description1 - rozklady_2015-09-08_13.43.01/N13_20140726/N13_20140726opisy1.csv
 * description2 - rozklady_2015-09-08_13.43.01/N13_20140726/N13_20140726opisy2.csv
 * variant1 - rozklady_2015-09-08_13.43.01/N13_20140726/N13_20140726warianty1.csv
 * variant2 -rozklady_2015-09-08_13.43.01/N13_20140726/N13_20140726warianty2.csv
 */

public class PathToCsvDTO {

    @Getter
    @Setter
    private String Id;

    @Getter
    @Setter
    private String folderName;

    @Getter
    @Setter
    private String course1;

    @Getter
    @Setter
    private String course2;

    @Getter
    @Setter
    private String description1;

    @Getter
    @Setter
    private String description2;

    @Getter
    @Setter
    private String variant1;

    @Getter
    @Setter
    private String variant2;


}
