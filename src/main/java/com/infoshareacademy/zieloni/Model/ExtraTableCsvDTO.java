package com.infoshareacademy.zieloni.Model;

import lombok.Getter;
import lombok.Setter;

/**
 * Entity - data from tablela.csv
 * Model dla informacji zawartych w pilku tabela.csv
 *
 * @author Michal Stasiński
 */

public class ExtraTableCsvDTO {

    /**
     * nazwa katalogu z rozkładem, o którym napisano w punkcie 2.
     */
    @Getter
    @Setter
    private String id;

    /**
     * nazwa linii - informacja o rodzaju środka transportu (autobus, tramwaj, autobus nocny, tramwaj nocny, tramwaj wodny)
     */
    @Getter
    @Setter

    private String lineNr;

    /**
     * informacja o rodzaju środka transportu (autobus, tramwaj, autobus nocny, tramwaj nocny, tramwaj wodny)
     */
    @Getter
    @Setter
    private String typeOfTransport;

    /*
    * sformatowany przy pomocy kodu HTML i CSS opis trasy przejazdu pojazdów realizujących zadania przewozowe linii
    */
    @Getter
    @Setter
    private String infoAboutRouteInHTMLformat;

    /*- data rozpoczęcia obowiązywania rozkładu*/
    @Getter
    @Setter
    private String isValidFrom;

    /**
     * data zakończenia obowiązywania rozkładu. Pole puste oznacza nieokreśloną datę zakończenia obowiązywania.
     */
    @Getter
    @Setter
    private String isValidTo;

    /**
     * informacja o tym, czy wszystkie kursy linii są wykonywane pojazdami niskopodłogowymi (wartość „1”) czy nie („0”)
     */
    @Getter
    @Setter
    private boolean LowRider;

    /**
     * następne dwie kolumny zawierają sformatowane przy pomocy kodu HTML i CSS uwagi do rozkładu
     */
    @Getter
    @Setter
    private String commentsHTML0;

    @Getter
    @Setter
    private String commentsHTML1;
    /**
     * ostatnia kolumna zawiera informację o przewoźniku (lub przewoźnikach) realizującym kursy danej linii.
     */

    @Getter
    @Setter
    private String carrier;

}
