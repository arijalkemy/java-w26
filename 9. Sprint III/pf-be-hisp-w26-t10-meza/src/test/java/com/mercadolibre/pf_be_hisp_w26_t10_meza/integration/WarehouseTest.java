package com.mercadolibre.pf_be_hisp_w26_t10_meza.integration;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.mercadolibre.pf_be_hisp_w26_t10_meza.dtos.warehouse.WarehouseInfoDto;
import com.mercadolibre.pf_be_hisp_w26_t10_meza.dtos.warehouse.WarehouseResponseInfoDto;
import com.mercadolibre.pf_be_hisp_w26_t10_meza.dtos.warehouse.WarehouseResponseRegisterDto;
import com.mercadolibre.pf_be_hisp_w26_t10_meza.service.implementations.WarehouseServiceImpl;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
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

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@ExtendWith(MockitoExtension.class)
@ActiveProfiles("test")
@AutoConfigureTestDatabase(replace= AutoConfigureTestDatabase.Replace.NONE)
@Transactional
public class WarehouseTest {

    @Autowired
    MockMvc mockMvc;

    static ObjectWriter writer;

    @MockBean
    WarehouseServiceImpl warehouseService;

    @BeforeAll
    public static void setupWriter(){
        writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .registerModule(new JavaTimeModule())
                .writer().withDefaultPrettyPrinter();
    }



    @Test
    @DisplayName(" Integratio Test - US006 Registration of A warehouse")
    public void registerWarehousePostMethod () throws Exception {

        String username = "zmarcos";
        String password = "12345";
        String token = getToken(username, password);


        WarehouseInfoDto warehouseInfoDto = new WarehouseInfoDto();
        warehouseInfoDto.setWarehouseName("NewHouse");
        warehouseInfoDto.setSupervisorId(9L);

        String payload = writer.writeValueAsString(warehouseInfoDto);


        WarehouseResponseRegisterDto warehouseResponseRegisterDto = new WarehouseResponseRegisterDto();
        warehouseResponseRegisterDto.setMessage("Warehouse register successfully");

        when(warehouseService.registerWarehouse(warehouseInfoDto)).thenReturn(warehouseResponseRegisterDto);

        MvcResult result = this.mockMvc.perform(MockMvcRequestBuilders.post("/warehouse/register")
                        .header(HttpHeaders.AUTHORIZATION, "Bearer " + token)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(String.valueOf(payload)))
                .andDo(print()).andExpect(status().isCreated())
                .andReturn();

        String jsonResponse = result.getResponse().getContentAsString();
        ObjectMapper objectMapper = new ObjectMapper();

        WarehouseResponseRegisterDto responseObtained = objectMapper.readValue(jsonResponse, WarehouseResponseRegisterDto.class);

        Assertions.assertEquals(warehouseResponseRegisterDto, responseObtained);
    }

    @Test
    @DisplayName(" Integratio Test - US006 getting a warehouse successfully")
    public void getOneWarehouse () throws Exception {

        String username = "zmarcos";
        String password = "12345";
        String token = getToken(username, password);

        Integer idWarehouse = 1;

        WarehouseResponseInfoDto warehouseResponseInfoDto = new WarehouseResponseInfoDto();
        warehouseResponseInfoDto.setId(1);
        warehouseResponseInfoDto.setName("Almacén Principal");

        when(warehouseService.findOneWarehouse(idWarehouse)).thenReturn(warehouseResponseInfoDto);

        this.mockMvc.perform(MockMvcRequestBuilders.get("/warehouse/{idWarehouse}", 1)
                        .header(HttpHeaders.AUTHORIZATION, "Bearer " + token))
                .andDo(print()).andExpect(status().isOk());


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

}
