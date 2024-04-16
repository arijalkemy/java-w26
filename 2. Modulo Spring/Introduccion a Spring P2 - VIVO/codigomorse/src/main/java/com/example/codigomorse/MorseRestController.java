package com.example.codigomorse;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@RestController
public class MorseRestController {


    private Map<String, Character> morseToSpanish = new HashMap<>();

    public MorseRestController() {
        morseToSpanish.put(".-", 'A');
        morseToSpanish.put("-...", 'B');
        morseToSpanish.put("-.-.", 'C');
        morseToSpanish.put("-..", 'D');
        morseToSpanish.put(".", 'E');
        morseToSpanish.put("..-.", 'F');
        morseToSpanish.put("--.", 'G');
        morseToSpanish.put("....", 'H');
        morseToSpanish.put("..", 'I');
        morseToSpanish.put(".---", 'J');
        morseToSpanish.put("-.-", 'K');
        morseToSpanish.put(".-..", 'L');
        morseToSpanish.put("--", 'M');
        morseToSpanish.put("-.", 'N');
        morseToSpanish.put("---", 'O');
        morseToSpanish.put(".--.", 'P');
        morseToSpanish.put("--.-", 'Q');
        morseToSpanish.put(".-.", 'R');
        morseToSpanish.put("...", 'S');
        morseToSpanish.put("-", 'T');
        morseToSpanish.put("..-", 'U');
        morseToSpanish.put("...-", 'V');
        morseToSpanish.put(".--", 'W');
        morseToSpanish.put("-..-", 'X');
        morseToSpanish.put("-.--", 'Y');
        morseToSpanish.put("--..", 'Z');
        morseToSpanish.put(".----", '1');
        morseToSpanish.put("..---", '2');
        morseToSpanish.put("...--", '3');
        morseToSpanish.put("....-", '4');
        morseToSpanish.put(".....", '5');
        morseToSpanish.put("-....", '6');
        morseToSpanish.put("--...", '7');
        morseToSpanish.put("---..", '8');
        morseToSpanish.put("----.", '9');
        morseToSpanish.put("-----", '0');
    }

    @GetMapping("/{morse}")
    public String traducirAEspañol(@PathVariable String morse) {
        StringBuilder traduccion = new StringBuilder();
        String[] palabras = morse.split("   ");
        //Arrays.stream(words).forEach(x -> System.out.println(x));

        for (String palabra : palabras
        ) {
            String[] caracteres = palabra.split(" ");
            for (String caracter : caracteres
            ) {
                if (morseToSpanish.containsKey(caracter)) traduccion.append(morseToSpanish.get(caracter));
            }
            traduccion.append(" ");

        }

        return traduccion.toString().trim();

    }

    @GetMapping("/2/{espaniol}")
    public String traducirAMorse(@PathVariable String espaniol) {
        StringBuilder traduccion = new StringBuilder();
        String[] palabras = espaniol.split(" ");
        for (String palabra : palabras) {
            System.out.println(palabra);
            for (char caracter : palabra.toCharArray()
            ) {
                for (Map.Entry<String, Character> entry : morseToSpanish.entrySet()) {
                    if (caracter == entry.getValue()) {
                        traduccion.append(entry.getKey());
                        traduccion.append(" ");
                    }
                }

            }
            traduccion.append("   ");
        }
        return traduccion.toString().trim();


    }


}
