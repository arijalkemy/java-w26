package com.demospring.deportes.services.implement;

import com.demospring.deportes.entities.Deporte;
import com.demospring.deportes.entities.Persona;
import com.demospring.deportes.dtos.PersonaDeporteDTO;
import com.demospring.deportes.services.IDeportes;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class Deportes implements IDeportes {
    private static List<Deporte> deportes = new ArrayList<>();
    private static List<Persona> personas = new ArrayList<>();

    static{
        deportes.add(new Deporte("Fútbol", 5));
        deportes.add(new Deporte("Baloncesto", 4));
        deportes.add(new Deporte("Tenis", 3));
        deportes.add(new Deporte("Natación", 3));
        deportes.add(new Deporte("Atletismo", 4));
        deportes.add(new Deporte("Rugby", 5));
        deportes.add(new Deporte("Voleibol", 4));
        deportes.add(new Deporte("Golf", 3));
        deportes.add(new Deporte("Hockey", 4));
        deportes.add(new Deporte("Ciclismo", 3));

        personas.add(new Persona("Juan", "Perez", 25));
        personas.add(new Persona("María", "González", 30));
        personas.add(new Persona("Carlos", "Martínez", 40));
        personas.add(new Persona("Laura", "López", 35));
        personas.add(new Persona("Pedro", "Rodríguez", 28));
        personas.add(new Persona("Ana", "Sánchez", 33));
        personas.add(new Persona("Diego", "Hernández", 22));
        personas.add(new Persona("Sofía", "Díaz", 27));
        personas.add(new Persona("Alejandro", "Torres", 45));
        personas.add(new Persona("Lucía", "Ruiz", 31));
    }

    @Override
    public List<Deporte> getDeportes() {
        return deportes;
    }

    @Override
    public Deporte getDeporte(String nombre) {
        return deportes.stream().filter(x -> x.getNombre().equals(nombre)).findFirst().orElse(null);
    }

    @Override
    public List<PersonaDeporteDTO> getDeportesPersonas() {
        generarPersonasDeportesRandom();
        return generarPersonasDeportes();
    }

    private void generarPersonasDeportesRandom(){
        for(Persona persona : personas){
            int random = (int)Math.floor(Math.random()*10+1);
            persona.setDeporte(deportes.get(random - 1));
        }
    }

    private List<PersonaDeporteDTO> generarPersonasDeportes(){
        List<PersonaDeporteDTO> personaDeporteDTOS = new ArrayList<>();
        for(Persona persona : personas){
            personaDeporteDTOS.add(new PersonaDeporteDTO(persona.getNombre(), persona.getApellido(), persona.getDeporte().getNombre()));
        }
        return personaDeporteDTOS;
    }
}
