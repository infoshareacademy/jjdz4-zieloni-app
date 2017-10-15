package com.infoshareacademy.zieloni;

import net.fortuna.ical4j.data.CalendarBuilder;
import net.fortuna.ical4j.data.ParserException;
import net.fortuna.ical4j.model.Calendar;
import net.fortuna.ical4j.model.Component;
import net.fortuna.ical4j.model.Property;

import java.io.FileInputStream;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;

public class Events {
    public ArrayList<Event> getEvents() {
        return events;
    }

    private ArrayList<Event> events = new ArrayList<>();

    public void loadEvents() throws IOException, ParserException, ParseException {
        FileInputStream icalFile = new FileInputStream("kalendarz.ics");
        CalendarBuilder builder = new CalendarBuilder();
        Calendar calendar = builder.build(icalFile);

        for (Iterator  i = calendar.getComponents().iterator(); i.hasNext();) {
            Component component = (Component) i.next();

            String eventStart = (String.valueOf(component.getProperty(Property.DTSTART).getValue().replace("T", "").replace("Z", "")));
            String eventEnd = (String.valueOf(component.getProperty(Property.DTEND).getValue().replace("T", "").replace("Z", "")));
            String eventLocation = (String.valueOf(component.getProperty(Property.LOCATION).getValue()));
            String eventUID = (String.valueOf(component.getProperty(Property.UID).getValue()));
            String eventSummary = (String.valueOf(component.getProperty(Property.SUMMARY).getValue()));
            add(eventStart, eventEnd, eventUID, eventLocation, eventSummary);
        }

    }

    public void add(String startTime, String endTime, String uid, String location, String summary) throws ParseException {
        SimpleDateFormat sf = new SimpleDateFormat("yyyyMMddHHmmss");
        events.add(new Event(sf.parse(startTime), sf.parse(endTime), uid, location, summary));
    }
}
