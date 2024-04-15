package com.example.codigomorse.service.serviceimp;

import com.example.codigomorse.service.ICodigoMorseService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class CodigoMorseServiceImp implements ICodigoMorseService {
    static final Map<String, Character> CODIGO_MORSE = new HashMap<>() {{
        put(".-", 'A');
        put("-...", 'B');
        put("-.-.", 'C');
        put("-..", 'D');
        put(".", 'E');
        put("..-.", 'F');
        put("--.", 'G');
        put("....", 'H');
        put("..", 'I');
        put(".---", 'J');
        put("-.-", 'K');
        put(".-..", 'L');
        put("--", 'M');
        put("-.", 'N');
        put("---", 'O');
        put(".--.", 'P');
        put("--.-", 'Q');
        put(".-.", 'R');
        put("...", 'S');
        put("-", 'T');
        put("..-", 'U');
        put("...-", 'V');
        put(".--", 'W');
        put("-..-", 'X');
        put("-.--", 'Y');
        put("--..", 'Z');
        put("-----", '0');
        put(".----", '1');
        put("..---", '2');
        put("...--", '3');
        put("....-", '4');
        put(".....", '5');
        put("-....", '6');
        put("--...", '7');
        put("---..", '8');
        put("----.", '9');
        put(".-.-.-", '.');
        put("--..--", ',');
        put("..--..", '?');
        put("-.-.--", '!');
    }};

    private String getKeyFromValueCodigoMorse(Character value) {
        Character valueUpperCase = Character.toUpperCase(value);
        for (Map.Entry<java.lang.String, java.lang.Character> entry : CODIGO_MORSE.entrySet()) {
            if (valueUpperCase.equals(entry.getValue())) {
                return entry.getKey().toString();
            }
        }
        return "";
    }


    @Override
    public String codigoMorseATexto(String codigo) {
        StringBuilder textoParseado = new StringBuilder();
        String[] palabras = codigo.split("   "); // separador de palabras en morse

        for (String palabra : palabras) {
            if (!textoParseado.isEmpty()) { // evita se inserte un espacio al principio del String
                textoParseado.append(" ");// hace un espacio por cada palabra
            }
            String[] caracteres = palabra.split(" "); //accede al caracter correspondiente al codigo morse
            for (String caracter : caracteres) {
                if (CODIGO_MORSE.containsKey(caracter)) {
                    textoParseado.append(CODIGO_MORSE.get(caracter));
                }
            }
        }

        return textoParseado.toString();
    }

    @Override
    public String textoACodigoMorse(String texto) {
        StringBuilder textoParseado = new StringBuilder();
        String[] palabras = texto.split(" ");

        for (String palabra : palabras) {
            if (!textoParseado.isEmpty()) { // evita se inserte un espacio al principio del String
                textoParseado.append("   ");// hace un espacio por cada palabra
            }
            char[] caracteres = palabra.toCharArray(); //accede al caracter correspondiente al codigo morse
            for (char caracter : caracteres)
                textoParseado.append(getKeyFromValueCodigoMorse(caracter)).append(" ");
        }
        return textoParseado.toString();
    }
}
