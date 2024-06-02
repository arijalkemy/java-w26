package org.example.starwars.Integration;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class CharacterController {

    @Autowired
    MockMvc mockMvc;

    @Test
    void findAllCharactersWithName() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/find?name=Luke")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isNotEmpty()
        );
    }

    @Test
    void findAllCharactersWithNameNotFound() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/find?name=AnythingElse")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isEmpty()
        );
    }
}
