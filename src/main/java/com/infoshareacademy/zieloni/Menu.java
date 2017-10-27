package com.infoshareacademy.zieloni;

public class Menu {

    public static void displayEvents(Events events) {
        if (events.getEvents().size() != 0) {

            System.out.println("Znaleziono: " + events.getEvents().size() + " wydarzeń:");

            for (int i = 0; i <events.getEvents().size(); i++) {
                System.out.println("-----------------------------------------------------");
                System.out.println("Wydarzenie nr: " + i);
                System.out.println("Początek wydarzenia: \t" +events.getEvents().get(i).getStartTime());
                System.out.println("Koniec wydarzenia: \t\t" + events.getEvents().get(i).getEndTime());
                System.out.println("Miejsce wydarzenia: \t" +events.getEvents().get(i).getLocation());
                System.out.println("Opis wydarzenia: \t\t" +events.getEvents().get(i).getSummary());
                if(i+1<events.getEvents().size()) {
                    System.out.println("Na kolejne wydarzenie dojedziesz następującymi autobusami:");
                    SearchBus.search(events.getEvents().get(i).getLocation(), events.getEvents().get(i + 1).getLocation());
                }else{
                    System.out.println("To jest ostatnie wydarzenie");
                }
            }

            /*int i = 1;
            for (Event event: events.getEvents()) {
                System.out.println("-----------------------------------------------------");
                System.out.println("Wydarzenie nr: " + i);
                System.out.println("Początek wydarzenia: \t" + event.getStartTime());
                System.out.println("Koniec wydarzenia: \t\t" + event.getEndTime());
                System.out.println("Miejsce wydarzenia: \t" + event.getLocation());
                System.out.println("Opis wydarzenia: \t\t" + event.getSummary());
                i++;
            }*/
        } else {
            System.out.println("Nie znaleziono żadnego wydarzenia!");
        }
    }

}
