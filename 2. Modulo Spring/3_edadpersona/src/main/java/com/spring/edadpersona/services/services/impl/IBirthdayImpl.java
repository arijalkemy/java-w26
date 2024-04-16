package com.spring.edadpersona.services.services.impl;

import com.spring.edadpersona.services.IBirthdayService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;

@Service
public class IBirthdayImpl implements IBirthdayService {

    @Override
    public Integer getAge(Integer day, Integer month, Integer year) {

        if(month > 12 || month < 1 || year < 0) {
            return -1;
        }

        LocalDate birthDate = LocalDate.of(year, month, day);
        LocalDate currentDay = LocalDate.now();

        if(currentDay.isAfter(birthDate)){
            Period period = Period.between(birthDate, currentDay);
            return period.getYears();
        }

        return -1;
    }

}
