package com.infoshareacademy.zieloni.Model;

import lombok.Getter;
import lombok.Setter;

/**
 *  Pojedynczy record t tabeli warianty.csv
 *
 *  N2;Flagi;Gmina;Nazwa;X3(00:00-29:59);X4(00:00-29:59);X5(00:00-29:59)
 *  1;B,P(125);ZTM;Nowy Port Szaniec Zachodni;;0;0

 * idVariant - numer porzadkowy;
 * flags - B,P(125);
 * community - ZTM;
 * nameOfBusStop- Nowy Port Szaniec Zachodni;
 *
 */
public class RecordVariantDTO {

    @Getter
    @Setter
    private String idVariant;

    @Getter
    @Setter
    private String flags;

    @Getter
    @Setter
    private String community;

    @Getter
    @Setter
    private String nameOfBusStop;

}


