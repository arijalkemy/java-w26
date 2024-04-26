package com.example.starwars.repository;
import com.example.starwars.entity.Personaje;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class PersonajesJSON implements IRepositorio{
    @Override
    public List<Personaje> obtenerPersonajes() {
        ObjectMapper mapper = new ObjectMapper();
        List<Personaje> personajes = null;
        String path = "src/main/java/com/example/starwars/3. c. starwars.json";
        try {
            // Leer el archivo JSON y convertirlo a un objeto Java
            personajes = mapper.readValue(new File(path), new TypeReference<List<Personaje>>() {
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
        return personajes;
    }

}
