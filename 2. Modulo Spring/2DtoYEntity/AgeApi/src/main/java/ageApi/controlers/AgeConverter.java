package ageApi.controlers;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;

@Service
public class AgeConverter implements IAgeConverter{


    @Override
    public String toAge(Integer day, Integer month, Integer year) {

        LocalDate nacimiento = LocalDate.of(year, month, day);
        LocalDate ahora = LocalDate.now();

        Period periodo = Period.between(nacimiento, ahora);
        return String.valueOf(periodo.getYears());
    }
}
