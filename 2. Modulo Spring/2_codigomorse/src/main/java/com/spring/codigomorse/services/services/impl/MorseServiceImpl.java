package com.spring.codigomorse.services.services.impl;

import com.spring.codigomorse.services.IMorseService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class MorseServiceImpl implements IMorseService {

    private final Map<String, Character> morseMap = Map.ofEntries(
            Map.entry(".-", 'A'),
            Map.entry("-...", 'B'),
            Map.entry("-.-.", 'C'),
            Map.entry("-..", 'D'),
            Map.entry(".", 'E'),
            Map.entry("..-.", 'F'),
            Map.entry("--.", 'G'),
            Map.entry("....", 'H'),
            Map.entry("..", 'I'),
            Map.entry(".---", 'J'),
            Map.entry("-.-", 'K'),
            Map.entry(".-..", 'L'),
            Map.entry("--", 'M'),
            Map.entry("-.", 'N'),
            Map.entry("---", 'O'),
            Map.entry(".--.", 'P'),
            Map.entry("--.-", 'Q'),
            Map.entry(".-.", 'R'),
            Map.entry("...", 'S'),
            Map.entry("-", 'T'),
            Map.entry("..-", 'U'),
            Map.entry("...-", 'V'),
            Map.entry(".--", 'W'),
            Map.entry("-..-", 'X'),
            Map.entry("-.--", 'Y'),
            Map.entry("--..", 'Z'),
            Map.entry("-----", '0'),
            Map.entry(".----", '1'),
            Map.entry("..---", '2'),
            Map.entry("...--", '3'),
            Map.entry("....-", '4'),
            Map.entry(".....", '5'),
            Map.entry("-....", '6'),
            Map.entry("--...", '7'),
            Map.entry("---..", '8'),
            Map.entry("----.", '9')
    );


    @Override
    public String translateText(String text) {
        if(text.isEmpty()) return "";
        StringBuilder stringBuilder = new StringBuilder();
        List<String> words = List.of(text.split(" "));
        for(String word : words) {
            for(String character : word.split("")) {
                // Esto es mejorable si es que tengo otro MAP pero con las letras como KEY.
                // En esta solucion NO optima, por cada caracter, recorre el listado del map.
                // O(n * m * k) dando un peor escenario de O(n^3)
                morseMap.forEach((k,v) -> {
                    if(v.toString().equals(character)) {
                        stringBuilder.append(k).append(" ");
                    }
                });
            }
            stringBuilder.append("  ");
        }
        stringBuilder.delete(stringBuilder.length() - 3, stringBuilder.length() - 1);
        return stringBuilder.toString();
    }

    @Override
    public String translateMorse(String text) {
        if(text.isEmpty()) return "";
        StringBuilder translatedText = new StringBuilder();
        List<String> words = List.of(text.split(" {3}"));
        for (String word : words) {
            List<String> simbols = List.of(word.split(" "));
            for (String simbol : simbols) {
                translatedText.append(morseMap.get(simbol));
            }
            translatedText.append(" ");
        }

        return translatedText.toString();
    }
}
