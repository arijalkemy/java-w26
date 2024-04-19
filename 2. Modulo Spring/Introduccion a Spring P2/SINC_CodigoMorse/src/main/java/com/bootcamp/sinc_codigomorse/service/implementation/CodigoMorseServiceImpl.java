package com.bootcamp.sinc_codigomorse.service.implementation;

import com.bootcamp.sinc_codigomorse.service.ICodigoMorseService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class CodigoMorseServiceImpl implements ICodigoMorseService {

    private static final Map<Character, String> espaniolMorseMap = new HashMap<>();
    private static final Map<String, Character> morseEspaniolMap = new HashMap<>();

    static {
        // Mapeo de caracteres en español a su equivalente en Morse
        espaniolMorseMap.put('A', ".-");
        espaniolMorseMap.put('B', "-...");
        espaniolMorseMap.put('C', "-.-.");
        espaniolMorseMap.put('D', "-..");
        espaniolMorseMap.put('E', ".");
        espaniolMorseMap.put('F', "..-.");
        espaniolMorseMap.put('G', "--.");
        espaniolMorseMap.put('H', "....");
        espaniolMorseMap.put('I', "..");
        espaniolMorseMap.put('J', ".---");
        espaniolMorseMap.put('K', "-.-");
        espaniolMorseMap.put('L', ".-..");
        espaniolMorseMap.put('M', "--");
        espaniolMorseMap.put('N', "-.");
        espaniolMorseMap.put('O', "---");
        espaniolMorseMap.put('P', ".--.");
        espaniolMorseMap.put('Q', "--.-");
        espaniolMorseMap.put('R', ".-.");
        espaniolMorseMap.put('S', "...");
        espaniolMorseMap.put('T', "-");
        espaniolMorseMap.put('U', "..-");
        espaniolMorseMap.put('V', "...-");
        espaniolMorseMap.put('W', ".--");
        espaniolMorseMap.put('X', "-..-");
        espaniolMorseMap.put('Y', "-.--");
        espaniolMorseMap.put('Z', "--..");
        espaniolMorseMap.put(' ', " ");
        espaniolMorseMap.put('!', "-.-.--");
        espaniolMorseMap.put('?', "..--..");
        espaniolMorseMap.put('.', ".-.-.-");
        espaniolMorseMap.put(',', "--..--");
    }

    static {
        morseEspaniolMap.put(".-", 'A');
        morseEspaniolMap.put("-...", 'B');
        morseEspaniolMap.put("-.-.", 'C');
        morseEspaniolMap.put("-..", 'D');
        morseEspaniolMap.put(".", 'E');
        morseEspaniolMap.put("..-.", 'F');
        morseEspaniolMap.put("--.", 'G');
        morseEspaniolMap.put("....", 'H');
        morseEspaniolMap.put("..", 'I');
        morseEspaniolMap.put(".---", 'J');
        morseEspaniolMap.put("-.-", 'K');
        morseEspaniolMap.put(".-..", 'L');
        morseEspaniolMap.put("--", 'M');
        morseEspaniolMap.put("-.", 'N');
        morseEspaniolMap.put("---", 'O');
        morseEspaniolMap.put(".--.", 'P');
        morseEspaniolMap.put("--.-", 'Q');
        morseEspaniolMap.put(".-.", 'R');
        morseEspaniolMap.put("...", 'S');
        morseEspaniolMap.put("-", 'T');
        morseEspaniolMap.put("..-", 'U');
        morseEspaniolMap.put("...-", 'V');
        morseEspaniolMap.put(".--", 'W');
        morseEspaniolMap.put("-..-", 'X');
        morseEspaniolMap.put("-.--", 'Y');
        morseEspaniolMap.put("--..", 'Z');
        morseEspaniolMap.put("   ", ' ');
        morseEspaniolMap.put("-.-.--", '!');
        morseEspaniolMap.put("..--..", '?');
        morseEspaniolMap.put(".-.-.-", '.');
        morseEspaniolMap.put("--..--", ',');
    }

    @Override
    public String convertirAEspaniol(String morse) {
        StringBuilder resultado = new StringBuilder();
        String[] palabras = morse.trim().split("   "); // Divido la cadena en palabras

        for (String palabra : palabras) {
            String[] letras = palabra.split(" "); // Divido la palabra en letras

            for (String letra : letras) {
                if (morseEspaniolMap.containsKey(letra)) {
                    resultado.append(morseEspaniolMap.get(letra)); // Agregrola letra en español al resultado
                }
            }
            resultado.append(" "); // Agrego un espaco entre palabras
        }
        return resultado.toString().trim(); // Elimino espacioes en blanco adelante y atras
    }

    @Override
    public String convertirAMorse(String codigoEspaniol) {
        StringBuilder morse = new StringBuilder();
        codigoEspaniol = codigoEspaniol.toUpperCase();

        for (char c : codigoEspaniol.toCharArray()) {
            if (espaniolMorseMap.containsKey(c)) {
                morse.append(espaniolMorseMap.get(c)).append(" "); // Agregar el código Morse del carácter y un espacio
            }
        }
        return morse.toString();
    }

}