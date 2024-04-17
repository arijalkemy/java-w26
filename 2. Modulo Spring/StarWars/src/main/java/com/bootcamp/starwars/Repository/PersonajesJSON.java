package com.bootcamp.starwars.Repository;


import com.bootcamp.starwars.Model.Personaje;
import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class PersonajesJSON implements IRepository {
    @Override
    public List<Personaje> obtenerPersonajes() {
        // Crear un ObjectMapper (parte de Jackson) para convertir JSON a objetos Java
        ObjectMapper objectMapper = new ObjectMapper();
        List<Personaje> personajes = null;
        String path = "src/main/java/com/bootcamp/starwars/starwars.json";
        try {
            // Leer el archivo JSON y convertirlo a un objeto Java
            personajes = objectMapper.readValue(new File(path), new TypeReference<List<Personaje>>() {
            });


        } catch (IOException e) {
            e.printStackTrace();

        }

        return personajes;
    }
}
