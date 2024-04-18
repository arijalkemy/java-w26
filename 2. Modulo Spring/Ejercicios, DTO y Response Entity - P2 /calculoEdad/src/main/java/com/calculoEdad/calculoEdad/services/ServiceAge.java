package com.calculoEdad.calculoEdad.services;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;

@Service
public class ServiceAge {
    public int calculateAgeByDate(int day, int month, int year){
        return Period.between(LocalDate.of(year, month, day), LocalDate.now()).getYears();
    }
}
