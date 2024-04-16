package org.ejercicio.personasdeportes.service;

import org.ejercicio.personasdeportes.model.Deporte;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class DeporteRepository {
    public static List<Deporte> deportes = Arrays.asList(new Deporte("Futbol","Avanzada"),
                                                        new Deporte("BasketBall","Media"),
                                                        new Deporte("Natación","Fácil"));

    public List<Deporte> findSports(){
        return deportes;
    }

    public String findSport(String name){
        Optional<Deporte> sports = deportes.stream().filter(d->d.getNombre().equalsIgnoreCase(name)).findFirst();
        if(sports.isPresent()){
            return sports.get().getNombre();
        }
        return "";
    }
}
