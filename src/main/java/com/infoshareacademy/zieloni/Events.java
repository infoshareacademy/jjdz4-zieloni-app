package com.infoshareacademy.zieloni;

import com.infoshareacademy.zieloni.model.Event;
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
import java.util.*;

import static com.infoshareacademy.zieloni.utils.ConsoleTools.*;

class Events {

    @Getter
    private Map<LocalDate, ArrayList<Event>> events = new TreeMap<>();
    @Getter
    private Integer counter = 0;

    // TODO Dodaj logowanie poniższych wyjątków
    void loadEvents() throws ParserException, ParseException, InterruptedException {
        FileInputStream icalFile = null;
        try {
            icalFile = new FileInputStream("kalendarz.ics");
        } catch (FileNotFoundException e) {
            printAlert("Kalendarz - brak pliku z wydarzeniami!");
            return;
        }
        CalendarBuilder builder = new CalendarBuilder();
        Calendar calendar = null;
        try {
            calendar = builder.build(icalFile);
        } catch (IOException e) {
            printAlert("Kalendarz - Błąd systemu I/O!");
            return;
        } catch (ParserException p) {
            printAlert("Kalendarz - nieprawidłowy format danych!");
            return;
        }
        // TODO Dodaj logowanie ilości wczytanych wydarzeń z kalendarza
        for (CalendarComponent calendarComponent : calendar.getComponents()) {
            String eventStart = (String.valueOf(calendarComponent.getProperty(Property.DTSTART).getValue().replace("T", "").replace("Z", "")));
            String eventEnd = (String.valueOf(calendarComponent.getProperty(Property.DTEND).getValue().replace("T", "").replace("Z", "")));
            String eventLocation = (String.valueOf(calendarComponent.getProperty(Property.LOCATION).getValue()));
            String eventUID = (String.valueOf(calendarComponent.getProperty(Property.UID).getValue()));
            String eventSummary = (String.valueOf(calendarComponent.getProperty(Property.SUMMARY).getValue()));
            add(eventStart, eventEnd, eventUID, eventLocation, eventSummary);
            counter++;
        }
    }

    private void add(String startTime, String endTime, String uid, String location, String summary) {
        LocalDateTime sT = LocalDateTime.parse(startTime, DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));
        LocalDateTime eT = LocalDateTime.parse(endTime, DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));
        LocalDate stDateKey = sT.toLocalDate();

        if (events.containsKey(sT.toLocalDate())) {
            // Dodajemy wydarzenie do ArrayListy, gdy już w tym samym dniu jest inne wydarzenie
            ArrayList<Event> eD = events.get(stDateKey);
            eD.add(new Event(sT, eT, uid, location, summary));

            // Sortowanie wg godziny rozpoczęcia wydarzenia
            eD.sort((e1, e2) -> e1.getStartTime().compareTo(e2.getStartTime()));
            events.put(stDateKey, eD);
        } else {
            // Tworzymy nową arrayListę gdy w dniu nie ma jeszcze wydarzeń
            ArrayList<Event> eD = new ArrayList<>();
            eD.add(new Event(sT, eT, uid, location, summary));
            events.put(stDateKey, eD);
        }
    }
}