package com.infoshareacademy.zieloni.admin.raport.dto;


import lombok.Data;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserActivity {

    private int id;
    private int age;
    private String name;
    private String surname;
    private String logTime;
    private String activity;
    private String login;
    private String gender;
}
