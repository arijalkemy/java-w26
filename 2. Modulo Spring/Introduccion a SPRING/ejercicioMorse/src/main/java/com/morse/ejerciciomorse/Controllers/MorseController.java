package com.morse.ejerciciomorse.Controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("converter")
public class MorseController {

    @GetMapping("/{morse}")
    public String morseAString(@PathVariable String morse) {
        Map<String, String> morseMapper = new HashMap<>();
        morseMapper.put(".-", "A");
        morseMapper.put("-...", "B");
        morseMapper.put("-.-.", "C");
        morseMapper.put("-..", "D");
        morseMapper.put(".", "E");
        morseMapper.put("..-.", "F");
        morseMapper.put("--.", "G");
        morseMapper.put("....", "H");
        morseMapper.put("..", "I");
        morseMapper.put(".---", "J");
        morseMapper.put("-.-", "K");
        morseMapper.put(".-..", "L");
        morseMapper.put("--", "M");
        morseMapper.put("-.", "N");
        morseMapper.put("---", "O");
        morseMapper.put(".--.", "P");
        morseMapper.put("--.-", "Q");
        morseMapper.put(".-.", "R");
        morseMapper.put("...", "S");
        morseMapper.put("-", "T");
        morseMapper.put("..-", "U");
        morseMapper.put("...-", "V");
        morseMapper.put(".--", "W");
        morseMapper.put("-..-", "X");
        morseMapper.put("-.--", "Y");
        morseMapper.put("--..", "Z");
        morseMapper.put(".----", "1");
        morseMapper.put("..---", "2");
        morseMapper.put("...--", "3");
        morseMapper.put("....-", "4");
        morseMapper.put(".....", "5");
        morseMapper.put("-....", "6");
        morseMapper.put("--...", "7");
        morseMapper.put("---..", "8");
        morseMapper.put("----.", "9");
        morseMapper.put("-----", "0");
        morseMapper.put("..--..", "?");
        morseMapper.put("-.-.--", "!");
        morseMapper.put(".-.-.-", ".");
        morseMapper.put("--..--", ",");


        StringBuilder resultado = new StringBuilder();
        String [] palabras = morse.split(" ");
        for (String palabra : palabras){
            String string = morseMapper.getOrDefault(palabra, " ");
            resultado.append(string);
        }

        return resultado.toString();
    }
}
