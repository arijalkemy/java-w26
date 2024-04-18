package com.EjercicioSpring.Ejercicio8_StarWars.repository;

import com.EjercicioSpring.Ejercicio8_StarWars.entity.Personaje;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class PersonajeRepository implements ICRUD<Personaje> {

    public List<Personaje> getAll() {
        List<Personaje> personajes = new ArrayList<>();
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            File archivo = new File("src/main/resources/static/3. c. starwars.json");
            JsonNode jsonNode = objectMapper.readTree(archivo);

            for (JsonNode node : jsonNode) {
                Personaje personaje = new Personaje();
                personaje.setName(node.get("name").asText());
                personaje.setHeight(node.get("height").asInt());
                personaje.setMass(node.get("mass").asInt());
                personaje.setHairColor(node.get("hair_color").asText());
                personaje.setSkinColor(node.get("skin_color").asText());
                personaje.setEyeColor(node.get("eye_color").asText());
                personaje.setBirthYear(node.get("birth_year").asText());
                personaje.setGender(node.get("gender").asText());
                personaje.setHomeworld(node.get("homeworld").asText());
                personaje.setSpecies(node.get("species").asText());

                personajes.add(personaje);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return personajes;
    }

}
