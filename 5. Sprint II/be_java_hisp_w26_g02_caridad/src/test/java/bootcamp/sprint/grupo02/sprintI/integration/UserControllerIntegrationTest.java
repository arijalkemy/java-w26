package bootcamp.sprint.grupo02.sprintI.integration;

import bootcamp.sprint.grupo02.sprintI.dto.response.SellerFollowersResponseDTO;
import bootcamp.sprint.grupo02.sprintI.dto.response.UserResponseDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    private static ObjectMapper objectMapper;
    private static ObjectWriter writer;

    @BeforeAll
    public static void setup() {
        objectMapper = new ObjectMapper();
        writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();
    }

    @Test
    void getSellerWithNumberOfFollowers() throws Exception {
        int userId = 1;
        SellerFollowersResponseDTO sellerFollowersResponseDTO = new SellerFollowersResponseDTO();
        sellerFollowersResponseDTO.setUser(new UserResponseDTO(1, "Un Vendedor"));
        sellerFollowersResponseDTO.setFollowersCount(3);

        MvcResult mvcResult =
                this.mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followers/count", userId))
                        .andDo(print()).andExpect(status().isOk())
                        .andExpect(content().contentType("application/json"))
                        .andExpect(MockMvcResultMatchers.jsonPath("$.user_id" )
                                .value(userId))
                        .andExpect(MockMvcResultMatchers.jsonPath("$.user_name" )
                                .value("Un Vendedor"))
                        .andExpect(MockMvcResultMatchers.jsonPath("$.followers_count" )
                                .value(3)).andReturn();

        String response = mvcResult.getResponse().getContentAsString();
        String expected = writer.writeValueAsString(sellerFollowersResponseDTO);

        Assertions.assertEquals(expected, response);
    }

}

