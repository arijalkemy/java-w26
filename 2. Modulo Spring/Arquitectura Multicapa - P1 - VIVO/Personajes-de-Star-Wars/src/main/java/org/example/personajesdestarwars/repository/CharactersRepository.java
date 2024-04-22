package org.example.personajesdestarwars.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.personajesdestarwars.entity.Character;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.util.List;

@Repository
public class CharactersRepository {

    public static List<Character> getAllCharacters() throws IOException {

        ClassPathResource resource = new ClassPathResource("starwars.json");

        // Mapear el archivo JSON a una lista de objetos de la clase Character
        ObjectMapper objectMapper = new ObjectMapper();

        return objectMapper.readValue(resource.getInputStream(), new TypeReference<>() {
        });
    }
}

