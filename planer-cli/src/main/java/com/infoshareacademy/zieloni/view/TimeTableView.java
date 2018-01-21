package com.infoshareacademy.zieloni.view;

import com.infoshareacademy.zieloni.database.BusDataBase;
import com.infoshareacademy.zieloni.model.BusDTO;
import com.infoshareacademy.zieloni.model.RecordCourseDTO;
import com.infoshareacademy.zieloni.utils.FormatTime;
import com.infoshareacademy.zieloni.utils.IsBusExist;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Map;

@SuppressWarnings({"squid:S106", "squid:S1192"})
public class TimeTableView {
    private TimeTableView() {
    }

    private static final List<BusDTO> busDB = BusDataBase.getDataBase();
    private static int level = 0;
    private static int selectedBus = -1;
    private static int street = -1;
    private static int variant = -1;
    private static Logger logger = LoggerFactory.getLogger(TimeTableView.class.getName());

    public static int selectBus() {
        level = 1;
        System.out.println("#################################################");
        System.out.println("#          Wybierz srodek transportu            #");
        System.out.println("#                                               #");
        System.out.println("#   Wpisz 'cofnij' aby wrócić do głównego menu  #");
        System.out.println("#       Wpisz 'exit' aby wyjść z programu       #");
        System.out.println("#################################################");

        StringBuilder allTransportBoard = new StringBuilder();
        int counter = 0;

        for (int i = -1; i < busDB.size(); i++) {
            if (counter % 12 == 0) {
                allTransportBoard.append("\n");
                allTransportBoard.append("__________________________________________________________________\n");
                allTransportBoard.append("\n");
            } else {
                allTransportBoard.append(busDB.get(i).getBusNumber() + " | ");
            }
            counter++;
        }
        System.out.println(allTransportBoard);

        return level;
    }

    public static int selectVariant(String txt) {
        int id = IsBusExist.check(txt)[1];
        level = 2;
        System.out.println("########################################################################################");
        System.out.println("         Wybrałeś " + busDB.get(id).getTypeOfTransport() + " nr " + busDB.get(id).getBusNumber());
        System.out.println("                                                                                        ");
        System.out.println("    Wpisz 1) jeśli chcesz jechać w kierunku: " + busDB.get(id).getBusStopsV2().get(0).getNameOfBusStop());
        System.out.println("    Wpisz 2) jeśli chcesz jechać w kierunku: " + busDB.get(id).getBusStopsV1().get(0).getNameOfBusStop());
        System.out.println("    Wpisz 'cofnij' aby wrócić do głównego menu                                            ");
        System.out.println("########################################################################################");
        selectedBus = id;

        return level;
    }

    public static int showVariantStreet(Integer variant) {

        level = 3;
        System.out.println("#################################################");
        System.out.println("#       Wybierz nr porządkowy przystanku        #");
        System.out.println("#       Wpisz 'exit' aby wyjść z programu       #");
        System.out.println("#   Wpisz 'cofnij' aby wrócić do głównego menu  #");
        System.out.println("#################################################");
        TimeTableView.variant = variant;

        if (variant == 1) {
            for (int i = 0; i < busDB.get(selectedBus).getBusStopsV1().size(); i++) {
                System.out.println(i + ") " + busDB.get(selectedBus).getBusStopsV1().get(i).getNameOfBusStop());
            }
        }
        if (variant == 2) {
            for (int i = 0; i < busDB.get(selectedBus).getBusStopsV2().size(); i++) {
                System.out.println(i + ") " + busDB.get(selectedBus).getBusStopsV2().get(i).getNameOfBusStop());
            }
        }

        return level;
    }

    public static int showTimesForBusStop(Integer integer) {
        street = integer;
        showTimeTable(street);
        return level;
    }

    private static void showTimeTable(Integer busStopIndex) {
        int busStopArrSize = -1;
        String busStopName = "";

        if (variant == 1) {
            busStopArrSize = busDB.get(selectedBus).getBusStopsV1().size();
        }
        if (variant == 2) {
            busStopArrSize = busDB.get(selectedBus).getBusStopsV2().size();
        }

        if (busStopIndex > -1 && busStopIndex < busStopArrSize) {

            level = 4;
            List<RecordCourseDTO> courseRecord = null;
            Map<String, List<String>> map = null;

            if (variant == 1) {
                courseRecord = busDB.get(selectedBus).getCourseRecordsV1();
                map = busDB.get(selectedBus).getColumnsMapV1();
                busStopName = busDB.get(selectedBus).getBusStopsV1().get(street).getNameOfBusStop().toUpperCase();

            } else if (variant == 2) {
                courseRecord = busDB.get(selectedBus).getCourseRecordsV2();
                map = busDB.get(selectedBus).getColumnsMapV2();
                busStopName = busDB.get(selectedBus).getBusStopsV2().get(street).getNameOfBusStop().toUpperCase();
            }

            timeTableStringBuilder(courseRecord, map, busStopName, busStopIndex, selectedBus);

        } else {
            System.out.println("Wybierz od 0 do " + (busStopArrSize - 1));
        }
    }

    public static StringBuilder timeTableStringBuilder(List<RecordCourseDTO> courseRecord, Map<String, List<String>> map, String busStopName, Integer street, int selectedBus) {

        String type = busDB.get(selectedBus).getTypeOfTransport();
        String busNr = busDB.get(selectedBus).getBusNumber();
        StringBuilder timeTableView = new StringBuilder();
        timeTableView.append("\n");
        timeTableView.append("                     Rozkład " + type + " nr " + busNr + " na ulicy " + busStopName);
        timeTableView.append("\n");
        int counter = 1;

        for (int i = 0; i < courseRecord.size(); i++) {
            int minutes = 0;
            String symbolOfCourse = courseRecord.get(i).getTypeOfCourse();

            for (int j = 0; j < street; j++) {
                try {
                    minutes += Integer.valueOf(map.get(symbolOfCourse).get(j));
                } catch (Exception e) {
                    minutes += 1;
                }
            }

            try {

                if (courseRecord.get(i).getTypeOfCourse().split("X")[0].equals("")) {
                    timeTableView.append(FormatTime.dateFromTo(courseRecord.get(i).getDepartureTime() + "+" + minutes) + " | ");
                    if (counter % 10 == 0) {
                        timeTableView.append("\n");
                    }
                    counter++;
                } else {
                    counter = 1;
                    timeTableView.append("\n");
                    timeTableView.append("--------------------------------------------------------------------------------\n");
                    timeTableView.append("                                 " + courseRecord.get(i).getTypeOfCourse() + "\n");
                    timeTableView.append("--------------------------------------------------------------------------------\n");
                }
            } catch (Exception e) {
                logger.info("Rozkład jazdy sie nie wyświetlił");
            }
        }

        System.out.println(timeTableView);
        return timeTableView;
    }
}
