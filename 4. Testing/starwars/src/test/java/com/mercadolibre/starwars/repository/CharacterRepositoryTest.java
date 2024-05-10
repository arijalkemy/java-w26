package com.mercadolibre.starwars.repository;

import com.mercadolibre.starwars.repositories.CharacterRepositoryImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ContextConfiguration(classes = {CharacterRepositoryImpl.class})
@ExtendWith(SpringExtension.class)
public class CharacterRepositoryTest {
    @Autowired
    private CharacterRepositoryImpl characterRepositoryImpl;

    @Test
    void FindAllByNameContains() {
        // Arrange, Act and Assert
        assertTrue(characterRepositoryImpl.findAllByNameContains("Query").isEmpty());
        assertEquals(87, characterRepositoryImpl.findAllByNameContains("").size());
    }
}
