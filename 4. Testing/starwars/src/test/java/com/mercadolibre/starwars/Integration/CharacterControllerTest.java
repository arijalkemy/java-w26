package com.mercadolibre.starwars.Integration;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.mercadolibre.starwars.dto.CharacterDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
@AutoConfigureMockMvc
public class CharacterControllerTest {

    @Autowired
    MockMvc mockMvc;

    private static ObjectWriter writer;

    private static ObjectMapper objectMapper;


    @BeforeAll
    public static void setup() {
        writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();

        objectMapper = new ObjectMapper();

    }

    @Test
    public void testFind() throws Exception {

        List<CharacterDTO> characterDTOSResult = new ArrayList<>();

        CharacterDTO character1 = new CharacterDTO();
        character1.setName("Darth Vader");
        character1.setHair_color("none");
        character1.setSkin_color("white");
        character1.setEye_color("yellow");
        character1.setBirth_year("41.9BBY");
        character1.setGender("male");
        character1.setHomeworld("Tatooine");
        character1.setSpecies("Human");
        character1.setHeight(202);
        character1.setMass(136);

        CharacterDTO character2 = new CharacterDTO();
        character2.setName("Darth Maul");
        character2.setHair_color("none");
        character2.setSkin_color("red");
        character2.setEye_color("yellow");
        character2.setBirth_year("54BBY");
        character2.setGender("male");
        character2.setHomeworld("Dathomir");
        character2.setSpecies("Zabrak");
        character2.setHeight(175);
        character2.setMass(80);

        characterDTOSResult.add(character1);
        characterDTOSResult.add(character2);



        ResultActions result =
                mockMvc.perform(
                        MockMvcRequestBuilders.get("/{query}","darth")
                                .contentType("application/json")
                        );

        result.andDo(print())
                .andExpect(content().contentType("application/json"))
                .andExpect(status().isOk())
                .andReturn();


        String responseContent = result.andReturn().getResponse().getContentAsString();
        List<CharacterDTO> responseDTOs = objectMapper.readValue(responseContent, new TypeReference<List<CharacterDTO>>(){});

        List<String> expectedNames = characterDTOSResult.stream()
                .map(CharacterDTO::getName)
                .collect(Collectors.toList());

        List<String> actualNames = responseDTOs.stream()
                .map(CharacterDTO::getName)
                .collect(Collectors.toList());

        Assertions.assertEquals(expectedNames, actualNames);

    }
}
