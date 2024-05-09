package com.meli.be_java_hisp_w26_g10.controller;

import com.api.socialmeli.dto.FollowedBySellerDto;
import com.api.socialmeli.dto.UserDto;
import com.api.socialmeli.entity.Buyer;
import com.api.socialmeli.entity.Seller;
import com.api.socialmeli.mapper.ListUserMapper;
import com.api.socialmeli.repository.IBuyerRepository;
import com.api.socialmeli.repository.impl.BuyerRepositoryImpl;
import com.api.socialmeli.repository.impl.SellerRepositoryImpl;
import com.api.socialmeli.service.impl.BuyerServiceImpl;
import com.api.socialmeli.service.impl.SellerServiceImpl;
import com.api.socialmeli.utils.FollowersOfSellerValidation;
import com.api.socialmeli.utils.UserDtoShort;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.be_java_hisp_w26_g10.util.TestGeneratorUtil;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import javax.print.attribute.standard.Media;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


//@WebMvcTest(controllers = {com.api.socialmeli.controller.SocialMeliController.class})
@SpringBootTest(classes = {com.api.socialmeli.BeJavaHispW26G10Application.class})
@AutoConfigureMockMvc(addFilters = false)
@ExtendWith(MockitoExtension.class)
public class SocialMeliControllerTest {
    private final static String BASE_PATH = "/users";

    @MockBean
    private SellerServiceImpl sellerService;

    @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName("it should return followers in ascending alphabetical order")
    public void getFollowersSortedByNameAscTest() throws Exception {
        // arrange
        List<UserDto> followersExpected = Arrays.asList(
                new UserDto(2, "Ana"),
                new UserDto(3, "Carlos"),
                new UserDto(4, "Juan")
        );
        FollowedBySellerDto followedBySellerDtoExpected = new FollowedBySellerDto(
                1, "Vendedor", followersExpected
        );
        when(sellerService.getFollowersOfSeller(anyInt(),anyString())).thenReturn(followedBySellerDtoExpected);

        // act
        ResultActions result = mockMvc.perform(
                get(BASE_PATH + "/{userId}/followers/list", 1)
                        .param("order", "name_asc")
                        .contentType(MediaType.APPLICATION_JSON)
        );

        // assert
        result.andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.followers").isArray())
                .andExpect(jsonPath("$.followers", hasSize(followersExpected.size())))
                .andExpect(jsonPath("$.followers[*].user_name", contains("Ana", "Carlos", "Juan")))
                .andExpect(jsonPath("$.followers[*].user_id", contains(2,3,4)));
    }

    @Test
    @DisplayName("it should return followers in desescending alphabetical order")
    public void getFollowersSortedByNameDescTest() throws Exception {
        // arrange
        List<UserDto> followersExpected = Arrays.asList(
                new UserDto(4, "Juan"),
                new UserDto(3, "Carlos"),
                new UserDto(2, "Ana")
        );
        FollowedBySellerDto followedBySellerDtoExpected = new FollowedBySellerDto(
                1, "Vendedor", followersExpected
        );
        when(sellerService.getFollowersOfSeller(anyInt(),anyString())).thenReturn(followedBySellerDtoExpected);

        // act
        ResultActions result = mockMvc.perform(
                get(BASE_PATH + "/{userId}/followers/list", 1)
                        .param("order", "name_desc")
                        .contentType(MediaType.APPLICATION_JSON)
        );

        // assert
        result.andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.followers").isArray())
                .andExpect(jsonPath("$.followers", hasSize(followersExpected.size())))
                .andExpect(jsonPath("$.followers[*].user_name", contains("Juan", "Carlos", "Ana")))
                .andExpect(jsonPath("$.followers[*].user_id", contains(4,3,2)));
    }

    @Test
    @DisplayName("it should return followers in without alphabetical order")
    public void getFollowersNoSortedByNameTest() throws Exception {
        // arrange
        List<UserDto> followersExpected = Arrays.asList(
                new UserDto(4, "Ana"),
                new UserDto(5, "Esteban"),
                new UserDto(3, "Zapata"),
                new UserDto(1, "Carlos"),
                new UserDto(2, "Juan")
        );
        FollowedBySellerDto followedBySellerDtoExpected = new FollowedBySellerDto(
                1, "Vendedor", followersExpected
        );
        when(sellerService.getFollowersOfSeller(anyInt(),anyString())).thenReturn(followedBySellerDtoExpected);

        // act
        ResultActions result = mockMvc.perform(
                get(BASE_PATH + "/{userId}/followers/list", 1)
//                        .param("order", "")
                        .contentType(MediaType.APPLICATION_JSON)
        );

        // assert
        result.andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.followers").isArray())
                .andExpect(jsonPath("$.followers", hasSize(followersExpected.size())))
                .andExpect(jsonPath("$.followers[*].user_name", contains("Ana", "Esteban", "Zapata", "Carlos", "Juan")))
                .andExpect(jsonPath("$.followers[*].user_id", contains(4,5,3,1,2)));
    }
}
