package com.bootcamp.DTO.y.Response.Entity.Edad.de.una.Persona.services.imp;

import com.bootcamp.DTO.y.Response.Entity.Edad.de.una.Persona.services.IPersona;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;

@Service
public class DateToAge implements IPersona {

    @Override
    public int calculateAge(Integer day, Integer month, Integer year) {
        if (year < 1900 || (month < 1 || month > 12) || day < 1 || day > 31) {
            throw new RuntimeException("Invalid date");
        }

        String birthdayFormatt = year + "-" + (month < 10 ? "0" + month : month) + "-" + day;
        LocalDate birthday = LocalDate.parse(birthdayFormatt);
        LocalDate currentDate = LocalDate.now();

        return Period.between(birthday, currentDate).getYears();
    }
}
