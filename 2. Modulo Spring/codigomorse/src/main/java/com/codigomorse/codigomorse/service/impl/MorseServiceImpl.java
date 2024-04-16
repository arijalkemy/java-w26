package com.codigomorse.codigomorse.service.impl;

import com.codigomorse.codigomorse.service.IMorseService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Locale;

@Service
public class MorseServiceImpl implements IMorseService {

    public static final HashMap<String, String> morseMap = new HashMap<String, String>();

    static {
        morseMap.put(".-", "A");
        morseMap.put("-...", "B");
        morseMap.put("-.-.", "C");
        morseMap.put("-..", "D");
        morseMap.put(".", "E");
        morseMap.put("..-.", "F");
        morseMap.put("--.", "G");
        morseMap.put("....", "H");
        morseMap.put("..", "I");
        morseMap.put(".---", "J");
        morseMap.put("-.-", "K");
        morseMap.put(".-..", "L");
        morseMap.put("--", "M");
        morseMap.put("-.", "N");
        morseMap.put("---", "O");
        morseMap.put(".--.", "P");
        morseMap.put("--.-", "Q");
        morseMap.put(".-.", "R");
        morseMap.put("...", "S");
        morseMap.put("-", "T");
        morseMap.put("..-", "U");
        morseMap.put("...-", "V");
        morseMap.put(".--", "W");
        morseMap.put("-..-", "X");
        morseMap.put("-.--", "Y");
        morseMap.put("--..", "Z");

    }

    public static final HashMap<Character,String> textoMap = new HashMap<Character,String>();

    static {
        textoMap.put('A', ".-");
        textoMap.put('B', "-...");
        textoMap.put('C', "-.-.");
        textoMap.put('D', "-..");
        textoMap.put('E', ".");
        textoMap.put('F', "..-.");
        textoMap.put('G', "--.");
        textoMap.put('H', "....");
        textoMap.put('I', "..");
        textoMap.put('J', ".---");
        textoMap.put('K', "-.-");
        textoMap.put('L', ".-..");
        textoMap.put('M', "--");
        textoMap.put('N', "-.");
        textoMap.put('O', "---");
        textoMap.put('P', ".--.");
        textoMap.put('Q', "--.-");
        textoMap.put('R', ".-.");
        textoMap.put('S', "...");
        textoMap.put('T', "-");
        textoMap.put('U', "..-");
        textoMap.put('V', "...-");
        textoMap.put('W', ".--");
        textoMap.put('X', "-..-");
        textoMap.put('Y', "-.--");
        textoMap.put('Z', "--..");

    }


    @Override
    public String convertirAPalabra(String morse) {
        String palabra = "";

        //Obtengo palabras
        String[] palabrasEnMorse = morse.split("   ");

        //Recorro las palabras para hacer la traduccion
        for(String palabraEnMorse: palabrasEnMorse ){
            String[] letrasEnMorse = palabraEnMorse.split(" ");
            //Traducir cada letra
            for(String letra: letrasEnMorse){
                String traduccion = morseMap.get(letra);
                if(traduccion!=null){
                    palabra+= traduccion;
                }
            }
            palabra+=" ";
        }

        return palabra;
    }

    @Override
    public String convertirAMorse(String palabra) {
        String morse = "";

        palabra = palabra.toUpperCase();
        palabra=palabra.replace(" ","");

        //Obtengo letras
        char[] letras = palabra.toCharArray();

        //Recorro las letras para hacer la traduccion
            for(char letra: letras){
                String traduccion = textoMap.get(letra);
                if(traduccion!=null){
                    morse+= traduccion +  " ";
                }
            morse+="  ";
        }

        return morse;
    }
}
