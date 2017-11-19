package com.infoshareacademy.zieloni.Model;

import lombok.Getter;
import lombok.Setter;


/**
 *  99;Codziennie;#EEEEEE
 *  23:26;X0;;
 *  24:26;X1;
 *
 *  departureTime - 23:26;
 *  courseX0_XX - X1
 *
 */
public class RecordCourseDTO {
    @Getter
    @Setter
    private String departureTime;

    @Getter
    @Setter
    private String courseX0_XX;
}
