package com.mercadolibre.starwars.repositories;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mercadolibre.starwars.dto.CharacterDTO;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.stream.Collectors;

@Repository
public class CharacterRepositoryImpl implements CharacterRepository {
  private List<CharacterDTO> database;

  public CharacterRepositoryImpl() {
    this.database = loadDataBase();
  }

  @Override
  public List<CharacterDTO> findAllByNameContains(String query) {
    database = loadDataBase();

    return database.stream()
        .filter(characterDTO -> matchWith(query, characterDTO))
        .collect(Collectors.toList());
  }

  private boolean matchWith(String query, CharacterDTO characterDTO) {
    return characterDTO.getName().toUpperCase().contains(query.toUpperCase());
  }


  private List<CharacterDTO> loadDataBase() {
    File file = null;

    Properties properties = new Properties();


    try {
      properties.load(new ClassPathResource("application.properties").getInputStream());
      String scope = properties.getProperty("api.scope");

      file = ResourceUtils.getFile("./src/" + scope + "/resources/starwars_characters.json");
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
        throw new RuntimeException(e);
    }
      ObjectMapper objectMapper = new ObjectMapper();

    TypeReference<List<CharacterDTO>> typeRef = new TypeReference<>() {};
    List<CharacterDTO> characters = null;
    try {
      characters = objectMapper.readValue(file, typeRef);
    } catch (IOException e) {
      e.printStackTrace();
    }
    return characters;
  }
}
