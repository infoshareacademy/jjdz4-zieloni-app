package com.infoshareacademy.zieloni;

public class Menu {

    public static void displayEvents(Events events) {
        if (events.getEvents().size() != 0) {

            System.out.println("Znaleziono: " + events.getEvents().size() + " wydarzeń:");

            int i = 1;
            for (Event event: events.getEvents()) {
                System.out.println("-----------------------------------------------------");
                System.out.println("Wydarzenie nr: " + i);
                System.out.println("Początek wydarzenia: \t" + event.getStartTime());
                System.out.println("Koniec wydarzenia: \t\t" + event.getEndTime());
                System.out.println("Miejsce wydarzenia: \t" + event.getLocation());
                System.out.println("Opis wydarzenia: \t\t" + event.getSummary());
                i++;
            }
        } else {
            System.out.println("Nie znaleziono żadnego wydarzenia!");
        }
    }

}
