package com.example.ejercicios_dto_y_response_entityvivo.service;

import com.example.ejercicios_dto_y_response_entityvivo.DTO.ResponseDTO;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

@Service
public class AgeService implements IAgeService {


    @Override
    public ResponseDTO calculateAge(Integer day, Integer month, Integer year) {
        LocalDate date = LocalDate.of(year,month,day);
        System.out.println(date+" "+LocalDate.now());

        //Obteniendo el valor restando el tiempo respecto a la fecha ingresada

        Integer years =LocalDate.now()
                .minusYears(Integer.toUnsignedLong(year))
                .minusMonths(Integer.toUnsignedLong(month))
                .minusDays(Integer.toUnsignedLong(day))
                .getYear();

        return new ResponseDTO(years.toString());
    }
}
