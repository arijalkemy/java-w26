package com.example.demo.service;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class TraductorService implements ITraductorService {

    @Override
    public String obtenerFraseEspanol(String codigoMorse) {
        Map<String, String> mapaEquivalencias = new HashMap<>();
        mapaEquivalencias.put(".-", "A");
        mapaEquivalencias.put("-...", "B");
        mapaEquivalencias.put("-.-.", "C");
        mapaEquivalencias.put("-..", "D");
        mapaEquivalencias.put(".", "E");
        mapaEquivalencias.put("..-.", "F");
        mapaEquivalencias.put("--.", "G");
        mapaEquivalencias.put("....", "H");
        mapaEquivalencias.put("..", "I");
        mapaEquivalencias.put(".---", "J");
        mapaEquivalencias.put("-.-", "K");
        mapaEquivalencias.put(".-..", "L");
        mapaEquivalencias.put("--", "M");
        mapaEquivalencias.put("-.", "N");
        mapaEquivalencias.put("---", "O");
        mapaEquivalencias.put(".--.", "P");
        mapaEquivalencias.put("--.-", "Q");
        mapaEquivalencias.put(".-.", "R");
        mapaEquivalencias.put("...", "S");
        mapaEquivalencias.put("-", "T");
        mapaEquivalencias.put("..-", "U");
        mapaEquivalencias.put("...-", "V");
        mapaEquivalencias.put(".--", "W");
        mapaEquivalencias.put("-..-", "X");
        mapaEquivalencias.put("-.--", "Y");
        mapaEquivalencias.put("--..", "Z");
        mapaEquivalencias.put(".----", "1");
        mapaEquivalencias.put("..---", "2");
        mapaEquivalencias.put("...--", "3");
        mapaEquivalencias.put("....-", "4");
        mapaEquivalencias.put(".....", "5");
        mapaEquivalencias.put("-....", "6");
        mapaEquivalencias.put("--....", "7");
        mapaEquivalencias.put("---..", "8");
        mapaEquivalencias.put("----.", "9");
        mapaEquivalencias.put("-----", "0");
        mapaEquivalencias.put("..--..", "?");
        mapaEquivalencias.put("-.-.--", "!");
        mapaEquivalencias.put(".-.-.--", ".");
        mapaEquivalencias.put("--..--", ",");

        StringBuilder fraseEspanol = new StringBuilder();
        String[] palabras = codigoMorse.split("   ");
        for(String palabra : palabras) {
            String[] letras = palabra.split(" ");
            for(String letra : letras) {
                fraseEspanol.append(mapaEquivalencias.get(letra));
            }
            fraseEspanol.append(" ");
        }

        return fraseEspanol.toString();
    }

    @Override
    public String obtenerCodigoMorse(String fraseEnEspanol) {
        Map<String, String> mapaEquivalencias = new HashMap<>();
        mapaEquivalencias.put("A", ".-");
        mapaEquivalencias.put("B", "-...");
        mapaEquivalencias.put("C", "-.-.");
        mapaEquivalencias.put("D", "-..");
        mapaEquivalencias.put("E", ".");
        mapaEquivalencias.put("F", "..-.");
        mapaEquivalencias.put("G", "--.");
        mapaEquivalencias.put("H", "....");
        mapaEquivalencias.put("I", "..");
        mapaEquivalencias.put("J", ".---");
        mapaEquivalencias.put("K", "-.-");
        mapaEquivalencias.put("L", ".-..");
        mapaEquivalencias.put("M", "--");
        mapaEquivalencias.put("N", "-.");
        mapaEquivalencias.put("O", "---");
        mapaEquivalencias.put("P", ".--.");
        mapaEquivalencias.put("Q", "--.-");
        mapaEquivalencias.put("R", ".-.");
        mapaEquivalencias.put("S", "...");
        mapaEquivalencias.put("T", "-");
        mapaEquivalencias.put("U", "..-");
        mapaEquivalencias.put("V", "...-");
        mapaEquivalencias.put("W", ".--");
        mapaEquivalencias.put("X", "-..-");
        mapaEquivalencias.put("Y", "-.--");
        mapaEquivalencias.put("Z", "--..");
        mapaEquivalencias.put("1", ".----");
        mapaEquivalencias.put("2", "..---");
        mapaEquivalencias.put("3", "...--");
        mapaEquivalencias.put("4", "....-");
        mapaEquivalencias.put("5", ".....");
        mapaEquivalencias.put("6", "-....");
        mapaEquivalencias.put("7", "--....");
        mapaEquivalencias.put("8", "---..");
        mapaEquivalencias.put("9", "----.");
        mapaEquivalencias.put("0", "-----");
        mapaEquivalencias.put("?", "..--..");
        mapaEquivalencias.put("!", "-.-.--");
        mapaEquivalencias.put(".", ".-.-.--");
        mapaEquivalencias.put(",", "--..--");

        StringBuilder codigoMorse = new StringBuilder();
        String[] palabras = fraseEnEspanol.split(" ");
        for(String palabra : palabras) {
            String[] letras = palabra.split("");
            for(String letra : letras) {
                codigoMorse.append(mapaEquivalencias.get(letra));
                codigoMorse.append(" ");
            }
            codigoMorse.append("   ");
        }

        return codigoMorse.toString();
    }
}
