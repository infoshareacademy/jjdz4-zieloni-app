package com.infoshareacademy.zieloni.utils;

import com.infoshareacademy.zieloni.model.ProposedBusDTO;
import com.infoshareacademy.zieloni.model.RecordCourseDTO;

import java.time.LocalTime;
import java.util.List;

@SuppressWarnings({"squid:S106", "squid:S1192"})
public class TimeLimiter {
    public TimeLimiter(LocalTime endEvent, LocalTime startEvent, ProposedBusDTO proposedBus) {
        LocalTime endEventTime = endEvent.minusMinutes(30);
        LocalTime startEventTime = startEvent.minusMinutes(10);
        List<RecordCourseDTO> corse;
        if (proposedBus.getVairiant() == 1) {

            corse = proposedBus.getBus().getCourseRecordsV1();
        } else {
            corse = proposedBus.getBus().getCourseRecordsV2();
        }
        for (int i = 0; i < corse.size(); i++) {
            String time = corse.get(i).getDepartureTime();

            if (time.equals("99")) {
                System.out.println("\n");
                System.out.println(corse.get(i).getTypeOfCourse() + "\n");
                System.out.println("-------------------------------------\n");
            } else {
                boolean isInRange = (LocalTime.parse(time).isAfter(endEventTime)) && (startEventTime.isBefore(LocalTime.parse(time)));
                if (isInRange) {
                    System.out.printf(String.format("%s | ", corse.get(i).getDepartureTime()));
                }
            }
        }

    }

}
