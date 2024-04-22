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
        StringBuilder morseText = new StringBuilder();
        String letra;
        for (char c : alphanumericText.toLowerCase().toCharArray()) {
            letra = String.valueOf(c);
            if (c == ' ') {
                morseText.append("   ");
            } else if (translations.containsValue(String.valueOf(c))) {
                for (Map.Entry<String, String> abecedario : translations.entrySet()) {
                    if (abecedario.getValue().equals(letra)) {
                        morseText.append(abecedario.getKey()).append(" ");
                        break;
                    }
                }
            } else {
                morseText.append(c);
            }
        }
        return morseText.toString();
    }

    @Override
    public String morseToAlphanumeric(String morseText) {
        String texto = "";
        String[] words = morseText.split("\s{3}");
        String[] characters = null;
        for(String palabra : words){
            characters = palabra.split(" ");
            for(String letra : characters){
                if(translations.containsKey(letra)){
                    texto += translations.get(letra);
                }
            }
            texto += " ";
        }

        return texto;
    }
}
