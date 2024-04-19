package com.example.personajesstarwars.repository;

import com.example.personajesstarwars.model.Personaje;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class PersonajeRepositoryImpl implements IPersonajeRepository{

    @Override
    public List<Personaje> obtenerNombres() {
        ObjectMapper objectMapper = new ObjectMapper();
        List<Personaje> personajes = null;
        String path = "src/main/java/com/example/personajesstarwars/starwars.json";
        try{
            personajes = objectMapper.readValue(new File(path), new TypeReference<List<Personaje>>() {
            });
        } catch (IOException e){
            e.printStackTrace();
        }

        return personajes;
    }
}
