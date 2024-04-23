package com.EjercicioSpring.Ejercicio4_CodigoMorse.service;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class CodigoMorseImpl implements CodigoMorseService{

    private Map<String, String> abecedarioMorse = cargarAbecedario();

    public Map<String, String> cargarAbecedario() {
        Map<String, String> abecedarioMorse = new HashMap<>();
        abecedarioMorse.put(".-", "A");
        abecedarioMorse.put("-...", "B");
        abecedarioMorse.put("-.-.", "C");
        abecedarioMorse.put("-..", "D");
        abecedarioMorse.put(".", "E");
        abecedarioMorse.put("..-.", "F");
        abecedarioMorse.put("--.", "G");
        abecedarioMorse.put("....", "H");
        abecedarioMorse.put("..", "I");
        abecedarioMorse.put(".---", "J");
        abecedarioMorse.put("-.-", "K");
        abecedarioMorse.put(".-..", "L");
        abecedarioMorse.put("--", "M");
        abecedarioMorse.put("-.", "N");
        abecedarioMorse.put("---", "O");
        abecedarioMorse.put(".--.", "P");
        abecedarioMorse.put("--.-", "Q");
        abecedarioMorse.put(".-.", "R");
        abecedarioMorse.put("...", "S");
        abecedarioMorse.put("-", "T");
        abecedarioMorse.put("..-", "U");
        abecedarioMorse.put("...-", "V");
        abecedarioMorse.put(".--", "W");
        abecedarioMorse.put("-..-", "X");
        abecedarioMorse.put("-.--", "Y");
        abecedarioMorse.put("--..", "Z");
        abecedarioMorse.put(".----", "1");
        abecedarioMorse.put("..---", "2");
        abecedarioMorse.put("...--", "3");
        abecedarioMorse.put("....-", "4");
        abecedarioMorse.put(".....", "5");
        abecedarioMorse.put("-....", "6");
        abecedarioMorse.put("--...", "7");
        abecedarioMorse.put("---..", "8");
        abecedarioMorse.put("----.", "9");
        abecedarioMorse.put("-----", "0");
        abecedarioMorse.put("..--..", "?");
        abecedarioMorse.put("-.-.--", "!");
        abecedarioMorse.put(".-.-.-", ".");
        abecedarioMorse.put("--..--", ",");
        return abecedarioMorse;
    }

    @Override
    public String getTextoDesdeMorse(String texto) {
        StringBuilder traduccion = new StringBuilder();
        String[] palabras = texto.split("\\s{3}");
        for (String palabra : palabras) {
            String[] simbolos = palabra.split("\\s");
            for (String simbolo : simbolos) {
                if (abecedarioMorse.containsKey(simbolo)) {
                    traduccion.append(abecedarioMorse.get(simbolo));
                } else {
                    return null;
                }
            }
            traduccion.append(" ");
        }
        traduccion.delete(traduccion.length() - 1, traduccion.length());
        return traduccion.toString();
    }

    @Override
    public String getMorseDesdeTexto(String texto) {
        StringBuilder traduccion = new StringBuilder();
        String[] palabras = texto.split("\\s");
        for (String palabra : palabras) {
            String[] simbolos = palabra.split("");
            for (String simbolo : simbolos) {
                if (abecedarioMorse.containsValue(simbolo)) {
                    for (Map.Entry<String, String> entry : abecedarioMorse.entrySet()) {
                        if (entry.getValue().equals(simbolo)) {
                            traduccion.append(entry.getKey());
                            traduccion.append(" ");
                            break;
                        }
                    }
                } else {
                    return null;
                }
            }
            traduccion.append("   ");
        }
        traduccion.delete(traduccion.length() - 1, traduccion.length());
        traduccion.delete(traduccion.length() - 1, traduccion.length());
        traduccion.delete(traduccion.length() - 1, traduccion.length());
        return traduccion.toString();
    }
}
