package controller;

import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.service.FindService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(classes = com.mercadolibre.starwars.StarWarsApplication.class)
@AutoConfigureMockMvc
public class FindControllerIntegrationTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private FindService findService;

    @Test
    void find_ShouldReturnCharacterDTOList() throws Exception {
        // Arrange
        String query = "Luke";
        CharacterDTO characterDTO1 = new CharacterDTO();
        characterDTO1.setName("Luke Skywalker");

        CharacterDTO characterDTO2 = new CharacterDTO();
        characterDTO2.setName("Luke");
        List<CharacterDTO> characterDTOList = Arrays.asList(characterDTO1, characterDTO2);

        given(findService.find(query)).willReturn(characterDTOList);

        // Act & Assert
        mockMvc.perform(get("/{query}", query)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].name").value("Luke Skywalker"))
                .andExpect(jsonPath("$[1].name").value("Luke"));
    }
}
