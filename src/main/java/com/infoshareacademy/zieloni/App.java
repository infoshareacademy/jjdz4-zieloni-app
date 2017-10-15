package com.infoshareacademy.zieloni;

import net.fortuna.ical4j.data.ParserException;
import java.io.IOException;
import java.text.ParseException;

/**
 * Hello world!
 *
 */
public class App 
{

    public static void main( String[] args ) throws ParseException, ParserException, IOException {
        Events events = new Events();
        events.loadEvents();
        System.out.println(events.getEvents().size());
    }
}
