package com.example.EjercicioEdadDeUnaPersona.Service.impl;

import com.example.EjercicioEdadDeUnaPersona.Service.IDateToAgeService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;

@Service
public class DateToAgeServiceImpl implements IDateToAgeService {
    @Override
    public int getAge(int Dia, int Mes, int Ano) {

        LocalDate localDate = LocalDate.now();
        LocalDate pastDate = LocalDate.of(Ano, Mes, Dia);
        Period period = Period.between(pastDate,localDate);
        return period.getYears();
    }
}
