package com.mercadolibre.agecalculator.service.imp;

import com.mercadolibre.agecalculator.service.IAgeService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class AgeServiceImpl implements IAgeService {
    @Override
    public Integer calculateAge(int day, int month, int year) {
        LocalDate birthDate = LocalDate.of(year, month, day);
        LocalDate today = LocalDate.now();
        return birthDate.until(today).getYears();
    }
}
