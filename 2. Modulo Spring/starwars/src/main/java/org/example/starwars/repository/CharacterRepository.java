package org.example.starwars.repository;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.starwars.dto.CharacterDTO;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

@Repository
public class CharacterRepository {
    private static List<CharacterDTO> characters = new ArrayList<>();

    public CharacterRepository() {
        ObjectMapper mapper = new ObjectMapper();
        try {
            // Cargar el archivo JSON como InputStream
            InputStream inputStream = new ClassPathResource("data/data.json").getInputStream();

            // Leer el contenido del archivo JSON
            JsonNode jsonNode = mapper.readTree(inputStream);

            // Iterar sobre los nodos del JSON y crear objetos CharacterDTO
            for (JsonNode character : jsonNode) {
                String name = character.get("name").asText();
                Integer height = character.get("height").asInt();
                Integer mass = character.get("mass").asInt();
                String gender = character.get("gender").asText();
                String homeWorld = character.get("homeworld").asText();
                String species = character.get("species").asText();
                characters.add(new CharacterDTO(name, height, mass, gender, homeWorld, species));
            }

            // Cerrar el InputStream
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<CharacterDTO> getCharactersByName(String name) {
        return characters.stream().filter(person -> person.getName().contains(name)).toList();
    }
}
