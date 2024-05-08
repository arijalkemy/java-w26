package bootcamp.sprint.grupo02.sprintI.integration;

import bootcamp.sprint.grupo02.sprintI.dto.response.FollowedListResponseDTO;
import bootcamp.sprint.grupo02.sprintI.dto.response.FollowersListResponseDTO;
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

import java.util.List;

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
    @Test
    void followUserReturnsOk_test() throws Exception {
        int userId = 2;
        int userIdToFollow = 2;

        this.mockMvc.perform(MockMvcRequestBuilders.post("/users/{userId}/follow/{userIdToFollow}", userId, userIdToFollow))
                .andDo(print()).andExpect(status().isOk());
    }

    @Test
    void followUserBuyerNotExist_test() throws Exception {
        int userId = 3;
        int userIdToFollow = 2;

        this.mockMvc.perform(MockMvcRequestBuilders.post("/users/{userId}/follow/{userIdToFollow}", userId, userIdToFollow))
                .andDo(print()).andExpect(status().isNotFound())
                .andExpect(MockMvcResultMatchers.jsonPath("$.message")
                        .value("User not found: 3"));
    }
    @Test
    void followUserSellerNotExist_test() throws Exception {
        int userId = 1;
        int userIdToFollow = 10;

        this.mockMvc.perform(MockMvcRequestBuilders.post("/users/{userId}/follow/{userIdToFollow}", userId, userIdToFollow))
                .andDo(print()).andExpect(status().isNotFound())
                .andExpect(MockMvcResultMatchers.jsonPath("$.message")
                        .value("Seller not found: 10"));
    }

    @Test
    void followUserBadRequestAlreadyFollows_test() throws Exception {
        int userId = 1;
        int userIdToFollow = 1;

        this.mockMvc.perform(MockMvcRequestBuilders.post("/users/{userId}/follow/{userIdToFollow}", userId, userIdToFollow))
                .andDo(print()).andExpect(status().isBadRequest())
                .andExpect(MockMvcResultMatchers.jsonPath("$.message")
                        .value("Cannot follow seller because is already followed. "));
    }
    @Test
    void followUserEmptyReturnsHandlerException_test() throws Exception {
        int userId = 0;
        int userIdToFollow = 1;

        this.mockMvc.perform(MockMvcRequestBuilders.post("/users/{userId}/follow/{userIdToFollow}", userId, userIdToFollow))
                .andDo(print()).andExpect(status().isBadRequest())
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].message")
                        .value("El Id debe ser mayor a cero"));
    }
    @Test
    void unfollowUserReturnUnfollowException_test() throws Exception {
        int userId = 2;
        int userIdToFollow = 1;

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/users/{userId}/unfollow/{userIdToUnfollow}", userId, userIdToFollow))
                .andDo(print()).andExpect(status().isBadRequest())
                .andExpect(MockMvcResultMatchers.jsonPath("$")
                        .value("Cannot unfollow seller because not followed previously"));
    }
    @Test
    void whenGetFollowersListReturnsOk_test() throws Exception {
        int userId = 1;
        FollowersListResponseDTO followersListResponseDTO = new FollowersListResponseDTO();
        followersListResponseDTO.setUser(new UserResponseDTO(1, "Un Vendedor"));
        followersListResponseDTO.setFollowers(List.of(new UserResponseDTO(1, "Seguidor 1"),
                new UserResponseDTO(2, "Seguidor 2"),
                new UserResponseDTO(3, "Seguidor 3")));

        MvcResult mvcResult =
                this.mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followers/list", userId))
                        .andDo(print()).andExpect(status().isOk())
                        .andExpect(content().contentType("application/json"))
                        .andExpect(MockMvcResultMatchers.jsonPath("$.user_id").value(1))
                        .andExpect(MockMvcResultMatchers.jsonPath("$.user_name").value("Un Vendedor"))
                        .andExpect(MockMvcResultMatchers.jsonPath("followers[0].user_id").value(1))
                        .andExpect(MockMvcResultMatchers.jsonPath("followers[1].user_id").value(2))
                        .andExpect(MockMvcResultMatchers.jsonPath("followers[2].user_id").value(3))
                        .andReturn();

        String response = mvcResult.getResponse().getContentAsString();
        String expected = writer.writeValueAsString(followersListResponseDTO);

        Assertions.assertEquals(expected, response);
    }

    @Test
    void whenGetFollowersListSeller10ReturnsNotFound_test() throws Exception {
        int userId = 10;

        this.mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followers/list", userId))
                .andDo(print()).andExpect(status().isNotFound())
                .andExpect(MockMvcResultMatchers.jsonPath("$.message")
                        .value("No se encontró un vendedor con Id: 10"));
    }
    @Test
    void whenGetFollowersListAscOrderReturnsOk_test() throws Exception {
        int userId = 1;
        String order = "NAME_ASC";
        FollowersListResponseDTO followersListResponseDTO = new FollowersListResponseDTO();
        followersListResponseDTO.setUser(new UserResponseDTO(1, "Un Vendedor"));
        followersListResponseDTO.setFollowers(List.of(new UserResponseDTO(1, "Seguidor 1"),
                new UserResponseDTO(2, "Seguidor 2"),
                new UserResponseDTO(3, "Seguidor 3")));

        MvcResult mvcResult =
                this.mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followers/list", userId)
                                .param("order", order))
                        .andDo(print()).andExpect(status().isOk())
                        .andExpect(content().contentType("application/json"))
                        .andExpect(MockMvcResultMatchers.jsonPath("$.user_id").value(1))
                        .andExpect(MockMvcResultMatchers.jsonPath("$.user_name").value("Un Vendedor"))
                        .andExpect(MockMvcResultMatchers.jsonPath("followers[0].user_id").value(1))
                        .andExpect(MockMvcResultMatchers.jsonPath("followers[1].user_id").value(2))
                        .andExpect(MockMvcResultMatchers.jsonPath("followers[2].user_id").value(3))
                        .andReturn();

        String response = mvcResult.getResponse().getContentAsString();
        String expected = writer.writeValueAsString(followersListResponseDTO);

        Assertions.assertEquals(expected, response);
    }

    @Test
    void getSellersFollowedSeller1ReturnsOk_test() throws Exception {
        int userId = 1;
        FollowedListResponseDTO followedListResponseDTO = new FollowedListResponseDTO();
        followedListResponseDTO.setUser(new UserResponseDTO(1, "Comprador"));
        followedListResponseDTO.setFollowed(List.of(new UserResponseDTO(1, "Un Vendedor"),
                new UserResponseDTO(2, "Vendedor 2")));

        MvcResult mvcResult =
                this.mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followed/list", userId))
                        .andDo(print()).andExpect(status().isOk())
                        .andExpect(content().contentType("application/json"))
                        .andExpect(MockMvcResultMatchers.jsonPath("$.user_id")
                                .value(1))
                        .andExpect(MockMvcResultMatchers.jsonPath("$.user_name")
                                .value("Comprador"))
                        .andExpect(MockMvcResultMatchers.jsonPath("$.followed[0].user_id")
                                .value(1))
                        .andExpect(MockMvcResultMatchers.jsonPath("$.followed[0].user_name")
                                .value("Un Vendedor"))
                        .andExpect(MockMvcResultMatchers.jsonPath("$.followed[1].user_id")
                                .value(2))
                        .andReturn();
        String response = mvcResult.getResponse().getContentAsString();
        String expected = writer.writeValueAsString(followedListResponseDTO);

        Assertions.assertEquals(expected, response);
    }

    @Test
    void whenGetFollowersListBuyer10ReturnsNotFound_test() throws Exception {
        int userId = 10;

        this.mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followed/list", userId))
                .andDo(print()).andExpect(status().isNotFound())
                .andExpect(MockMvcResultMatchers.jsonPath("$.message")
                        .value("No buyer founded with ID [10]"));
    }
}

