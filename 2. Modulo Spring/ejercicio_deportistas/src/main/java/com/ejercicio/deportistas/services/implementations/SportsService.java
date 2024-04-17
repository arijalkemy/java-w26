package com.ejercicio.deportistas.services.implementations;

import com.ejercicio.deportistas.models.Sport;
import com.ejercicio.deportistas.repository.implementations.SportsRepository;
import com.ejercicio.deportistas.services.interfaces.ISportsService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SportsService implements ISportsService {
    SportsRepository sportsRepository = new SportsRepository();

    @Override
    public List<Sport> getAllSports() {
        return sportsRepository.getAll();
    }

    @Override
    public Sport getSportByName(String name) {
        return sportsRepository.getByName(name);
    }
}
