package com.mercadolibre.starwars.controller;

import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.service.FindService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
public class FindControllerTests {

    @Mock
    private FindService findService;

    @InjectMocks
    private FindController findController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    private CharacterDTO createCharacter(String name, String hairColor) {
        CharacterDTO characterDTO = new CharacterDTO();
        characterDTO.setName(name);
        characterDTO.setHair_color(hairColor);
        return characterDTO;
    }

    @Test
    public void findControllerFindOkTest() {
        String query = "test";
        List<CharacterDTO> characterDTOList = Arrays.asList(
                createCharacter("Luke Skywalker", "blond"),
                createCharacter("Leia Organa", "brown")
        );

        when(findService.find(query)).thenReturn(characterDTOList);

        List<CharacterDTO> result = findController.find(query);
        assertEquals(2, result.size());
        assertEquals("Luke Skywalker", result.get(0).getName());
        assertEquals("blond", result.get(0).getHair_color());
        assertEquals("Leia Organa", result.get(1).getName());
        assertEquals("brown", result.get(1).getHair_color());
    }

    @Test
    public void findControllerFindThrowsRuntimeExceptionTest() {
        String query = "test";
        when(findService.find(query)).thenThrow(new RuntimeException("Service exception"));

        assertThrows(RuntimeException.class, () -> findController.find(query));
    }

}
