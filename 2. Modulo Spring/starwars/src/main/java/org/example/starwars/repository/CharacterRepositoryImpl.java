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
import java.util.stream.Collectors;

@Repository
public class CharacterRepositoryImpl implements CharacterRepository {
    List<CharacterDTO> characters;

    public CharacterRepositoryImpl() {
        characters = load();
    }

    private static List<CharacterDTO> load() {
        ObjectMapper mapper = new ObjectMapper();
        List<CharacterDTO> data = new ArrayList<>();
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
                data.add(new CharacterDTO(name, height, mass, gender, homeWorld, species));
            }

            // Cerrar el InputStream
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }

    public List<CharacterDTO> getCharactersByName(String name) {
        return characters.stream().filter(person -> person.getName().contains(name)).collect(Collectors.toList());
    }
}
