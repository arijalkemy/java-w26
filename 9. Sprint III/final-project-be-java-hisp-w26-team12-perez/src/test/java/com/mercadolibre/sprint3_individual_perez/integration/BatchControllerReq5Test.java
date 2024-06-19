package com.mercadolibre.sprint3_individual_perez.integration;

import com.mercadolibre.sprint3_individual_perez.exceptions.ApiException;
import com.mercadolibre.sprint3_individual_perez.utils.UtilAutenticationTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class BatchControllerReq5Test {

    @Autowired
    private MockMvc mockMvc;
    private String token;

    /* CONFIG When security is active
    @BeforeEach
    public void setUp() throws Exception {
        LoginRequestDTO login = new LoginRequestDTO("Yair", "Yair");

        // Solicit
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("/auth/login")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(login))
                )
                .andExpect(status().isOk())  // We need apropiate status
                .andReturn();

        // Get the token
        String responseToken = result.getResponse().getContentAsString();

       //Save in global variable
        token = responseToken;
    }

    // Método utilitario para convertir un objeto a JSON
    private static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    */

    @Test
    public void testGetBatchesToExpire() throws Exception{
        //Arrange
        Integer cantDays = 100000; //Day to expire batches
        UtilAutenticationTest utilAutenticationTest = new UtilAutenticationTest();
        String token = utilAutenticationTest.getTokenAdmin(mockMvc); // Get the token
        //Act and Assert
        MvcResult response = mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/fresh-products/batch/list/due-date/{cantDays}",cantDays)
                        .header(HttpHeaders.AUTHORIZATION, "Bearer " + token) //Prepared to active security
                )
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andReturn();
    }

    @Test
    public void testGetBatchesToExpireThowsException() throws Exception{
        Integer cantDays = 0; //Day to expire batches
        UtilAutenticationTest utilAutenticationTest = new UtilAutenticationTest();
        String token = utilAutenticationTest.getTokenAdmin(mockMvc);
        MvcResult response = mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/fresh-products/batch/list/due-date/{cantDays}",cantDays)
                        .header(HttpHeaders.AUTHORIZATION, "Bearer " + token) //Prepared to active security
                )
                .andDo(print())
                .andExpect(status().isNotFound())
                .andExpect(content().contentType("application/json"))
                .andReturn();

        Assertions.assertEquals(ApiException.class, response.getResolvedException().getClass());

    }
    /*Test before merge
    public void testGetBatchesToExpireThowsExceptionByUser() throws Exception{
        Integer cantDays = 0; //Day to expire batches

        MvcResult response = mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/fresh-products/batch/list/due-date/{cantDays}",cantDays)
                        .header(HttpHeaders.AUTHORIZATION, "Bearer " + "Nothing") //Prepared to active security
                )
                .andDo(print())
                .andExpect(status().isNotFound())
                .andExpect(content().contentType("application/json"))
                .andReturn();

        Assertions.assertEquals(ApiException.class, response.getResolvedException().getClass());

    }
     */
}
