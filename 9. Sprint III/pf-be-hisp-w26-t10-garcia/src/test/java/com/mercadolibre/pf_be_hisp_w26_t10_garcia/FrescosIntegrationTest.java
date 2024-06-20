package com.mercadolibre.pf_be_hisp_w26_t10_garcia;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.mercadolibre.pf_be_hisp_w26_t10_garcia.dtos.*;
import com.mercadolibre.pf_be_hisp_w26_t10_garcia.repository.IUserAccountRepository;
import com.mercadolibre.pf_be_hisp_w26_t10_garcia.service.implementations.BatchServiceImpl;
import org.junit.jupiter.api.*;
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

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Arrays;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;




@SpringBootTest(classes = {com.mercadolibre.pf_be_hisp_w26_t10_garcia.Application.class})
@AutoConfigureMockMvc
@ActiveProfiles("test")
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class FrescosIntegrationTest {
    private UploadBatchRequestDto uploadBatchRequestDto;
    private UploadBatchRequestDto updateBatchRequestDto;
    static ObjectWriter writer;

    @Autowired
    IUserAccountRepository userAccountRepository;
    @Autowired
    MockMvc mockMvc;
    @MockBean
    BatchServiceImpl batchServiceImpl;

    @BeforeAll
    public static void setupWriter(){
        writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer().withDefaultPrettyPrinter();
    }

    @BeforeEach
    public void setup(){
        this.uploadBatchRequestDto = new UploadBatchRequestDto();
        this.updateBatchRequestDto = new UploadBatchRequestDto();
        InboundOrderDto inboundOrderDto = new InboundOrderDto();
        InboundOrderDto inboundOrderUpdated = new InboundOrderDto();
        SectionDto sectionDto = new SectionDto();

        sectionDto.setSectionCode(1);
        sectionDto.setWarehouseCode(1);

        inboundOrderDto.setOrderNumber(1020);
        inboundOrderDto.setOrderDate(LocalDate.of(2024, 6, 17));
        inboundOrderDto.setSectionDto(sectionDto);
        inboundOrderDto.setBatchDto(
                Arrays.asList(
                        new BatchDto(
                                1,
                                1,
                                32.1,
                                31.0,
                                4,
                                7,
                                LocalDate.of(2024, 6, 17),
                                LocalTime.of(9,0,0),
                                LocalDate.of(2025, 6, 17))));

        inboundOrderUpdated.setOrderNumber(1020);
        inboundOrderUpdated.setOrderDate(LocalDate.of(2024, 6, 17));
        inboundOrderUpdated.setSectionDto(sectionDto);
        inboundOrderUpdated.setBatchDto(
                Arrays.asList(
                        new BatchDto(
                                1,
                                1,
                                42.1,
                                41.0,
                                4,
                                7,
                                LocalDate.of(2024, 6, 17),
                                LocalTime.of(9,0,0),
                                LocalDate.of(2025, 6, 17))));


        uploadBatchRequestDto.setInboundOrderDto(inboundOrderDto);
        updateBatchRequestDto.setInboundOrderDto(inboundOrderUpdated);

    }

    @Test
    @DisplayName("Integration Test US0001 - Generating the response of a Batch inserted into the stock")
    public void batchInStockSuccessfully() throws Exception{
        String payload = writer.writeValueAsString(uploadBatchRequestDto);

        BatchResponseDto responseDto = new BatchResponseDto();
        responseDto.setBatch_stock(uploadBatchRequestDto.getInboundOrderDto().getBatchDto());
        when(batchServiceImpl.uploadBatchIntoStock(uploadBatchRequestDto)).thenReturn(responseDto);

        String requestAccess = getToken("mluis", "12345");
        MvcResult result = this.mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/fresh-products/inboundorder")
                        .header(HttpHeaders.AUTHORIZATION, "Bearer " + requestAccess)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(String.valueOf(payload)))
                        .andDo(print()).andExpect(status().isCreated())
                        .andReturn();

        String jsonResponse = result.getResponse().getContentAsString();
        ObjectMapper objectMapper = new ObjectMapper();
        BatchResponseDto responseDto1 = objectMapper.readValue(jsonResponse, BatchResponseDto.class);

        Assertions.assertEquals(responseDto,responseDto1 );
    }


    @Test
    @DisplayName("")
    public void batchInStockUpdatedSuccessfully() throws Exception {
        String payload = writer.writeValueAsString(updateBatchRequestDto);

        BatchResponseDto responseDto = new BatchResponseDto();
        responseDto.setBatch_stock(updateBatchRequestDto.getInboundOrderDto().getBatchDto());
        when(batchServiceImpl.updateBatchInStock(updateBatchRequestDto)).thenReturn(responseDto);

        String requestAccess = getToken("mluis", "12345");
        MvcResult result = this.mockMvc.perform(MockMvcRequestBuilders.put("/api/v1/fresh-products/inboundorder")
                        .header(HttpHeaders.AUTHORIZATION, "Bearer " + requestAccess)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(String.valueOf(payload)))
                .andDo(print()).andExpect(status().isCreated())
                .andReturn();

        String jsonResponse = result.getResponse().getContentAsString();
        ObjectMapper objectMapper = new ObjectMapper();
        BatchResponseDto responseDto1 = objectMapper.readValue(jsonResponse, BatchResponseDto.class);

        Assertions.assertEquals(responseDto,responseDto1 );
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
    @DisplayName("US-002-ISSUE-06-Get products from shopping cart Integration test")


    public void getProductsFromShoppingCart() throws Exception {
        String username = "jgonz";
        String password = "12345";

        String token = getToken(username,password);

        Integer idOrder = 3;
        MvcResult mvcResult = mockMvc.perform(get("/api/v1/fresh-products/orders/{idOrder}", idOrder)
                        .header("Authorization","Bearer " + token))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$[0].name").value("Yogur Natural"))
                .andReturn();
    }
}
