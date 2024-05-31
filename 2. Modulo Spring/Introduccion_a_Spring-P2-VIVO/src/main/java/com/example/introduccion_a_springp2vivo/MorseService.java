package com.example.introduccion_a_springp2vivo;

import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class MorseService implements IMorseService{

    private static final HashMap<String, String> morseCodeMap = new HashMap<>();

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
        // Otros caracteres o dígitos podrían ser agregados aquí
    }


    @Override
    public ResponseDTO toMorse(String words) {
        StringBuilder morse = new StringBuilder();
        words = words.toUpperCase(); // Convertir las palabras a mayúsculas para que coincidan con el mapa Morse
        for (int i = 0; i < words.length(); i++) {
            char c = words.charAt(i);
            if (c == ' ') {
                morse.append("   "); // Agregar tres espacios para representar el espacio entre palabras
            } else {
                String morseChar = morseCodeMap.get(String.valueOf(c));
                if (morseChar != null) {
                    morse.append(morseChar).append(" "); // Agregar el código Morse del carácter y un espacio
                } else {
                    // Ignorar caracteres que no están en el mapa Morse
                }
            }
        }
        return new ResponseDTO(morse.toString().trim());
    }

    @Override
    public ResponseDTO toChars(String morse) {
        StringBuilder chain = new StringBuilder();
        String[] toWords = morse.split("\\s{3}");
        for (String s: toWords){
            String[] letters = s.split("\\s+");
            for (String l: letters){
                String converted = morseCodeMap.get(l);
                if(converted.isEmpty()){}
                else {
                    chain.append(converted);
                }
            }
            chain.append(" ");
        }
        return  new ResponseDTO(chain.toString().trim());
    }
}
