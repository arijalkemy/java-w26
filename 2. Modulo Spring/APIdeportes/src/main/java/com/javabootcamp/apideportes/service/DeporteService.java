package com.javabootcamp.apideportes.service;

import com.javabootcamp.apideportes.dto.Deporte;
import com.javabootcamp.apideportes.dto.Persona;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DeporteService {
    // Creacion de una lista de personas y deportes

    private List<Deporte> deportes = List.of(
            new Deporte("Futbol", "Profesional"),
            new Deporte("Baloncesto", "Profesional"),
            new Deporte("Voleibol", "Profesional"),
            new Deporte("Tenis", "Profesional"),
            new Deporte("Natacion", "Profesional"),
            new Deporte("Atletismo", "Profesional"),
            new Deporte("Ciclismo", "Profesional"),
            new Deporte("Golf", "Profesional"),
            new Deporte("Rugby", "Profesional"),
            new Deporte("Boxeo", "Profesional")
    );

    private List<Persona> personas = List.of(
            new Persona("Juan", "Perez", 25,deportes.get(2)),
            new Persona("Maria", "Gomez", 30,deportes.get(4)),
            new Persona("Pedro", "Gonzalez", 35,deportes.get(6)),
            new Persona("Luis", "Rodriguez", 40,deportes.get(1)),
            new Persona("Ana", "Martinez", 45,deportes.get(3)),
            new Persona("Sofia", "Fernandez", 50,deportes.get(5)),
            new Persona("Carlos", "Lopez", 55,deportes.get(7)),
            new Persona("Javier", "Sanchez", 60,deportes.get(7)),
            new Persona("Javier", "Sanchez", 60,deportes.get(9)),
            new Persona("Javier", "Sanchez", 60,deportes.get(0)),
            new Persona("Marta", "Torres", 65,deportes.get(9)),
            new Persona("Lucia", "Ramirez", 70,deportes.get(2))
    );

    // mostrar todos los deportes y sus niveles
    public List<Deporte> muestraTodosDeportes() {
        return deportes.stream().toList();
    }

    public String findSportByName(String name){
        Optional<Deporte> consulta = Optional.ofNullable(findInSports(name));
        if(consulta.isPresent()){
            return "Deporte encontrado, mostrando información:\n" + consulta.get().toString();
        }
        else{
            return "Deporte no encontrado.";
        }
    }

    public Deporte findInSports(String name){
        for(Deporte d:deportes){
            if(d.getNombre().equals(name)){
                return d;
            }
        }
        return null;
    }

    public List<Persona> findAllPersons() {
        return personas.stream().toList();
    }
}
