package com.infoshareacademy.zieloni.Model;

import lombok.Getter;
import lombok.Setter;

/**
 * Entity - path to files in folder rozklady_2015-09-08_13.43.01
 * Model dla scieżki która prowdzi do poszczególnych pilków w folderze rozklady_2015-09-08_13.43.01
 *
 * @author Michał Stasiński
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
