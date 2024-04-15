package com.example.codigomorse.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;


@RestController
@RequestMapping("/traducir/")
public class MorseToStringController {
    private static final Map<String, Character> morseCodeMap = new HashMap<>();

    static{
        morseCodeMap.put(".-", 'A');
        morseCodeMap.put("-...", 'B');
        morseCodeMap.put("-.-.", 'C');
        morseCodeMap.put("-..", 'D');
        morseCodeMap.put(".", 'E');
        morseCodeMap.put("..-.", 'F');
        morseCodeMap.put("--.", 'G');
        morseCodeMap.put("....", 'H');
        morseCodeMap.put("..", 'I');
        morseCodeMap.put(".---", 'J');
        morseCodeMap.put("-.-", 'K');
        morseCodeMap.put(".-..", 'L');
        morseCodeMap.put("--", 'M');
        morseCodeMap.put("-.", 'N');
        morseCodeMap.put("---", 'O');
        morseCodeMap.put(".--.", 'P');
        morseCodeMap.put("--.-", 'Q');
        morseCodeMap.put(".-.", 'R');
        morseCodeMap.put("...", 'S');
        morseCodeMap.put("-", 'T');
        morseCodeMap.put("..-", 'U');
        morseCodeMap.put("...-", 'V');
        morseCodeMap.put(".--", 'W');
        morseCodeMap.put("-..-", 'X');
        morseCodeMap.put("-.--", 'Y');
        morseCodeMap.put("--..", 'Z');
    }

    @GetMapping("/{codigoMorse}")
    public String morseToString(@PathVariable String codigoMorse) {
        String[] morseWords = codigoMorse.split("   "); // Separar palabras cada 3 espacios en blanco
        StringBuilder result = new StringBuilder(); //Se crea objeto result para concatenar Strings

        for (String morseWord : morseWords) {
            String[] morseLetters = morseWord.split(" "); // Separar palabras
            for (String morseLetter : morseLetters) {
                if (morseCodeMap.containsKey(morseLetter)) {
                    result.append(morseCodeMap.get(morseLetter));
                } else {
                    // Si el código morse no está en el mapa, dejar como está
                    result.append(morseLetter);
                }
            }
            result.append(" "); // Agregar espacio entre palabras
        }

        return result.toString().trim(); // Eliminar espacios adicionales al final
    }
}
