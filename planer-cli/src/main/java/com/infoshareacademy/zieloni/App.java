package com.infoshareacademy.zieloni;

import com.infoshareacademy.zieloni.database.BusDataBase;
import net.fortuna.ical4j.data.ParserException;

import java.io.IOException;
import java.text.ParseException;

import static com.infoshareacademy.zieloni.Menu.startMenu;

public class App {

    public static void main(String[] args) throws ParseException, ParserException, IOException, InterruptedException {

        BusDataBase database = new BusDataBase();
        database.createDataBase();

        startMenu();
    }
}
