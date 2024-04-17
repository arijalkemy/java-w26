package com.example._06_starwars.repository;

import com.example._06_starwars.entity.Personaje;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PersonajeRepository implements IPersonajeRepository{
    static List<Personaje> personajes;
    static {
        personajes = new ArrayList<>();
        personajes.add(new Personaje("Luke Skywalker", "rubio", "blanca", "azul",
                "1980", "masculino", "Tierra", "no tiene", 72, 170));
        personajes.add(new Personaje("Darth Vader", "negro", "blanca", "negro",
                "1960", "masculino", "Tierra", "humanoide", 90, 190));
        personajes.add(new Personaje("Darth Maul", "no tiene", "rojo", "rojo",
                "1940", "masculino", "Dathomir", "zabrak", 72, 175));
    }

    @Override
    public List<Personaje> obtenerPersonajes() {
        return personajes;
    }
}
