package co.com.mercadolibre.codigomorse.service.impl;

import co.com.mercadolibre.codigomorse.service.ICodigoService;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CodigoService implements ICodigoService {

    @Override
    public String convertirDeMorseANormal(String codigoMorse) {
        Map<String, String> map = devolverMap();
        StringBuilder resultado = new StringBuilder();
        List<String> palabras = Arrays.stream(codigoMorse.split("   ")).toList();
        for (String palabra : palabras) {
            List<String> letras = Arrays.stream(codigoMorse.split(" ")).toList();

            for (String letra : letras) {
                resultado.append(map.get(letra));
            }
            resultado.append(" ");
        }
        return resultado.toString();
    }

    @Override
    public String convertirDeNormalAMorse(String normal) {
        Map<String, String> map = mapaMorseAAlfabeto();
        StringBuilder resultado = new StringBuilder();
        List<String> palabras = Arrays.stream(normal.toUpperCase().split(" ")).toList();
        for (String palabra : palabras) {
            List<String> letras = Arrays.stream(normal.split("")).toList();
            for (String letra : letras) {
                resultado.append(map.get(letra));
            }
            resultado.append(" ");
        }
        return resultado.toString();
    }

    private Map<String, String> devolverMap() {
        Map<String, String> mapaMorseAAlfabeto = new HashMap<>();
        mapaMorseAAlfabeto.put(".-", "A");
        mapaMorseAAlfabeto.put("-...", "B");
        mapaMorseAAlfabeto.put("-.-.", "C");
        mapaMorseAAlfabeto.put("-..", "D");
        mapaMorseAAlfabeto.put(".", "E");
        mapaMorseAAlfabeto.put("..-.", "F");
        mapaMorseAAlfabeto.put("--.", "G");
        mapaMorseAAlfabeto.put("....", "H");
        mapaMorseAAlfabeto.put("..", "I");
        mapaMorseAAlfabeto.put(".---", "J");
        mapaMorseAAlfabeto.put("-.-", "K");
        mapaMorseAAlfabeto.put(".-..", "L");
        mapaMorseAAlfabeto.put("--", "M");
        mapaMorseAAlfabeto.put("-.", "N");
        mapaMorseAAlfabeto.put("---", "O");
        mapaMorseAAlfabeto.put(".--.", "P");
        mapaMorseAAlfabeto.put("--.-", "Q");
        mapaMorseAAlfabeto.put(".-.", "R");
        mapaMorseAAlfabeto.put("...", "S");
        mapaMorseAAlfabeto.put("-", "T");
        mapaMorseAAlfabeto.put("..-", "U");
        mapaMorseAAlfabeto.put("...-", "V");
        mapaMorseAAlfabeto.put(".--", "W");
        mapaMorseAAlfabeto.put("-..-", "X");
        mapaMorseAAlfabeto.put("-.--", "Y");
        mapaMorseAAlfabeto.put("--..", "Z");
        mapaMorseAAlfabeto.put("-----", "0");
        mapaMorseAAlfabeto.put(".----", "1");
        mapaMorseAAlfabeto.put("..---", "2");
        mapaMorseAAlfabeto.put("...--", "3");
        mapaMorseAAlfabeto.put("....-", "4");
        mapaMorseAAlfabeto.put(".....", "5");
        mapaMorseAAlfabeto.put("-....", "6");
        mapaMorseAAlfabeto.put("--...", "7");
        mapaMorseAAlfabeto.put("---..", "8");
        mapaMorseAAlfabeto.put("----.", "9");
        return mapaMorseAAlfabeto;
    }

    private Map<String, String> mapaMorseAAlfabeto() {
        return new HashMap<>(){{
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
    }

}