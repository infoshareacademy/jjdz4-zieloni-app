package com.infoshareacademy.zieloni.Controller;

import com.infoshareacademy.zieloni.Menu;
import com.infoshareacademy.zieloni.Utils.IsBusExist;
import com.infoshareacademy.zieloni.View.TimeTableView;
import net.fortuna.ical4j.data.ParserException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.text.ParseException;


/* mechanika przechodzenia menu miedzy widokami opcji 2 -"Rozkład jazdy"*/
public class TimeTableController {

    private static int level = 1;
    private static Logger logger = LogManager.getLogger(TimeTableController.class.getName());

    public static void show() throws ParseException, ParserException, IOException {
        System.out.println("show");
        String text;
        //TimeTableView.startMenu();
        TimeTableView.selectBus();

        while (Menu.scanner.hasNextLine()) {
            text = Menu.scanner.nextLine();
            if (text.equals("exit")) {
                System.out.println("koniec");
                break;
            }

            if (text.equals("cofnij")) {
                level = 1;
                return;

            } else {

                if (level == 1) {
                    try {
                        if (IsBusExist.check(text)[0] == 1) {
                            level = TimeTableView.selectVariant(text);
                        } else {
                            System.out.println("Nie ma takiego srodka transportu");
                        }

                    } catch (Exception e) {

                        System.out.println("Wpisz nr srodka transportu");
                        logger.info("Użytkownik nie wpisał liczby w poziomie 2");
                    }

                } else if (level == 2) {
                    try {
                        if (text.toString().equals("1") || text.toString().equals("2")) {
                            level = TimeTableView.showVariantStreet(Integer.valueOf(text));
                        } else {
                            System.out.println("Wybierz od 1 do 2");
                        }
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
