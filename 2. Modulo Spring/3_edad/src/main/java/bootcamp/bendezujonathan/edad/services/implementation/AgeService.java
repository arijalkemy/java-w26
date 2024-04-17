package bootcamp.bendezujonathan.edad.services.implementation;

import java.time.LocalDate;
import java.time.Period;

import org.springframework.stereotype.Service;

import bootcamp.bendezujonathan.edad.services.interfaces.IAgeService;

@Service
public class AgeService implements IAgeService {

    @Override
    public int calculateAge(int day, int month, int year) {
        LocalDate fecha = LocalDate.of(year, month, day);
        return Period.between(fecha, LocalDate.now()).getYears();
    }
    
}
