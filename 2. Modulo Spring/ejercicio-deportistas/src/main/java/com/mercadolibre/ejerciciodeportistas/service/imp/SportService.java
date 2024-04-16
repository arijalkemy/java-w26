package com.mercadolibre.ejerciciodeportistas.service.imp;

import com.mercadolibre.ejerciciodeportistas.model.entity.Sport;
import com.mercadolibre.ejerciciodeportistas.service.ISportService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SportService implements ISportService {
    private List<Sport> sports;
    public SportService() {
        this.sports = new ArrayList<>(List.of(
                new Sport("Football", "Intermediate"),
                new Sport("Golf", "Hard"),
                new Sport("Voleyball", "Easy"),
                new Sport("Soccer", "Hard")
        ));
    }
    @Override
    public List<Sport> findAll() {
        return sports;
    }

    @Override
    public String findLevelByName(String name) {
        return sports.stream()
                .filter(sport -> sport.getName().equals(name))
                .findFirst()
                .map(Sport::getLevel)
                .orElse(null);
    }

}
