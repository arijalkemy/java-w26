package com.mercadolibre.starwars.repository;

import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.repositories.CharacterRepository;
import com.mercadolibre.starwars.repositories.CharacterRepositoryImpl;
import com.mercadolibre.starwars.util.TestUtilsGenerator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.apache.commons.collections4.CollectionUtils;

import java.util.List;
import java.util.stream.Collectors;

public class CharacterRepositoryTests {
    private String name;
    CharacterRepository characterRepository;

    @BeforeEach
    public void setUp(){
        this.characterRepository = new CharacterRepositoryImpl();
        this.name = "Luke";
    }

    @Test
    @DisplayName("Obtener todos los personajes que contienen un fragmento del nombre solicitado de manera exitosa")
    public void findAllByNameContains(){
        //Arrange
        List<CharacterDTO> characters = TestUtilsGenerator.getAllByNameContains(name);
        //Act
        List<CharacterDTO> foundSet = characterRepository.findAllByNameContains(name);
        //Assert
        Assertions.assertTrue(CollectionUtils.isEqualCollection(characters,foundSet));
    }
}
