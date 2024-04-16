package com.ejercicio.deportistas.repository.implementations;

import com.ejercicio.deportistas.entities.Sport;
import com.ejercicio.deportistas.repository.interfaces.IRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class SportsRepository implements IRepository<Sport> {

    private List<Sport> sports = createSports();

    @Override
    public List<Sport> getAll() {
        return sports;
    }

    @Override
    public Sport getByName(String name) {
        Optional<Sport> result = sports
                .stream()
                .filter(sport -> sport.getName().equals(name))
                .findFirst();

        if (result.isPresent()) return result.get();
        return null;
    }

    private List<Sport> createSports() {
        List<Sport> sports = new ArrayList<Sport>();

        sports.add(new Sport("Baloncesto", "Medio"));
        sports.add(new Sport("Futbol", "Alto"));
        sports.add(new Sport("HandBall", "Medio"));
        sports.add(new Sport("Ciclismo", "Bajo"));
        sports.add(new Sport("VolleyBall", "Alto"));

        return sports;
    }
}
