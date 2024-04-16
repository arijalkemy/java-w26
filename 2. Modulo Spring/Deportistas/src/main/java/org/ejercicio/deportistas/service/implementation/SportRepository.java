package org.ejercicio.deportistas.service.implementation;

import org.ejercicio.deportistas.model.Sport;
import org.ejercicio.deportistas.service.IRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
@Qualifier("sport")
public class SportRepository implements IRepository<Sport> {

    public static List<Sport> sports = Arrays.asList(
            new Sport("Futbol","Avanzada"),
            new Sport("Ciclismo","Media")
    );

    @Override
    public Sport findByName(String name) {
        return sports.stream().filter(s -> s.getName().equalsIgnoreCase(name)).findFirst().orElse(null);
    }

    @Override
    public List<Sport> findAll() {
        return sports;
    }
}
