package com.spring.starwars.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.spring.starwars.entity.StarWarsCharacter;
import lombok.Getter;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Repository
public class StarWarsRepository {

    private List<StarWarsCharacter> starWarsCharacters;

    public StarWarsRepository() {
        this.starWarsCharacters = loadJSONData();
    }

    private List<StarWarsCharacter> loadJSONData(){
        try{
            File file = ResourceUtils.getFile("classpath:starwars.json");
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.readValue(
                    file, new TypeReference<List<StarWarsCharacter>>(){}
            );
        } catch (FileNotFoundException e) {
            System.out.println("Archivo no encontrado: " + e.getMessage());
        } catch (IOException e) {
            //throw new RuntimeException(e);
            System.out.println("Error en el manejo del archivo: " + e.getMessage());
        }
        return new ArrayList<>();
    }
}
