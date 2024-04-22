package org.example.starswars.repository.repositoriesImpl;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.starswars.repository.IcharacterRepository;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import org.example.starswars.Model.Character;


@Repository
public class CharacterRepositoryImpl implements IcharacterRepository {
    private List<Character> listCharacters;

    public CharacterRepositoryImpl() {
        this.listCharacters =this.loadDataBase();
    }

    private List<Character> loadDataBase() {
        File file = null;
        try {
            file = ResourceUtils.getFile("classpath:starwars.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<Character>> typeRef = new TypeReference<>() {
        };
        List<Character> characters = null;
        try {
            characters = objectMapper.readValue(file, typeRef);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return characters;
    }

//    public StarWarsRepository() {
//        ObjectMapper objectMapper = new ObjectMapper();
//        try {
//            // Lee el archivo JSON y mapea su contenido a una lista de objetos Java
//            File jsonFile = new File("classpath:starwars.json");
//            Character[] characters = objectMapper.readValue(jsonFile, Character[].class);
//            this.listCharacters = List.of(characters);
//        } catch (MismatchedInputException e) {
//            // El formato del archivo JSON no coincide con la estructura esperada de la clase Character
//            throw new RuntimeException("El formato del archivo JSON es incorrecto", e);
//        } catch (IOException e) {
//            // Error al leer el archivo JSON
//            throw new RuntimeException("Error al leer el archivo JSON", e);
//        }
//    }

    public List<Character> allCharacters() {
        return this.listCharacters;
    }
}

