package com.mercadolibre.romannumerals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.CoreMatchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class RomanNumeralsApplicationTests {

  /*
1
Devuelve el equivalente en número romano: I

3
Devuelve el equivalente en número romano: III

5
Devuelve el equivalente en número romano: V

7
Devuelve el equivalente en número romano: VII

10
Devuelve el equivalente en número romano: X

50
Devuelve el equivalente en número romano: L
   */

  @Autowired
  private MockMvc mockMvc;

  @Test
  void oneShouldBeI() throws Exception {
    performTest("1", "I");
  }

  @Test
  void tenShouldBeX() throws Exception {
    performTest("10", "X");
  }

  @Test
  void sevenShouldBeVII() throws Exception {
    performTest("7", "VII");
  }

  @Test
  void fifteenShouldBeXV() throws Exception {
    performTest("15", "XV");
  }

  private void performTest(String decimal, String roman) throws Exception {
    this.mockMvc.perform(get("/" + decimal))
        .andDo(print())
        .andExpect(status().isOk())
        .andExpect(content().string(containsString(roman)));
  }
}
