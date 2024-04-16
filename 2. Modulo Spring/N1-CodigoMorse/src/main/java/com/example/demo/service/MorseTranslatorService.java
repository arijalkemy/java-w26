package com.example.demo.service;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class MorseTranslatorService {

    private final Map<String, String> morseToSpanishMap;
    private final Map<String, String> spanishToMorseMap;

    public MorseTranslatorService() {
        this.morseToSpanishMap = new HashMap<>();
        this.spanishToMorseMap = new HashMap<>();
        initializeMorseToSpanishMap();
        initializeSpanishToMorseMap();
    }

    public String translateMorseToSpanish(String morseCode) {
        StringBuilder translation = new StringBuilder();

        // Separa el código morse en palabras
        String[] words = morseCode.trim().split(" {3}");

        for (String word : words) {
            // Separa cada palabra en caracteres
            String[] characters = word.split(" ");
            for (String character : characters) {
                // Traducir cada caracter Morse a español
                if (morseToSpanishMap.containsKey(character)) {
                    translation.append(morseToSpanishMap.get(character));
                } else {
                    // Si el caracter Morse no está en el diccionario, dejar un espacio en blanco
                    translation.append(" ");
                }
            }
            // Agregar un espacio entre palabras
            translation.append(" ");
        }

        return translation.toString();
    }

    public String translateSpanishToMorse(String spanishText) {
        StringBuilder translation = new StringBuilder();

        // Convertir el texto a mayúsculas para facilitar la traducción
        spanishText = spanishText.toUpperCase();

        // Separar la frase en palabras
        String[] words = spanishText.split(" ");

        for (String word : words) {
            // Separar cada palabra en caracteres
            char[] characters = word.toCharArray();
            for (char character : characters) {
                // Traducir cada caracter a código Morse
                if (spanishToMorseMap.containsKey(String.valueOf(character))) {
                    translation.append(spanishToMorseMap.get(String.valueOf(character))).append(" ");
                } else {
                    // Si el caracter no tiene una traducción definida, dejar un espacio en blanco
                    translation.append(" ");
                }
            }
            // Agregar un espacio entre palabras
            translation.append("   ");
        }

        return translation.toString().trim();
    }

    private void initializeMorseToSpanishMap() {
        // Inicializar el diccionario con algunas traducciones de ejemplo
        morseToSpanishMap.put(".-", "A");
        morseToSpanishMap.put("-...", "B");
        morseToSpanishMap.put("-.-.", "C");
        morseToSpanishMap.put("-..", "D");
        morseToSpanishMap.put(".", "E");
        morseToSpanishMap.put("..-.", "F");
        morseToSpanishMap.put("--.", "G");
        morseToSpanishMap.put("....", "H");
        morseToSpanishMap.put("..", "I");
        morseToSpanishMap.put(".---", "J");
        morseToSpanishMap.put("-.-", "K");
        morseToSpanishMap.put(".-..", "L");
        morseToSpanishMap.put("--", "M");
        morseToSpanishMap.put("-.", "N");
        morseToSpanishMap.put("---", "O");
        morseToSpanishMap.put(".--.", "P");
        morseToSpanishMap.put("--.-", "Q");
        morseToSpanishMap.put(".-.", "R");
        morseToSpanishMap.put("...", "S");
        morseToSpanishMap.put("-", "T");
        morseToSpanishMap.put("..-", "U");
        morseToSpanishMap.put("...-", "V");
        morseToSpanishMap.put(".--", "W");
        morseToSpanishMap.put("-..-", "X");
        morseToSpanishMap.put("-.--", "Y");
        morseToSpanishMap.put("--..", "Z");
        morseToSpanishMap.put("-----", "0");
        morseToSpanishMap.put(".----", "1");
        morseToSpanishMap.put("..---", "2");
        morseToSpanishMap.put("...--", "3");
        morseToSpanishMap.put("....-", "4");
        morseToSpanishMap.put(".....", "5");
        morseToSpanishMap.put("-....", "6");
        morseToSpanishMap.put("--...", "7");
        morseToSpanishMap.put("---..", "8");
        morseToSpanishMap.put("----.", "9");
        // Añadir más traducciones según sea necesario
    }

    private void initializeSpanishToMorseMap() {
        // Las traducciones son inversas a las del diccionario Morse a español
        for (Map.Entry<String, String> entry : morseToSpanishMap.entrySet()) {
            spanishToMorseMap.put(entry.getValue(), entry.getKey());
        }
        /*
        spanishToMorseMap.put("A", ".-");
        spanishToMorseMap.put("B", "-...");
        spanishToMorseMap.put("C", "-.-.");
        spanishToMorseMap.put("D", "-..");
        spanishToMorseMap.put("E", ".");
        spanishToMorseMap.put("F", "..-.");
        spanishToMorseMap.put("G", "--.");
        spanishToMorseMap.put("H", "....");
        spanishToMorseMap.put("I", "..");
        spanishToMorseMap.put("J", ".---");
        spanishToMorseMap.put("K", "-.-");
        spanishToMorseMap.put("L", ".-..");
        spanishToMorseMap.put("M", "--");
        spanishToMorseMap.put("N", "-.");
        spanishToMorseMap.put("O", "---");
        spanishToMorseMap.put("P", ".--.");
        spanishToMorseMap.put("Q", "--.-");
        spanishToMorseMap.put("R", ".-.");
        spanishToMorseMap.put("S", "...");
        spanishToMorseMap.put("T", "-");
        spanishToMorseMap.put("U", "..-");
        spanishToMorseMap.put("V", "...-");
        spanishToMorseMap.put("W", ".--");
        spanishToMorseMap.put("X", "-..-");
        spanishToMorseMap.put("Y", "-.--");
        spanishToMorseMap.put("Z", "--..");
        spanishToMorseMap.put("0", "-----");
        spanishToMorseMap.put("1", ".----");
        spanishToMorseMap.put("2", "..---");
        spanishToMorseMap.put("3", "...--");
        spanishToMorseMap.put("4", "....-");
        spanishToMorseMap.put("5", ".....");
        spanishToMorseMap.put("6", "-....");
        spanishToMorseMap.put("7", "--...");
        spanishToMorseMap.put("8", "---..");
        spanishToMorseMap.put("9", "----.");

         */
    }
}
