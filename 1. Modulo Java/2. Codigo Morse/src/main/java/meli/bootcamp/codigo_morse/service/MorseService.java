package meli.bootcamp.codigo_morse.service;

import java.util.HashMap;
import org.springframework.stereotype.Service;

@Service
public class MorseService {

  private static final HashMap<String, Character> morseCodeMap = new HashMap<>();

  static {
    morseCodeMap.put(".-", 'A');
    morseCodeMap.put("-...", 'B');
    morseCodeMap.put("-.-.", 'C');
    morseCodeMap.put("-..", 'D');
    morseCodeMap.put(".", 'E');
    morseCodeMap.put("..-.", 'F');
    morseCodeMap.put("--.", 'G');
    morseCodeMap.put("....", 'H');
    morseCodeMap.put("..", 'I');
    morseCodeMap.put(".---", 'J');
    morseCodeMap.put("-.-", 'K');
    morseCodeMap.put(".-..", 'L');
    morseCodeMap.put("--", 'M');
    morseCodeMap.put("-.", 'N');
    morseCodeMap.put("---", 'O');
    morseCodeMap.put(".--.", 'P');
    morseCodeMap.put("--.-", 'Q');
    morseCodeMap.put(".-.", 'R');
    morseCodeMap.put("...", 'S');
    morseCodeMap.put("-", 'T');
    morseCodeMap.put("..-", 'U');
    morseCodeMap.put("...-", 'V');
    morseCodeMap.put(".--", 'W');
    morseCodeMap.put("-..-", 'X');
    morseCodeMap.put("-.--", 'Y');
    morseCodeMap.put("--..", 'Z');
    morseCodeMap.put("-----", '0');
    morseCodeMap.put(".----", '1');
    morseCodeMap.put("..---", '2');
    morseCodeMap.put("...--", '3');
    morseCodeMap.put("....-", '4');
    morseCodeMap.put(".....", '5');
    morseCodeMap.put("-....", '6');
    morseCodeMap.put("--...", '7');
    morseCodeMap.put("---..", '8');
    morseCodeMap.put("----.", '9');
  }

  public static String translateToText(String morseCode) {
    StringBuilder result = new StringBuilder();
    String[] words = morseCode.split(" {3}");

    for (String word : words) {
      String[] letters = word.split(" ");
      for (String letter : letters) {
        if (morseCodeMap.containsKey(letter)) {
          result.append(morseCodeMap.get(letter));
        } else {
          result.append('?'); // handle unknown characters
        }
      }
      result.append(' ');
    }

    return result.toString().trim();
  }

}