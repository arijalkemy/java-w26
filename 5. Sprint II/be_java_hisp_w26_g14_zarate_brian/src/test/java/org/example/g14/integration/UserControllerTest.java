package org.example.g14.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.example.g14.dto.response.UserFollowedResponseDto;
import org.example.g14.utils.UsersList;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerTest {

    @Autowired
    MockMvc mockMvc;

    private static ObjectWriter writer;

    @BeforeAll
    public static void setup() {
        writer = new ObjectMapper()
                .findAndRegisterModules()
                .writer();
    }

    @ParameterizedTest
    @ValueSource(strings = {"name_asc", "name_desc"})
    @DisplayName("Integration test: check list order of followed users from a user")
    public void getFollowedUsersTestOk(String order) throws Exception {
        UserFollowedResponseDto expectedResultAsc = UsersList.getMockedUserFollowedResponseDtoSortedAsc();
        UserFollowedResponseDto expectedResultDesc = UsersList.getMockedUserFollowedResponseDtoSortedDesc();


        ResultActions result = mockMvc.perform(get("/users/{userId}/followed/list?order={order}", expectedResultAsc.getUser_id(), order))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));

        String actualJson = result.andReturn().getResponse().getContentAsString();
        String expectedJson = writer.writeValueAsString(
                order.equals("name_asc") ? expectedResultAsc : expectedResultDesc
        );

        assertEquals(expectedJson, actualJson);
    }
}
