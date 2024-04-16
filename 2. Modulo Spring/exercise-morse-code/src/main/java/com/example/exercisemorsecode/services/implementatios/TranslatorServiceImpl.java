package com.example.exercisemorsecode.services.implementatios;

import com.example.exercisemorsecode.services.ITranslatorService;
import org.springframework.stereotype.Service;

import java.util.AbstractMap;
import java.util.Map;

@Service
public class TranslatorServiceImpl implements ITranslatorService {

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


    @Override
    public String alphanumericToMorse(String alphanumericText) {
        return "xd";
    }

    @Override
    public String morseToAlphanumeric(String morseText) {
        return null;
    }
}
