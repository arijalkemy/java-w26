package com.mercadolibre.starwars.repositories;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.mercadolibre.starwars.dto.CharacterDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class CharacterRepositoryImplTest {

    private CharacterRepository repository;

    private static ObjectMapper writer;

    @BeforeAll
    static void init() {
        CharacterRepositoryImplTest.writer =
                new ObjectMapper().configure(SerializationFeature.WRAP_ROOT_VALUE, false);
    }

    @BeforeEach
    void setUp() {
        this.repository = new CharacterRepositoryImpl();
    }

    @Test
    void getLukeCharacter() {
        // ----

        new CharacterDTO(
            "Luke Skywalker",
            "blond",
            "fair",
            "blue",
            "19BBY",
            "male",
            "Tatooine",
            "Human",
            77,
            172
        );
        //        List<String> lukeListString = lukeList.stream().map(c -> {
        //            try {
        //                return writer.writeValueAsString(c);
        //            } catch (JsonProcessingException e) {
        //                throw new RuntimeException(e);
        //            }
        //        }).collect(Collectors.toList());

        // ----
        List<CharacterDTO> resultList = this.repository.findAllByNameContains("Luke");

        Assertions.assertEquals(1, resultList.size());
        Assertions.assertTrue(resultList.get(0).getName().toLowerCase().contains("luke"));
    }

    @Test
    void getEmptyList() {
        List<CharacterDTO> resultList = this.repository.findAllByNameContains("Chespirito");

        Assertions.assertEquals(0, resultList.size());
    }
}