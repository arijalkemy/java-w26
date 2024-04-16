package com.ejercicio.edadpersona.services.implementations;

import com.ejercicio.edadpersona.services.interfaces.IPersonAgeService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class PersonAgeService implements IPersonAgeService {

    @Override
    public int calculateAge(int day, int month, int year) {
        LocalDateTime dateTime = LocalDateTime.of(year, month, day, 0, 0);
        LocalDateTime actualDate = LocalDateTime.now();

        int age = dateTime.compareTo(actualDate);
        boolean notBirthdayYet = month > actualDate.getMonthValue() ||
                (month == actualDate.getMonthValue() && day > actualDate.getDayOfMonth());

        if(notBirthdayYet) age += 1;

        return -age;
    }
}
