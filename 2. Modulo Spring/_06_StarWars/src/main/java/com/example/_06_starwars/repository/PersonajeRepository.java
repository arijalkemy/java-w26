package com.example._06_starwars.repository;

import com.example._06_starwars.entity.Personaje;
import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DatabindException;
import com.google.gson.Gson;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class PersonajeRepository implements IPersonajeRepository{
    public List<Personaje> personajes = new ArrayList<>();


    public void cargarLista(){
        String path = "/Users/mbellotti/Desktop/java-w26/2. Modulo Spring/_06_StarWars/3. c. starwars.json";

        try {
            ObjectMapper objectMapper = new ObjectMapper();

            personajes = objectMapper.readValue(new FileReader(path), new TypeReference<List<Personaje>>(){});

            } catch (StreamReadException ex) {
            throw new RuntimeException(ex);
        } catch (DatabindException ex) {
            throw new RuntimeException(ex);
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }

    }
    @Override
    public List<Personaje> obtenerPersonajes(){
        if(personajes.size()==0)
            cargarLista();

        return personajes;
    }
}
