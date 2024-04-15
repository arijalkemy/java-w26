package com.practicaSpring.codigoMorse;

import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.AbstractMap;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

@RestController
public class CodigoMorseController {

    private Map<String, String> translations = Map.ofEntries(
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

    @GetMapping("/{input}")
    public String decodeMorse(@PathVariable String input) {
        StringBuilder response = new StringBuilder();
        String[] words = input.split(" {3}");
        for (String word : words){
            String[] letters = word.split(" ");
            for (String letter : letters){
                response.append(translations.get(letter).toUpperCase());
            }
            response.append(" ");
        }
        return response.toString();
    }
}
