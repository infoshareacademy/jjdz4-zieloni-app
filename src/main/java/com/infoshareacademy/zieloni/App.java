package com.infoshareacademy.zieloni;

import net.fortuna.ical4j.data.ParserException;

import java.io.IOException;
import java.text.ParseException;
import java.util.logging.Logger;

import static com.infoshareacademy.zieloni.Menu.startMenu;

/**
 * Hello world!
 */
public class App {

    Logger logger = Logger.getLogger(App.class.getName());

    public static void main(String[] args) throws ParseException, ParserException, IOException, InterruptedException {

        startMenu();

    }
}
