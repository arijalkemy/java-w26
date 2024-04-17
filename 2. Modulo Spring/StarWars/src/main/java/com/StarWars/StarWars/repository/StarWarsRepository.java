package com.StarWars.StarWars.repository;

import com.StarWars.StarWars.entity.Personaje;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

@Repository
public class StarWarsRepository implements  IStarWarsRepository{

    public StarWarsRepository() {
        this.listaPersonaje = obtenerDatos();
    }
    @Override
    public List<Personaje> obtenerPesonajes() {
        return listaPersonaje;
    }

    public void setListaPersonaje(List<Personaje> listaPersonaje) {
        this.listaPersonaje = listaPersonaje;
    }
    private List<Personaje> listaPersonaje;

    public List<Personaje> obtenerDatos() {
        File file = null;
        try {
            file = ResourceUtils.getFile("classpath:starwars_data.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<Personaje>> typeRef = new TypeReference<>() {};
        List<Personaje> characters = null;
        try {
            characters = objectMapper.readValue(file, typeRef);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return characters;
    }

}
