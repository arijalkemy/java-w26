package org.example.rest_http_p1_age_calcs.ages;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.util.Calendar;
import java.util.GregorianCalendar;

@Service
public class AgesService {
    public String calcAge(Integer day, Integer month, Integer year) {
        LocalDate now = LocalDate.now();
        Integer nowYear = now.getYear();

        if (year > nowYear) return "No se puede calcular con un año mayor al actual.";
        if (month > 12 || month < 1) return "El mes que proporcionaste no es válido";

        Calendar cal = new GregorianCalendar(year, month, 1);
        Integer daysInDate = cal.getActualMaximum(Calendar.DAY_OF_MONTH);

        if (day > daysInDate || day < 1)
            return "El día que proporcionaste para esa fecha no se encuentra dentro de un rango válido";
        LocalDate givenDate = LocalDate.of(year, month, day);

        Period period = Period.between(givenDate, now);

        return ""+period.getYears();
    }
}
