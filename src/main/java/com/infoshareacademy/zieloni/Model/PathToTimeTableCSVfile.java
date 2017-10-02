package com.infoshareacademy.zieloni.Model;

/**
 * @author Michał Stasiński
 */


/* Model do sciezek w folderze z rozkładami jazdy csv*/

public class PathToTimeTableCSVfile {

    private String Id;
    private int isValidFrom;
    private int isValidTo;

    private String folderName;

    private String course1;
    private String course2;

    private String description1;
    private String description2;

    private String variant1;
    private String variant2;


    public String getId() {
        return Id;
    }

    public int getIsValidFrom() {
        int data = Integer.parseInt(getId().split("_")[1]);
        return data;
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

    public void setId(String id) {
        Id = id;
    }

    public String getFolderName() {
        return folderName;
    }

    public void setFolderName(String folderName) {
        this.folderName = folderName;
    }

    public String getCourse1() {
        return course1;
    }

    public void setCourse1(String course1) {
        this.course1 = course1;
    }

    public String getCourse2() {
        return course2;
    }

    public void setCourse2(String course2) {
        this.course2 = course2;
    }

    public String getDescription1() {
        return description1;
    }

    public void setDescription1(String description1) {
        this.description1 = description1;
    }

    public String getDescription2() {
        return description2;
    }

    public void setDescription2(String description2) {
        this.description2 = description2;
    }

    public String getVariant1() {
        return variant1;
    }

    public void setVariant1(String variant1) {
        this.variant1 = variant1;
    }

    public String getVariant2() {
        return variant2;
    }

    public void setVariant2(String variant2) {
        this.variant2 = variant2;
    }

}
