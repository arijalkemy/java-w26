package com.example.starwars.repository;

import com.example.starwars.dto.CharacterDTO;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Repository;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Repository
@Data
public class CharacterRepository  implements ICharacterRepo{
    private List<CharacterDTO> characterDTOS;

    CharacterRepository(){
        this.characterDTOS = new ArrayList<>();
        populate();
        System.out.println(characterDTOS.size());
    }

    public void populate() {
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            // Leer el archivo JSON y convertirlo en un arreglo de objetos JSON
            JsonNode jsonNode = objectMapper.readTree(new ClassPathResource("static/starwars.json").getFile());

            // Iterar sobre cada objeto JSON en el arreglo
            for (JsonNode objeto : jsonNode) {
                // Extraer datos de cada objeto
                String nombre = objeto.get("name").asText();
                Integer altura = objeto.get("height").asInt();
                Integer masa = objeto.get("mass").asInt();
                String genero = objeto.get("gender").asText();
                String planeta = objeto.get("homeworld").asText();
                String especie = objeto.get("species").asText();
                //System.out.println("");
                this.characterDTOS.add(new CharacterDTO(nombre, altura, masa, genero, planeta, especie));
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public List<CharacterDTO> findAll(){
        return this.characterDTOS;
    }
}

