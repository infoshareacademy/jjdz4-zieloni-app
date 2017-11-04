package com.infoshareacademy.zieloni;

import net.fortuna.ical4j.data.ParserException;

import java.io.IOException;
import java.text.ParseException;
import java.util.logging.Logger;

/**
 * Hello world!
 */
public class App {

    Logger logger = Logger.getLogger(App.class.getName());

    public static void main(String[] args) throws ParseException, ParserException, IOException {

        Menu.startMenu();

//        PlanerView planer = new PlanerView();
//        planer.startMenu();

       /* Events events = new Events();
        events.loadEvents();
        //System.out.println(events.getEvents().size());

//        Menu.displayEvents(events);
//
//        TimeTableMenu.show();
//        Menu.clearConsole();
//        Menu.displayEvents(events);
//        Menu.displayDatesWithEvents(events);

//        String starBusStop = "Jaśkowa Dolina (n/ż)";
//        String endBustop = "Uniwersytet Medyczny (n/ż)";
//        System.out.println("Chce dojechac z " + starBusStop + " do " + endBustop);
//
//        SearchBus.search(starBusStop, endBustop);

        // SearchBus.search("Sandomierska  (n/ż)","Elmet (n/ż)");



        /*---------------------------pobranie pliku tabela.csv   --moze sie to przyda może nie*/
        /*final String currentDirectory = System.getProperty("user.dir");
        final File tabelaCSVPath = new File(currentDirectory + "//src//main//resource//rozklady_2015-09-08_13.43.01//tabela.csv");
        File csvFile = new File(tabelaCSVPath.toString());
        ArrayList<String> recordsArray = CSVReader.readCSVfileAndConvertToRecordsArray(tabelaCSVPath.toString());
        ArrayList<ExtraTableCsvDTO> tabelaCSVArray = CSVFileParser.formatCSVToTimeTableWithExtraInfoRecords(recordsArray);
        System.out.println(tabelaCSVArray.get(0).getId());
        System.out.println(tabelaCSVArray.get(0).getLineNr());
        System.out.println(tabelaCSVArray.get(0).getTypeOfTransport());
        System.out.println(tabelaCSVArray.get(0).getIsValidFrom());
        System.out.println(tabelaCSVArray.get(0).isLowRider());*/

    }
}
