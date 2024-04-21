package com.calculaEdad.CalculaEdad.Service;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeParseException;


@Service
public class AgeServiceImpl implements  IageService{
    @Override
    public Integer calculaEdad(Integer day, Integer month, Integer year) {
        LocalDate today = LocalDate.now();
        try{
            LocalDate birthday = LocalDate.of(year, month, day);
            Period age = Period.between(birthday, today);
            return age.getYears();

        }catch (DateTimeParseException e){
            return -1;
        }
    }
}
