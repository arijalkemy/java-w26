package org.example.api.service;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

@Service
public class PersonImpl implements IPerson {
    @Override
    public Long calculateAge(Integer day, Integer month, Integer year) {
        LocalDate today = LocalDate.now();
        return ChronoUnit.YEARS.between(LocalDate.of(year, month, day), today);
    }
}
