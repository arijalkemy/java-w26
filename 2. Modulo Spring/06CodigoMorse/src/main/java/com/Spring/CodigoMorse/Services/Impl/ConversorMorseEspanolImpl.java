package com.Spring.CodigoMorse.Services.Impl;

import com.Spring.CodigoMorse.Services.IConversorMorseEspanol;
import org.springframework.stereotype.Service;

import java.util.AbstractMap;
import java.util.Map;

@Service
public class ConversorMorseEspanolImpl implements IConversorMorseEspanol {

    private final Map<String, String> traducciones = Map.ofEntries(
            new AbstractMap.SimpleEntry<>(".-", "a"),
            new AbstractMap.SimpleEntry<>("-...", "b"),
            new AbstractMap.SimpleEntry<>("-.-.", "c"),
            new AbstractMap.SimpleEntry<>("-..", "d"),
            new AbstractMap.SimpleEntry<>(".", "e"),
            new AbstractMap.SimpleEntry<>("..-.", "f"),
            new AbstractMap.SimpleEntry<>("--.", "g"),
            new AbstractMap.SimpleEntry<>("....", "h"),
            new AbstractMap.SimpleEntry<>("..", "i"),
            new AbstractMap.SimpleEntry<>(".---", "j"),
            new AbstractMap.SimpleEntry<>("-.-", "k"),
            new AbstractMap.SimpleEntry<>(".-..", "l"),
            new AbstractMap.SimpleEntry<>("--", "m"),
            new AbstractMap.SimpleEntry<>("-.", "n"),
            new AbstractMap.SimpleEntry<>("---", "o"),
            new AbstractMap.SimpleEntry<>(".--.", "p"),
            new AbstractMap.SimpleEntry<>("--.-", "q"),
            new AbstractMap.SimpleEntry<>(".-.", "r"),
            new AbstractMap.SimpleEntry<>("...", "s"),
            new AbstractMap.SimpleEntry<>("-", "t"),
            new AbstractMap.SimpleEntry<>("..-", "u"),
            new AbstractMap.SimpleEntry<>("...-", "v"),
            new AbstractMap.SimpleEntry<>(".--", "w"),
            new AbstractMap.SimpleEntry<>("-..-", "x"),
            new AbstractMap.SimpleEntry<>("-.--", "y"),
            new AbstractMap.SimpleEntry<>("--..", "z"),
            new AbstractMap.SimpleEntry<>(".----", "1"),
            new AbstractMap.SimpleEntry<>("..---", "2"),
            new AbstractMap.SimpleEntry<>("...--", "3"),
            new AbstractMap.SimpleEntry<>("....-", "4"),
            new AbstractMap.SimpleEntry<>(".....", "5"),
            new AbstractMap.SimpleEntry<>("-....", "6"),
            new AbstractMap.SimpleEntry<>("--...", "7"),
            new AbstractMap.SimpleEntry<>("---..", "8"),
            new AbstractMap.SimpleEntry<>("----.", "9"),
            new AbstractMap.SimpleEntry<>("-----", "0"),
            new AbstractMap.SimpleEntry<>("..--..", "?"),
            new AbstractMap.SimpleEntry<>("-.-.--", "!"),
            new AbstractMap.SimpleEntry<>("--..--", ","),
            new AbstractMap.SimpleEntry<>(".-.-.-", ".")
    );


    @Override
    public String convertirAEspanol(String textoEnMorse) {
        StringBuilder textoEnEspanol = new StringBuilder();
        for (String palabra : textoEnMorse.split(" {3}")) {
            for (String letra : palabra.split(" ")) {
                String letraEnEspanol = traducciones.get(letra);
                if (letraEnEspanol != null) {
                    textoEnEspanol.append(letraEnEspanol);
                }
            }
            textoEnEspanol.append(" ");

        }
        textoEnEspanol.delete(textoEnEspanol.length() - 1, textoEnEspanol.length());
        return textoEnEspanol.toString();
    }

    @Override
    public String convertirAMorse(String textoEnEspanol) {
        StringBuilder textoEnMorse = new StringBuilder();
        String[] palabras = textoEnEspanol.split("\\s");
        for (String palabra : palabras) {
            String[] simbolos = palabra.split("");
            for (String simbolo : simbolos) {
                if (traducciones.containsValue(simbolo)) {
                    for (Map.Entry<String, String> entry : traducciones.entrySet()) {
                        if (entry.getValue().equals(simbolo)) {
                            textoEnMorse.append(entry.getKey());
                            textoEnMorse.append(" ");
                            break;
                        }
                    }
                } else {
                    return null;
                }
            }
            textoEnMorse.append("   ");
        }
        textoEnMorse.delete(textoEnMorse.length() - 1, textoEnMorse.length());
        textoEnMorse.delete(textoEnMorse.length() - 1, textoEnMorse.length());
        textoEnMorse.delete(textoEnMorse.length() - 1, textoEnMorse.length());
        return textoEnMorse.toString();
    }
}
