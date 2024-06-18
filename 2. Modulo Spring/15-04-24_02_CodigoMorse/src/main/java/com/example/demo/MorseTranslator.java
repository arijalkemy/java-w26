package com.example.demo;

import java.util.HashMap;
import java.util.Map;

public class MorseTranslator {
    private static final Map<String, String> TEXT_TO_MORSE;
    private static final Map<String, String> MORSE_TO_TEXT;

    static {
        MORSE_TO_TEXT = new HashMap<>();
        MORSE_TO_TEXT.put(".-", "A");
        MORSE_TO_TEXT.put("-...", "B");
        MORSE_TO_TEXT.put("-.-.", "C");
        MORSE_TO_TEXT.put("-..", "D");
        MORSE_TO_TEXT.put(".", "E");
        MORSE_TO_TEXT.put("..-.", "F");
        MORSE_TO_TEXT.put("--.", "G");
        MORSE_TO_TEXT.put("....", "H");
        MORSE_TO_TEXT.put("..", "I");
        MORSE_TO_TEXT.put(".---", "J");
        MORSE_TO_TEXT.put("-.-", "K");
        MORSE_TO_TEXT.put(".-..", "L");
        MORSE_TO_TEXT.put("--", "M");
        MORSE_TO_TEXT.put("-.", "N");
        MORSE_TO_TEXT.put("---", "O");
        MORSE_TO_TEXT.put(".--.", "P");
        MORSE_TO_TEXT.put("--.-", "Q");
        MORSE_TO_TEXT.put(".-.", "R");
        MORSE_TO_TEXT.put("...", "S");
        MORSE_TO_TEXT.put("-", "T");
        MORSE_TO_TEXT.put("..-", "U");
        MORSE_TO_TEXT.put("...-", "V");
        MORSE_TO_TEXT.put(".--", "W");
        MORSE_TO_TEXT.put("-..-", "X");
        MORSE_TO_TEXT.put("-.--", "Y");
        MORSE_TO_TEXT.put("--..", "Z");
        MORSE_TO_TEXT.put("/", " ");

        TEXT_TO_MORSE = new HashMap<>();
        MORSE_TO_TEXT.forEach((key, value) -> TEXT_TO_MORSE.put(value, key));
    }

    public static String translateToText(String morseCode) {
        StringBuilder translation = new StringBuilder();
        String[] words = morseCode.trim().split(" {3}"); // 3 espacios para separar palabras

        for (String word : words) {
            for (String character : word.split(" ")) {
                String letter = MORSE_TO_TEXT.getOrDefault(character, "");
                translation.append(letter);
            }
            translation.append(" "); // Añadir espacio para separar palabras
        }

        return translation.toString().trim();
    }

    public static String translateToMorse(String text) {
        StringBuilder morseCode = new StringBuilder();
        text = text.toUpperCase(); // Convertir a mayúsculas para la correspondencia

        for (char character : text.toCharArray()) {
            String morse = TEXT_TO_MORSE.getOrDefault(String.valueOf(character), " ");
            morseCode.append(morse).append(" ");
        }

        return morseCode.toString().trim();
    }
}
