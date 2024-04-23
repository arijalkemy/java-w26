package com.mercadolibre.CharacterStarWarsAPI.repositories;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mercadolibre.CharacterStarWarsAPI.dto.CharacterDTO;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class RepoBD {
    private final List<CharacterDTO> database;

    public RepoBD() {
        this.database = loadDataBase();
    }

    private List<CharacterDTO> loadDataBase() {
        List<CharacterDTO> personajes = new ArrayList<>();
        String rutaArchivo = "classpath:starwars_characters.json";
        ObjectMapper objectMapper = new ObjectMapper();
        File file;
        try {
            file = ResourceUtils.getFile(rutaArchivo);
            List<Map<String, Object>> datos = objectMapper.readValue(file, List.class);

            for (Map<String, Object> dato : datos) {
                CharacterDTO personaje = new CharacterDTO();
                personaje.setName((String) dato.get("name"));
                personaje.setHeight((String) dato.get("height").toString());
                personaje.setMass((String) dato.get("mass").toString());
                personaje.setHairColor((String) dato.get("hair_color"));
                personaje.setSkinColor((String) dato.get("skin_color"));
                personaje.setEyeColor((String) dato.get("eye_color"));
                personaje.setBirthYear((String) dato.get("birth_year"));
                personaje.setGender((String) dato.get("gender"));
                personaje.setHomeworld((String) dato.get("homeworld"));
                personaje.setSpecies((String) dato.get("species"));

                personajes.add(personaje);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return personajes;
    }

    public List<CharacterDTO> getDatabase() {
        return database;
    }
}
