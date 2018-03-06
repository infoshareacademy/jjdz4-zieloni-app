package com.infoshareacademy.zieloni.raport.dto;


import lombok.Data;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class User {

    private int id;
    private String name;
    private String surname;
    private int logCounter;
}
