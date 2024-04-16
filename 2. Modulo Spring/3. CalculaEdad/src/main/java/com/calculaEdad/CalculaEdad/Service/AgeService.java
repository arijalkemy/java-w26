package com.calculaEdad.CalculaEdad.Service;

import org.springframework.stereotype.Service;

import java.sql.Timestamp;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;


@Service
public class AgeService  implements  IageService{
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
