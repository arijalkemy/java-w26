package com.spring.codigomorse.Utils;

import java.util.HashMap;
import java.util.Map;

public class TranslateMorseText {
    private static final Map<Character, String> textToMorseMap = new HashMap<>();
    private static final Map<String, Character> morseToTextMap = new HashMap<>();

    static {
        // Mapeo de texto a código Morse
        textToMorseMap.put('A', ".-");
        textToMorseMap.put('B', "-...");
        textToMorseMap.put('C', "-.-.");
        textToMorseMap.put('D', "-..");
        textToMorseMap.put('E', ".");
        textToMorseMap.put('F', "..-.");
        textToMorseMap.put('G', "--.");
        textToMorseMap.put('H', "....");
        textToMorseMap.put('I', "..");
        textToMorseMap.put('J', ".---");
        textToMorseMap.put('K', "-.-");
        textToMorseMap.put('L', ".-..");
        textToMorseMap.put('M', "--");
        textToMorseMap.put('N', "-.");
        textToMorseMap.put('O', "---");
        textToMorseMap.put('P', ".--.");
        textToMorseMap.put('Q', "--.-");
        textToMorseMap.put('R', ".-.");
        textToMorseMap.put('S', "...");
        textToMorseMap.put('T', "-");
        textToMorseMap.put('U', "..-");
        textToMorseMap.put('V', "...-");
        textToMorseMap.put('W', ".--");
        textToMorseMap.put('X', "-..-");
        textToMorseMap.put('Y', "-.--");
        textToMorseMap.put('Z', "--..");
        textToMorseMap.put('1', ".----");
        textToMorseMap.put('2', "..---");
        textToMorseMap.put('3', "...--");
        textToMorseMap.put('4', "....-");
        textToMorseMap.put('5', ".....");
        textToMorseMap.put('6', "-....");
        textToMorseMap.put('7', "--...");
        textToMorseMap.put('8', "---..");
        textToMorseMap.put('9', "----.");
        textToMorseMap.put('0', "-----");
        // Mapeo de código Morse a texto
        for (Map.Entry<Character, String> entry : textToMorseMap.entrySet()) {
            morseToTextMap.put(entry.getValue(), entry.getKey());
        }
    }

    public static String textToMorse(String text) {
        StringBuilder morseCode = new StringBuilder();
        for (char c : text.toUpperCase().toCharArray()) {
            if (c == ' ') {
                morseCode.append(" ");
            } else {
                String morseChar = textToMorseMap.get(c);
                if (morseChar != null) {
                    morseCode.append(morseChar).append(" ");
                }
            }
        }
        return morseCode.toString().trim();
    }

    public static String morseToText(String morse) {
        StringBuilder text = new StringBuilder();
        String[] words = morse.split("   ");
        for (String word : words) {
            String[] letters = word.split(" ");
            for (String letter : letters) {
                Character textChar = morseToTextMap.get(letter);
                if (textChar != null) {
                    text.append(textChar);
                }
            }
            text.append(" ");
        }
        return text.toString().trim();
    }
}
