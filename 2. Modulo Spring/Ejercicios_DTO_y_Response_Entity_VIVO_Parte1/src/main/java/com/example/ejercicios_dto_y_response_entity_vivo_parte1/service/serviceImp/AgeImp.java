package com.example.ejercicios_dto_y_response_entity_vivo_parte1.service.serviceImp;

import com.example.ejercicios_dto_y_response_entity_vivo_parte1.service.IAgeService;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalDate;
import java.time.Period;

@Service
public class AgeImp implements IAgeService {
    @Override
    public String calculateAge(Integer day, Integer month, Integer year) {

        try {
            LocalDate personLocalDate = LocalDate.of(year, month, day);
            LocalDate localDate = LocalDate.now();
            Period periodDate = Period.between(personLocalDate, localDate);
            return String.valueOf(periodDate.getYears());
        }catch (Exception e) {
            e.getStackTrace();
            return "Incorrect date input";
        }




    }
}
