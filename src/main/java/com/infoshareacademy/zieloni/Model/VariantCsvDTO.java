package com.infoshareacademy.zieloni.Model;

public class VariantCsvDTO {
    private String idVariant;
    private String flags;
    private String nameOfTheMunicipality;
    private String nameOfBasStop;


  /*
    private String theColumnsInMinutesTravelTimeFromTheFirstLastNonBlankRow0;
    private String theColumnsInMinutesTravelTimeFromTheFirstLastNonBlankRow1;
    private String theColumnsInMinutesTravelTimeFromTheFirstLastNonBlankRow2;
    private String theColumnsInMinutesTravelTimeFromTheFirstLastNonBlankRow3;
    private String theColumnsInMinutesTravelTimeFromTheFirstLastNonBlankRow4;
    private String theColumnsInMinutesTravelTimeFromTheFirstLastNonBlankRow5;
    private String theColumnsInMinutesTravelTimeFromTheFirstLastNonBlankRow6;*/

    public String getIdVariant() {
        return idVariant;
    }

    public void setIdVariant(String idVariant) {
        this.idVariant = idVariant;
    }

    public String getFlags() {
        return flags;
    }

    public void setFlags(String flags) {
        this.flags = flags;
    }

    public String getNameOfTheMunicipality() {
        return nameOfTheMunicipality;
    }

    public void setNameOfTheMunicipality(String nameOfTheMunicipality) {
        this.nameOfTheMunicipality = nameOfTheMunicipality;
    }

    public String getNameOfBasStop() {
        return nameOfBasStop;
    }

    public void setNameOfBasStop(String nameOfBasStop) {
        this.nameOfBasStop = nameOfBasStop;
    }
}
