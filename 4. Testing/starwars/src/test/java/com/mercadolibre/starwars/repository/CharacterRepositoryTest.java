package com.mercadolibre.starwars.repository;

import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.repositories.CharacterRepository;
import com.mercadolibre.starwars.repositories.CharacterRepositoryImpl;
import org.junit.jupiter.api.*;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;

public class CharacterRepositoryTest {

    CharacterRepository characterRepository;


    @BeforeEach@AfterEach
    public void setUp() {
        characterRepository = new CharacterRepositoryImpl();

    }
    @Test
    public void testFindAllByNameContains() {
        //arrange
        CharacterDTO expected = new CharacterDTO();
        expected.setName("Luke Skywalker");

        //act
        CharacterDTO response = characterRepository.findAllByNameContains("Luke").get(0);

        //assert
        Assertions.assertEquals(expected.getName(),response.getName());

    }
}
