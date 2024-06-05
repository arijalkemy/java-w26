package org.example.edaddeunapersona.controller;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class CalcularEdadIntegrationTest {

    @Autowired
    MockMvc mockMvc;

    private String okEndPoint, badEndPoint;

    @BeforeEach
    void setUp()
    {
        String year = "2001", month = "04", day = "06";
        okEndPoint = "/birthdate?day=" + day + "&month=" + month + "&year=" + year;
        badEndPoint = "/birthdate?day=" + day + "&month=" + "13" + "&year=" + year;
    }


    @Test
    void verifyIndexReturnsACorrectAge() throws Exception
    {
        // arrange
        int expectedAge = 23;

        // act and assertion
        mockMvc.perform(MockMvcRequestBuilders.get(okEndPoint)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").value(expectedAge)

        );
    }

    @Test
    void verifyExceptionIsThrown() throws Exception
    {

        //act and assert
        mockMvc.perform(MockMvcRequestBuilders.get(badEndPoint)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$").value("Input data dates is not valid")
        );

    }
}
