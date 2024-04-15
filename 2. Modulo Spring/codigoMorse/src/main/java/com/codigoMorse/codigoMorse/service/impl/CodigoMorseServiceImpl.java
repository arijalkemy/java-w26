package com.codigoMorse.codigoMorse.service.impl;

import com.codigoMorse.codigoMorse.service.ICodigoMorseService;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class CodigoMorseServiceImpl implements ICodigoMorseService {

    private HashMap<String, Character> morseCaracter;
    private HashMap<Character,String> caracterMorse;

    @Override
    public String decodificarCodigoMorse(String code) {
        StringBuilder retorno = new StringBuilder();

        String[] mensajeConEspacios = code.split("     ");

        for (String word : mensajeConEspacios) {
            String[] mensajeCaracater = word.split(" ");
            for (String letter : mensajeCaracater) {
                if (morseCaracter.containsKey(letter)) {
                    retorno.append(morseCaracter.get(letter));
                }
            }
            retorno.append(" ");
        }
        return retorno.toString();
    }

    @Override
    public String codificarCodigoMorse(String mensaje){

        StringBuilder retorno = new StringBuilder();
        String[] splitMensaje = mensaje.toUpperCase().split(" ");

        for (String itemMensaje: splitMensaje) {
            for (Character caracterMensaje:itemMensaje.toCharArray()) {
                if(caracterMorse.containsKey(caracterMensaje))
                {
                    retorno.append(caracterMorse.get(caracterMensaje)).append("  ");
                }
            }
            retorno.append("   ");
        }

        return retorno.toString();
    }


    public CodigoMorseServiceImpl() {
        morseCaracter = new HashMap<>();
        caracterMorse = new HashMap<>();
        morseCaracter.put(".-", 'A');
        morseCaracter.put("-...", 'B');
        morseCaracter.put("-.-.", 'C');
        morseCaracter.put("-..", 'D');
        morseCaracter.put(".", 'E');
        morseCaracter.put("..-.", 'F');
        morseCaracter.put("--.", 'G');
        morseCaracter.put("....", 'H');
        morseCaracter.put("..", 'I');
        morseCaracter.put(".---", 'J');
        morseCaracter.put("-.-", 'K');
        morseCaracter.put(".-..", 'L');
        morseCaracter.put("--", 'M');
        morseCaracter.put("-.", 'N');
        morseCaracter.put("---", 'O');
        morseCaracter.put(".--.", 'P');
        morseCaracter.put("--.-", 'Q');
        morseCaracter.put(".-.", 'R');
        morseCaracter.put("...", 'S');
        morseCaracter.put("-", 'T');
        morseCaracter.put("..-", 'U');
        morseCaracter.put("...-", 'V');
        morseCaracter.put(".--", 'W');
        morseCaracter.put("-..-", 'X');
        morseCaracter.put("-.--", 'Y');
        morseCaracter.put("--..", 'Z');


        for (String key : morseCaracter.keySet()) {
            caracterMorse.put(morseCaracter.get(key), key);
        }



    }
}
