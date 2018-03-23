package com.infoshareacademy.zieloni.utils;

import com.infoshareacademy.zieloni.model.ProposedBusDTO;
import com.infoshareacademy.zieloni.model.RecordCourseDTO;
import lombok.Data;

import java.time.LocalTime;
import java.util.List;
import java.util.Map;
@Data
@SuppressWarnings({"squid:S106", "squid:S1192"})
public class TimeLimiter {

    private String textInfo;

    public TimeLimiter(LocalTime endEvent, LocalTime startEvent, ProposedBusDTO proposedBus) {

        LocalTime endEventTime = endEvent.minusMinutes(30);
        LocalTime startEventTime = startEvent.minusMinutes(10);
        int street = proposedBus.getBusStopIndex();
        textInfo="";
        System.out.println("Proponowany srodek transportu " + proposedBus.getBus().getTypeOfTransport() + " nr:  " + proposedBus.getBus().getBusNumber());
        textInfo="Proponowany srodek transportu " + proposedBus.getBus().getTypeOfTransport() + " nr:  " + proposedBus.getBus().getBusNumber();
        textInfo+="<br/>";
        Map<String, List<String>> map = null;

        List<RecordCourseDTO> course;
        if (proposedBus.getVairiant() == 1) {

            course = proposedBus.getBus().getCourseRecordsV1();
            map = proposedBus.getBus().getColumnsMapV1();
        } else {
            course = proposedBus.getBus().getCourseRecordsV2();
            map = proposedBus.getBus().getColumnsMapV2();

        }

        for (int i = 0; i < course.size(); i++) {

            String symbolOfCourse = course.get(i).getTypeOfCourse();
            int minutes = 0;
            for (int j = 0; j < street; j++) {
                try {
                    minutes += Integer.valueOf(map.get(symbolOfCourse).get(j));
                } catch (Exception e) {
                    minutes += 1;
                }
            }

            String time = course.get(i).getDepartureTime();
            if (time.equals("99")) {
                System.out.println("\n");
                System.out.println("-------------------------------------");
                System.out.println(course.get(i).getTypeOfCourse());
                textInfo+="<br/>";
                textInfo+=course.get(i).getTypeOfCourse();
                textInfo+="<br/>";


            } else {
                String time1 = FormatTime.dateFromTo(course.get(i).getDepartureTime() + "+" + minutes);

                boolean isInRange = (LocalTime.parse(time1).isAfter(endEventTime)) && (LocalTime.parse(time1).isBefore(startEventTime));
                if (isInRange) {
                    System.out.printf(String.format("%s | ", time1));
                    textInfo+=String.format("%s |", time1);
                }
            }

        }
    }

}