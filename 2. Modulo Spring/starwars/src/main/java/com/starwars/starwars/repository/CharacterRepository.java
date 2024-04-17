package com.starwars.starwars.repository;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.starwars.starwars.model.CharacterModel;
import com.starwars.starwars.utils.JsonManage;

@Service
public class CharacterRepository implements IRepository{
    
    private List<CharacterModel> characterList;

    public CharacterRepository() {
        this.fillCharactersfromJson();
    }

    public List<CharacterModel> findByName(String name) {
        return this.characterList.stream().filter(cha -> cha.getName().contains(name)).toList();
    }

    public void fillCharactersfromJson(){
        String jsonFile = "starwars.json";
        try{
            String jsonContent = JsonManage.loadJsonFile(jsonFile);
            List<CharacterModel> charactersFromJson = JsonManage.deserializeJson(jsonContent);
            this.characterList = charactersFromJson;
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    public List<CharacterModel> fillCharacters(){
        String jsonFilePath = "";
        List<CharacterModel> characterList = new ArrayList<>();

        ObjectMapper mapper = new ObjectMapper();

        try {
            String json = new String(Files.readAllBytes(Paths.get(jsonFilePath)));
            characterList = mapper.readValue(json, new TypeReference<List<CharacterModel>>(){});

        } catch (IOException e) {
            e.printStackTrace();
        }

        return characterList;
    }

    
}
