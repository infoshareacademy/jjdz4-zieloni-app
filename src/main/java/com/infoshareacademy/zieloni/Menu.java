package com.infoshareacademy.zieloni;

import com.infoshareacademy.zieloni.controller.TimeTableController;
import com.infoshareacademy.zieloni.database.BusDataBase;
import com.infoshareacademy.zieloni.model.Event;
import net.fortuna.ical4j.data.ParserException;

import java.io.IOException;
import java.text.ParseException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Set;

import static com.infoshareacademy.zieloni.utils.ConsoleTools.clearConsole;

class Menu {

    private static Events events = new Events();
    private static LocalDate selectedDate = null;
    private static Event selectedEvent = null;
    private static Event nextEvent = null;

    private Menu() {
    }

    static void startMenu() throws ParseException, ParserException, IOException, InterruptedException {
        events.loadEvents();

        displayMainMenu();
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            switch (scanner.nextLine().toLowerCase()) {
                case "1":
                    getDateFromUser();
                    getEventFromUser();
                    //TODO wywołaj metodę szukającą dojazdu

                    displayMainMenu();
                    break;
                case "2":

                    System.out.println(BusDataBase.getDataBase().size());

                    if (BusDataBase.getDataBase().size() > 0) {
                        TimeTableController.show();
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

    private static void displayMainMenu() {
        clearConsole();
        System.out.println("***** PLANER CLI v0.1 *****");
        System.out.println();
        System.out.println("Liczba wydarzeń w bazie: " + events.getCounter());
        System.out.println();
        System.out.println("1\tWyświetl dni z wydarzeniami");
        System.out.println("2\tWyświetl rozkład jazdy");
        System.out.println("EXIT\tWyjście z programu");
        System.out.println();
        System.out.print("Wpisz polecenie: ");
    }

    private static void getDateFromUser() {
        Set<LocalDate> keys = events.getEvents().keySet();
        LocalDate[] daysWithEvents = keys.toArray(new LocalDate[keys.size()]);

        displayDatesWithEventsMenu(daysWithEvents);

        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String command = scanner.nextLine().toLowerCase();

            if (command.equals("up")) {
                selectedDate = null;
                return;
            }
            Integer selectedNumber = null;
            try {
                selectedNumber = Integer.parseInt(command) - 1;
            } catch (NumberFormatException e) {
                displayDatesWithEventsMenu(daysWithEvents);
                continue;
            }
            if ((selectedNumber >= 0) && (selectedNumber < daysWithEvents.length)) {
                selectedDate = daysWithEvents[selectedNumber];
                return;
            } else {
                displayDatesWithEventsMenu(daysWithEvents);
            }
        }
    }

    private static void displayDatesWithEventsMenu(LocalDate[] daysWithEvents) {
        clearConsole();
        System.out.println("Masz zaplanowane wydarzenia w dniach:\n");
        for (int i = 0; i < daysWithEvents.length; i++) {
            System.out.println(i + 1 + ".\t" + daysWithEvents[i] +
                    " [" + events.getEvents().get(daysWithEvents[i]).size() + "]");
        }
        System.out.println("UP\tPowrót do menu głównego");
        System.out.println();
        System.out.print("Wybierz dzień: ");
    }

    private static void getEventFromUser() {
        if (selectedDate == null) return;

        ArrayList<Event> eventsInSelectedDate = events.getEvents().get(selectedDate);

        displayEventsFromDate(eventsInSelectedDate);

        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String command = scanner.nextLine().toLowerCase();
            if (command.equals("up")) {
                selectedDate = null;
                return;
            }
            Integer selectedNumber = null;
            try {
                selectedNumber = Integer.parseInt(command) - 1;
            } catch (NumberFormatException e) {
                displayEventsFromDate(eventsInSelectedDate);
                continue;
            }
            if ((selectedNumber >= 0) && (selectedNumber < eventsInSelectedDate.size())) {
                selectedEvent = eventsInSelectedDate.get(selectedNumber);
                nextEvent = selectedNumber + 1 < eventsInSelectedDate.size() ? eventsInSelectedDate.get(selectedNumber + 1) : null;
                return;
            } else {
                displayEventsFromDate(eventsInSelectedDate);
            }
        }
    }

    private static void displayEventsFromDate(ArrayList<Event> eventsFromDate) {
        clearConsole();
        System.out.println("W dniu: " + selectedDate + " masz zaplanowane wydarzenia:\n");
        for (int i = 0; i < eventsFromDate.size(); i++) {
            System.out.println(i + 1 + ".\tPoczątek:\t" + eventsFromDate.get(i).getStartTime().toLocalTime());
            System.out.println("\tKoniec:\t\t" + eventsFromDate.get(i).getEndTime().toLocalTime());
            System.out.println("\tOpis:\t\t" + eventsFromDate.get(i).getSummary());
            System.out.println("\tMiejsce:\t" + eventsFromDate.get(i).getLocation());
            System.out.println("----------------------------------------");
        }
        System.out.println("UP\tPowrót do menu głównego");
        System.out.println();
        System.out.print("Wybierz wydarzenie: ");
    }
}