package com.example.starwars.repository;

import com.example.starwars.dto.PersonajeDTO;
import com.example.starwars.entity.Personaje;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class PersonajeRepository {

    private static List<Personaje> personajes = new ArrayList<Personaje>();

    public List<Personaje> loadDataBase() {
        File file = null;
        try {
            file = ResourceUtils.getFile("classpath:starwars2.json");
        } catch (FileNotFoundException e) {
            e.getMessage();
        }
        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<Personaje>> typeRef = new TypeReference<>() {};

        try {
            personajes = objectMapper.readValue(file, typeRef);

        }
        catch (IOException e) {
            e.printStackTrace();
        }

        return personajes;
    }

}
