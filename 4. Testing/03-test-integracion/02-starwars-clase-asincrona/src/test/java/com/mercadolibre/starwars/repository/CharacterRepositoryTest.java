package com.mercadolibre.starwars.repository;

import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.repositories.CharacterRepository;
import com.mercadolibre.starwars.repositories.CharacterRepositoryImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CharacterRepositoryTest {

    private CharacterRepository characterRepository;

    private List<CharacterDTO> characters;

    @BeforeEach
    void setUp(){
        characterRepository = new CharacterRepositoryImpl();
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
    @DisplayName("Encontrar personajes por nombre")
    void findAllByNameConstraints(){
        List<CharacterDTO> actual = characterRepository.findAllByNameContains("dar");

        assertEquals(characters, actual);
    }
}
