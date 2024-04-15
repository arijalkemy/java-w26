package com.practica1.CodigoMorse.service;

import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.Map;

@Service
public class CodigoMorseServiceImpl implements ICodigoMorseService{

    private static final Map<String, String> listadoCodigoMorse = new HashMap<>();

    static {
        listadoCodigoMorse.put(".-", "A");
        listadoCodigoMorse.put("-...", "B");
        listadoCodigoMorse.put("-.-.", "C");
        listadoCodigoMorse.put("-..", "D");
        listadoCodigoMorse.put(".", "E");
        listadoCodigoMorse.put("..-.", "F");
        listadoCodigoMorse.put("--.", "G");
        listadoCodigoMorse.put("....", "H");
        listadoCodigoMorse.put("..", "I");
        listadoCodigoMorse.put(".---", "J");
        listadoCodigoMorse.put("-.-", "K");
        listadoCodigoMorse.put(".-..", "L");
        listadoCodigoMorse.put("--", "M");
        listadoCodigoMorse.put("-.", "N");
        listadoCodigoMorse.put("---", "O");
        listadoCodigoMorse.put(".--.", "P");
        listadoCodigoMorse.put("--.-", "Q");
        listadoCodigoMorse.put(".-.", "R");
        listadoCodigoMorse.put("...", "S");
        listadoCodigoMorse.put("-", "T");
        listadoCodigoMorse.put("..-", "U");
        listadoCodigoMorse.put("...-", "V");
        listadoCodigoMorse.put(".--", "W");
        listadoCodigoMorse.put("-..-", "X");
        listadoCodigoMorse.put("-.--", "Y");
        listadoCodigoMorse.put("--..", "Z");
    }

    public String convertirATexto(String codigo){
        StringBuilder textoFinal = new StringBuilder();
        String[] palabras = codigo.split(" {3}");

        for(String palabra: palabras){
            String[] letras = palabra.split(" ");

            for (String letra: letras){
                textoFinal.append(listadoCodigoMorse.get(letra));
            }
            textoFinal.append(" ");
        }

        return textoFinal.toString();
    }

    public String convertirAMorse(String texto){
        StringBuilder textoFinal = new StringBuilder();

        String[] palabras = texto.split(" ");

        for(String palabra: palabras){
            String[] letras = palabra.split("");

            for (String letra: letras){
                if(listadoCodigoMorse.containsValue(letra)){
                    for (Map.Entry<String, String> elemento: listadoCodigoMorse.entrySet()){
                        textoFinal.append(elemento.getValue().equals(letra) ? elemento.getKey() : "");
                    }
                }
                textoFinal.append(" ");
            }
            textoFinal.append("   ");
        }

        return textoFinal.toString();
    }
}
