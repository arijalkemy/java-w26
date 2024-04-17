package org.bootcamp.edadpersona.service;

import java.time.LocalDate;
import java.time.Period;

import org.springframework.stereotype.Service;

@Service
public class AgeServiceImpl implements IAgeService {

    @Override
    public Integer calculateAge(int dia, int mes, int anio) {
        LocalDate birthDate = LocalDate.of(anio, mes, dia);
        LocalDate currentDate = LocalDate.now();
        int age = Period.between(birthDate, currentDate).getYears();
        return age;
    }
}
