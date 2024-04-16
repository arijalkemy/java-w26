package meli.bootcamp.edad_de_una_persona.services;

import java.time.LocalDate;
import java.time.Period;
import org.springframework.stereotype.Service;

@Service
public class AgeService {

  public int calculateAge(int year, int month, int day) {
    LocalDate birthDate = LocalDate.of(year, month, day);
    LocalDate today = LocalDate.now();

    return Period.between(birthDate, today).getYears();
  }
}
