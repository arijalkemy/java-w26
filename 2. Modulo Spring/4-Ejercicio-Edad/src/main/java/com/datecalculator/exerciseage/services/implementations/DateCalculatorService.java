package com.datecalculator.exerciseage.services.implementations;

import com.datecalculator.exerciseage.services.IDateCalculatorService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;

@Service
public class DateCalculatorService implements IDateCalculatorService {
    @Override
    public Integer calculateAge(Integer day, Integer month, Integer year) {
        LocalDate birthDate = LocalDate.of(year, month, day);
        LocalDate currentDate = LocalDate.now();
        Period period = birthDate.until(currentDate);

        return period.getYears();
    }
}
