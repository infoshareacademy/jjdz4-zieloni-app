package com.infoshareacademy.zieloni;

import com.infoshareacademy.zieloni.Model.Event;
import lombok.Getter;
import net.fortuna.ical4j.data.CalendarBuilder;
import net.fortuna.ical4j.data.ParserException;
import net.fortuna.ical4j.model.Calendar;
import net.fortuna.ical4j.model.Property;
import net.fortuna.ical4j.model.component.CalendarComponent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

class Events {


    @Getter private ArrayList<Event> events = new ArrayList<>();

    /**
     * Set keeps dates with Events
     */
    private Set<LocalDate> eventDays = new HashSet<>();

//    ArrayList<Event> getEvents() {
//        return events;
//    }

    Set<LocalDate> getEventDays() {
        return eventDays;
    }

    void loadEvents() throws ParserException, ParseException {
        FileInputStream icalFile = null;
        try {
            icalFile = new FileInputStream("kalendarz.ics");
        } catch (FileNotFoundException e) {
            System.out.println("\n" +
                    "\u001B[31m" +
                    "Kalendarz - brak pliku z wydarzeniami!" +
                    "\u001B[30m" +
                    "\n");
            return;
        }
        CalendarBuilder builder = new CalendarBuilder();
        Calendar calendar = null;
        try {
            calendar = builder.build(icalFile);
        } catch (IOException e) {
            System.out.println("\n" +
                    "\u001B[31m" +
                    "Kalendarz - Błąd systemu I/O!" +
                    "\u001B[30m" +
                    "\n");
            return;
        } catch (ParserException p) {
            System.out.println("\n" +
                    "\u001B[31m" +
                    "Kalendarz - nieprawidłowy format danych!" +
                    "\u001B[30m" +
                    "\n");
            return;
        }

        for (CalendarComponent calendarComponent : calendar.getComponents()) {
            String eventStart = (String.valueOf(calendarComponent.getProperty(Property.DTSTART).getValue().replace("T", "").replace("Z", "")));
            String eventEnd = (String.valueOf(calendarComponent.getProperty(Property.DTEND).getValue().replace("T", "").replace("Z", "")));
            String eventLocation = (String.valueOf(calendarComponent.getProperty(Property.LOCATION).getValue()));
            String eventUID = (String.valueOf(calendarComponent.getProperty(Property.UID).getValue()));
            String eventSummary = (String.valueOf(calendarComponent.getProperty(Property.SUMMARY).getValue()));
            add(eventStart, eventEnd, eventUID, eventLocation, eventSummary);
        }
    }

    private void add(String startTime, String endTime, String uid, String location, String summary) throws ParseException {
        LocalDateTime sT = LocalDateTime.parse(startTime, DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));
        LocalDateTime eT = LocalDateTime.parse(endTime, DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));
        events.add(new Event(sT, eT, uid, location, summary));
        eventDays.add(sT.toLocalDate()); // Zbieramy daty w których pojawiają się Wydarzenia
    }
}
