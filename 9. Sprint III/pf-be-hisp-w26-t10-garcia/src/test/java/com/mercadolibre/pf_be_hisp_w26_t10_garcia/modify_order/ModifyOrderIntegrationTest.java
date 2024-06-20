package com.mercadolibre.pf_be_hisp_w26_t10_garcia.modify_order;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mercadolibre.pf_be_hisp_w26_t10_garcia.dtos.order.*;
import com.mercadolibre.pf_be_hisp_w26_t10_garcia.exceptions.BadRequestException;
import com.mercadolibre.pf_be_hisp_w26_t10_garcia.exceptions.NotFoundException;
import com.mercadolibre.pf_be_hisp_w26_t10_garcia.repository.IUserAccountRepository;
import com.mercadolibre.pf_be_hisp_w26_t10_garcia.service.implementations.ShoppingCartServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.MockitoAnnotations;
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
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@ExtendWith(MockitoExtension.class)
@ActiveProfiles("test")
@AutoConfigureTestDatabase(replace= AutoConfigureTestDatabase.Replace.NONE)
public class ModifyOrderIntegrationTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ShoppingCartServiceImpl shoppingCartService;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    IUserAccountRepository userAccountRepository;

    @BeforeEach
    public void setUp() throws Exception{
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @DisplayName("Modify Order - Valid Request")
    public void testModifyOrder_ValidRequest() throws Exception {
        // Mockear servicio para devolver una respuesta exitosa
        PurchaseOrderResponseDto responseDto = new PurchaseOrderResponseDto(100.0); // Supongamos que devuelve un total de 100.0
        when(shoppingCartService.modifyPurchaseOrder(any(Integer.class), any(PurchaseOrderRequestBodyDto.class)))
                .thenReturn(responseDto);

        // Construir el cuerpo de la solicitud
        PurchaseOrderRequestDto requestDto = new PurchaseOrderRequestDto();
        requestDto.setDate("2024-06-16");
        requestDto.setBuyer_id(1);
        requestDto.setOrder_status(new PurchaseOrderStatusDto("shopping_cart"));
        requestDto.setProducts(Collections.singletonList(new PurchaseOrderProduct(1, 5)));

        PurchaseOrderRequestBodyDto requestBodyDto = new PurchaseOrderRequestBodyDto(requestDto);

        // Convertir el objeto a JSON
        String requestBody = objectMapper.writeValueAsString(requestBodyDto);

        // Realizar la solicitud HTTP y verificar la respuesta
        String token = getToken("jgonz", "12345");
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.put("/api/v1/fresh-products/orders/1")
                        .header(HttpHeaders.AUTHORIZATION, "Bearer " + token)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestBody))
                .andExpect(status().isOk())
                .andReturn();

        // Verificar el contenido de la respuesta
        String responseContent = mvcResult.getResponse().getContentAsString();
        PurchaseOrderResponseDto actualResponseDto = objectMapper.readValue(responseContent, PurchaseOrderResponseDto.class);
        assertEquals(100.0, actualResponseDto.getTotal_price()); // Verificar que el total devuelto es correcto
    }

    @Test
    @DisplayName("Modify Order - Nonexistent Order")
    public void testModifyOrder_NonexistentOrder() throws Exception {
        // Mockear servicio para lanzar NotFoundException
        when(shoppingCartService.modifyPurchaseOrder(any(Integer.class), any(PurchaseOrderRequestBodyDto.class)))
                .thenThrow(new NotFoundException("The order with the id: 1 does not exist"));

        // Construir el cuerpo de la solicitud (puede ser vacío para este caso)
        PurchaseOrderRequestBodyDto requestBodyDto = new PurchaseOrderRequestBodyDto();

        // Convertir el objeto a JSON
        String requestBody = objectMapper.writeValueAsString(requestBodyDto);

        String token = getToken("jgonz", "12345");
        // Realizar la solicitud HTTP y verificar la respuesta
        mockMvc.perform(MockMvcRequestBuilders.put("/api/v1/fresh-products/orders/1")
                        .header(HttpHeaders.AUTHORIZATION, "Bearer " + token)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestBody))
                .andExpect(status().isNotFound())
                .andExpect(MockMvcResultMatchers.jsonPath("$.message").value("The order with the id: 1 does not exist"));
    }

    @Test
    @DisplayName("Modify Order - Nonexistent User")
    public void testModifyOrder_NonexistentUser() throws Exception {
        // Mockear servicio para lanzar NotFoundException
        when(shoppingCartService.modifyPurchaseOrder(any(Integer.class), any(PurchaseOrderRequestBodyDto.class)))
                .thenThrow(new NotFoundException("The buyer with the id 1 does not exist"));

        // Construir el cuerpo de la solicitud (puede ser vacío para este caso)
        PurchaseOrderRequestBodyDto requestBodyDto = new PurchaseOrderRequestBodyDto();

        // Convertir el objeto a JSON
        String requestBody = objectMapper.writeValueAsString(requestBodyDto);

        // Realizar la solicitud HTTP y verificar la respuesta
        String token = getToken("jgonz", "12345");
        mockMvc.perform(MockMvcRequestBuilders.put("/api/v1/fresh-products/orders/1")
                        .header(HttpHeaders.AUTHORIZATION, "Bearer " + token)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestBody))
                .andExpect(status().isNotFound())
                .andExpect(MockMvcResultMatchers.jsonPath("$.message").value("The buyer with the id 1 does not exist"));
    }

    @Test
    @DisplayName("Modify Order - Nonexistent Product")
    public void testModifyOrder_NonexistentProduct() throws Exception {
        // Mockear servicio para lanzar NotFoundException
        when(shoppingCartService.modifyPurchaseOrder(any(Integer.class), any(PurchaseOrderRequestBodyDto.class)))
                .thenThrow(new NotFoundException("Product not found with the ID: 1"));

        // Construir el cuerpo de la solicitud (puede ser vacío para este caso)
        PurchaseOrderRequestBodyDto requestBodyDto = new PurchaseOrderRequestBodyDto();

        // Convertir el objeto a JSON
        String requestBody = objectMapper.writeValueAsString(requestBodyDto);

        // Realizar la solicitud HTTP y verificar la respuesta
        String token = getToken("jgonz", "12345");
        mockMvc.perform(MockMvcRequestBuilders.put("/api/v1/fresh-products/orders/1")
                        .header(HttpHeaders.AUTHORIZATION, "Bearer " + token)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestBody))
                .andExpect(status().isNotFound())
                .andExpect(MockMvcResultMatchers.jsonPath("$.message").value("Product not found with the ID: 1"));
    }

    @Test
    @DisplayName("Modify Order - Incorrect Order State")
    public void testModifyOrder_IncorrectOrderState() throws Exception {
        // Mockear servicio para lanzar BadRequestException
        when(shoppingCartService.modifyPurchaseOrder(any(Integer.class), any(PurchaseOrderRequestBodyDto.class)))
                .thenThrow(new BadRequestException("The status of the purchase order must be 'shopping_cart'"));

        // Construir el cuerpo de la solicitud con estado incorrecto
        PurchaseOrderRequestDto requestDto = new PurchaseOrderRequestDto();
        requestDto.setDate("2024-06-16");
        requestDto.setBuyer_id(1);
        requestDto.setOrder_status(new PurchaseOrderStatusDto("completed")); // Estado incorrecto
        requestDto.setProducts(Collections.singletonList(new PurchaseOrderProduct(1, 5)));

        PurchaseOrderRequestBodyDto requestBodyDto = new PurchaseOrderRequestBodyDto(requestDto);

        // Convertir el objeto a JSON
        String requestBody = objectMapper.writeValueAsString(requestBodyDto);

        // Realizar la solicitud HTTP y verificar la respuesta
        String token = getToken("jgonz", "12345");
        mockMvc.perform(MockMvcRequestBuilders.put("/api/v1/fresh-products/orders/1")
                        .header(HttpHeaders.AUTHORIZATION, "Bearer " + token)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestBody))
                .andExpect(status().isBadRequest())
                .andExpect(MockMvcResultMatchers.jsonPath("$.message").value("The status of the purchase order must be 'shopping_cart'"));
    }

    public String getToken(String username, String password) throws Exception {
        String jsonBody = "{ \"username\": \"" + username + "\", \"password\": \"" + password + "\" }";
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("/auth/login")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonBody))
                .andExpect(status().isOk())
                .andReturn();

        String response = result.getResponse().getContentAsString();
        ObjectMapper mapper = new ObjectMapper();
        JsonNode jsonNode = mapper.readTree(response);

        return jsonNode.get("token").asText();
    }
}
