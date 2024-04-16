package com.example.codigomorse.util.codigomorse;

import java.util.HashMap;
import java.util.Map;

public class TraductorCodigoMorseUtil {
    private static final Map<String, Character> MORSE_A_TEXTO = new HashMap<>() {{
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

    private static final Map<Character, String> TEXTO_A_MORSE = new HashMap<>() {{
        for (Map.Entry<String, Character> entry : MORSE_A_TEXTO.entrySet()) {
            put(entry.getValue(), entry.getKey());
        }
    }}; // invierte los valores para traducir de morse a texto

    private static final String SEPARADOR_MORSE = "   "; // hace un espacio por cada palabra

    public static String codigoMorseATexto(String codigoMorse) {
        StringBuilder textoParseado = new StringBuilder();
        String[] palabras = codigoMorse.split(SEPARADOR_MORSE);

        for (String palabra : palabras) {
            String[] caracteres = palabra.split(" "); //accede al caracter correspondiente al codigoMorse morse
            for (String caracter : caracteres) {
                if (MORSE_A_TEXTO.containsKey(caracter)) {
                    textoParseado.append(MORSE_A_TEXTO.get(caracter));
                }
            }
            textoParseado.append(" ");
        }

        return textoParseado.toString();
    }

    static public String textoACodigoMorse(String texto) {
        String textoEnMayusculas = texto.toUpperCase();
        StringBuilder textoParseado = new StringBuilder();
        String[] palabras = textoEnMayusculas.split(" ");

        for (String palabra : palabras) {
            char[] caracteres = palabra.toCharArray(); //accede al caracter correspondiente al codigo morse
            for (char caracter : caracteres) {
                if (TEXTO_A_MORSE.containsKey(caracter)) {
                    textoParseado.append(TEXTO_A_MORSE.get(caracter)).append(" ");
                }
            }
            textoParseado.append(SEPARADOR_MORSE);
        }

        return textoParseado.toString();
    }
}
