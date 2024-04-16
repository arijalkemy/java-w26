package com.Bootcamp.ejercicioClaveMorse.service.service.impl;

import com.Bootcamp.ejercicioClaveMorse.service.ImorseCodeService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class CodeMorseServiceImpl implements ImorseCodeService {

    private static final Map<String, Character> morseToCharMap = new HashMap<>();
    private static final Map<Character, String> charToMorseMap = new HashMap<>();

    static {
        // Inicialización estática de los mapas
        // Inicializacion de map para traducir de morse a español
        morseToCharMap.put(".-", 'A');
        morseToCharMap.put("-...", 'B');
        morseToCharMap.put("-.-.", 'C');
        morseToCharMap.put("-..", 'D');
        morseToCharMap.put(".", 'E');
        morseToCharMap.put("..-.", 'F');
        morseToCharMap.put("--.", 'G');
        morseToCharMap.put("....", 'H');
        morseToCharMap.put("..", 'I');
        morseToCharMap.put(".---", 'J');
        morseToCharMap.put("-.-", 'K');
        morseToCharMap.put(".-..", 'L');
        morseToCharMap.put("--", 'M');
        morseToCharMap.put("-.", 'N');
        morseToCharMap.put("---", 'O');
        morseToCharMap.put(".--.", 'P');
        morseToCharMap.put("--.-", 'Q');
        morseToCharMap.put(".-.", 'R');
        morseToCharMap.put("...", 'S');
        morseToCharMap.put("-", 'T');
        morseToCharMap.put("..-", 'U');
        morseToCharMap.put("...-", 'V');
        morseToCharMap.put(".--", 'W');
        morseToCharMap.put("-..-", 'X');
        morseToCharMap.put("-.--", 'Y');
        morseToCharMap.put("--..", 'Z');
        morseToCharMap.put("-----", '0');
        morseToCharMap.put(".----", '1');
        morseToCharMap.put("..---", '2');
        morseToCharMap.put("...--", '3');
        morseToCharMap.put("....-", '4');
        morseToCharMap.put(".....", '5');
        morseToCharMap.put("-....", '6');
        morseToCharMap.put("--...", '7');
        morseToCharMap.put("---..", '8');
        morseToCharMap.put("----.", '9');

        // Inicializacion de map para traducir de español a morse
        charToMorseMap.put('A', ".-");
        charToMorseMap.put('B', "-...");
        charToMorseMap.put('C', "-.-.");
        charToMorseMap.put('D', "-..");
        charToMorseMap.put('E', ".");
        charToMorseMap.put('F', "..-.");
        charToMorseMap.put('G', "--.");
        charToMorseMap.put('H', "....");
        charToMorseMap.put('I', "..");
        charToMorseMap.put('J', ".---");
        charToMorseMap.put('K', "-.-");
        charToMorseMap.put('L', ".-..");
        charToMorseMap.put('M', "--");
        charToMorseMap.put('N', "-.");
        charToMorseMap.put('O', "---");
        charToMorseMap.put('P', ".--.");
        charToMorseMap.put('Q', "--.-");
        charToMorseMap.put('R', ".-.");
        charToMorseMap.put('S', "...");
        charToMorseMap.put('T', "-");
        charToMorseMap.put('U', "..-");
        charToMorseMap.put('V', "...-");
        charToMorseMap.put('W', ".--");
        charToMorseMap.put('X', "-..-");
        charToMorseMap.put('Y', "-.--");
        charToMorseMap.put('Z', "--..");
    }

    @Override
    public String encodeMorse(String inputText) {
        String[] words = inputText.toUpperCase().split(" ");
        StringBuilder translation = new StringBuilder();
        for (String word : words) {
            char[] letters = word.toCharArray();
            for (char letter : letters) {
                translation.append(charToMorseMap.get(letter)).append(" ");
            }
            translation.append("   ");
        }
        return translation.toString();
    }

    @Override
    public String decodeMorse(String morseCode) {
        if (morseCode.matches("^[.\\-\\s]*$")) {
            String[] words = morseCode.split("   ");
            StringBuilder translation = new StringBuilder();
            for (String word : words) {
                // se eliminan los espacios que sobran y se divide por simbolo
                String[] symbols = word.trim().split(" ");
                for (String symbol : symbols) {
                    translation.append(morseToCharMap.get(symbol));
                }
                translation.append(" ");
            }
            return translation.toString();
        } else {
            return "Error: El texto solo puede contener .- y espacios";
        }
    }
}
