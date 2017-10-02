package com.infoshareacademy.zieloni.Model;

/**
 * @author Michal Stasiński
 */


/* Model dla pliku tabela.csv*/
public class Additional_Info_Timetable {

    /*  - nazwa katalogu z rozkładem, o którym napisano w punkcie 2.*/
    private String id;

    /*- nazwa linii - informacja o rodzaju środka transportu (autobus, tramwaj, autobus nocny, tramwaj nocny, tramwaj wodny)*/
    private String lineNr;

    /* - sformatowany przy pomocy kodu HTML i CSS opis trasy przejazdu pojazdów realizujących zadania przewozowe linii*/
    private String infoAboutRouteInHTMLformat;

    /*- data rozpoczęcia obowiązywania rozkładu*/
    private int isValidFrom;

    /* - data zakończenia obowiązywania rozkładu. Pole puste oznacza nieokreśloną datę zakończenia obowiązywania.*/
    private int isValidTo;

    /* - informacja o tym, czy wszystkie kursy linii są wykonywane pojazdami niskopodłogowymi (wartość „1”) czy nie („0”)*/
    private Boolean isLowRider;

    /* - następne dwie kolumny zawierają sformatowane przy pomocy kodu HTML i CSS uwagi do rozkładu*/
    private String commentsHTML0;
    private String commentsHTML1;
    /* - ostatnia kolumna zawiera informację o przewoźniku (lub przewoźnikach) realizującym kursy danej linii.*/
    private String carrier;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLineNr() {
        return lineNr;
    }

    public void setLineNr(String lineNr) {
        this.lineNr = lineNr;
    }

    public String getInfoAboutRouteInHTMLformat() {
        return infoAboutRouteInHTMLformat;
    }

    public void setInfoAboutRouteInHTMLformat(String infoAboutRouteInHTMLformat) {
        this.infoAboutRouteInHTMLformat = infoAboutRouteInHTMLformat;
    }

    public int getIsValidFrom() {
        return isValidFrom;
    }

    public void setIsValidFrom(int isValidFrom) {
        this.isValidFrom = isValidFrom;
    }

    public int getIsValidTo() {
        return isValidTo;
    }

    public void setIsValidTo(int isValidTo) {
        this.isValidTo = isValidTo;
    }

    public Boolean getLowRider() {
        return isLowRider;
    }

    public void setLowRider(Boolean lowRider) {
        isLowRider = lowRider;
    }

    public String getCommentsHTML0() {
        return commentsHTML0;
    }

    public void setCommentsHTML0(String commentsHTML0) {
        this.commentsHTML0 = commentsHTML0;
    }

    public String getCommentsHTML1() {
        return commentsHTML1;
    }

    public void setCommentsHTML1(String commentsHTML1) {
        this.commentsHTML1 = commentsHTML1;
    }

    public String getCarrier() {
        return carrier;
    }

    public void setCarrier(String carrier) {
        this.carrier = carrier;
    }


}
