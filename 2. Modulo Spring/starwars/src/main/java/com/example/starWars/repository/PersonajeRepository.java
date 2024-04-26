package com.example.starWars.repository;

import com.example.starWars.dto.PersonajeDTO;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Repository;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class PersonajeRepository {

    private List<PersonajeDTO> personajeDTOS;

    PersonajeRepository(){
        this.personajeDTOS = new ArrayList<>();
        populate();
    }

    public void populate() {
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            // Leer el archivo JSON y convertirlo en un arreglo de objetos JSON
            JsonNode jsonNode = objectMapper.readTree(new ClassPathResource("data/starwars.json").getFile());

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
                this.personajeDTOS.add(new PersonajeDTO(nombre, altura, masa, genero, planeta, especie));
            }
            //System.out.println(this.personajeDTOS);

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public List<PersonajeDTO> findAll(){
        return this.personajeDTOS;
    }

}
