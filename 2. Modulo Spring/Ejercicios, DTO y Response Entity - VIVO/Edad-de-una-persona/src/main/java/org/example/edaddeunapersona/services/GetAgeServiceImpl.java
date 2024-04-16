package org.example.edaddeunapersona.services;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;

@Service
public class GetAgeServiceImpl implements IGetAgeService{
    @Override
    public long getAge(int day, int month, int year) {

        LocalDate today = LocalDate.now();
        LocalDate dayOfBirth = LocalDate.of(year, month, day);

        //calculate the years from day of birth until today
        //otra forma de hacerlo Period.between(dayOfBirth, today).getYears();
        return ChronoUnit.YEARS.between(dayOfBirth, today);

    }
}
