package com.infoshareacademy.zieloni;

import com.infoshareacademy.zieloni.database.BusDataBase;
import net.fortuna.ical4j.data.ParserException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.text.ParseException;

import static com.infoshareacademy.zieloni.Menu.startMenu;

public class App {

    private static Logger logger = LogManager.getLogger(App.class.getName());

    public static void main(String[] args) throws ParseException, ParserException, IOException, InterruptedException {

        logger.info("Start aplikacji");


        BusDataBase.createDataBase();


        startMenu();
    }
}
