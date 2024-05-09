package com.example.sprint1.integration;

import com.example.sprint1.model.User;
import com.example.sprint1.repository.IUserRepository;
import com.example.sprint1.service.IUserService;
import com.jayway.jsonpath.JsonPath;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;



@SpringBootTest
@AutoConfigureMockMvc
public class IntegrationTestUserController {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private IUserRepository userRepository;

    @Autowired
    private IUserService userService;


    /**
     * Integration test that adds a new follower to a user
     * @throws Exception
     */
    @Test
    public void testPostNewFollower() throws Exception{
        Integer userId = 1;
        Integer userIdToFollow = 2;
        MvcResult result = mockMvc.perform(post("/users/{userId}/follow/{userIdToFollow}", userId, userIdToFollow)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andReturn();

        // Assert
        User updatedUser1 = userRepository.findUserById(2);
        assertThat(updatedUser1.getFollowers()).hasSize(1);
        assertThat(updatedUser1.getFollowers()).contains(1);
    }

    /**
     * Integration test that gets the followers list
     * @throws Exception
     */
    @Test
    void testGetFollowerList() throws Exception{

        MvcResult resultAsc = mockMvc.perform(get("/users/3/followers/list?order={order}","name_asc")
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();
        // Get the response content as a String
        //String responseContent = resultAsc.getResponse().getContentAsString();

        // Print the response content to the console
        //System.out.println("Response Content: " + responseContent);

        //Turns result into a String
        String responseContent = resultAsc.getResponse().getContentAsString();

        //Assert the followed array
        List<Map<String, Object>> followedList = JsonPath.read(responseContent, "$.followed");

        assertEquals(followedList.size(),2, "Same number of followers");

        assertThat(followedList.get(0)).containsEntry("user_id", 4).containsEntry("user_name", "user4");
        assertThat(followedList.get(1)).containsEntry("user_id", 5).containsEntry("user_name", "user5");
    }

    /**
     * Integration test that returns the list of followed of users
     * @throws Exception
     */
    @Test
    public void testGetFollowedList() throws Exception{
        MvcResult result = mockMvc.perform(get("/users/{userId}/followed/list", 3)
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn()
                ;

        //Turns result into a String
        String responseContent = result.getResponse().getContentAsString();

        //Assert the followed array
        List<Map<String, Object>> followedList = JsonPath.read(responseContent, "$.followed");

        assertEquals(followedList.size(),2, "Same number of followed");

        assertThat(followedList.get(0)).containsEntry("user_id", 4).containsEntry("user_name", "user4");
        assertThat(followedList.get(1)).containsEntry("user_id", 5).containsEntry("user_name", "user5");
    }

    /**
     * Integration test that checks the number of followers a user have
     * @throws Exception
     */
    @Test
    public void testGetFollowerCount() throws Exception{
        MvcResult result = mockMvc.perform(get("/users/{userId}/followers/count",3)
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn()
                ;

        // Assert
        //Turns result into a String
        String responseContent = result.getResponse().getContentAsString();
        int followersCount = JsonPath.read(responseContent,"$.followers_count");
        assertThat(followersCount).isEqualTo(2);
    }

    /**
     * Integration test that checks that a person is unfollowed
     * @throws Exception
     */
    @Test
    public void testSetUnFolllow() throws Exception{
        MvcResult result = mockMvc.perform(post("/users/{userId}/unfollow/{userIdToUnfollow}", 3,4))
                .andExpect(status().isNoContent())
                .andReturn()
                ;

        User userAux = userRepository.findUserById(3);
        assertThat(userAux.getFollowed()).doesNotContain(4);
    }


}
