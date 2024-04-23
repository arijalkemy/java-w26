package com.mercadolibre.DeportistasAPI.repository;

import com.mercadolibre.DeportistasAPI.model.Deporte;
import com.mercadolibre.DeportistasAPI.model.Persona;

import java.util.List;

public class RepoBD {
    public static List<Deporte> deportes = List.of(new Deporte("Futbol", "amateur"),
            new Deporte("Tenis", "amateur"), new Deporte("Handball", "amateur"),
            new Deporte("Basquet", "amateur"));

    public static List<Persona> personas = List.of(new Persona("Maca", "Caridad", 29,deportes.get(0)),
            new Persona("Angel", "Lopez", 30,deportes.get(2)));
}
