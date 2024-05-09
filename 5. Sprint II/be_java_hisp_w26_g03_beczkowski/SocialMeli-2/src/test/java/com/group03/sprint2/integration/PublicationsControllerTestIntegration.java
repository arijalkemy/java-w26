package com.group03.sprint2.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.group03.sprint2.dto.ProductDTO;
import com.group03.sprint2.dto.PublicationDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.time.LocalDate;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith({MockitoExtension.class, SpringExtension.class})
@SpringBootTest
@AutoConfigureMockMvc
public class PublicationsControllerTestIntegration {

    @Autowired
    private MockMvc mockMvc;
    private ObjectMapper objectMapper = new ObjectMapper();
    private Integer buyerId;
    private Integer sellerId;
    private PublicationDTO payload;

    @BeforeEach
    void setUp() {
        objectMapper = new ObjectMapper().registerModule(new JavaTimeModule());
        buyerId = 12345;
        sellerId = 1;
        payload = new PublicationDTO(sellerId, 100, LocalDate.now(),
                new ProductDTO(10, "Celular", "Tecnologia", "Apple",
                        "Negro", "Excelente estado"),
                10, 898989.0);
    }

    @Test
    @DisplayName("Should show exit message when you create a post")
    public void createPublicationOKTest() throws Exception {
        String payloadJson = objectMapper.writeValueAsString(payload);
        mockMvc.perform(MockMvcRequestBuilders.post("/products/post")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(payloadJson))
                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(MockMvcResultMatchers.jsonPath("$.message")
                        .value("Post created successfully."));
    }

    @Test
    @DisplayName("Should show not found message when you try to create a post with an seller id that doesnt exist")
    public void createPublicationNotFoundTest() throws Exception {
        payload.setUserId(999999);
        String payloadJson = objectMapper.writeValueAsString(payload);
        mockMvc.perform(MockMvcRequestBuilders.post("/products/post")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(payloadJson))
                .andDo(print())
                .andExpect(status().isNotFound())
                .andExpect(MockMvcResultMatchers.jsonPath("$.message")
                        .value("There is not seller with ID: " + payload.getUserId()));
    }


    @Test
    @DisplayName("Should show show publications from last two weeks without order")
    public void getFollowedLastTwoWeeksPublicationsOKTest() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/products/followed/{userId}/list",
                        buyerId))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.userId").value(buyerId))
                .andExpect(MockMvcResultMatchers.jsonPath("$.publications[0].post_id").value(1002));

    }

    @Test
    @DisplayName("Should show show publications from last two weeks with date ascendant order")
    public void getFollowedLastTwoWeeksPublicationsOKOrderAscTest() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/products/followed/" + buyerId
                        + "/list?order=date_asc"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.userId").value(buyerId))
                .andExpect(MockMvcResultMatchers.jsonPath("$.publications[0].post_id").value(1002));

    }

    @Test
    @DisplayName("Should show show bad request message for wrong date order")
    public void getFollowedLastTwoWeeksPublicationsBadRequestOrderTest() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/products/followed/" + buyerId
                        + "/list?order=order"))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(MockMvcResultMatchers.jsonPath("$.message")
                        .value("Invalid order type."));

    }

    @Test
    @DisplayName("Should show bad request message when user does not exist in the system.")
    public void getFollowedLastTwoWeeksPublicationsBadRequestBuyerTest() throws Exception {
        buyerId = 999999;
        mockMvc.perform(MockMvcRequestBuilders.get("/products/followed/{userId}/list", buyerId))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(MockMvcResultMatchers.jsonPath("$.message")
                        .value("The specified user does not exist in the system."));

    }

    @Test
    @DisplayName("Should show not found message when the specified user doesnt have any followed sellers.")
    public void getFollowedLastTwoWeeksPublicationsNotFoundNotFollowedTest() throws Exception {
        buyerId = 1111;
        mockMvc.perform(MockMvcRequestBuilders.get("/products/followed/{userId}/list", buyerId))
                .andDo(print())
                .andExpect(status().isNotFound())
                .andExpect(MockMvcResultMatchers.jsonPath("$.message")
                        .value("The specified user does not have any followed sellers."));

    }

    @Test
    @DisplayName("Should show not found message when you try to get publications from last two weeks")
    public void getFollowedLastTwoWeeksPublicationsNotFoundNotTest() throws Exception {
        buyerId = 24680;
        mockMvc.perform(MockMvcRequestBuilders.get("/products/followed/{userId}/list", buyerId))
                .andDo(print())
                .andExpect(status().isNotFound())
                .andExpect(MockMvcResultMatchers.jsonPath("$.message")
                        .value("There are no publications in the last 2 weeks for the specified user."));

    }


}
