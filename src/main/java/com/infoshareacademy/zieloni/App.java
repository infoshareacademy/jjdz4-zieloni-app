package com.infoshareacademy.zieloni;

import com.infoshareacademy.zieloni.DataBase.BusDataBase;
import net.fortuna.ical4j.data.ParserException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.text.ParseException;
import java.util.Scanner;

import static com.infoshareacademy.zieloni.Menu.startMenu;

/**
 * Hello world!
 */
public class App {

    private static Logger logger = LogManager.getLogger(App.class.getName());

    public static void main(String[] args) throws ParseException, ParserException, IOException, InterruptedException {

        logger.info("Start aplikacji");

        /*tworzymy baze danych*/
        BusDataBase.DB = BusDataBase.createDataBase();
        startMenu();



       /* FindBusController.search("Sopot PKP", "Piastowska");
        String busNr = FindBusController.getProposedBusArr().get(0).getBus().getBusNumber();
        String type = FindBusController.getProposedBusArr().get(0).getBus().getTypeOfTransport();
        int wybranyWariant = FindBusController.getProposedBusArr().get(0).getVairiant();
        int id = FindBusController.getProposedBusArr().get(0).getId();

        System.out.println("Proponowany " + type + " nr: " + busNr);
        System.out.println(" wybrany wariant " +id);*/

    }
}
