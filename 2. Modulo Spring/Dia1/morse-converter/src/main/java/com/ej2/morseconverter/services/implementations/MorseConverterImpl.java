package com.ej2.morseconverter.services.implementations;

import com.ej2.morseconverter.services.IMorseConverter;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class MorseConverterImpl implements IMorseConverter {

    private static final Map<String, String> morseToSpanish = new HashMap<>();
    private static final Map<String, String> spanishToMorse = new HashMap<>();

    static {
        // mapeo de letras y números en código Morse a español
        morseToSpanish.put(".-", "A");
        morseToSpanish.put("-...", "B");
        morseToSpanish.put("-.-.", "C");
        morseToSpanish.put("-..", "D");
        morseToSpanish.put(".", "E");
        morseToSpanish.put("..-.", "F");
        morseToSpanish.put("--.", "G");
        morseToSpanish.put("....", "H");
        morseToSpanish.put("..", "I");
        morseToSpanish.put(".---", "J");
        morseToSpanish.put("-.-", "K");
        morseToSpanish.put(".-..", "L");
        morseToSpanish.put("--", "M");
        morseToSpanish.put("-.", "N");
        morseToSpanish.put("---", "O");
        morseToSpanish.put(".--.", "P");
        morseToSpanish.put("--.-", "Q");
        morseToSpanish.put(".-.", "R");
        morseToSpanish.put("...", "S");
        morseToSpanish.put("-", "T");
        morseToSpanish.put("..-", "U");
        morseToSpanish.put("...-", "V");
        morseToSpanish.put(".--", "W");
        morseToSpanish.put("-..-", "X");
        morseToSpanish.put("-.--", "Y");
        morseToSpanish.put("--..", "Z");
        morseToSpanish.put("-----", "0");
        morseToSpanish.put(".----", "1");
        morseToSpanish.put("..---", "2");
        morseToSpanish.put("...--", "3");
        morseToSpanish.put("....-", "4");
        morseToSpanish.put(".....", "5");
        morseToSpanish.put("-....", "6");
        morseToSpanish.put("--...", "7");
        morseToSpanish.put("---..", "8");
        morseToSpanish.put("----.", "9");
        morseToSpanish.put("..--..", "?");
        morseToSpanish.put("-.-.--", "!");
        morseToSpanish.put(".-.-.-", ".");
        morseToSpanish.put("--..--", ",");

        // mapeo de letras y números en español a código Morse
        for (Map.Entry<String, String> entry : morseToSpanish.entrySet()) {
            spanishToMorse.put(entry.getValue(), entry.getKey());
        }
    }

    @Override
    public String convertToSpanish(String morseCode) {
        StringBuilder result = new StringBuilder();
        // separo el código Morse en palabras
        String[] words = morseCode.split("   ");
        for (String word : words) {
            // separo cada palabra en letras
            String[] letters = word.split(" ");
            for (String letter : letters) {
                // convierto cada letra Morse a su equivalente español y agregar al resultado
                result.append(morseToSpanish.get(letter));
            }
            // agrego un espacio entre las palabras
            result.append(" ");
        }
        return result.toString().trim(); // elimino espacios en blanco adicionales al final
    }

    @Override
    public String convertToMorse(String text) {
        StringBuilder result = new StringBuilder();
        // convierto el texto en mayúsculas para que coincida con las claves en el mapa
        text = text.toUpperCase();
        // separo el texto en palabras
        String[] words = text.split(" ");
        for (String word : words) {
            // separo cada palabra en letras
            char[] chars = word.toCharArray();
            for (char c : chars) {
                // convierto cada letra a su equivalente en código Morse y agregar al resultado
                String morse = spanishToMorse.get(String.valueOf(c));
                if (morse != null) {
                    result.append(morse).append(" ");
                }
            }
            // agrego tres espacios para separar las palabras
            result.append("   ");
        }
        return result.toString().trim(); // elimino espacios en blanco adicionales al final
    }
}
