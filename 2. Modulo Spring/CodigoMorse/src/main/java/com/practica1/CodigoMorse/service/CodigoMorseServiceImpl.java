package com.practica1.CodigoMorse.service;

import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.Map;

@Service
public class CodigoMorseServiceImpl implements ICodigoMorseService{

    private static final Map<String, String> listadoCodigoMorse = new LinkedHashMap<>();

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
        listadoCodigoMorse.put("-..-s", "X");
        listadoCodigoMorse.put("-.--", "Y");
        listadoCodigoMorse.put("--..", "Z");
    }

    public String convertirCodigoMorse(String codigoMorse){
        StringBuilder texto = new StringBuilder();

        int longitudCodigo = codigoMorse.length();
        for (int i = 0; i < longitudCodigo; i++){
            if (codigoMorse.charAt(i) == ' '){
                texto.append(" ");
            } else {
                StringBuilder codigo = new StringBuilder();
                while (i < longitudCodigo && codigoMorse.charAt(i) != ' '){
                    codigo.append(codigoMorse.charAt(i));
                    i++;
                }
                texto.append(listadoCodigoMorse.get(codigo.toString()));
            }
        }
        return texto.toString();
    }

}
