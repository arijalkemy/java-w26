package org.meli.ejercicio4_testing_p3_1_starwars.IntegrationTest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.meli.ejercicio4_testing_p3_1_starwars.dto.CharacterDTO;
import org.meli.ejercicio4_testing_p3_1_starwars.utils.PersonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class FindControllerIntegrationTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName("Test de Integración 001 - obtención del personaje Luke Skywalker")
    public void findPersonajeLukeSkywalker() throws Exception {
        CharacterDTO character = PersonUtil.getListPerson().get(0);

        ObjectWriter objectMapper = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer().withDefaultPrettyPrinter();

        mockMvc.perform(
                        MockMvcRequestBuilders.get("/{query}", character.getName()))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("Test de Integración 001 - obtención del personaje mal formado")
    public void findPersonajeBadRequest() throws Exception {

        mockMvc.perform(
                        MockMvcRequestBuilders.get("/{query}", "$$"))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }
}


