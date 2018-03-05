package com.infoshareacademy.zieloni.dto;


import lombok.Data;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class User {

    private int id;
    private String  name;
    private String  surname;
    private Credentials  credentials;;
}
