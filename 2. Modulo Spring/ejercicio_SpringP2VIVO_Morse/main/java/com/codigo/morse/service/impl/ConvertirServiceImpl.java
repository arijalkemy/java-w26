package com.codigo.morse.service.impl;

import com.codigo.morse.service.IConvertirService;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ConvertirServiceImpl implements IConvertirService {
    private Map<String, Character> mapaMorseAAlfabeto = new HashMap<>() {{
        put(".-", 'A');
        put("-...", 'B');
        put("-.-.", 'C');
        put("-..", 'D');
        put(".", 'E');
        put("..-.", 'F');
        put("--.", 'G');
        put("....", 'H');
        put("..", 'I');
        put(".---", 'J');
        put("-.-", 'K');
        put(".-..", 'L');
        put("--", 'M');
        put("-.", 'N');
        put("---", 'O');
        put(".--.", 'P');
        put("--.-", 'Q');
        put(".-.", 'R');
        put("...", 'S');
        put("-", 'T');
        put("..-", 'U');
        put("...-", 'V');
        put(".--", 'W');
        put("-..-", 'X');
        put("-.--", 'Y');
        put("--..", 'Z');
        put("-----", '0');
        put(".----", '1');
        put("..---", '2');
        put("...--", '3');
        put("....-", '4');
        put(".....", '5');
        put("-....", '6');
        put("--...", '7');
        put("---..", '8');
        put("----.", '9');
        put(".-.-.-", '.');
        put("--..--", ',');
        put("..--..", '?');
        put("-.-.--", '!');
    }};
    private Map<String, String> mapaAlfabetoAmorse = new HashMap<>() {{
        put(" ", "   ");
        put("A", ".-");
        put("B", "-...");
        put("C", "-.-.");
        put("D", "-..");
        put("E", ".");
        put("F", "..-.");
        put("G", "--.");
        put("H", "....");
        put("I", "..");
        put("J", ".---");
        put("K", "-.-");
        put("L", ".-..");
        put("M", "--");
        put("N", "-.");
        put("O", "---");
        put("P", ".--.");
        put("Q", "--.-");
        put("R", ".-.");
        put("S", "...");
        put("T", "-");
        put("U", "..-");
        put("V", "...-");
        put("W", ".--");
        put("X", "-..-");
        put("Y", "-.--");
        put("Z", "--..");
        put("0", "-----");
        put("1", ".----");
        put("2", "..---");
        put("3", "...--");
        put("4", "....-");
        put("5", ".....");
        put("6", "-....");
        put("7", "--...");
        put("8", "---..");
        put("9", "----.");
    }};

    @Override
    public String convertirDeMorseANormal(String cadena) {
        StringBuilder resultado = new StringBuilder();
        // Dividir la cadena de código Morse en palabras separadas por espacios
        String[] palabras = cadena.split("   ");

        // Iterar sobre cada palabra
        for (String palabra : palabras) {
            // Dividir la palabra en letras separadas por un espacio
            String[] letras = palabra.split(" ");
            // Iterar sobre cada letra
            for (String letra : letras) {
                // Obtener la letra correspondiente al código Morse y agregarla al resultado
                resultado.append(mapaMorseAAlfabeto.get(letra));
            }
            // Agregar un espacio entre palabras
            resultado.append(" ");
        }
        return resultado.toString().trim();
    }

    @Override
    public String convertirDeNormalAMorse(String cadena) {
        StringBuilder resultado = new StringBuilder();
        List<String> palabras = Arrays.stream(cadena.toUpperCase().split(" ")).toList();
        for (String palabra : palabras) {
            List<String> letras = Arrays.stream(cadena.split("")).toList();
            for (String letra : letras) {
                resultado.append(mapaAlfabetoAmorse.get(letra));
            }
            resultado.append(" ");
        }
        return resultado.toString();
    }
}
