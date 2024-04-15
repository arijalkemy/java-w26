package com.javabootcamp.primerproyectospring.servicesImp;

import com.github.fracpete.romannumerals4j.RomanNumeralFormat;
import com.javabootcamp.primerproyectospring.services.ConverterServices;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

@Service
public class ConverterServicesImp implements ConverterServices {

    private Map<String, Character> textToMorseMap = new HashMap<>();
    private  Map<Character, String> morseToTextMap = new HashMap<>();
    @Override
    public String enteroARomano(int number) {
        RomanNumeralFormat f = new RomanNumeralFormat();
        return f.format(number);
    }

    @Override
    public String morseATexto(String codigoMorse) {
        llenarArray();
        String resultado ="";
        String[] arrayPalabraMorse = codigoMorse.split("   ");
        for(String palabraMorse: arrayPalabraMorse){
            for (String letraMorse: palabraMorse.split(" ")){
                resultado += textToMorseMap.get(letraMorse);
            };
            resultado+=" ";
        }
        return resultado;
    }

    @Override
    public String textoAMorse(String texto) {
        llenarArray();
        String resultado ="";
        String[] arraytexto = texto.toUpperCase().split(" ");
        for(String palabra: arraytexto){
            for (int i =0;i<palabra.length();i++){
                resultado += morseToTextMap.get(palabra.charAt(i));
                resultado +=" ";
            };
            resultado +="   ";
        }
        return resultado;
    }


    private void llenarArray(){
        textToMorseMap.put(".-", 'A');
        textToMorseMap.put("-...", 'B');
        textToMorseMap.put("-.-.", 'C');
        textToMorseMap.put("-..", 'D');
        textToMorseMap.put(".", 'E');
        textToMorseMap.put("..-.", 'F');
        textToMorseMap.put("--.", 'G');
        textToMorseMap.put("....", 'H');
        textToMorseMap.put("..", 'I');
        textToMorseMap.put(".---", 'J');
        textToMorseMap.put("-.-", 'K');
        textToMorseMap.put(".-..", 'L');
        textToMorseMap.put("--", 'M');
        textToMorseMap.put("-.", 'N');
        textToMorseMap.put("---", 'O');
        textToMorseMap.put(".--.", 'P');
        textToMorseMap.put("--.-", 'Q');
        textToMorseMap.put(".-.", 'R');
        textToMorseMap.put("...", 'S');
        textToMorseMap.put("-", 'T');
        textToMorseMap.put("..-", 'U');
        textToMorseMap.put("...-", 'V');
        textToMorseMap.put(".--", 'W');
        textToMorseMap.put("-..-", 'X');
        textToMorseMap.put("-.--", 'Y');
        textToMorseMap.put("--..", 'Z');
        textToMorseMap.put(".----", '1');
        textToMorseMap.put("..---", '2');
        textToMorseMap.put("...--", '3');
        textToMorseMap.put("....-", '4');
        textToMorseMap.put(".....", '5');
        textToMorseMap.put("-....", '6');
        textToMorseMap.put("--...", '7');
        textToMorseMap.put("---..", '8');
        textToMorseMap.put("----.", '9');
        textToMorseMap.put("-----", '0');
        for (Map.Entry<String, Character> entry : textToMorseMap.entrySet()) {
            morseToTextMap.put(entry.getValue(), entry.getKey());

        }
    }
}
