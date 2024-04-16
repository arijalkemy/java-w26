package org.example.morse.services;

import com.google.common.collect.BiMap;
import com.google.common.collect.ImmutableBiMap;
import org.example.morse.services.interfaces.IMorseService;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.stream.Collectors;

@Service
public class MorseServiceImpl implements IMorseService {

    // Se usa un BiMap para tener disponible el mapeo inverso (caracteres en español a Morse)
    private static final BiMap<String, Character> morseToEnglishMap = ImmutableBiMap.<String, Character>builder()
        .put(".-", 'A')
        .put("-...", 'B')
        .put("-.-.", 'C')
        .put("-..", 'D')
        .put(".", 'E')
        .put("..-.", 'F')
        .put("--.", 'G')
        .put("....", 'H')
        .put("..", 'I')
        .put(".---", 'J')
        .put("-.-", 'K')
        .put(".-..", 'L')
        .put("--", 'M')
        .put("-.", 'N')
        .put("---", 'O')
        .put(".--.", 'P')
        .put("--.-", 'Q')
        .put(".-.", 'R')
        .put("...", 'S')
        .put("-", 'T')
        .put("..-", 'U')
        .put("...-", 'V')
        .put(".--", 'W')
        .put("-..-", 'X')
        .put("-.--", 'Y')
        .put("--..", 'Z')
        .put(".----", '1')
        .put("..---", '2')
        .put("...--", '3')
        .put("....-", '4')
        .put(".....", '5')
        .put("-....", '6')
        .put("--...", '7')
        .put("---..", '8')
        .put("----.", '9')
        .put("-----", '0')
        .put("..--..", '?')
        .put("-.-.--", '!')
        .put("--..--", ',')
        .put(".-.-.-", '.')
        .build();


    @Override
    public String convertirMorseALatino(String mensajeEnMorse) {

        String[] palabras = mensajeEnMorse.split(" {3}");
        StringBuilder resultado = new StringBuilder();

        for (int i = 0; i < palabras.length; i++) {
            String palabra = palabras[i];

            String palabraConvertida = Arrays.stream(palabra.split(" "))
                .map(caracterMorse -> {
                    if (!morseToEnglishMap.containsKey(caracterMorse)) {
                        throw new RuntimeException(
                            "No existe mapeo en latino para el caracter Morse '%s'".formatted(caracterMorse)
                        );
                    }

                    return morseToEnglishMap.get(caracterMorse).toString();
                })
                .collect(Collectors.joining());

            resultado.append(palabraConvertida);

            // Agregar espacio entre palabras al resultado, pero solo si no se está procesando
            // la última palabra.
            if (i < palabras.length - 1)
                resultado.append(" ");
        }

        return resultado.toString();
    }

    @Override
    public String convertirLatinoAMorse(String mensajeEnLatino) {

        mensajeEnLatino = mensajeEnLatino.toUpperCase();
        String[] palabras = mensajeEnLatino.split(" ");
        StringBuilder resultado = new StringBuilder();

        for (int i = 0; i < palabras.length; i++) {
            String palabra = palabras[i];

            for (int j = 0; j < palabra.length(); j++) {
                Character caracter = palabra.charAt(j);

                if (!morseToEnglishMap.inverse().containsKey(caracter)) {
                    throw new RuntimeException(
                        "No existe mapeo en Morse para el caracter latino '%s'".formatted(caracter)
                    );
                }

                resultado.append(morseToEnglishMap.inverse().get(caracter));

                // Agregar espacio entre caracteres Morse al resultado, pero solo si no se está procesando
                // la última letra de la palabra.
                if (j < palabra.length() - 1) {
                    resultado.append(" ");
                }
            }

            // Agregar espacios entre palabras al resultado, pero solo si no se está procesando
            // la última palabra.
            if (i < palabras.length - 1)
                resultado.append("   ");
        }

        return resultado.toString();
    }

}
