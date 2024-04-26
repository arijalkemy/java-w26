package org.example.starwars.repository;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.tomcat.util.json.JSONParser;
import org.example.starwars.dto.PersonajeDTO;
import org.example.starwars.model.Personaje;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class PersonajeRepository {

    public List<Personaje> findAll() throws IOException {
        File json = null;
        json = ResourceUtils.getFile("classpath:starwars.json");

        ObjectMapper mapper = new ObjectMapper();
        TypeReference<List<Personaje>> typeRef = new TypeReference<>() {};

        List<Personaje> personajes = null;
        personajes = mapper.readValue(json, typeRef);

        return personajes;
    }
}
