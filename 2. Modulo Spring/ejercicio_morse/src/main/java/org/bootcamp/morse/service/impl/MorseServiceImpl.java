package org.bootcamp.morse.service.impl;

import org.bootcamp.morse.service.MorseService;
import org.springframework.stereotype.Service;

import java.util.AbstractMap;
import java.util.Map;

@Service
public class MorseServiceImpl implements MorseService {

    private Map<String, String> traductor = Map.ofEntries(
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
    public String obtenerCodidoMorse(String texto) {
        StringBuilder codigoMorse = new StringBuilder();
        String letra;
        for (char c : texto.toLowerCase().toCharArray()) {
            letra = String.valueOf(c);
            if (c == ' ') {
                codigoMorse.append("   ");
            } else if (traductor.containsValue(String.valueOf(c))) {
                for (Map.Entry<String, String> abecedario : traductor.entrySet()) {
                    if (abecedario.getValue().equals(letra)) {
                        codigoMorse.append(abecedario.getKey()).append(" ");
                        break;
                    }
                }
            } else {
                codigoMorse.append(c);
            }
        }
        return codigoMorse.toString();

    }

    @Override
    public String obtenerTextoAlfanumerico(String codigoMorse) {
        String texto = "";
        String[] palabras = codigoMorse.split("\s{3}");
        String[] letras = null;
        for(String palabra : palabras){
            letras = palabra.split(" ");
            for(String letra : letras){
                if(traductor.containsKey(letra)){
                    texto += traductor.get(letra);
                }
            }
            texto += " ";
        }

        return texto;
    }

}
