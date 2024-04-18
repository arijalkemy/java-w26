package org.responseentity.starwars.characters.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.responseentity.starwars.characters.entity.CharacterEntity;
import org.responseentity.starwars.characters.utils.JSONManage;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@Service
public class CharacterRepository {
    private List<CharacterEntity> characters;

    public CharacterRepository() {
        this.fillCharactersFromJson();
        //this.fillCharactersFromJson();
    }

    /* DB Methods */
    public List<CharacterEntity> findCharacterByName(String characterName){
        return this.characters.stream().filter(cha -> cha.getName().contains(characterName)).toList();
    }

    public void fillCharactersFromJson(){
        String jsonFile = "starwars.json";
        try{
            String jsonContent = JSONManage.loadJsonFile(jsonFile);
            List<CharacterEntity> characterFromJson = JSONManage.deserializeJson(jsonContent);
            this.characters = characterFromJson;
        }catch (Exception ex){
            System.out.println(ex.getCause());
        }
    }

    public List<CharacterEntity> fillCharacters(){
        String jsonFilePath = "";
        List<CharacterEntity> characters = new ArrayList<>();

        ObjectMapper mapper = new ObjectMapper();

        try {
            String json = new String(Files.readAllBytes(Paths.get(jsonFilePath)));
            characters = mapper.readValue(json, new TypeReference<List<CharacterEntity>>(){});

        } catch (IOException e) {
            e.printStackTrace();
        }

        return characters;
    }
}
