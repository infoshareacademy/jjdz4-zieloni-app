package com.infoshareacademy.zieloni.Model;

import java.util.InputMismatchException;
import java.util.Scanner;

public class  ImputStreet {
    private  String odczyt;
    public String getOdczyt() {
        Scanner odczyt1= new Scanner(System.in);
        String odczyt= odczyt1.nextLine();
        return odczyt;
    }


}
