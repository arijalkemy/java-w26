package org.example.be_java_hisp_w26_g04.service.integration_tests;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.be_java_hisp_w26_g04.dto.BuyerDTO;
import org.example.be_java_hisp_w26_g04.dto.FollowersCountDTO;
import org.example.be_java_hisp_w26_g04.dto.SellerFollowersDTO;
import org.example.be_java_hisp_w26_g04.dto.UserDTO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.http.MediaType;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer;

import java.util.Arrays;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    @Order(1)
    @DisplayName("El vendedor 123 tiene 1 seguidor (verifico cantidad correcta).")
    public void getFollowersCountTest() throws Exception {
        //Arrange
        FollowersCountDTO expectedFollowersCountDTO = new FollowersCountDTO();
        expectedFollowersCountDTO.setUserId(123);
        expectedFollowersCountDTO.setUserName("JohnDoe");
        expectedFollowersCountDTO.setFollowersCount(1);

        ObjectMapper mapper = new ObjectMapper();
        String expectedJson = mapper.writeValueAsString(expectedFollowersCountDTO);

        // Act & Assert
        mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followers/count", expectedFollowersCountDTO.getUserId())
                        .param("userId", String.valueOf(expectedFollowersCountDTO.getUserId())))
                .andExpect(status().isOk())
                .andExpect(content().json(expectedJson));
    }

    @Test
    @Order(2)
    @DisplayName("Devuelve bad request si ingreso un vendedor inexistente 999.")
    public void getFollowersCountSadPathTest() throws Exception {
        //Arrange
        FollowersCountDTO expectedFollowersCountDTO = new FollowersCountDTO();
        expectedFollowersCountDTO.setUserId(999);
        expectedFollowersCountDTO.setUserName("JohnDoe");
        expectedFollowersCountDTO.setFollowersCount(1);

        // Act & Assert
        mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followers/count", expectedFollowersCountDTO.getUserId())
                        .param("userId", String.valueOf(expectedFollowersCountDTO.getUserId())))
                .andExpect(status().isBadRequest());
    }

    @Test
    @Order(3)
    @DisplayName("El usuario 789 puede darle follow al vendedor 123 correctamente.")
    public void followTest() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders.post("/users/{userId}/follow/{userIdToFollow}", "789", "123")
                        .param("userId", "789")
                        .param("userIdToFollow", "123"))
                .andExpect(status().isOk());
    }

    @Test
    @Order(4)
    @DisplayName("Devuelve bad request al dar follow a usuario inexistente 999.")
    public void followSadPathTest() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders.post("/users/{userId}/follow/{userIdToFollow}", "789", "999")
                .param("userId", "789")
                .param("userIdToFollow", "999"))
                .andExpect(status().isBadRequest());
    }

    @Test
    @Order(5)
    @DisplayName("El usuario 789 puede darle unfollow al vendedor 123 correctamente.")
    public void unfollowTest() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders.post("/users/{userId}/unfollow/{userIdToUnfollow}", "789", "123")
                        .param("userId", "789")
                        .param("userIdToUnfollow", "123"))
                .andExpect(status().isOk());
    }

    @Test
    @Order(6)
    @DisplayName("Verifico que devuelve bad request al dar unfollow a usuario inexistente 999.")
    public void unfollowSadPathTest() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders.post("/users/{userId}/unfollow/{userIdToUnfollow}", "789", "999")
                        .param("userId", "789")
                        .param("userIdToUnfollow", "999"))
                .andExpect(status().isBadRequest());
    }

    @Test
    @Order(7)
    @DisplayName("El vendedor 234 me devuelve sus seguidores 789 y 456 correctamente.")
    public void sortFollowersTest() throws Exception {

        SellerFollowersDTO sellerFollowersDTO = new SellerFollowersDTO();
        sellerFollowersDTO.setId(234);
        sellerFollowersDTO.setUsername("JaneSmith");
        sellerFollowersDTO.setFollowers(Arrays.asList(
                new UserDTO(789, "AliceSmith"),
                new UserDTO(456, "JaneDoe")
        ));

        ObjectMapper mapper = new ObjectMapper();
        String expectedJson = mapper.writeValueAsString(sellerFollowersDTO);

        mockMvc.perform(MockMvcRequestBuilders.get("/users/234/followers/list?order=name_asc")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json(expectedJson));
    }

    @Test
    @Order(8)
    @DisplayName("El vendedor 234 me devuelve sus seguidores 789 y 456 sin indicarle orden correctamente.")
    public void sortFollowersNoOrderTest() throws Exception {

        SellerFollowersDTO sellerFollowersDTO = new SellerFollowersDTO();
        sellerFollowersDTO.setId(234);
        sellerFollowersDTO.setUsername("JaneSmith");
        sellerFollowersDTO.setFollowers(Arrays.asList(
                new UserDTO(789, "AliceSmith"),
                new UserDTO(456, "JaneDoe")
        ));

        ObjectMapper mapper = new ObjectMapper();
        String expectedJson = mapper.writeValueAsString(sellerFollowersDTO);

        mockMvc.perform(MockMvcRequestBuilders.get("/users/234/followers/list")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json(expectedJson));
    }

    @Test
    @Order(9)
    @DisplayName("Verifico que el usuario 456 sigue a los vendedores 234 y 123 correctamente.")
    public void sortFollowedTest() throws Exception {

        BuyerDTO  buyerDTO = new BuyerDTO();
        buyerDTO.setUserId(456);
        buyerDTO.setUserName("JaneDoe");
        buyerDTO.setFollowed(Arrays.asList(
                new UserDTO(234, "JaneSmith"),
                new UserDTO(123, "JohnDoe")
        ));

        ObjectMapper mapper = new ObjectMapper();
        String expectedJson = mapper.writeValueAsString(buyerDTO);

        mockMvc.perform(MockMvcRequestBuilders.get("/users/456/followed/list")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json(expectedJson));
    }

    @Test
    @Order(10)
    @DisplayName("Verifico que devuelve bad request cuando un usuario inexistente 999 sigue a los vendedores 234 y 123.")
    public void sortFollowedSadPathTest() throws Exception {

        BuyerDTO  buyerDTO = new BuyerDTO();
        buyerDTO.setUserId(999);
        buyerDTO.setUserName("JaneDoe");
        buyerDTO.setFollowed(Arrays.asList(
                new UserDTO(234, "JaneSmith"),
                new UserDTO(123, "JohnDoe")
        ));

        ObjectMapper mapper = new ObjectMapper();
        String expectedJson = mapper.writeValueAsString(buyerDTO);

        mockMvc.perform(MockMvcRequestBuilders.get("/users/999/followed/list")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }

}
