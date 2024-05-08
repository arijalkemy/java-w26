package com.mercadolibre.romannumerals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.core.StringContains.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class RomanNumeralsControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void oneShouldBeI() throws Exception {
        performTest("1","I");
    }
    @Test
    void threeShouldBeIII() throws Exception {
        performTest("3","III");
    }
    @Test
    void fiveShouldBeV() throws Exception {
        performTest("5","V");
    }
    @Test
    void sevenShouldBeVII() throws Exception {
        performTest("7","VII");
    }
    @Test
    void tenShouldBeX() throws Exception {
        performTest("10","X");
    }
    @Test
    void fiftyShouldBeL() throws Exception {
        performTest("50","L");
    }


    private void performTest(String decimal, String roman) throws Exception {
        this.mockMvc.perform(get("/"+decimal))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString(roman)));
    }
}
