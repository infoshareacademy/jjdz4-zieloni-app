package com.infoshareacademy.zieloni;

import com.infoshareacademy.zieloni.Controller.TimeTableController;
import com.infoshareacademy.zieloni.DataBase.BusDataBase;
import net.fortuna.ical4j.data.ParserException;

import java.io.IOException;
import java.text.ParseException;
import com.infoshareacademy.zieloni.Controller.FindBusController;

import java.time.LocalDate;
import java.util.Scanner;

class Menu {

    static void startMenu() throws ParseException, ParserException, IOException, InterruptedException {
        Events events = new Events();
        events.loadEvents();

        displayMainMenu();
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            switch (scanner.nextLine().toLowerCase()) {
                case "1":
//                    displayDatesWithEvents(events);
                    displayEvents(events);
                    break;
                case "2":
                    /*Rozkład Jazdy*/
                    if (BusDataBase.DB.size() > 0) {
                        //TimeTableController.show();
                    } else {
                        //logger.fatal("Baza danych jest pusta");
                   }
                    displayMainMenu();
                    break;
                case "3":
                    break;
                case "exit":
                    return;
                default:
                    displayMainMenu();
                    break;
            }
        }
    }

    static void displayMainMenu() {
        clearConsole();
        System.out.println("*** PLANER CLI ***");
        System.out.println();
        System.out.println("1\tWyświetl dni z wydarzeniami");
        System.out.println("2\tWyświetl rozkład jazdy");
//        System.out.println("3\tWczytaj plik z kalendarzem");
        System.out.println("EXIT\tWyjście z programu");
        System.out.println();
        System.out.print("Wpisz polecenie: ");
    }


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
    static void displayEvents(Events events) throws InterruptedException {
        if (events.getEvents().size() != 0) {

            clearConsole();
            System.out.println("Znaleziono: " + events.getEvents().size() + " wydarzeń:");

            for (int i = 0; i < events.getEvents().size(); i++) {
                System.out.println("-----------------------------------------------------");
                System.out.println("Wydarzenie nr: " + i + 1);
                System.out.println("Początek wydarzenia: \t" + events.getEvents().get(i).getStartTime().toString().replace("T",", "));
                System.out.println("Koniec wydarzenia: \t" + events.getEvents().get(i).getEndTime().toString().replace("T",", "));
                System.out.println("Miejsce wydarzenia: \t" + events.getEvents().get(i).getLocation());
                System.out.println("Opis wydarzenia: \t" + events.getEvents().get(i).getSummary());
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
            System.out.println("\n" +
                    "\u001B[31m" +
                    "Nie znaleziono żadnego wydarzenia!" +
                    "\u001B[0m" +
                    "\n");
            Thread.sleep(3000);
        }
    }

    /**
     * Display
     *
     * @param events - kolekcja wydarzeń z których wyświetlamy daty wydarzeń
     */
    static void displayDatesWithEvents(Events events) {
        System.out.println("Masz zaplanowane wydarzenia w dniach:");
        LocalDate eventDays[] = events.getEventDays().toArray(new LocalDate[(events.getEventDays().size())]);
//        for (LocalDate ld : events.getEventDays()) {
//            System.out.println(i++ + ". " + ld + " (" + ld.getDayOfWeek() + ")");
        for (int i = 0; i < eventDays.length; i++) {
            System.out.println(i+1 + "\t" + eventDays[i] + " (" + eventDays[i].getDayOfWeek() + ")");
        }
        System.out.println("UP\tPowrót do menu głównego");
        System.out.println();
        System.out.print("Wpisz polecenie: ");

        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            switch (scanner.nextLine()) {

                case "UP":
                    return;
                default:
                    break;
            }
        }
    }
}