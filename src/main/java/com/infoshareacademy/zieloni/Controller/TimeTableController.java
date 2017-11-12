package com.infoshareacademy.zieloni.Controller;

import com.infoshareacademy.zieloni.PlanerView;
import com.infoshareacademy.zieloni.View.TimeTableView;
import net.fortuna.ical4j.data.ParserException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.text.ParseException;


/**
 * @author Michal Stasiński
 */

/* mechanika przechodzenia menu miedzy widokami opcji 2 -"Rozkład jazdy"*/
public class TimeTableController {

    private static int level = 1;
    private static Logger logger = LogManager.getLogger(TimeTableController.class.getName());

    public static void show() throws ParseException, ParserException, IOException {

        String text;

        //TimeTableView.startMenu();
        TimeTableView.choiceBus("1");
        while (PlanerView.scanner.hasNextLine()) {
            text = PlanerView.scanner.nextLine();
            if (text.equals("exit")) {
                System.out.println("koniec");
                break;
            }

            if (text.equals("cofnij")) {
                level = 1;
                return;
                //PlanerView.startMenu();
                // System.out.println(level);

            } else {

                if (level == 1) {
                    try {
                        level = TimeTableView.choiceVariant(text);
                    } catch (Exception e) {

                        System.out.println("Wpisz nr srodka transportu");
                        logger.info("Użytkownik nie wpisał liczby w poziomie 2");
                    }

                } else if (level == 2) {
                    try {
                        level = TimeTableView.showVariantStreet(Integer.valueOf(text));
                    } catch (Exception e) {
                        System.out.println("Musisz wpisać liczbę");
                        logger.info("Użytkownik nie wpisał liczby w poziomie 3");
                    }
                } else if (level == 3) {
                    try {
                        level = TimeTableView.showTimesForBusStop(Integer.valueOf(text));
                    } catch (Exception e) {
                        System.out.println("Musisz wpisać liczbę");
                        logger.info("Użytkownik nie wpisał liczby w poziomie 4");
                    }
                } else if (level == 4) {
                    break;
                }
            }
        }
    }
}
