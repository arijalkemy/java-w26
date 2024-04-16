package com.Bootcamp.SpringP1ejercicioNumerosRomanos.service.service.impl;

import com.Bootcamp.SpringP1ejercicioNumerosRomanos.service.ItraducirService;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class traducirServiceImpl implements ItraducirService {


    private final Map<String, Character> morseCodeMap;
    private final Map<Character, String> espanolCodeMap;

    // Agregar las entradas al HashMap

    public traducirServiceImpl() {
        this.morseCodeMap = new HashMap<>();
        morseCodeMap.put(".-", 'A');
        morseCodeMap.put("-...", 'B');
        morseCodeMap.put("-.-.", 'C');
        morseCodeMap.put("-..", 'D');
        morseCodeMap.put(".", 'E');
        morseCodeMap.put("..-.", 'F');
        morseCodeMap.put("--.", 'G');
        morseCodeMap.put("....", 'H');
        morseCodeMap.put("..", 'I');
        morseCodeMap.put(".---", 'J');
        morseCodeMap.put("-.-", 'K');
        morseCodeMap.put(".-..", 'L');
        morseCodeMap.put("--", 'M');
        morseCodeMap.put("-.", 'N');
        morseCodeMap.put("---", 'O');
        morseCodeMap.put(".--.", 'P');
        morseCodeMap.put("--.-", 'Q');
        morseCodeMap.put(".-.", 'R');
        morseCodeMap.put("...", 'S');
        morseCodeMap.put("-", 'T');
        morseCodeMap.put("..-", 'U');
        morseCodeMap.put("...-", 'V');
        morseCodeMap.put(".--", 'W');
        morseCodeMap.put("-..-", 'X');
        morseCodeMap.put("-.--", 'Y');
        morseCodeMap.put("--..", 'Z');
        morseCodeMap.put("-----", '0');
        morseCodeMap.put(".----", '1');
        morseCodeMap.put("..---", '2');
        morseCodeMap.put("...--", '3');
        morseCodeMap.put("....-", '4');
        morseCodeMap.put(".....", '5');
        morseCodeMap.put("-....", '6');
        morseCodeMap.put("--...", '7');
        morseCodeMap.put("---..", '8');
        morseCodeMap.put("----.", '9');

        this.espanolCodeMap = new HashMap<>();
        espanolCodeMap.put('A', ".-");
        espanolCodeMap.put('B', "-...");
        espanolCodeMap.put('C', "-.-.");
        espanolCodeMap.put('D', "-..");
        espanolCodeMap.put('E', ".");
        espanolCodeMap.put('F', "..-.");
        espanolCodeMap.put('G', "--.");
        espanolCodeMap.put('H', "....");
        espanolCodeMap.put('I', "..");
        espanolCodeMap.put('J', ".---");
        espanolCodeMap.put('K', "-.-");
        espanolCodeMap.put('L', ".-..");
        espanolCodeMap.put('M', "--");
        espanolCodeMap.put('N', "-.");
        espanolCodeMap.put('O', "---");
        espanolCodeMap.put('P', ".--.");
        espanolCodeMap.put('Q', "--.-");
        espanolCodeMap.put('R', ".-.");
        espanolCodeMap.put('S', "...");
        espanolCodeMap.put('T', "-");
        espanolCodeMap.put('U', "..-");
        espanolCodeMap.put('V', "...-");
        espanolCodeMap.put('W', ".--");
        espanolCodeMap.put('X', "-..-");
        espanolCodeMap.put('Y', "-.--");
        espanolCodeMap.put('Z', "--..");
    }


    @Override
    public String traducirEspanol(String texto) {
        List<String> palabras = List.of(texto.split(" "));
        String traduccion = "";
        for( String palabra:palabras){
            char[] letras = palabra.toCharArray();
            for (Character letra: letras){
                traduccion += this.espanolCodeMap.get(letra);
                traduccion+=" ";
            }
            traduccion += "   ";
        }
        return traduccion;
    }

    @Override
    public String traducirMorse(String codigoMorse) {
        List<String> palabras = List.of(codigoMorse.split("   "));
        String traduccion = "";
        for( String palabra:palabras){
            List<String> simbolos = List.of(palabra.split(" "));
            for (String simbolo: simbolos){
                traduccion += this.morseCodeMap.get(simbolo);
            }
            traduccion += " ";
        }
        return traduccion;
    }

}
