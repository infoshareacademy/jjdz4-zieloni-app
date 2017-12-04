package com.infoshareacademy.zieloni;

import com.infoshareacademy.zieloni.controller.FindBusController;
import com.infoshareacademy.zieloni.controller.FindBusWithChangeController;
import com.infoshareacademy.zieloni.controller.TimeTableController;
import com.infoshareacademy.zieloni.database.BusDataBase;
import com.infoshareacademy.zieloni.model.ChangeConnectionDTO;
import com.infoshareacademy.zieloni.model.Event;
import com.infoshareacademy.zieloni.model.ProposedBusDTO;
import com.infoshareacademy.zieloni.utils.TimeLimiter;
import net.fortuna.ical4j.data.ParserException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Set;

import static com.infoshareacademy.zieloni.utils.ConsoleTools.clearConsole;

@SuppressWarnings({"squid:S106"})
class Menu {

    private static Events events = new Events();
    private static LocalDate selectedDate = null;
    private static Event selectedEvent = null;
    private static Event nextEvent = null;

    private Menu() {
    }

    static void startMenu() throws ParseException, ParserException, IOException, InterruptedException {
        final Logger logger = LoggerFactory.getLogger(Menu.class.getName());

        events.loadEvents();

        displayMainMenu();
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            switch (scanner.nextLine().toLowerCase()) {
                case "1":
                    getDateFromUser();
                    getEventFromUser();


                    if (nextEvent != null) {
                        FindBusController.search(selectedEvent.getLocation().toString(), nextEvent.getLocation().toString());
                        LocalTime endEventTime = selectedEvent.getEndTime().toLocalTime();
                        LocalTime startEventTime = nextEvent.getStartTime().toLocalTime();


                        if (FindBusController.getProposedBusArr().size() > 0) {
                            ProposedBusDTO bus = FindBusController.getProposedBusArr().get(0);
                            TimeLimiter showTime = new TimeLimiter(endEventTime, startEventTime, bus);
                        } else {
                            FindBusWithChangeController.search(selectedEvent.getLocation().toString(), nextEvent.getLocation().toString());

                            ChangeConnectionDTO bus = FindBusWithChangeController.getChangeConnectionArray().get(0);
                            System.out.println("Proponowanie połacznie  to  " + bus.getBus0().getTypeOfTransport() +
                                    " nr : " + bus.getBus0().getBusNumber() + " przesiadka na przystanku " + bus.getConnectionBusStop()
                                    + " w " + bus.getBus1().getTypeOfTransport() + " nr : " + bus.getBus1().getBusNumber());
                        }
                    } else {
                        System.out.println("To ostatnie wydarznie");
                    }
                    Thread.sleep(10000);
                    displayMainMenu();
                    break;
                case "2":

                    System.out.println(BusDataBase.getDataBase().size());

                    if (BusDataBase.getDataBase().size() > 0) {
                        TimeTableController.show();
                    } else {
                        logger.error("Baza danych jest pusta");
                    }
                    displayMainMenu();
                    break;
                case "3":
                    break;
                case "exit":
                    logger.debug("Użytkownik zakończył działanie aplikacji PLANER-CLI");
                    return;
                default:
                    displayMainMenu();
                    break;
            }
        }
    }

    private static void displayMainMenu() {
        clearConsole();
        System.out.println("***** PLANER CLI v0.2 *****");
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
        Set<LocalDate> keys = events.getEventsDB().keySet();
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
                    " [" + events.getEventsDB().get(daysWithEvents[i]).size() + "]");
        }
        System.out.println("UP\tPowrót do menu głównego");
        System.out.println();
        System.out.print("Wybierz dzień: ");
    }

    private static void getEventFromUser() {
        if (selectedDate == null) return;

        ArrayList<Event> eventsInSelectedDate = events.getEventsDB().get(selectedDate);

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