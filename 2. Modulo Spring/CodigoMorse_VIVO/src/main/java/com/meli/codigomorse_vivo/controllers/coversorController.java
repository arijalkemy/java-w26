package com.meli.codigomorse_vivo.controllers;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.HashMap;
import java.util.Map;

@RestController
public class coversorController {

    public Map<Character, String> abecedarioMorse = new HashMap<Character, String>() {{
        put('A', ".-");
        put('B', "-...");
        put('C', "-.-.");
        put('D', "-..");
        put('E', ".");
        put('F', "..-.");
        put('G', "--.");
        put('H', "....");
        put('I', "..");
        put('J', ".---");
        put('K', "-.-");
        put('L', ".-..");
        put('M', "--");
        put('N', "-.");
        put('O', "---");
        put('P', ".--.");
        put('Q', "--.-");
        put('R', ".-.");
        put('S', "...");
        put('T', "-");
        put('U', "..-");
        put('V', "...-");
        put('W', ".--");
        put('X', "-..-");
        put('Y', "-.--");
        put('Z', "--..");
        put(' ', " ");
    }};

    @GetMapping("/morseALetras/{codigoMorse}")
    public String morseALetras (@PathVariable String codigoMorse) {

        String[] palabras = codigoMorse.split("   ");
        StringBuilder result = new StringBuilder();
        for (String letra : palabras) {
            String[] letras = letra.split(" ");
            for (String letraMorse : letras) {
                for (Map.Entry<Character, String> entry : abecedarioMorse.entrySet()) {
                    if (entry.getValue().equals(letraMorse)) {
                        result.append(entry.getKey());
                        break;
                    }
                }
            }
            result.append(" ");
        }
        return result.toString();
    }

    @GetMapping("/letrasAMorse/{letras}")
    public String letrasAMorse (@PathVariable String letras) {
        letras = letras.toUpperCase();
        StringBuilder result = new StringBuilder();
        for (char letra : letras.toCharArray()) {
            result.append(abecedarioMorse.get(letra));
            result.append(" ");
        }
        return result.toString();
    }
}
