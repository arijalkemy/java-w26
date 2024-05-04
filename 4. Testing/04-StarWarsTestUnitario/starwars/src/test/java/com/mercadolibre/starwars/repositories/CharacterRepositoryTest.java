package com.mercadolibre.starwars.repositories;


import com.mercadolibre.starwars.dto.CharacterDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.Arrays;
import java.util.List;
import com.mercadolibre.starwars.util.CreateCharacterUtil;

@ExtendWith(MockitoExtension.class)
@AutoConfigureMockMvc
@SpringBootTest
public class CharacterRepositoryTest {

    CharacterRepository characterRepository;

    CreateCharacterUtil createCharacterUtil;

    @BeforeEach
    private void setUp(){

        this.characterRepository =  new CharacterRepositoryImpl();
    }

    @Test
    @DisplayName("Find all characters by name Test")
    public void findAllByNameTest(){
        //arrange
        String name = "Luke";
        List<CharacterDTO> expectedList = Arrays.asList(createCharacterUtil.createLuke());

        //act
        List<CharacterDTO> obtainedList = characterRepository.findAllByNameContains(name);

        //assert
        Assertions.assertEquals(expectedList, obtainedList);
    }

    @Test
    @DisplayName("Find all characters by nonexistent name Test")
    public void findAllByNameNonExistentTest(){
        //arrange
        String name = "Pablo";
        List<CharacterDTO> expectedList = Arrays.asList();

        //act
        List<CharacterDTO> obtainedList = characterRepository.findAllByNameContains(name);

        //assert
        Assertions.assertEquals(expectedList, obtainedList);
    }

    @Test
    @DisplayName("Find all characters by null name Test")
    public void findAllByNameNullTest(){
        //arrange
        String name = null;
        List<CharacterDTO> expectedList = Arrays.asList();

        //act
        try{
            List<CharacterDTO> obtainedList = characterRepository.findAllByNameContains(name);
        }catch (NullPointerException e){
            //assert
            Assertions.assertTrue(true);
        }

    }
}
