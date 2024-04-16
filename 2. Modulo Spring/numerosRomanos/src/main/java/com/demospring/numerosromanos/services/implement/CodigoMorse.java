package com.demospring.numerosromanos.services.implement;

import com.demospring.numerosromanos.services.ICodigoMorse;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

@Service
public class CodigoMorse implements ICodigoMorse {
    private static final Map<String, String> equivalenteMorseATexto = new HashMap<>();
    private static final Map<String, String> equivalenteTextoAMorse = new HashMap<>();

    static {
        // Mapear caracteres Morse a texto
        equivalenteMorseATexto.put(".-", "A");
        equivalenteMorseATexto.put("-...", "B");
        equivalenteMorseATexto.put("-.-.", "C");
        equivalenteMorseATexto.put("-..", "D");
        equivalenteMorseATexto.put(".", "E");
        equivalenteMorseATexto.put("..-.", "F");
        equivalenteMorseATexto.put("--.", "G");
        equivalenteMorseATexto.put("....", "H");
        equivalenteMorseATexto.put("..", "I");
        equivalenteMorseATexto.put(".---", "J");
        equivalenteMorseATexto.put("-.-", "K");
        equivalenteMorseATexto.put(".-..", "L");
        equivalenteMorseATexto.put("--", "M");
        equivalenteMorseATexto.put("-.", "N");
        equivalenteMorseATexto.put("---", "O");
        equivalenteMorseATexto.put(".--.", "P");
        equivalenteMorseATexto.put("--.-", "Q");
        equivalenteMorseATexto.put(".-.", "R");
        equivalenteMorseATexto.put("...", "S");
        equivalenteMorseATexto.put("-", "T");
        equivalenteMorseATexto.put("..-", "U");
        equivalenteMorseATexto.put("...-", "V");
        equivalenteMorseATexto.put(".--", "W");
        equivalenteMorseATexto.put("-..-", "X");
        equivalenteMorseATexto.put("-.--", "Y");
        equivalenteMorseATexto.put("--..", "Z");
        equivalenteMorseATexto.put(".----", "1");
        equivalenteMorseATexto.put("..---", "2");
        equivalenteMorseATexto.put("...--", "3");
        equivalenteMorseATexto.put("....-", "4");
        equivalenteMorseATexto.put(".....", "5");
        equivalenteMorseATexto.put("-....", "6");
        equivalenteMorseATexto.put("--...", "7");
        equivalenteMorseATexto.put("---..", "8");
        equivalenteMorseATexto.put("----.", "9");
        equivalenteMorseATexto.put("-----", "0");
        equivalenteMorseATexto.put("..--..", "?");
        equivalenteMorseATexto.put(".-.-.-", ".");
        equivalenteMorseATexto.put("-.-.--", "!");
        equivalenteMorseATexto.put("--..--", ",");
        equivalenteMorseATexto.put("/", " ");

        for (Map.Entry<String, String> entry : equivalenteMorseATexto.entrySet()) {
            equivalenteTextoAMorse.put(entry.getValue(), entry.getKey());
            System.out.println(entry.getValue() + " " + entry.getKey());
        }
    }

    @Override
    public String decodificar(String codigo) {
        return morseATexto(codigo);
    }

    @Override
    public String codificar(String texto) {
        return textoAMorse(texto);
    }

    private String morseATexto(String codigoMorse) {
        StringBuilder text = new StringBuilder();
        String[] palabras = codigoMorse.split("\\s+");
        for (String palabra : palabras) {
            if (equivalenteMorseATexto.containsKey(palabra)) {
                text.append(equivalenteMorseATexto.get(palabra));
            }
        }
        return text.toString();
    }

    private String textoAMorse(String texto) {
        StringBuilder text = new StringBuilder();
        String[] letras = texto.toUpperCase(Locale.ROOT).split("");
        for (String letra : letras) {
            if (equivalenteTextoAMorse.containsKey(letra)) {
                text.append(equivalenteTextoAMorse.get(letra) + " ");
            }
        }
        return text.toString();
    }
}
