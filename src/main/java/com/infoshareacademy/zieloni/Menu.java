package com.infoshareacademy.zieloni;

import com.infoshareacademy.zieloni.Controller.FindBusController;

import java.time.LocalDate;

class Menu {

    /**
     * Clears linux console
     */
    static void clearConsole() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    /**
     * Displays all events passed in a collection
     *
     * @param events collection of events to display
     */
    static void displayEvents(Events events) {
        if (events.getEvents().size() != 0) {

            System.out.println("Znaleziono: " + events.getEvents().size() + " wydarzeń:");

            for (int i = 0; i < events.getEvents().size(); i++) {
                System.out.println("-----------------------------------------------------");
                System.out.println("Wydarzenie nr: " + i);
                System.out.println("Początek wydarzenia: \t" + events.getEvents().get(i).getStartTime());
                System.out.println("Koniec wydarzenia: \t\t" + events.getEvents().get(i).getEndTime());
                System.out.println("Miejsce wydarzenia: \t" + events.getEvents().get(i).getLocation());
                System.out.println("Opis wydarzenia: \t\t" + events.getEvents().get(i).getSummary());
                if (i + 1 < events.getEvents().size()) {
                    System.out.println("Na kolejne wydarzenie dojedziesz następującymi autobusami:");
                    FindBusController.search(events.getEvents().get(i).getLocation(), events.getEvents().get(i + 1).getLocation());
                } else {
                    System.out.println("To jest ostatnie wydarzenie");
                }
            }

            /*int i = 1;
            for (Event event: events.getEvents()) {
                System.out.println("-----------------------------------------------------");
                System.out.println("Wydarzenie nr: " + i);
                System.out.println("Początek wydarzenia: \t" + event.getStartTime().toString().replace("T", ", "));
                System.out.println("Koniec wydarzenia: \t" + event.getEndTime().toString().replace("T", ", "));
                System.out.println("Miejsce wydarzenia: \t" + event.getLocation());
                System.out.println("Opis wydarzenia: \t" + event.getSummary());
                i++;
            }*/
        } else {
            System.out.println("Nie znaleziono żadnego wydarzenia!");
        }
    }

    /**
     * Display
     *
     * @param events - kolekcja wydarzeń z których wyświetlamy daty wydarzeń
     */
    static void displayDatesWithEvents(Events events) {
        int i = 1;
        System.out.println("Masz zaplanowane wydarzenia w dniach:");
        for (LocalDate ld : events.getEventDays()) {
            System.out.println(i++ + ". " + ld + " (" + ld.getDayOfWeek() + ")");
        }
    }
}