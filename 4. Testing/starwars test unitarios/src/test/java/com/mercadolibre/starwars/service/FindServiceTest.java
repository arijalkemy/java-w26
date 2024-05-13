package com.mercadolibre.starwars.service;

import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.repositories.CharacterRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class FindServiceTest {
    @Mock
    CharacterRepository characterRepository;

    @InjectMocks
    FindService findService;

    @Test
    @DisplayName("encontar personajes por nombre serivce")
    public void findByNameTest() {

        CharacterDTO characterDTO = new CharacterDTO();
        characterDTO.setName("Luke Skywalker");
        List<CharacterDTO> characterDTOList = new ArrayList<>();
        characterDTOList.add(characterDTO);

        when(characterRepository.findAllByNameContains("Luke Skywalker")).thenReturn(characterDTOList);

        findService.find("Luke Skywalker");

        Assertions.assertEquals("Luke Skywalker", characterDTOList.get(0).getName());
    }
}
