package org.example.be_java_hisp_w26_g04.service.integration;
import org.example.be_java_hisp_w26_g04.model.Buyer;
import org.example.be_java_hisp_w26_g04.model.Seller;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerIntegration {
    @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName("Comprador sigue a un vendedor correctamente")
    void userFollowAnotherOkTest() throws Exception{
        int userId = 789;
        int userIdToFollow = 123;

        Buyer buyer = new Buyer();
        Seller seller = new Seller();
        this.mockMvc.perform(MockMvcRequestBuilders.post("/users/" + userId + "/follow/" + userIdToFollow)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("Mostrar correctamente cantidad de seguidores")
    void showUserFollowersOkTest() throws Exception {
        int userId = 123;
        mockMvc.perform(MockMvcRequestBuilders.get("/users/" + userId + "/followers/count")
                .contentType(MediaType.APPLICATION_JSON)).andDo(print())
                .andExpect(status().isOk())
                //Se utiliza el nombre de atributo definido en @JsonProperty dentro del DTO
                .andExpect(jsonPath("$.user_id").value(userId))
                .andExpect(jsonPath("$.user_name").value("JohnDoe"))
                .andExpect(jsonPath("$.followers_count").value(2));
    }
}
