package org.example.integradorcalcularedad.service;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.util.Date;

@Service
public class ConversorServiceImp implements IConversorService{
    @Override
    public Integer convertAge(Integer day, Integer month, Integer year){

        LocalDate dateNow = LocalDate.now();
        LocalDate dateToConvert = LocalDate.of(year, month, day);

        Period period = Period.between(dateToConvert, dateNow);
        return period.getYears();
    };
}
