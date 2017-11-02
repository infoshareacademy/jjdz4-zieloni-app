package com.infoshareacademy.zieloni;

import com.infoshareacademy.zieloni.Controller.TimeTableController;
import com.infoshareacademy.zieloni.DataBase.BusDataBase;
import net.fortuna.ical4j.data.ParserException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.text.ParseException;
import java.util.Scanner;

public class PlanerView {
    public static Scanner scanner = new Scanner(System.in);
    private static Logger logger = LogManager.getLogger(PlanerView.class.getName());

    public static void startMenu() throws ParseException, ParserException, IOException {

        String text;

        System.out.println("#################################################");
        System.out.println("#                PLANER WEEKENDU                #");
        System.out.println("#                                               #");
        System.out.println("#             Wpisz '1' WYDARZENIA              #");
        System.out.println("#             Wpisz '2' ROZKŁAD JAZDY           #");
        System.out.println("#             Wpisz '3' O AUTORACH              #");
        System.out.println("#                                               #");
        System.out.println("#       Wpisz 'exit' aby wyjść z programu       #");
        System.out.println("#################################################");

        while (PlanerView.scanner.hasNextLine()) {
            text = PlanerView.scanner.nextLine();

            if (text.equals("exit")) {
                System.out.println("koniec");
                break;
            } else if (text.equals("1")) {

                /*Wydarzenia*/
                Events events = new Events();
                events.loadEvents();
                Menu.displayEvents(events);
                Menu.displayDatesWithEvents(events);
                break;
            } else if (text.equals("2")) {
                /*Rozkład Jazdy*/
                if (BusDataBase.getDataBase().size() > 0) {
                    TimeTableController.show();
                } else {
                    logger.fatal("Baza danych jest pusta");
                }
                break;
            } else if (text.equals("3")) {
                System.out.println("TEAM ZIELONI\n");
                System.out.println("Adam Chudeusz");
                System.out.println("Adam Kosała");
                System.out.println("Marcin Kruszyński");
                System.out.println("Michał Stasiński");
                break;
            } else {
                System.out.println("Wybierz jedną z dostępnych opcji lub wpisz exit");
            }
        }
    }

}
