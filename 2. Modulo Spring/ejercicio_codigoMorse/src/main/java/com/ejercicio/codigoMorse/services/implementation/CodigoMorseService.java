package com.ejercicio.codigoMorse.services.implementation;

import com.ejercicio.codigoMorse.dictionaries.Dictionaries;
import com.ejercicio.codigoMorse.services.interfaces.ICodigoMorseService;
import org.springframework.stereotype.Service;

import java.util.Dictionary;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class CodigoMorseService implements ICodigoMorseService {
    @Override
    public String morseToSpanish(String codigoMorse) {
        String[] words = codigoMorse.split("\\s+\\s+\\s+");

        for(int i = 0; i < words.length; i++) {
            String[] characters = words[i].split("\\s+");
            for(int j = 0; j < characters.length; j++) {
                characters[j] = Dictionaries.morseToSpanish.get(characters[j]);
            }
            words[i] = String.join("", characters);
        }
        return String.join(" ", words);
    }

    @Override
    public String spanishToMorse(String text) {
        String upperCaseText = text.toUpperCase();

        String[] words = upperCaseText.split("\\s+");

        for(int i = 0; i < words.length; i++) {
            String[] characters = words[i].split("");
            for(int j = 0; j < characters.length; j++) {
                characters[j] = Dictionaries.spanishToMorse.get(characters[j]);
            }
            words[i] = String.join(" ", characters);
        }
        return String.join("   ", words);
    }
}
