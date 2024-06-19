package com.mercadolibre.pf_be_hisp_w26_t10_mcaldera.integration;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.mercadolibre.pf_be_hisp_w26_t10_mcaldera.dtos.BatchResponseDto;
import com.mercadolibre.pf_be_hisp_w26_t10_mcaldera.dtos.CheckInventoryResponseDto;
import com.mercadolibre.pf_be_hisp_w26_t10_mcaldera.dtos.ProductCrudResponseDto;
import com.mercadolibre.pf_be_hisp_w26_t10_mcaldera.dtos.UploadBatchRequestDto;
import com.mercadolibre.pf_be_hisp_w26_t10_mcaldera.entity.Rol;
import com.mercadolibre.pf_be_hisp_w26_t10_mcaldera.entity.UserAccount;
import com.mercadolibre.pf_be_hisp_w26_t10_mcaldera.exceptions.ForbiddenException;
import com.mercadolibre.pf_be_hisp_w26_t10_mcaldera.exceptions.NotFoundException;
import com.mercadolibre.pf_be_hisp_w26_t10_mcaldera.repository.IUserAccountRepository;
import com.mercadolibre.pf_be_hisp_w26_t10_mcaldera.service.implementations.ProductServiceImpl;
import com.mercadolibre.pf_be_hisp_w26_t10_mcaldera.util.TestGeneratorUtil;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.mockito.Mockito.when;
import static org.springframework.mock.http.server.reactive.MockServerHttpRequest.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
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

    private final ObjectWriter objectWriter = new ObjectMapper()
            .registerModule(new JavaTimeModule())
            .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
            .writer().withDefaultPrettyPrinter();

    @BeforeEach
    public void setUp() {
        UserAccount userSuper = new UserAccount();
        userSuper.setUsername("userSupervisorTest");
        userSuper.setPassword("$2a$10$uIBcaiVxrohx46v3Hj.keeLHKL7TOjY4JiYYaI3Kvzl9/U.J2esA.");
        userSuper.setFirstName("Supervisor");
        userSuper.setLastName("Test");
        userSuper.setUserRole(Rol.SUPERVISOR);
        userAccountRepository.save(userSuper);

        UserAccount userSeller = new UserAccount();
        userSeller.setUsername("userSellerTest");
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
        String username = "userSupervisorTest";
        String password = "12345";
        CheckInventoryResponseDto checkInventoryResponseDtos = TestGeneratorUtil.getCheckInvResponse();
        when(productService.getProductWh(1)).thenReturn(checkInventoryResponseDtos);

        String token = getToken(username, password);

        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/fresh-products/1/warehouse/list")
                        .header("Authorization", "Bearer " + token))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("Test us 4.2 - Exception validation, when sending non-registered data.")
    public void getItemQtyByWhNotFoundTest() throws Exception {
        String username = "userSupervisorTest";
        String password = "12345";
        String token = getToken(username, password);
        when(productService.getProductWh(5000)).thenThrow(new NotFoundException("No se encuentra inventario en ningun almacen del producto 1"));

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
        when(productService.getProductWh(5000)).thenThrow(new NotFoundException("No se encuentra inventario en ningun almacen del producto 1"));

        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/fresh-products/{idProduct}/warehouse/list", 5000)
                        .header("Authorization", "Bearer " + token))
                .andDo(print())
                .andExpect(status().isForbidden());
    }

    @Test
    @DisplayName("Test US 5 - Endpoint Call, Happy path")
    public void getBatchExpiringInDaysOrderedTest() throws Exception {
        String username = "userSupervisorTest";
        String password = "12345";
        String token = getToken(username, password);
        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/fresh-products/batch/list/due-date/50")
                        .header("Authorization", "Bearer " + token))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("Test us 6.1 - Create products validation")
    public void createProductCrudTest() throws Exception {
        String username = "userSellerTest";
        String password = "12345";
        String token = getToken(username, password);

        mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/fresh-products/{idSeller}", 1)
                        .header("Authorization", "Bearer " + token)
                        .content(objectWriter.writeValueAsString(TestGeneratorUtil.getProductListCtrl()))
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("Test us 6.2 - Modify products validation")
    public void changeProductInfoTest() throws Exception {
        String username = "userSellerTest";
        String password = "12345";
        String token = getToken(username, password);

        mockMvc.perform(MockMvcRequestBuilders.put("/api/v1/fresh-products/{idSeller}/{idProduct}", 1, 1)
                        .header("Authorization", "Bearer " + token)
                        .content(objectWriter.writeValueAsString(TestGeneratorUtil.getProductListCtrl()))
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("Test us 6.3 - Get all products by seller")
    public void getAllProductSellerTest() throws Exception {
        String username = "userSellerTest";
        String password = "12345";
        String token = getToken(username, password);

        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/fresh-products/list-items-seller")
                        .header("Authorization", "Bearer " + token))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("Test us 6.4 - remove products by seller")
    public void removeProductBySellerTest() throws Exception {
        String username = "userSupervisorTest";
        String password = "12345";
        String token = getToken(username, password);

        mockMvc.perform(delete("/api/v1/fresh-products/{idSeller}/delete/{idProduct}", 1, 1)
                        .header("Authorization", "Bearer " + token)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectWriter.writeValueAsString(TestGeneratorUtil.getProductListCtrl())))
                .andDo(print())
                .andExpect(status().isAccepted());
    }

    @Test
    void testRemoveProductBySeller_Success() throws Exception {
        // Arrange
        String username = "userSupervisorTest";
        String password = "12345";
        String token = getToken(username, password);

        String idSeller = "1";
        Integer idProduct = 1;
        ProductCrudResponseDto responseDto = new ProductCrudResponseDto(200, "Se ha eliminado el registro", 202);

        when(productService.removeProductsBySeller(idSeller, idProduct)).thenReturn(responseDto);

        // Act & Assert
        mockMvc.perform(delete("/api/v1/fresh-products/{idSeller}/delete/{idProduct}",1,1)
                        .header("Authorization", "Bearer " + token)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isAccepted());
    }

    @Test
    void testRemoveProductBySeller_UserNotSupervisor() throws Exception {
        // Arrange
        String idSeller = "seller123";
        Integer idProduct = 1;

        when(productService.removeProductsBySeller(idSeller, idProduct))
                .thenThrow(new ForbiddenException("Este usuario no tiene acceso a esta herrmaienta"));

        // Act & Assert
        mockMvc.perform(delete("/api/v1/fresh-products/{idSeller}/delete/{idProduct}",1,1)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isForbidden());
    }

    @Test
    void testRemoveProductBySeller_ProductNotFound() throws Exception {
        // Arrange
        String idSeller = "seller123";
        Integer idProduct = 0;
        String username = "userSupervisorTest";
        String password = "12345";
        String token = getToken(username, password);

        when(productService.removeProductsBySeller(idSeller, idProduct))
                .thenThrow(new NotFoundException("El producto no se encuentra registrado"));

        // Act & Assert
        mockMvc.perform(delete("/api/v1/fresh-products/{idSeller}/delete/{idProduct}",1,1)
                        .header("Authorization", "Bearer " + token)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isAccepted());
    }
}
