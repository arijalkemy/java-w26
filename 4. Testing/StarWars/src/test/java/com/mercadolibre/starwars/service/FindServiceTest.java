package com.mercadolibre.starwars.service;

import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.repositories.CharacterRepository;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
public class FindServiceTest {

    @Mock
    private CharacterRepository characterRepository;

    @InjectMocks
    private FindService findService;

    public void findCharacterOk() {
        CharacterDTO param = new CharacterDTO();
        param.setName("Luke Skywalker");
        param.setHair_color("blond");
        param.setSkin_color("red");
        param.setEye_color("blue");
        param.setBirth_year("19BBY");
        param.setGender("male");
        param.setHomeworld("Tatooine");
        param.setSpecies("Human");
        param.setHeight(172);
        param.setMass(77);


        List<CharacterDTO> result = new ArrayList<>();
        result.add(param);

        when(characterRepository.findAllByNameContains(param.getName())).thenReturn(result);

        List<CharacterDTO> response = findService.find("Luke Skywalker");
    }




    }
}
