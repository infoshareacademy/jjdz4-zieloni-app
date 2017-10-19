package com.infoshareacademy.zieloni;

import com.infoshareacademy.zieloni.Model.ExtraTableCsvDTO;

import java.io.File;
import java.util.ArrayList;

public class App {

    public static void main(String[] args) {
        System.setProperty("file.encoding", "UTF-8");
        SearchBus.search("Ptasia", "GG");






        /*---------------------------pobranie pliku tabela.csv   --moze sie to przyda może nie*/
        final String currentDirectory = System.getProperty("user.dir");
        final File tabelaCSVPath = new File(currentDirectory + "//src//main//resource//rozklady_2015-09-08_13.43.01//tabela.csv");
        File csvFile = new File(tabelaCSVPath.toString());

        /*Wrzucenie poszczególnych linii tablei.csv do Array*/
        ArrayList<String> recordsArray = CSVReader.readCSVfileAndConvertToRecordsArray(tabelaCSVPath.toString());
        ArrayList<ExtraTableCsvDTO> tabelaCSVArray = CSVFileParser.formatCSVToTimeTableWithExtraInfoRecords(recordsArray);

        /*System.out.println(tabelaCSVArray.get(0).getId());
        System.out.println(tabelaCSVArray.get(0).getLineNr());
        System.out.println(tabelaCSVArray.get(0).getTypeOfTransport());
        System.out.println(tabelaCSVArray.get(0).getIsValidFrom());
        System.out.println(tabelaCSVArray.get(0).isLowRider());*/

    }
}
