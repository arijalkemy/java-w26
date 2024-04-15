package meli.bootcamp.codigo_morse.service;

import org.springframework.stereotype.Service;

@Service
public class MorseService {

  char[] letter = {'a', 'b', 'c', 'd', 'e', 'f',
      'g', 'h', 'i', 'j', 'k', 'l',
      'm', 'n', 'o', 'p', 'q', 'r',
      's', 't', 'u', 'v', 'w', 'x',
      'y', 'z', '1', '2', '3', '4',
      '5', '6', '7', '8', '9', '0'};

  String[] code
      = {".-", "-...", "-.-.", "-..", ".",
      "..-.", "--.", "....", "..", ".---",
      "-.-", ".-..", "--", "-.", "---",
      ".--.", "--.-", ".-.", "...", "-",
      "..-", "...-", ".--", "-..-", "-.--",
      "--..", "|"};

  public String morseToText(String morseCode) {
    String[] array = morseCode.split(" ");
    StringBuilder result = new StringBuilder();

    for (String s : array) {
      for (int j = 0; j < code.length; j++) {
        if (s.compareTo(code[j]) == 0) {
          result.append(letter[j]);
          break;
        }
      }
    }

    return result.toString();
  }

  public String textToMorse(String text) {
    StringBuilder result = new StringBuilder();

    for (int i = 0; i < text.length(); i++) {
      for (int j = 0; j < letter.length; j++) {
        if (text.toLowerCase().charAt(i) == letter[j]) {
          result.append(code[j]).append(" ");
          break;
        }
      }
    }

    return result.toString();
  }

}