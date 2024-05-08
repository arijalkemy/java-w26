package com.mercadolibre.starwars.service;

import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.repositories.CharacterRepository;
import com.mercadolibre.starwars.util.TestUtilsGenerator;
import org.apache.commons.collections4.CollectionUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.stream.Collectors;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class FindServiceTests {
    String name;
    @Mock
    CharacterRepository characterRepository;

    @InjectMocks
    FindService findService;

    @BeforeEach
    public void setUp(){
        name = "Luke";
    }

    @Test
    @DisplayName("Obtener todos los personajes que contienen un fragmento del nombre solicitado de manera exitosa")
    public void findAllByNameContains(){
        //Arrange
        List<CharacterDTO> characters = TestUtilsGenerator.getAllByNameContains(name);
        when(characterRepository.findAllByNameContains(name)).thenReturn(characters);
        //Act
        List<CharacterDTO> foundSet = characterRepository.findAllByNameContains(name);
        //Assert
        Assertions.assertTrue(CollectionUtils.isEqualCollection(characters,foundSet));
    }
}
