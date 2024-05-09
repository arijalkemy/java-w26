package com.mercadolibre.romannumerals;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RomanNumeralsRestController {
  private final int[] numValues = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
  private final String[] romValues = {"M", "CM", "D", "CD", "C", "XC", "L", "XL",
          "X", "IX", "V", "IV", "I"};
  @GetMapping("/{number}")
  public String toRoman(@PathVariable Integer number) {
    StringBuilder roman = new StringBuilder();

    for (int i = 0; i < numValues.length; i++)
      while (number >= numValues[i]) {
        number -= numValues[i];
        roman.append(romValues[i]);
      }

    return roman.toString();
  }
}
