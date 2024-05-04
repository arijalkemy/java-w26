package com.mercadolibre.romannumerals;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class RomanNumeralsApplicationTests {
  @Autowired
  private MockMvc mockMvc;

  @Test
  void oneShouldBeI() throws Exception {
    performTest("1", "I");
  }

  @Test
  void threeShouldBeIII() throws Exception {
    performTest("3", "III");
  }

  @Test
  void fiveShouldBeV() throws Exception {
    performTest("5", "V");
  }

  @Test
  void sevenShouldBeVII() throws Exception {
    performTest("7", "VII");
  }

  @Test
  void tenShouldBeX() throws Exception {
    performTest("10", "X");
  }

  @Test
  void fifteenShouldBeXV() throws Exception {
    performTest("15", "XV");
  }

  @Test
  void fiftyShouldBeL() throws Exception {
    performTest("50", "L");
  }

  private void performTest(String decimal, String roman) throws Exception {
    this.mockMvc.perform(get("/" + decimal))
        .andDo(print())
        .andExpect(status().isOk())
        .andExpect(content().string(containsString(roman)));

  }

}
