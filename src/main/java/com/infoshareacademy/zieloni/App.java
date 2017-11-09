package com.infoshareacademy.zieloni;

import com.infoshareacademy.zieloni.Controller.FindBusController;
import com.infoshareacademy.zieloni.Controller.FindBusInterchangesController;
import com.infoshareacademy.zieloni.Model.BusDTO;
import com.infoshareacademy.zieloni.Model.ProposedBusDTO;
import net.fortuna.ical4j.data.ParserException;

import java.io.IOException;
import java.text.ParseException;
import java.util.logging.Logger;

import static com.infoshareacademy.zieloni.Menu.startMenu;

/**
 * Hello world!
 */
public class App {

    Logger logger = Logger.getLogger(App.class.getName());

    public static void main(String[] args) throws ParseException, ParserException, IOException, InterruptedException {

        // startMenu();

        //TODO Adam : jeden z parametrów klasy FindBusController.getProposedBusArr()
        FindBusController.search("Wilanowska", "Startowa"); //002

        //Przykład  jak w  juz docelowej klasie tego uzyć dla pierwszego elementu  get(0);
        int nr = 0;
        BusDTO bus =  FindBusController.getProposedBusArr().get(nr).getBus();
        int variant = FindBusController.getProposedBusArr().get(nr).getVairiant();
        int id = FindBusController.getProposedBusArr().get(nr).getId();

        int busStop = FindBusController.getProposedBusArr().get(nr).getBusStopIndex();

        // zaleznosci od variant 1 czy 2 wycągasz własniwew elementy
        System.out.println(bus.getBusNumber());
        System.out.println("wariant"+ variant);
        System.out.println(bus.getBusStops_v1().get(busStop).getNameOfBusStop());

        System.out.println(bus.getCourseRecords_v1().get(1).getDepartureTime());




        // FindBusController.search("Wrzeszcz PKP","Dworzec Główny");//0N3
        //FindBusInterchangesController.search("Dworzec Główny","Oliwa");
        //FindBusController.search("Dworzec Główny","Bysewo"); //002
        //FindBusInterchangesController.search("Dworzec Główny","Bysewo"); //002
    }
}
