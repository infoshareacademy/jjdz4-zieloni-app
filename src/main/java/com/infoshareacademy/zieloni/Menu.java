package com.infoshareacademy.zieloni;

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

            int i = 1;
            for (Event event: events.getEvents()) {
                System.out.println("-----------------------------------------------------");
                System.out.println("Wydarzenie nr: " + i);
                System.out.println("Początek wydarzenia: \t" + event.getStartTime().toString().replace("T", ", "));
                System.out.println("Koniec wydarzenia: \t" + event.getEndTime().toString().replace("T", ", "));
                System.out.println("Miejsce wydarzenia: \t" + event.getLocation());
                System.out.println("Opis wydarzenia: \t" + event.getSummary());
                i++;
            }
        } else {
            System.out.println("Nie znaleziono żadnego wydarzenia!");
        }
    }

}