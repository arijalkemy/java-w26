package com.meli.be_java_hisp_w26_g09.controller;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.be_java_hisp_w26_g09.dto.ExceptionDTO;
import com.meli.be_java_hisp_w26_g09.dto.PostDTO;
import com.meli.be_java_hisp_w26_g09.dto.ProductFollowedListDTO;
import com.meli.be_java_hisp_w26_g09.dto.ResponseDTO;
import com.meli.be_java_hisp_w26_g09.exception.BadRequestException;
import com.meli.be_java_hisp_w26_g09.exception.NotFoundException;
import com.meli.be_java_hisp_w26_g09.service.IPostService;
import com.meli.be_java_hisp_w26_g09.util.JsonUtil;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@WebMvcTest(PostController.class)
@AutoConfigureMockMvc
class PostControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    IPostService postService;

    private PostDTO postDTO;
    private ObjectMapper objectMapper;

    @BeforeEach
    void setUp() throws IOException {
        objectMapper = new ObjectMapper();
        postDTO = JsonUtil.readJsonFromFile("core/dto/postDTO.json", PostDTO.class);
    }

    @Test
    @DisplayName("Create post successful")
    void testCreatePostSuccessful() throws Exception {
        // arrange
        ResponseDTO responseDTO = JsonUtil.readJsonFromFile("postcreated/successful/responseDTO.json", ResponseDTO.class);
        when(postService.addPost(postDTO)).thenReturn(responseDTO);

        // Act and assert
        String resultJson = mockMvc.perform(MockMvcRequestBuilders.post("/products/post")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(postDTO)))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.message").value(responseDTO.getMessage()))
                .andReturn().getResponse().getContentAsString();

        assertEquals(objectMapper.writeValueAsString(responseDTO), resultJson);
    }

    @Test
    @DisplayName("Bad request when the client tries to create a post")
    void testCreatePost_ClientTriesPostBadRequestException() throws Exception {
        // arrange
        postDTO.setUserId(1);
        ExceptionDTO exceptionDTO = JsonUtil
                .readJsonFromFile("postcreated/badrequest/customerExceptionDTO.json",
                        ExceptionDTO.class);
        when(postService.addPost(postDTO)).thenThrow(new BadRequestException("The customer can't create posts "));

        // Act and assert
        mockMvc.perform(MockMvcRequestBuilders.post("/products/post")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(postDTO)))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.message").value(exceptionDTO.getMessage()));
    }

    @Test
    @DisplayName("Bad request when the fields is null")
    void testPostCreate_FieldsNullArgumentNotValid() throws Exception {
        // arrange
        postDTO = JsonUtil.
                readJsonFromFile("postcreated/argumentnotvalid/request/fieldsNullPostDTO.json", PostDTO.class);
        List<ExceptionDTO> exceptionDTOs = JsonUtil.readJsonFromFileToList(
                "postcreated/argumentnotvalid/response/fieldsnullExceptionDTO.json",
                ExceptionDTO.class);

        // Act and assert
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post("/products/post")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(postDTO)))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();

        Set<ExceptionDTO> responseExceptionDTO = objectMapper.
                readValue(mvcResult.getResponse().getContentAsString(), new TypeReference<>() {
                });
        assertEquals(new HashSet<>(exceptionDTOs), responseExceptionDTO);
    }

    @Test
    @DisplayName("Bad request when the fields aren't valid")
    void testPostCreate_FieldsInvalidsArgumentNotValid() throws Exception {
        // arrange
        postDTO = JsonUtil.readJsonFromFile("postcreated/argumentnotvalid/request/fieldsInvalidPostDTO.json",
                PostDTO.class);

        List<ExceptionDTO> exceptionDTOs = JsonUtil
                .readJsonFromFileToList("postcreated/argumentnotvalid/response/fieldsInvalidExceptionDTO.json",
                        ExceptionDTO.class);

        // Act and assert
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post("/products/post")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(postDTO)))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();

        Set<ExceptionDTO> responseExceptionDTO = objectMapper.readValue(
                mvcResult.getResponse().getContentAsString(), new TypeReference<>() {
                });
        assertEquals(new HashSet<>(exceptionDTOs), responseExceptionDTO);
    }

    @Test
    @DisplayName("Bad request when the date field format isn't valid")
    void testPostCreate_DateFieldArgumentNotValid() throws Exception {
        // arrange
        String postDTOJson = Files.readString(
                Paths.get("src/test/resources/json/postcreated/" +
                        "argumentnotvalid/request/dateFormatInvalidPostDTO.json"));

        ExceptionDTO exceptionDTO = JsonUtil
                .readJsonFromFile("postcreated/argumentnotvalid/response/dateFormatInvalidExceptionDTO.json",
                        ExceptionDTO.class);

        // Act and assert
        mockMvc.perform(MockMvcRequestBuilders.post("/products/post")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(postDTOJson))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.message").value(exceptionDTO.getMessage()));
    }

    @Test
    @DisplayName("Get all product posts from those followed by customer id")
    void testGetFollowedUsersPostsSuccessful() throws Exception {
        // arrange
        int customerID = 1;
        ProductFollowedListDTO productFollowedListDTOExpect = JsonUtil.readJsonFromFile(
                "productfollowed/successful/responseDTO.json", ProductFollowedListDTO.class);

        when(postService.findFollowedPostsLastTwoWeeks(customerID)).thenReturn(productFollowedListDTOExpect);

        // act and assert
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/products/followed/{userId}/list", customerID)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.user_id").value(productFollowedListDTOExpect.getUserId()))
                .andReturn();

        assertEquals(objectMapper.writeValueAsString(productFollowedListDTOExpect),
                mvcResult.getResponse().getContentAsString());
    }

    @Test
    @DisplayName("Get all products posts followed by customer, when customer not found")
    void testGetFollowedUsersPosts_NotFoundException() throws Exception {
        // arrange
        int customerID = 1;
        ExceptionDTO exceptionDTOExpect = JsonUtil.readJsonFromFile(
                "productfollowed/notfound/exceptionDTO.json", ExceptionDTO.class);

        when(postService.findFollowedPostsLastTwoWeeks(customerID))
                .thenThrow(new NotFoundException("No information was found about those followed."));

        // act and assert
        mockMvc.perform(MockMvcRequestBuilders.get("/products/followed/{userId}/list", customerID)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isNotFound())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.message").value(exceptionDTOExpect.getMessage()));
    }

    @Test
    @DisplayName("Get products post followed from customer, when not same type attribute")
    void testGetFollowedUsersPosts_NotSameType() throws Exception {
        // arrange
        String customerID = "text";
        ExceptionDTO exceptionDTOExpect = JsonUtil.readJsonFromFile(
                "productfollowed/notsametype/exceptionDTO.json", ExceptionDTO.class);

        // act and assert
        mockMvc.perform(MockMvcRequestBuilders.get("/products/followed/{userId}/list", customerID)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.message").value(exceptionDTOExpect.getMessage()));
    }

    @Test
    @DisplayName("Get products post followed by customer with date ordered ascending")
    void testGetFollowedUsersPosts_WithDateOrderedAscending() throws Exception {
        // arrange
        int customerID = 1;
        String order = "date_asc";
        ProductFollowedListDTO productFollowedListDTOExpect = JsonUtil.readJsonFromFile(
                "productfollowed/ordered/responseDTOAsc.json", ProductFollowedListDTO.class);

        when(postService.findFollowedPostsLastTwoWeeksSorted(customerID, order))
                .thenReturn(productFollowedListDTOExpect);

        // act and assert
        MvcResult mvcResult = mockMvc.perform(
                        MockMvcRequestBuilders.get("/products/followed/{userId}/list", customerID)
                                .param("order", order)
                                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.user_id").value(productFollowedListDTOExpect.getUserId()))
                .andReturn();

        assertEquals(objectMapper.writeValueAsString(productFollowedListDTOExpect),
                mvcResult.getResponse().getContentAsString());
    }

    @Test
    @DisplayName("Get products post followed by customer with date ordered descending")
    void testGetFollowedUsersPosts_WithDateOrderedDescending() throws Exception {
        // arrange
        int customerID = 1;
        String order = "date_desc";
        ProductFollowedListDTO productFollowedListDTOExpect = JsonUtil.readJsonFromFile(
                "productfollowed/ordered/responseDTODesc.json", ProductFollowedListDTO.class);

        when(postService.findFollowedPostsLastTwoWeeksSorted(customerID, order))
                .thenReturn(productFollowedListDTOExpect);

        // act and assert
        MvcResult mvcResult = mockMvc.perform(
                        MockMvcRequestBuilders.get("/products/followed/{userId}/list", customerID)
                                .param("order", order)
                                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.user_id").value(productFollowedListDTOExpect.getUserId()))
                .andReturn();

        assertEquals(objectMapper.writeValueAsString(productFollowedListDTOExpect),
                mvcResult.getResponse().getContentAsString());
    }

    @Test
    @DisplayName("Get products post followed by customer, when order type is incorrect")
    void testGetFollowedUsersPosts_WithOrderIsIncorrect() throws Exception {
        // arrange
        int customerID = 1;
        String order = "order_incorrect";
        ExceptionDTO exceptionDTOExpect = JsonUtil.readJsonFromFile(
                "productfollowed/ordered/exceptionDTO.json", ExceptionDTO.class);

        when(postService.findFollowedPostsLastTwoWeeksSorted(customerID, order))
                .thenThrow(new BadRequestException("Invalid order parameter. " +
                        "Valid values are 'date_asc' or 'date_desc'."));

        // act and assert
        mockMvc.perform(
                        MockMvcRequestBuilders.get("/products/followed/{userId}/list", customerID)
                                .param("order", order)
                                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.message").value(exceptionDTOExpect.getMessage()));
    }



}