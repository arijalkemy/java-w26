package org.example.multi_layer_p1_starwars.repository;

import com.google.gson.Gson;
import org.example.multi_layer_p1_starwars.dto.JsonDataDTO;
import org.example.multi_layer_p1_starwars.entity.Character;
import org.springframework.stereotype.Repository;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class CharacterRepository {
    private List<Character> characterList = new ArrayList<>();

    public CharacterRepository() throws FileNotFoundException {
        String filePath = "src/main/java/org/example/multi_layer_p1_starwars/db/characters.json";
        Gson gson = new Gson();
        try {
            FileReader reader = new FileReader(filePath);
            JsonDataDTO resultsData = gson.fromJson(reader, JsonDataDTO.class);
            this.characterList = resultsData.getResults();
        } catch (IOException ex) {
            ex.getCause();
        }
    }

    public List<Character> getAllCharacters() {
        return characterList;
    }
}
