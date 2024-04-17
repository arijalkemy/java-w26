package com.example.deportistas.repository;

import com.example.deportistas.model.Deporte;
import com.example.deportistas.model.Persona;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DeportesRepository {

    private List<Persona> personas = new ArrayList<>();
    private List<Deporte> deportes = new ArrayList<>();

    public DeportesRepository() {
        Deporte sport1 = new Deporte("Futbol", "Intermedio");
        Deporte sport2 = new Deporte("Natacion", "Avanzado");

        Persona person1 = new Persona("Juan", "Perez", 30, null);
        Persona person2 = new Persona("Maria", "Gomez", 25, sport2);
        Persona person3 = new Persona("Pablo", "Diaz", 30, sport1);

        personas.add(person1);
        personas.add(person2);
        personas.add(person3);

        deportes.add(sport1);
        deportes.add(sport2);
    }

    public List<Deporte> findAllDeportes() {
        return deportes;
    }

    public Deporte findById(String name) {
        return deportes.stream().filter(deporte -> deporte.getNombre()
                .equals(name))
                .findFirst()
                .orElse(null);
    }

    public List<Persona> findSportsPersons() {
        List<Persona> personasConDeporte = new ArrayList<>();
        for (Persona persona : personas) {
            if(persona.getDeporte() != null){
                personasConDeporte.add(persona);
            }
        }
        return personasConDeporte;
    }
}
