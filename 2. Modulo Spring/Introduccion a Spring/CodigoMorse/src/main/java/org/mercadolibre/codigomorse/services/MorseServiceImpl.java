package org.mercadolibre.codigomorse.services;

import org.mercadolibre.codigomorse.services.interfaces.IMorseService;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MorseServiceImpl implements IMorseService {
    private final Map<String, String> mapaCodigos = new HashMap<>(){{
        put(".-", "A");
        put("-...", "B");
        put("-.-.", "C");
        put("-..", "D");
        put(".", "E");
        put("..-.", "F");
        put("--.", "G");
        put("....", "H");
        put("..", "I");
        put(".---", "J");
        put("-.-", "K");
        put(".-..", "L");
        put("--", "M");
        put("-.", "N");
        put("---", "O");
        put(".--.", "P");
        put("--.-", "Q");
        put(".-.", "R");
        put("...", "S");
        put("-", "T");
        put("..-", "U");
        put("...-", "V");
        put(".--", "W");
        put("-..-", "X");
        put("-.--", "Y");
        put("--..", "Z");
        put("-----", "0");
        put(".----", "1");
        put("..---", "2");
        put("...--", "3");
        put("....-", "4");
        put(".....", "5");
        put("-....", "6");
        put("--...", "7");
        put("---..", "8");
        put("----.", "9");
    }};
    private final Map<String, String> mapaCaracteres = new HashMap<>(){{
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
    public String decodificar(String codigoMorse) {
        StringBuilder resultado = new StringBuilder();
        List<String> palabras = Arrays.stream(codigoMorse.split("   ")).toList();
        for (String palabra: palabras){
            List<String> letras = Arrays.stream(palabra.split(" ")).toList();
            for (String letra: letras){
                resultado.append(this.mapaCodigos.get(letra));
            }
            resultado.append(" ");
        }
        return resultado.toString();
    }

    @Override
    public String codificar(String oracion) {
        StringBuilder resultado = new StringBuilder();
        List<String> palabras = Arrays.stream(oracion.split(" ")).toList();
        for (String palabra: palabras){
            List<String> letras = Arrays.stream(palabra.split("")).toList();
            for (String letra: letras){
                resultado.append(this.mapaCaracteres.get(letra));
                resultado.append(" ");
            }
            resultado.append("  ");
        }
        return resultado.toString();
    }
}
