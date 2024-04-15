package com.miprimerproyecto.prueba.servicios.implementaciones;

import com.miprimerproyecto.prueba.servicios.ITraducible;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class TraduccionServiceImpl implements ITraducible {

    private static final Map<String, Character> morseAbecedario = new HashMap<String, Character>();
    static {
        morseAbecedario.put(".-", 'A');
        morseAbecedario.put("-...", 'B');
        morseAbecedario.put("-.-.", 'C');
        morseAbecedario.put("-..", 'D');
        morseAbecedario.put(".", 'E');
        morseAbecedario.put("..-.", 'F');
        morseAbecedario.put("--.", 'G');
        morseAbecedario.put("....", 'H');
        morseAbecedario.put("..", 'I');
        morseAbecedario.put(".---", 'J');
        morseAbecedario.put("-.-", 'K');
        morseAbecedario.put(".-..", 'L');
        morseAbecedario.put("--", 'M');
        morseAbecedario.put("-.", 'N');
        morseAbecedario.put("---", 'O');
        morseAbecedario.put(".--.", 'P');
        morseAbecedario.put("--.-", 'Q');
        morseAbecedario.put(".-.", 'R');
        morseAbecedario.put("...", 'S');
        morseAbecedario.put("-", 'T');
        morseAbecedario.put("..-", 'U');
        morseAbecedario.put("...-", 'V');
        morseAbecedario.put(".--", 'W');
        morseAbecedario.put("-..-", 'X');
        morseAbecedario.put("-.--", 'Y');
        morseAbecedario.put("--..", 'Z');
        morseAbecedario.put("..--..", '?');
        morseAbecedario.put(".-.-.-", ',');
        morseAbecedario.put("-.-.--", '!');
        morseAbecedario.put("--..--", ',');
    }

    @Override
    public String obtenerResultadoDeTraduccionAEspanol(String morse) {

        String[] palabras = morse.split("   ");
        StringBuilder mensajeDecodificado = new StringBuilder();

        for (String palabra : palabras) {
            String[] letras = palabra.split(" ");

            for (String letra : letras) {
                Character caracter = morseAbecedario.get(letra);
                if (caracter != null) {
                    mensajeDecodificado.append(caracter);
                } else {
                    mensajeDecodificado.append('*');
                }
            }
            mensajeDecodificado.append(' ');
        }

        return mensajeDecodificado.toString();
    }

    @Override
    public String obtenerResultadoDeTraduccionAMorse(String espanol) {

        StringBuilder morse = new StringBuilder();
        for (char caracter : espanol.toUpperCase().toCharArray()) {
            String codigoMorse = obtenerCodigoMorse(caracter);
            if (!codigoMorse.isEmpty()) {
                morse.append(codigoMorse).append(" ");
            }else
                morse.append(codigoMorse).append("  ");
        }
        return morse.toString().trim();
    }
    public static String obtenerCodigoMorse(char caracter) {
        for (Map.Entry<String, Character> entry : morseAbecedario.entrySet()) {
            if (entry.getValue() == caracter) {
                return entry.getKey();
            }
        }
        return "";
    }
}
