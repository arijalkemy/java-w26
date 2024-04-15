package org.miprimerproyecto.codigomorse;

import java.util.HashMap;
import java.util.Map;

public class MorseTranslator {
    private static final Map<String, String> morseToChar = new HashMap<>();
    private static final Map<String, String> charToMorse = new HashMap<>();

    static {
        morseToChar.put(".-", "A");
        morseToChar.put("-...", "B");
        morseToChar.put("-.-.", "C");
        morseToChar.put("-..", "D");
        morseToChar.put(".", "E");
        morseToChar.put("..-.", "F");
        morseToChar.put("--.", "G");
        morseToChar.put("....", "H");
        morseToChar.put("..", "I");
        morseToChar.put(".---", "J");
        morseToChar.put("-.-", "K");
        morseToChar.put(".-..", "L");
        morseToChar.put("--", "M");
        morseToChar.put("-.", "N");
        morseToChar.put("---", "O");
        morseToChar.put(".--.", "P");
        morseToChar.put("--.-", "Q");
        morseToChar.put(".-.", "R");
        morseToChar.put("...", "S");
        morseToChar.put("-", "T");
        morseToChar.put("..-", "U");
        morseToChar.put("...-", "V");
        morseToChar.put(".--", "W");
        morseToChar.put("-..-", "X");
        morseToChar.put("-.--", "Y");
        morseToChar.put("--..", "Z");
        morseToChar.put(".----", "1");
        morseToChar.put("..---", "2");
        morseToChar.put("...--", "3");
        morseToChar.put("....-", "4");
        morseToChar.put(".....", "5");
        morseToChar.put("-....", "6");
        morseToChar.put("--...", "7");
        morseToChar.put("---..", "8");
        morseToChar.put("----.", "9");
        morseToChar.put("-----", "0");
        morseToChar.put("/", " ");
        // Mapa de caracteres a código Morse (inverso)
        for (Map.Entry<String, String> entry : morseToChar.entrySet()) {
            charToMorse.put(entry.getValue(), entry.getKey());
        }
    }
    // Si la entrada contiene solo puntos, guiones y espacios, consideramos que es código Morse
    //Sino se debera aplicar el inverso
    public static String translateToMorseOrSpanish(String input) {

        if (input.matches("[\\s.-]+")) {
            return translateMorseToSpanish(input);
        } else {
            return translateSpanishToMorse(input);
        }
    }

    public static String translateMorseToSpanish(String morseCode) {
        StringBuilder result = new StringBuilder();
        String[] words = morseCode.trim().split("\\s{2,}"); // Separar por 2 o más espacios en blanco

        for (String word : words) {
            String[] letters = word.split("\\s+");
            for (String letter : letters) {
                String translatedChar = morseToChar.get(letter);
                if (translatedChar != null) {
                    result.append(translatedChar);
                }
            }
            result.append(" ");
        }

        return result.toString().trim();
    }

    public static String translateSpanishToMorse(String spanishText) {
        // Implementación de la traducción de español a código Morse
        StringBuilder result = new StringBuilder();
        String upperCaseText = spanishText.toUpperCase();

        for (int i = 0; i < upperCaseText.length(); i++) {
            char c = upperCaseText.charAt(i);
            String morseCode = charToMorse.get(String.valueOf(c));
            if (morseCode != null) {
                result.append(morseCode).append(" ");
            } else if (c == ' ') {
                result.append("/ ");
            }
        }

        return result.toString().trim();
    }
}

