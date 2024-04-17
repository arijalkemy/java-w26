package meli.bootcamp.calcularedad.service;

import meli.bootcamp.calcularedad.service.interfaces.ICalculateAge;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.util.Date;

@Service
public class CalculateAgeImpl implements ICalculateAge {
    @Override
    public Integer fromDate(Integer year, Integer month, Integer day) {
        LocalDate birthDate = LocalDate.of(year, month, day);
        LocalDate today = LocalDate.now();


        return Period.between(birthDate, today).getYears();
    }
}
