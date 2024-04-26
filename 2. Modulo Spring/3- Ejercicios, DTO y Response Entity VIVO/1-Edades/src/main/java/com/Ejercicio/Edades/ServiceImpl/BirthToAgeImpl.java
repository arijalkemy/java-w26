package com.Ejercicio.Edades.ServiceImpl;
import com.Ejercicio.Edades.Service.BirthToAge;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;

@Service
public class BirthToAgeImpl implements BirthToAge {
    @Override
    public Integer birthToAge(Integer day, Integer month, Integer year) {
        LocalDate birthDate = LocalDate.of(year, month, day);
        LocalDate currentDate = LocalDate.now();
        return Period.between(birthDate, currentDate).getYears();
    }
}
