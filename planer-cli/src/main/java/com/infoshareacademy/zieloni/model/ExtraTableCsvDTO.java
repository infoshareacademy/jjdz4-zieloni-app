package com.infoshareacademy.zieloni.model;

import lombok.Data;

/**
 * model dla informacji zawartych w pilku tabela.csv
 */
@Data
public class ExtraTableCsvDTO {

    private String id;
    private String lineNr;
    private String typeOfTransport;
    private String infoAboutRouteInHTMLformat;
    private String isValidFrom; /*- data rozpoczęcia obowiązywania rozkładu*/
    private String isValidTo;
    private boolean lowRider;
    private String commentsHTML0;
    private String commentsHTML1;
    private String carrier;

}
