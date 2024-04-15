package com.morse.codigo.Controllers;

import com.morse.codigo.TextoRequestBody;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class Morse {

    private static final Map<Character, String> morseCodeMap = new HashMap<>();
    private static final Map<String, Character> characterCodeMap = new HashMap<>();

    static {
        characterCodeMap.put(".-", 'a');
        characterCodeMap.put("-...", 'b');
        characterCodeMap.put("-.-.", 'c');
        characterCodeMap.put("-..", 'd');
        characterCodeMap.put(".", 'e');
        characterCodeMap.put("..-.", 'f');
        characterCodeMap.put("--.", 'g');
        characterCodeMap.put("....", 'h');
        characterCodeMap.put("..", 'i');
        characterCodeMap.put(".---", 'j');
        characterCodeMap.put("-.-", 'k');
        characterCodeMap.put(".-..", 'l');
        characterCodeMap.put("--", 'm');
        characterCodeMap.put("-.", 'n');
        characterCodeMap.put("---", 'o');
        characterCodeMap.put(".--.", 'p');
        characterCodeMap.put("--.-", 'q');
        characterCodeMap.put(".-.", 'r');
        characterCodeMap.put("...", 's');
        characterCodeMap.put("-", 't');
        characterCodeMap.put("..-", 'u');
        characterCodeMap.put("...-", 'v');
        characterCodeMap.put(".--", 'w');
        characterCodeMap.put("-..-", 'x');
        characterCodeMap.put("-.--", 'y');
        characterCodeMap.put("--..", 'z');
        characterCodeMap.put("-----", '0');
        characterCodeMap.put(".----", '1');
        characterCodeMap.put("..---", '2');
        characterCodeMap.put("...--", '3');
        characterCodeMap.put("....-", '4');
        characterCodeMap.put(".....", '5');
        characterCodeMap.put("-....", '6');
        characterCodeMap.put("--...", '7');
        characterCodeMap.put("---..", '8');
        characterCodeMap.put("----.", '9');
        characterCodeMap.put("..--..", '?');
        characterCodeMap.put("-.-.--", '!');
        characterCodeMap.put(".-.-.-", '.');
        characterCodeMap.put("--..--", ',');
        characterCodeMap.put("", ' ');
    }

    static {
        morseCodeMap.put('a', ".-");
        morseCodeMap.put('b', "-...");
        morseCodeMap.put('c', "-.-.");
        morseCodeMap.put('d', "-..");
        morseCodeMap.put('e', ".");
        morseCodeMap.put('f', "..-.");
        morseCodeMap.put('g', "--.");
        morseCodeMap.put('h', "....");
        morseCodeMap.put('i', "..");
        morseCodeMap.put('j', ".---");
        morseCodeMap.put('k', "-.-");
        morseCodeMap.put('l', ".-..");
        morseCodeMap.put('m', "--");
        morseCodeMap.put('n', "-.");
        morseCodeMap.put('o', "---");
        morseCodeMap.put('p', ".--.");
        morseCodeMap.put('q', "--.-");
        morseCodeMap.put('r', ".-.");
        morseCodeMap.put('s', "...");
        morseCodeMap.put('t', "-");
        morseCodeMap.put('u', "..-");
        morseCodeMap.put('v', "...-");
        morseCodeMap.put('w', ".--");
        morseCodeMap.put('x', "-..-");
        morseCodeMap.put('y', "-.--");
        morseCodeMap.put('z', "--..");
        morseCodeMap.put('0', "-----");
        morseCodeMap.put('1', ".----");
        morseCodeMap.put('2', "..---");
        morseCodeMap.put('3', "...--");
        morseCodeMap.put('4', "....-");
        morseCodeMap.put('5', ".....");
        morseCodeMap.put('6', "-....");
        morseCodeMap.put('7', "--...");
        morseCodeMap.put('8', "---..");
        morseCodeMap.put('9', "----.");
        morseCodeMap.put('0', "-----");
        morseCodeMap.put('?', "..--..");
        morseCodeMap.put('!', "-.-.--");
        morseCodeMap.put('.', ".-.-.-");
        morseCodeMap.put(',', "--..--");
        morseCodeMap.put(' ', " ");

    }

    @GetMapping("/convertirMorse")
    public String convertirMorse(@RequestBody TextoRequestBody requestBody){
        String texto = requestBody.getTexto();
        System.out.println(texto);
        StringBuilder result = new StringBuilder();
        for (char c : texto.toLowerCase().toCharArray()) {
            String morseCode = morseCodeMap.get(c);
            if (morseCode != null) {
                result.append(morseCode).append(" ");
            }
        }
        return result.toString().trim();
    }

    @GetMapping("/convertirTexto")
    public String convertirTexto(@RequestBody TextoRequestBody requestBody){
        String texto[] = requestBody.getTexto().split(" ");
        System.out.println(texto);
        StringBuilder result = new StringBuilder();
        for (String c : texto) {
            String morseCode = String.valueOf(characterCodeMap.get(c));
            if (morseCode != null) {
                result.append(morseCode).append("");
            }
        }
        String str;
        str = result.toString().replace("  ", " ");
        return str;
    }
}
