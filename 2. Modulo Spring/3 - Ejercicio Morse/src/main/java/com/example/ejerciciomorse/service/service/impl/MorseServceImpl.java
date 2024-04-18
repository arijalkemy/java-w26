package com.example.ejerciciomorse.service.service.impl;

import com.example.ejerciciomorse.service.IMorseService;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class MorseServceImpl implements IMorseService {

    private static final HashMap<String, String> morseMap = new HashMap<String, String>() {{
        put(".-", "A");
        put("-...", "B");
        put("-.-.", "C");
        put("-..", "D");
        put(".", "E");
        put("..-.", "F");
        put("--.", "G");
        put("....", "H");
        put("..", "I");
        put(".---", "J");
        put("-.-", "K");
        put(".-..", "L");
        put("--", "M");
        put("-.", "N");
        put("---", "O");
        put(".--.", "P");
        put("--.-", "Q");
        put(".-.", "R");
        put("...", "S");
        put("-", "T");
        put("..-", "U");
        put("...-", "V");
        put(".--", "W");
        put("-..-", "X");
        put("-.--", "Y");
        put("--..", "Z");
        // Agrega más letras y sus traducciones morse según sea necesario
    }};

    private static final HashMap<String, String> textMap = new HashMap<String, String>() {{
        put("A", ".-");
        put("B", "-...");
        put("C", "-.-.");
        put("D", "-..");
        put("E", ".");
        put("F", "..-.");
        put("G", "--.");
        put("H", "....");
        put("I", "..");
        put("J", ".---");
        put("K", "-.-");
        put("L", ".-..");
        put("M", "--");
        put("N", "-.");
        put("O", "---");
        put("P", ".--.");
        put("Q", "--.-");
        put("R", ".-.");
        put("S", "...");
        put("T", "-");
        put("U", "..-");
        put("V", "...-");
        put("W", ".--");
        put("X", "-..-");
        put("Y", "-.--");
        put("Z", "--..");
        // Agrega más letras y sus traducciones morse según sea necesario
    }};

    @Override
    public String convertToWord(String morse) {
        String word = "";

        //Primero obtener las palabras
        String[] morseWords = morse.split("   ");
        //Recorrer cada palabra y traducirla
        for( String morseWord: morseWords){
            String[] morseLetters = morseWord.split(" ");
            //Traducir cada letra de la palabra
            for (String  m : morseLetters) {
                String translation = morseMap.get(m);
                if( translation != null ) {
                    word +=  translation;
                }
            }
            word += " ";
        }

        return word;
    }

    @Override
    public String convertToMorse(String word) {
        String morse = "";

        //Primero obtener las palabras
        String[] words = word.split(" ");
        //Recorrer cada palabra y traducirla
        for( String actualWord: words){
            //Traducir cada letra de la palabra
            for (int i = 0; i < actualWord.length(); i++) {
                String translation = textMap.get("" + actualWord.charAt(i));
                if( translation != null ) {
                    morse +=  translation + " ";
                }
            }
            morse += "  ";
        }

        return morse;
    }
}
