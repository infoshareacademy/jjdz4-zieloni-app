package com.infoshareacademy.zieloni;

import com.infoshareacademy.zieloni.model.Event;
import lombok.Getter;
import net.fortuna.ical4j.data.CalendarBuilder;
import net.fortuna.ical4j.data.ParserException;
import net.fortuna.ical4j.model.Calendar;
import net.fortuna.ical4j.model.Property;
import net.fortuna.ical4j.model.component.CalendarComponent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

import static com.infoshareacademy.zieloni.utils.ConsoleTools.*;

public class Events {

    @Getter
    private Map<LocalDate, ArrayList<Event>> eventsDB = new TreeMap<>();
    @Getter
    private Integer counter = 0;
    private final Logger logger = LoggerFactory.getLogger(Events.class.getName());

    public void loadEvents() throws ParserException, ParseException, InterruptedException {
        FileInputStream icalFile = null;
        try {
            logger.debug("Wczytywanie pliku iCal z kalendarzem zainicjowane");
            icalFile = new FileInputStream("kalendarz.ics");
        } catch (FileNotFoundException e) {
            logger.error("Wczytywanie pliku iCal zakończone niepowodzeniem - brak pliku!", e);
            printAlert("Kalendarz - brak pliku z wydarzeniami!");
            return;
        }
        CalendarBuilder builder = new CalendarBuilder();
        Calendar calendar = null;
        try {
            calendar = builder.build(icalFile);
        } catch (IOException e) {
            logger.error("Wczytywanie pliku iCal zakończone niepowodzeniem - błąd systemu I/O!", e);
            printAlert("Kalendarz - Błąd systemu I/O!");
            return;
        } catch (ParserException p) {
            logger.error("Wczytywanie pliku iCal zakończone niepowodzeniem - nieprawidłowy format danych!", p);
            printAlert("Kalendarz - nieprawidłowy format danych!");
            return;
        }
        for (CalendarComponent calendarComponent : calendar.getComponents()) {
            String eventStart = (String.valueOf(calendarComponent.getProperty(Property.DTSTART).getValue().replace("T", "").replace("Z", "")));
            String eventEnd = (String.valueOf(calendarComponent.getProperty(Property.DTEND).getValue().replace("T", "").replace("Z", "")));
            String eventLocation = (String.valueOf(calendarComponent.getProperty(Property.LOCATION).getValue()));
            String eventUID = (String.valueOf(calendarComponent.getProperty(Property.UID).getValue()));
            String eventSummary = (String.valueOf(calendarComponent.getProperty(Property.SUMMARY).getValue()));
            add(eventStart, eventEnd, eventUID, eventLocation, eventSummary);
            counter++;
        }
            logger.info("Wczytywanie pliku iCal zakończono pomyślnie. Dodano {} wydarzeń.", counter);
    }

    private void add(String startTime, String endTime, String uid, String location, String summary) {
        LocalDateTime sT = LocalDateTime.parse(startTime, DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));
        LocalDateTime eT = LocalDateTime.parse(endTime, DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));
        LocalDate stDateKey = sT.toLocalDate();

        if (eventsDB.containsKey(sT.toLocalDate())) {
            // Dodajemy wydarzenie do ArrayListy, gdy już w tym samym dniu jest inne wydarzenie
            ArrayList<Event> eD = eventsDB.get(stDateKey);
            eD.add(new Event(sT, eT, uid, location, summary));

            // Sortowanie wg godziny rozpoczęcia wydarzenia
            eD.sort((e1, e2) -> e1.getStartTime().compareTo(e2.getStartTime()));
            eventsDB.put(stDateKey, eD);
        } else {
            // Tworzymy nową arrayListę gdy w dniu nie ma jeszcze wydarzeń
            ArrayList<Event> eD = new ArrayList<>();
            eD.add(new Event(sT, eT, uid, location, summary));
            eventsDB.put(stDateKey, eD);
        }
    }
}