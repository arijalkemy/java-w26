package org.example.ejerciciodeportistas.services.services.impl;

import org.example.ejerciciodeportistas.dto.SportDto;
import org.example.ejerciciodeportistas.models.Sport;
import org.example.ejerciciodeportistas.services.IsportServices;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SportServiceImpl implements IsportServices {

    public List<Sport> sports;

    public SportServiceImpl() {
        sports = new ArrayList<>();
        Sport soccer = new Sport("soccer", "medium");
        Sport basketball = new Sport("bascketball", "high");
        Sport tennis = new Sport("tennis", "low");
        Sport karate = new Sport("karate", "medium");
        Sport volleyball = new Sport("volleyball", "high");
        Sport cricket = new Sport("cricket", "medium");
        Sport summerball = new Sport("summerball", "high");

        sports.add(soccer);
        sports.add(tennis);
        sports.add(karate);
        sports.add(volleyball);
        sports.add(cricket);
        sports.add(summerball);

    }

    @Override
    public List<Sport> allSporst() {
        return this.sports;
    }

    @Override
    public SportDto sportByName(String name) {
        Sport sport = this.sports.stream().filter(s -> s.getName().equals(name)).findFirst().orElse(null);
        if (sport != null) {
            return new SportDto(sport.getName());
        }
        return null;
    }

}
