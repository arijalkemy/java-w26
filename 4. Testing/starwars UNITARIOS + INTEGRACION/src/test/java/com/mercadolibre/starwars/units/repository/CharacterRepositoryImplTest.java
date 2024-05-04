package com.mercadolibre.starwars.units.repository;

import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.repositories.CharacterRepository;
import com.mercadolibre.starwars.repositories.CharacterRepositoryImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class CharacterRepositoryImplTest {

    private CharacterRepository repository;

    @BeforeEach
    void setUp() {
        repository = new CharacterRepositoryImpl();
    }

    @Test
    @DisplayName("Busca todos los personajes en el repositoryo y devuelve una lista no vacía")
    void findAllNotEmptyListCharacter() {
        //Arrange
        Integer sizeExpected = 2;

        //Act
        List<CharacterDTO> output = repository.findAllByNameContains("Darth");

        //Assert
        Assertions.assertEquals(sizeExpected, output.size());
    }

    @Test
    @DisplayName("Busca todos los personajes en el repositoryo pero no existe y devuelve una lista vacía")
    void findAllButIsAnEmptyListCharacter() {
        //Arrange
        Integer sizeExpected = 0;

        //Act
        List<CharacterDTO> output = repository.findAllByNameContains("Ronaldo");

        //Assert
        Assertions.assertEquals(sizeExpected, output.size());
    }
}
