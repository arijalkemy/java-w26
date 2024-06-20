package com.mercadolibre.pf_be_hisp_w26_t10_gonzalez.integration;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mercadolibre.pf_be_hisp_w26_t10_gonzalez.dtos.CheckInventoryResponseDto;
import com.mercadolibre.pf_be_hisp_w26_t10_gonzalez.dtos.ProductUS6Dto;
import com.mercadolibre.pf_be_hisp_w26_t10_gonzalez.dtos.ProductsUS6RequestDto;
import com.mercadolibre.pf_be_hisp_w26_t10_gonzalez.entity.Rol;
import com.mercadolibre.pf_be_hisp_w26_t10_gonzalez.entity.UserAccount;
import com.mercadolibre.pf_be_hisp_w26_t10_gonzalez.exceptions.NotFoundException;
import com.mercadolibre.pf_be_hisp_w26_t10_gonzalez.repository.IUserAccountRepository;
import com.mercadolibre.pf_be_hisp_w26_t10_gonzalez.service.implementations.ProductServiceImpl;
import com.mercadolibre.pf_be_hisp_w26_t10_gonzalez.util.TestGeneratorUtil;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Collections;
import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@ExtendWith(MockitoExtension.class)
@ActiveProfiles("test")
@AutoConfigureTestDatabase(replace= AutoConfigureTestDatabase.Replace.NONE)
@Transactional
public class ProductControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    ProductServiceImpl productService;

    @Autowired
    IUserAccountRepository userAccountRepository;

    @Autowired
    private ObjectMapper objectMapper;

    @BeforeEach
    public void setUp() {
        UserAccount userSuper = new UserAccount();
        userSuper.setUsername("userSupervisor");
        userSuper.setPassword("$2a$10$uIBcaiVxrohx46v3Hj.keeLHKL7TOjY4JiYYaI3Kvzl9/U.J2esA.");
        userSuper.setFirstName("Supervisor");
        userSuper.setLastName("Test");
        userSuper.setUserRole(Rol.SUPERVISOR);
        userAccountRepository.save(userSuper);

        UserAccount userSeller = new UserAccount();
        userSeller.setUsername("userSeller");
        userSeller.setPassword("$2a$10$uIBcaiVxrohx46v3Hj.keeLHKL7TOjY4JiYYaI3Kvzl9/U.J2esA.");
        userSeller.setFirstName("Seller");
        userSeller.setLastName("Test");
        userSeller.setUserRole(Rol.SELLER);
        userAccountRepository.save(userSeller);
    }

    private String getToken(String username, String password) throws Exception {

        String jsonBody = "{ \"username\": \"" + username + "\", \"password\": \"" + password + "\" }";

        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("/auth/login")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonBody))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();

        String response = result.getResponse().getContentAsString();
        ObjectMapper mapper = new ObjectMapper();
        JsonNode jsonNode = mapper.readTree(response);

        return jsonNode.get("token").asText();
    }

    @Test
    @DisplayName("Test us 4.1 - Validation of successful result by sending valid data.")
    public void getItemQtyByWhTest() throws Exception {
        String username = "userSupervisor";
        String password = "12345";
        CheckInventoryResponseDto checkInventoryResponseDtos = TestGeneratorUtil.getCheckInvResponse();
        Mockito.when(productService.getProductWh(1)).thenReturn(checkInventoryResponseDtos);

        String token = getToken(username, password);

        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/fresh-products/1/warehouse/list")
                        .header("Authorization", "Bearer " + token))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("Test us 4.2 - Exception validation, when sending non-registered data.")
    public void getItemQtyByWhNotFoundTest() throws Exception {
        String username = "userSupervisor";
        String password = "12345";
        String token = getToken(username, password);
        Mockito.when(productService.getProductWh(5000)).thenThrow(new NotFoundException("No se encuentra inventario en ningun almacen del producto 1"));

        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/fresh-products/{idProduct}/warehouse/list", 5000)
                        .header("Authorization", "Bearer " + token))
                .andDo(print())
                .andExpect(status().isNotFound());
    }

    @Test
    @DisplayName("Test us 4.3 - Access denied exception to not permitted role.")
    public void getItemQtyByWhNotTokenError() throws Exception {
        String username = "userSeller";
        String password = "12345";
        String token = getToken(username, password);
        Mockito.when(productService.getProductWh(5000)).thenThrow(new NotFoundException("No se encuentra inventario en ningun almacen del producto 1"));

        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/fresh-products/{idProduct}/warehouse/list", 5000)
                        .header("Authorization", "Bearer " + token))
                .andDo(print())
                .andExpect(status().isForbidden());
    }

    @Test
    @DisplayName("Test US 5 - Endpoint Call, Happy path")
    public void getBatchExpiringInDaysOrderedTest() throws Exception {
        String username = "userSupervisor";
        String password = "12345";
        String token = getToken(username, password);
        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/fresh-products/batch/list/due-date/50")
                        .header("Authorization", "Bearer " + token))
                .andDo(print())
                .andExpect(status().isOk());
    }



}
