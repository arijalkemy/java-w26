package org.example.codigomorse.services.implementation;

import org.example.codigomorse.services.ICodigoMorseService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class CodigoMorseServiceImpl implements ICodigoMorseService {

    private Map<String, String> mapMorse = getMapMorse();
    private Map<String, String> mapTexto = getMapTexto();

    @Override
    public String convertirCodigoMorseATexto(String texto) {
        StringBuilder traduccion = new StringBuilder();
        String[] palabrasMorse = texto.split(" {3}");
        for (String p : palabrasMorse) {
            String[] simbolosMorse = p.split(" ");
            for (String simbolo : simbolosMorse) {
                if (mapMorse.containsKey(simbolo)) {
                    traduccion.append(mapMorse.get(simbolo));
                }
            }
            traduccion.append(" ");
        }
        return traduccion.toString();
    }

    @Override
    public String convertirTextoACodigoMorse(String texto) {
        StringBuilder traduccion = new StringBuilder();
        String[] palabras = texto.toUpperCase().split(" ");
        for (String p : palabras) {
            String[] letras = p.split("");
            for (String letra : letras) {
                if (mapTexto.containsKey(letra)) {
                    traduccion.append(mapTexto.get(letra));
                }
            }
            traduccion.append("   ");
        }
        return traduccion.toString();
    }

    private Map<String, String> getMapMorse() {
        Map<String, String> mapMorse = new HashMap<>();
        mapMorse.put(".-", "A");
        mapMorse.put("-...", "B");
        mapMorse.put("-.-.", "C");
        mapMorse.put("-..", "D");
        mapMorse.put(".", "E");
        mapMorse.put("..-.", "F");
        mapMorse.put("--.", "G");
        mapMorse.put("....", "H");
        mapMorse.put("..", "I");
        mapMorse.put(".---", "J");
        mapMorse.put("-.-", "K");
        mapMorse.put(".-..", "L");
        mapMorse.put("--", "M");
        mapMorse.put("-.", "N");
        mapMorse.put("---", "O");
        mapMorse.put(".--.", "P");
        mapMorse.put("--.-", "Q");
        mapMorse.put(".-.", "R");
        mapMorse.put("...", "S");
        mapMorse.put("-", "T");
        mapMorse.put("..-", "U");
        mapMorse.put("...-", "V");
        mapMorse.put(".--", "W");
        mapMorse.put("-..-", "X");
        mapMorse.put("-.--", "Y");
        mapMorse.put("--..", "Z");
        return mapMorse;
    }

    private Map<String, String> getMapTexto() {
        Map<String, String> mapTexto = new HashMap<>();
        mapTexto.put("A", ".-");
        mapTexto.put("B", "-...");
        mapTexto.put("C", "-.-.");
        mapTexto.put("D", "-..");
        mapTexto.put("E", ".");
        mapTexto.put("F", "..-.");
        mapTexto.put("G", "--.");
        mapTexto.put("H", "....");
        mapTexto.put("I", "..");
        mapTexto.put("J", ".---");
        mapTexto.put("K", "-.-");
        mapTexto.put("L", ".-..");
        mapTexto.put("M", "--");
        mapTexto.put("N", "-.");
        mapTexto.put("O", "---");
        mapTexto.put("P", ".--.");
        mapTexto.put("Q", "--.-");
        mapTexto.put("R", ".-.");
        mapTexto.put("S", "...");
        mapTexto.put("T", "-");
        mapTexto.put("U", "..-");
        mapTexto.put("V", "...-");
        mapTexto.put("W", ".--");
        mapTexto.put("X", "-..-");
        mapTexto.put("Y", "-.--");
        mapTexto.put("Z", "--..");
        return mapTexto;
    }
}
