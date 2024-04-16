package com.ej1p1.personage.services.implementations;

import com.ej1p1.personage.services.IAgeCalculator;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class AgeCalculatorImpl implements IAgeCalculator {

    @Override
    public int calculateAge(Integer day, Integer month, Integer year) {
        LocalDate nowDate = LocalDate.now();
        LocalDate birthDate = LocalDate.of(year, month, day);

        int nowYear = nowDate.getYear();
        int nowDay = nowDate.getDayOfYear();

        int birthDay = birthDate.getDayOfYear();

        int age = nowYear - year;
        if (nowDay < birthDay){
            age--;
        }
        return age;
    }
}
