package meli.bootcamp.codigomorse.helpers;

import java.util.HashMap;
import java.util.Map;

public class ConvertMorse {
    static HashMap<String, String> morseCodeMap = new HashMap<>();
    static {
        morseCodeMap.put(".-", "A");
        morseCodeMap.put("-...", "B");
        morseCodeMap.put("-.-.", "C");
        morseCodeMap.put("-..", "D");
        morseCodeMap.put(".", "E");
        morseCodeMap.put("..-.", "F");
        morseCodeMap.put("--.", "G");
        morseCodeMap.put("....", "H");
        morseCodeMap.put("..", "I");
        morseCodeMap.put(".---", "J");
        morseCodeMap.put("-.-", "K");
        morseCodeMap.put(".-..", "L");
        morseCodeMap.put("--", "M");
        morseCodeMap.put("-.", "N");
        morseCodeMap.put("---", "O");
        morseCodeMap.put(".--.", "P");
        morseCodeMap.put("--.-", "Q");
        morseCodeMap.put(".-.", "R");
        morseCodeMap.put("...", "S");
        morseCodeMap.put("-", "T");
        morseCodeMap.put("..-", "U");
        morseCodeMap.put("...-", "V");
        morseCodeMap.put(".--", "W");
        morseCodeMap.put("-..-", "X");
        morseCodeMap.put("-.--", "Y");
        morseCodeMap.put("--..", "Z");
        morseCodeMap.put("-----", "0");
        morseCodeMap.put(".----", "1");
        morseCodeMap.put("..---", "2");
        morseCodeMap.put("...--", "3");
        morseCodeMap.put("....-", "4");
        morseCodeMap.put(".....", "5");
        morseCodeMap.put("-....", "6");
        morseCodeMap.put("--...", "7");
        morseCodeMap.put("---..", "8");
        morseCodeMap.put("----.", "9");
        morseCodeMap.put(".-.-.-", ".");
        morseCodeMap.put("--..--", ",");
        morseCodeMap.put("..--..", "?");
        morseCodeMap.put("-.-.--", "!");
    }

    public static String convertMorseCode(String morseCode) {

        return morseCodeMap.getOrDefault(morseCode, " ");
    }

    public static String convertToMorseCode(String letter) {
        Map<String, String> reversedMap = new HashMap<>();
        for(Map.Entry<String, String> entry : morseCodeMap.entrySet()) {
            reversedMap.put(entry.getValue(), entry.getKey());
        }

        return reversedMap.getOrDefault(letter, " ");
    }
}
