package com.infoshareacademy.zieloni;

import net.fortuna.ical4j.data.ParserException;

import java.io.IOException;
import java.text.ParseException;

/**
 * Hello world!
 */
public class App {

    public static void main(String[] args) throws ParseException, ParserException, IOException {


        Events events = new Events();
        events.loadEvents();
        //System.out.println(events.getEvents().size());
        Menu.displayEvents(events);

        TimeTableController.show();
        Menu.clearConsole();
        Menu.displayEvents(events);
        Menu.displayDatesWithEvents(events);

//        String starBusStop = "Jaśkowa Dolina (n/ż)";
//        String endBustop = "Uniwersytet Medyczny (n/ż)";
//        System.out.println("Chce dojechac z " + starBusStop + " do " + endBustop);
//
//        FindBus.search(starBusStop, endBustop);

        // FindBus.search("Sandomierska  (n/ż)","Elmet (n/ż)");



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
