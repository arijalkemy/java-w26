package com.javabootcamp.codigomorse.service;

import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@Service
public class MorseService {

    private static final Map<String,String> morseCode = new HashMap<>();
    static{
        morseCode.put(".-", "A");
        morseCode.put("-...", "B");
        morseCode.put("-.-.", "C");
        morseCode.put("-..", "D");
        morseCode.put(".", "E");
        morseCode.put("..-.", "F");
        morseCode.put("--.", "G");
        morseCode.put("....", "H");
        morseCode.put("..", "I");
        morseCode.put(".---", "J");
        morseCode.put("-.-", "K");
        morseCode.put(".-..", "L");
        morseCode.put("--", "M");
        morseCode.put("-.", "N");
        morseCode.put("---", "O");
        morseCode.put(".--.", "P");
        morseCode.put("--.-", "Q");
        morseCode.put(".-.", "R");
        morseCode.put("...", "S");
        morseCode.put("-", "T");
        morseCode.put("..-", "U");
        morseCode.put("...-", "V");
        morseCode.put(".--", "W");
        morseCode.put("-..-", "X");
        morseCode.put("-.--", "Y");
        morseCode.put("--..", "Z");
        morseCode.put("-----", "0");
        morseCode.put(".----", "1");
        morseCode.put("..---", "2");
        morseCode.put("...--", "3");
        morseCode.put("....-", "4");
        morseCode.put(".....", "5");
        morseCode.put("-....", "6");
        morseCode.put("--...", "7");
        morseCode.put("---..", "8");
        morseCode.put("----.", "9");
        morseCode.put(".-.-.-", ".");
        morseCode.put("--..--", ",");
        morseCode.put("..--..", "?");
        morseCode.put("-.-.--", "!");
    }

    public String translateMtoT(String codeInMorse) {
        StringBuilder result = new StringBuilder();
        String[] words = codeInMorse.split("   ");
        for (String word : words) {
            String[] miniSec = word.split(" ");
            for (String miniS : miniSec) {
                String character = morseCode.get(miniS);
                if (character != null) {
                    result.append(character);
                }
            }
            result.append(" ");
        }

        return result.toString().trim();
    }

    public String translateTtoM(String text) {
        text = text.toUpperCase();
        StringBuilder result = new StringBuilder();
        String[] words = text.split(" ");

        for (String word : words) {
            for (char letter : word.toCharArray()) {
                for (Map.Entry<String, String> entry : morseCode.entrySet()) {
                    if (entry.getValue().equals(String.valueOf(letter).toUpperCase())) {
                        result.append(entry.getKey()).append(" ");
                    }
                }
            }
            result.append("  ");
        }

        return result.toString();
    }
}
