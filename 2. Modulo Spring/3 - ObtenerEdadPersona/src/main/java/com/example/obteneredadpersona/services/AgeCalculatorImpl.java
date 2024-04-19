package com.example.obteneredadpersona.services;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;

@Service
public class AgeCalculatorImpl implements IAgeCalculatorServices{

    @Override
    public String calculateAge(int day, int month, int year) {
        if (day >= 1 && day <=31){
            if (month >= 1 && month <= 12){
                if(year <= LocalDate.now().getYear()){
                    LocalDate birthDate = LocalDate.of(year,month,day);
                    LocalDate actualDate = LocalDate.now();
                    Period period = Period.between(birthDate, actualDate);
                    int age = period.getYears();
                    String newStringAge = Integer.toString(age);
                    return newStringAge;
                }
            }
        }
        return "La fecha ingresada no es correcta.";
    }
}
