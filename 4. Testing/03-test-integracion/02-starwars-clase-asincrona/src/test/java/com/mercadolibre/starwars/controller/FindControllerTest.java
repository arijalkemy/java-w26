package com.mercadolibre.starwars.controller;

import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.service.FindService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class FindControllerTest {

    @Mock
    private FindService findService;

    @InjectMocks
    private FindController findController;

    private List<CharacterDTO> characters;

    @BeforeEach
    void setUp(){
        characters = List.of(
                CharacterDTO.builder()
                        .name("Darth Vader")
                        .hair_color("none")
                        .skin_color("white")
                        .eye_color("yellow")
                        .birth_year("41.9BBY")
                        .gender("male")
                        .homeworld("Tatooine")
                        .species("Human")
                        .height(202)
                        .mass(136)
                        .build(),
                CharacterDTO.builder()
                        .name("Biggs Darklighter")
                        .hair_color("black")
                        .skin_color("light")
                        .eye_color("brown")
                        .birth_year("24BBY")
                        .gender("male")
                        .homeworld("Tatooine")
                        .species("Human")
                        .height(183)
                        .mass(84)
                        .build(),
                CharacterDTO.builder()
                        .name("Darth Maul")
                        .hair_color("none")
                        .skin_color("red")
                        .eye_color("yellow")
                        .birth_year("54BBY")
                        .gender("male")
                        .homeworld("Dathomir")
                        .species("Zabrak")
                        .height(175)
                        .mass(80)
                        .build()
        );
    }

    @Test
    @DisplayName("Encontrar persona")
    void findCharacter(){
        when(findService.find("dar")).thenReturn(characters);

        List<CharacterDTO> actual = findController.find("dar");
        assertEquals(characters, actual);
    }
}
