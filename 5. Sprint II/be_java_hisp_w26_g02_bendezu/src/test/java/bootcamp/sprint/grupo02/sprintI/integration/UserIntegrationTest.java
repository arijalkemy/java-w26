package bootcamp.sprint.grupo02.sprintI.integration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Comparator;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;

import bootcamp.sprint.grupo02.sprintI.dto.response.FollowedListResponseDTO;
import bootcamp.sprint.grupo02.sprintI.dto.response.FollowersListResponseDTO;
import bootcamp.sprint.grupo02.sprintI.dto.response.UserResponseDTO;
import bootcamp.sprint.grupo02.sprintI.enums.AlfabeticOrder;
import bootcamp.sprint.grupo02.sprintI.util.TestGeneratorUtil;

@SpringBootTest
@AutoConfigureMockMvc
public class UserIntegrationTest {

    @Autowired
    MockMvc mockMvc;

    private static ObjectWriter WRITER;
    private static final String USER_URI = "/users/%s";

    @BeforeAll
    public static void init() {
        WRITER = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();
    }

    @Test
    void givenExistUsers_whenFollow_then200() throws Exception {
        int buyerId = 1;
        int sellerId = 2;
        this.mockMvc
                .perform(followRequest(buyerId, sellerId))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void givenAlreadyFollow_whenFollow_then400() throws Exception {
        int buyerId = 1;
        int sellerId = 1;
        this.mockMvc
                .perform(followRequest(buyerId, sellerId))
                .andDo(print())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.message").value("Cannot follow seller because is already followed. "));
    }

    @Test
    void givenNoExistBuyer_whenFollow_then404AndMessage() throws Exception {
        int buyerId = 10;
        int sellerId = 2;
        followAndNotExistBase(buyerId, sellerId, "User not found: 10");
    }

    @Test
    void givenNoExistSeller_whenFollow_then404AndMessage() throws Exception {
        int buyerId = 1;
        int sellerId = 20;
        followAndNotExistBase(buyerId, sellerId, "Seller not found: 20");
    }

    @Test
    void givenInvalidId_whenFollow_then400() throws Exception {
        int buyerId = -1;
        int sellerId = -2;

        this.mockMvc.perform(followRequest(buyerId, sellerId))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$[0].message").value("El Id debe ser mayor a cero"))
                .andExpect(jsonPath("$[1].message").value("El Id debe ser mayor a cero"));

    }

    @Test
    void givenNoFollowSeller_whenUnFollow_then404() throws Exception {
        int buyerId = 1;
        int sellerId = 2;

        this.mockMvc.perform(MockMvcRequestBuilders.post(buildUrl("{userId}/unfollow/{userIdToUnfollow}"), buyerId, sellerId))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.message").value("Cannot unfollow seller because not followed previously"));
    }

    @Test
    void givenUserWithFollowers_whenFollowerList_then200AndList() throws Exception {
        FollowersListResponseDTO dto = TestGeneratorUtil.createFollowersListResponseDTO();

        String expected = WRITER.writeValueAsString(dto);

        MockHttpServletResponse response = this.mockMvc
                .perform(MockMvcRequestBuilders.get(buildUrl("{userId}/followers/list"), 1))
                .andDo(print())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn()
                .getResponse();

        assertEquals(expected, response.getContentAsString());
    }

    @Test
    void givenUserWithFollowed_whenFollowedList_then200AndList() throws Exception {
        FollowedListResponseDTO dto = TestGeneratorUtil.createFollowedListResponseDTO();

        String expected = WRITER.writeValueAsString(dto);

        MockHttpServletResponse response = this.mockMvc
                .perform(MockMvcRequestBuilders.get(buildUrl("{userId}/followed/list"), 1))
                .andDo(print())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn()
                .getResponse();

        assertEquals(expected, response.getContentAsString());
    }

    @Test
    void givenUserWithFollowers_whenFollowerListWithOrderDesc_then200AndList() throws Exception {
        FollowersListResponseDTO dto = TestGeneratorUtil.createFollowersListResponseDTO();
        dto.getFollowers().sort(Comparator.comparing(UserResponseDTO::getUserName).reversed());
        String expected = WRITER.writeValueAsString(dto);

        MockHttpServletResponse response = this.mockMvc
                .perform(MockMvcRequestBuilders.get(buildUrl("{userId}/followers/list"), 1)
                        .param("order", AlfabeticOrder.NAME_DESC.name()))
                .andDo(print())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn()
                .getResponse();

        assertEquals(expected, response.getContentAsString());
    }

    
    @Test
    void givenUserWithFollowed_whenFollowedListWithOrderDesc_then200AndList() throws Exception {
        FollowedListResponseDTO dto = TestGeneratorUtil.createFollowedListResponseDTO();
        dto.getFollowed().remove(1);
        String expected = WRITER.writeValueAsString(dto);

        MockHttpServletResponse response = this.mockMvc
                .perform(MockMvcRequestBuilders.get(buildUrl("{userId}/followed/list"), 1)
                        .param("order", AlfabeticOrder.NAME_DESC.name()))
                .andDo(print())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn()
                .getResponse();

        assertEquals(expected, response.getContentAsString());
    }


    @Test
    void givenUserWithFollowers_whenFollowersCount_then200AndThreeFollowers() throws Exception {
        this.mockMvc
                .perform(MockMvcRequestBuilders.get(buildUrl("{userId}/followers/count"), 1))
                .andDo(print())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.user_id").value(1))
                .andExpect(jsonPath("$.followers_count").value(3));
    }

    private void followAndNotExistBase(int buyerId, int sellerId, String expectedMessage) throws Exception {
        this.mockMvc
                .perform(followRequest(buyerId, sellerId))
                .andDo(print())
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.message").value(expectedMessage));
    }

    private MockHttpServletRequestBuilder followRequest(int buyerId, int sellerId) {
        return MockMvcRequestBuilders.post(buildUrl("{userId}/follow/{userIdToFollow}"),
                buyerId,
                sellerId);
    }

    private String buildUrl(String resource) {
        return String.format(USER_URI, resource);
    }

}
