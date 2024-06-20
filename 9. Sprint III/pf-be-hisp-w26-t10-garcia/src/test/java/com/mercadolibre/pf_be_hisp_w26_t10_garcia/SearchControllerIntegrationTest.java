package com.mercadolibre.pf_be_hisp_w26_t10_garcia;


import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.mercadolibre.pf_be_hisp_w26_t10_garcia.entity.Rol;
import com.mercadolibre.pf_be_hisp_w26_t10_garcia.entity.UserAccount;
import com.mercadolibre.pf_be_hisp_w26_t10_garcia.repository.*;
import com.mercadolibre.pf_be_hisp_w26_t10_garcia.util.EntitiesUtilsTest;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.text.SimpleDateFormat;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
@ExtendWith(MockitoExtension.class)
@ActiveProfiles("test_none")
@Transactional
public class SearchControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private IUserAccountRepository accountRepository;

    @Autowired
    private ICategoryRepository categoryRepository;

    @Autowired
    private IProductRepository productRepository;

    @Autowired
    private IWarehouseRepository warehouseRepository;

    @Autowired
    private ISectorRepository sectorRepository;

    @Autowired
    private IBatchRepository batchRepository;


    @Autowired
    private IUserAccountRepository userAccountRepository;

    @BeforeEach
    public void setUp() {
        UserAccount userSuper = new UserAccount();
        userSuper.setUsername("nhoyosp");
        userSuper.setPassword("$2a$10$QdjO1iHy/vOEpbIyb5gTuuysQWbrLOSzM8PTSL2kwWSUpL3NgYY0G");
        userSuper.setFirstName("nicolas");
        userSuper.setLastName("hoyos");
        userSuper.setUserRole(Rol.SUPERVISOR);
        userAccountRepository.save(userSuper);

        UserAccount userSuper1 = new UserAccount();
        userSuper1.setUsername("jgonz");
        userSuper1.setPassword("$2a$10$HApgftcY3m4qgHFiaPZQkuIck/Fxios/Vwn2HvPS5ccw1NPhjWxx.");
        userSuper1.setFirstName("juan");
        userSuper1.setLastName("gonzalez");
        userSuper1.setUserRole(Rol.SUPERVISOR);
        userAccountRepository.save(userSuper1);

        UserAccount userSuper2 = new UserAccount();
        userSuper2.setUsername("mluis");
        userSuper2.setPassword("$2a$10$dSxd1Ydm74kQeaQNqnWE9./ufOIPWWcfcO1AcK7WMivLBqyOyYBva");
        userSuper2.setFirstName("luis");
        userSuper2.setLastName("meza");
        userSuper2.setUserRole(Rol.SUPERVISOR);
        userAccountRepository.save(userSuper2);

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

    @Order(2)
    @DisplayName("US-03: Product don´t exist ")
    @Test
    public void productNotFoundTest() throws Exception {
        String messageError = "Product not found";

        mockMvc.perform(get("/api/v1/fresh-products/100/batch/list")
                        .contentType(MediaType.APPLICATION_JSON)
                .header(HttpHeaders.AUTHORIZATION, "Bearer " + getToken("nhoyosp","12345")))
                .andDo(print())
                .andExpect(status().isNotFound())
                .andExpect(MockMvcResultMatchers.jsonPath("$.message").value(messageError));

    }

    @Order(1)
    @DisplayName("US-03: Search products on batch ")
    @Test
    public void searchProductBatchTest() throws Exception {

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        mapper = mapper.setDateFormat(formatter);
        String expect = mapper.writeValueAsString(EntitiesUtilsTest.firsrtResponse());

        categoryRepository.save(EntitiesUtilsTest.category());
        System.out.println(categoryRepository.findAll().get(0).getId());
        productRepository.save(EntitiesUtilsTest.mazanaProductComplete());
        batchRepository.save(EntitiesUtilsTest.firstBatch());
        batchRepository.save(EntitiesUtilsTest.secondBatch());
        sectorRepository.save(EntitiesUtilsTest.sector());
        warehouseRepository.save(EntitiesUtilsTest.warehouseComplete());
        sectorRepository.save(EntitiesUtilsTest.sectorComplete());
        batchRepository.save(EntitiesUtilsTest.firstBatchComplete());
        batchRepository.save(EntitiesUtilsTest.secondBatchComplete());

        mockMvc.perform(get("/api/v1/fresh-products/1/batch/list")
                        .contentType(MediaType.APPLICATION_JSON)
                        .header(HttpHeaders.AUTHORIZATION, "Bearer " + getToken("jgonz","12345")))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(expect));

    }


}


