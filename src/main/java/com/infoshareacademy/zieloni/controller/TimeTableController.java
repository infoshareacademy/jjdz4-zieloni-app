package com.infoshareacademy.zieloni.controller;

import com.infoshareacademy.zieloni.Menu;
import com.infoshareacademy.zieloni.utils.IsBusExist;
import com.infoshareacademy.zieloni.view.TimeTableView;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class TimeTableController {

    private static int level = 1;
    private static Logger logger = LogManager.getLogger(TimeTableController.class.getName());

    public static void show() {
        String text;
        TimeTableView.selectBus();
        while (Menu.scanner.hasNextLine()) {
            text = Menu.scanner.nextLine();
            if (text.equals("exit")) {
                logger.info("koniec");
                break;
            }
            if (text.equals("cofnij")) {
                level = 1;
                return;

            } else {
                swithToLevel(text);
            }
        }
    }

    private static void swithToLevel(String text) {
        if (level == 1) {
            levelOne(text);
        } else if (level == 2) {
            levelTwo(text);
        } else if (level == 3) {
            levelThree(text);
        }
    }

    private static void levelThree(String text) {
        try {
            level = TimeTableView.showTimesForBusStop(Integer.valueOf(text));
        } catch (Exception e) {
            logger.info("Musisz wpisać liczbę");
            logger.info("Użytkownik nie wpisał liczby w poziomie 4");
        }
    }

    private static void levelTwo(String text) {
        try {
            if (text.equals("1") || text.equals("2")) {
                level = TimeTableView.showVariantStreet(Integer.valueOf(text));
            } else {
                logger.info("Wybierz od 1 do 2");
            }
        } catch (Exception e) {
            logger.info("Musisz wpisać liczbę");
        }
    }

    private static void levelOne(String text) {
        try {
            if (IsBusExist.check(text)[0] == 1) {
                level = TimeTableView.selectVariant(text);
            } else {
                logger.info("Nie ma takiego srodka transportu");
            }

        } catch (Exception e) {
            logger.info("Wpisz nr srodka transportu");
            logger.info("Użytkownik nie wpisał liczby w poziomie 2");
        }
    }
}
