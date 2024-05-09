package com.meli.be_java_hisp_w26_g10.integration;

import com.api.socialmeli.BeJavaHispW26G10Application;
import com.api.socialmeli.dto.PostDto;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.meli.be_java_hisp_w26_g10.util.TestGeneratorUtil;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;


import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(classes = BeJavaHispW26G10Application.class)
@AutoConfigureMockMvc
@ExtendWith(MockitoExtension.class)
public class SocialMeliControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    @DisplayName("Se pide el número de segidores de un vendedor")
    public void getFollowersCountTest() throws Exception {
        //Arrange
        Long userId = 1L;

        //Act
        //Assert
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/users/{userId}/followers/count",userId)
                                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.followers_count")
                        .value(4));

    }

    @Test
    @DisplayName("Se pide el número de segidores de un vendedor que no existe")
    public void getFollowersCountNotFoundUserTest() throws Exception {
        //Arrange
        Long userId = 100L;

        //Act
        //Assert
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/users/{userId}/followers/count",userId)
                                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print()).andExpect(status().isNotFound());

    }





}
