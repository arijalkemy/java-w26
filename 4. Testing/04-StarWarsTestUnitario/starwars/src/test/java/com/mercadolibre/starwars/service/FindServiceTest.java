package com.mercadolibre.starwars.service;

import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.repositories.CharacterRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.List;
import static com.mercadolibre.starwars.util.CreateCharacterUtil.createLuke;
import static org.mockito.Mockito.when;



@ExtendWith(MockitoExtension.class)
@AutoConfigureMockMvc
@SpringBootTest
public class FindServiceTest {

    @Mock
    CharacterRepository characterRepository;

    @InjectMocks
    FindService findService;

    @BeforeEach
    private void setUp(){
        this.findService =  new FindService(characterRepository);
    }


    @Test
    @DisplayName("Find Service Test")
    public void findTest(){
        //aasert
        String name = "Luke";
        CharacterDTO character = createLuke();
        List<CharacterDTO> charactersExpected = List.of(character);


        //act
        when(characterRepository.findAllByNameContains(name)).thenReturn(charactersExpected);
        List<CharacterDTO> charactersObtained = findService.find(name);

        //assert
        Assertions.assertEquals(charactersExpected, charactersObtained);

    }
}
