package org.bootcamp.morse.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public class MorseServiceImpl implements IMorseService {
    private static final Map<String, Character> morseAlphabet = new HashMap<>();

    static {
        morseAlphabet.put(".-", 'A');
        morseAlphabet.put("-...", 'B');
        morseAlphabet.put("-.-.", 'C');
        morseAlphabet.put("-..", 'D');
        morseAlphabet.put(".", 'E');
        morseAlphabet.put("..-.", 'F');
        morseAlphabet.put("--.", 'G');
        morseAlphabet.put("....", 'H');
        morseAlphabet.put("..", 'I');
        morseAlphabet.put(".---", 'J');
        morseAlphabet.put("-.-", 'K');
        morseAlphabet.put(".-..", 'L');
        morseAlphabet.put("--", 'M');
        morseAlphabet.put("--", 'M');
        morseAlphabet.put("-.", 'N');
        morseAlphabet.put("---", 'O');
        morseAlphabet.put(".--.", 'P');
        morseAlphabet.put("--.-", 'Q');
        morseAlphabet.put(".-.", 'R');
        morseAlphabet.put("...", 'S');
        morseAlphabet.put("-", 'T');
        morseAlphabet.put("..-", 'U');
        morseAlphabet.put("...-", 'V');
        morseAlphabet.put(".--", 'W');
        morseAlphabet.put("-..-", 'X');
        morseAlphabet.put("-.--", 'Y');
        morseAlphabet.put("--..", 'Z');
    }

    @Override
    public String decode(String text) {
        String[] words = text.split("   ");
        StringBuilder result = new StringBuilder();

        for (String word : words) {
            String[] letters = word.split(" ");
            for (String letter : letters) {
                result.append(morseAlphabet.get(letter));
            }
            result.append(" ");
        }
        return result.toString();
    }

    @Override
    public String encode(String text) {
        StringBuilder result = new StringBuilder();
        char[] chars = text.toUpperCase().toCharArray();

        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if (c == ' ') {
                result.append("   ");
            } else {
                result.append(getMorseCode(c));
                // Check if the next character is not a space before adding a space
                if (i + 1 < chars.length && chars[i + 1] != ' ') {
                    result.append(" ");
                }
            }
        }
        return result.toString();
    }

    private String getMorseCode(char c) {
        for (Map.Entry<String, Character> entry : morseAlphabet.entrySet()) {
            if (entry.getValue() == c) {
                return entry.getKey();
            }
        }
        return "";
    }
}
