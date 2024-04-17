package co.com.mercadolibre.starwars.repository.impl;

import co.com.mercadolibre.starwars.entity.CustomCharacter;
import co.com.mercadolibre.starwars.repository.ICustomCharacterRepository;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

@Repository
public class CustomCharacterRepository implements ICustomCharacterRepository {

    @Override
    public CustomCharacter findByName(String name) {
        try {
            String jsonContent = new String(Files.readAllBytes(Paths.get("src/main/resources/starwars.json")));
            ObjectMapper objectMapper = new ObjectMapper();
            List<CustomCharacter> characterList = objectMapper.readValue(jsonContent,
                    new TypeReference<List<CustomCharacter>>() {
            });

            for (CustomCharacter customCharacter : characterList) {
                if (customCharacter.getName().toLowerCase().contains(name.toLowerCase())) {
                    return customCharacter;
                }
            }
        } catch (IOException exception) {
            exception.printStackTrace();
        }
        return null;
    }
}
