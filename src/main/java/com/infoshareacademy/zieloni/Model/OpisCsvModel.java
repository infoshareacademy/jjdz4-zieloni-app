package com.infoshareacademy.zieloni.Model;

public class OpisCsvModel {

    private String idVariant;
    private String OrdinalNumberOfTheBarNumberStart;
    private String OrdinalNumberOfTheBarNumberEnd;
    private String theLetterSymbolGoesUp;
    private String fullDescription;

    public String getFullDescription() {
        return fullDescription;
    }

    public void setFullDescription(String fullDescription) {
        this.fullDescription = fullDescription;
    }

    public String getTheLetterSymbolGoesUp() {
        return theLetterSymbolGoesUp;
    }

    public void setTheLetterSymbolGoesUp(String theLetterSymbolGoesUp) {
        this.theLetterSymbolGoesUp = theLetterSymbolGoesUp;
    }

    public String getOrdinalNumberOfTheBarNumberEnd() {
        return OrdinalNumberOfTheBarNumberEnd;
    }

    public void setOrdinalNumberOfTheBarNumberEnd(String ordinalNumberOfTheBarNumberEnd) {
        OrdinalNumberOfTheBarNumberEnd = ordinalNumberOfTheBarNumberEnd;
    }

    public String getOrdinalNumberOfTheBarNumberStart() {
        return OrdinalNumberOfTheBarNumberStart;
    }

    public void setOrdinalNumberOfTheBarNumberStart(String ordinalNumberOfTheBarNumberStart) {
        OrdinalNumberOfTheBarNumberStart = ordinalNumberOfTheBarNumberStart;
    }

    public String getIdVariant() {
        return idVariant;
    }

    public void setIdVariant(String idVariant) {
        this.idVariant = idVariant;
    }
}
