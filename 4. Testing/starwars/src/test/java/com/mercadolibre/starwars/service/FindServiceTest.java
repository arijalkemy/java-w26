package com.mercadolibre.starwars.service;


import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.repositories.CharacterRepository;
import com.mercadolibre.starwars.util.UtilTestCharacters;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.stream.Collectors;

import static org.mockito.Mockito.when;

@SpringBootTest
public class FindServiceTest {

    @Mock
    CharacterRepository repository;

    @InjectMocks
    FindService service;

    private List<CharacterDTO> characters;
    private final List<String> charactersName = List.of("luck", "Dark");

    @BeforeEach
    public void setup(){
        characters = UtilTestCharacters.generateListOfCharacters(charactersName);
    }



    private void whenServiceFind(String search){
        when(service.find(search)).thenReturn(UtilTestCharacters.filterCharacters(characters,search));
    }

    @Test
    @DisplayName("testing FindService.find ok")
    public void testFindServiceFind(){
        String search = charactersName.get(0);
        whenServiceFind(search);
        List<CharacterDTO> expected = characters.stream()
                .filter(c -> c.getName().contains(search)).collect(Collectors.toList());
        List<CharacterDTO> result = service.find(search);

        Assertions.assertEquals(expected, result);
    }

}
