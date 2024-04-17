package com.codigo.morse.service.impl;

import com.codigo.morse.service.ICodigoMorseService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class CodigoMorseServiceImpl implements ICodigoMorseService {

    private static HashMap<Character,String> mapaMorse = new HashMap<>();
    
    static {
        mapaMorse.put('A', ".-");
        mapaMorse.put('B', "-...");
        mapaMorse.put('C', "-.-.");
        mapaMorse.put('D', "-..");
        mapaMorse.put('E', ".");
        mapaMorse.put('F', "..-.");
        mapaMorse.put('G', "--.");
        mapaMorse.put('H', "....");
        mapaMorse.put('I', "..");
        mapaMorse.put('J', ".---");
        mapaMorse.put('K', "-.-");
        mapaMorse.put('L', ".-..");
        mapaMorse.put('M', "--");
        mapaMorse.put('N', "-.");
        mapaMorse.put('O', "---");
        mapaMorse.put('P', ".--.");
        mapaMorse.put('Q', "--.-");
        mapaMorse.put('R', ".-.");
        mapaMorse.put('S', "...");
        mapaMorse.put('T', "-");
        mapaMorse.put('U', "..-");
        mapaMorse.put('V', "...-");
        mapaMorse.put('W', ".--");
        mapaMorse.put('X', "-..-");
        mapaMorse.put('Y', "-.--");
        mapaMorse.put('Z', "--..");
        mapaMorse.put('0', "-----");
        mapaMorse.put('1', ".----");
        mapaMorse.put('2', "..---");
        mapaMorse.put('3', "...--");
        mapaMorse.put('4', "....-");
        mapaMorse.put('5', ".....");
        mapaMorse.put('6', "-....");
        mapaMorse.put('7', "--...");
        mapaMorse.put('8', "---..");
        mapaMorse.put('9', "----.");
        mapaMorse.put('?', "..--..");
        mapaMorse.put('!', "-.-.--");
        mapaMorse.put('.', ".-.-.-");
        mapaMorse.put(',', "--..--");
    }

    public String getTraduccionMorseAAlfabeto(String texto) {

        String[] listaMorsePalabrasInput = texto.split("   ");
        String textoFinal = "";

        for (int i = 0; i < listaMorsePalabrasInput.length; i++){
            String[] listaMorseLetraInput = listaMorsePalabrasInput[i].split(" ");

            for (int j = 0; j < listaMorseLetraInput.length; j++){

                for (Map.Entry<Character, String> entry : mapaMorse.entrySet()) {
                    if (entry.getValue().equals(listaMorseLetraInput[j])) {
                        textoFinal += entry.getKey();
                        break;
                    }
                }
            }
            textoFinal += " ";
        }

        return textoFinal;
    }

    public String getTraduccionAlfabetoAMorse(String texto) {
        StringBuilder textoMorse = new StringBuilder();

        for (char caracter : texto.toUpperCase().toCharArray()) {
            if (mapaMorse.containsKey(caracter)) {
                textoMorse.append(mapaMorse.get(caracter)).append(" ");
            } else if (caracter == ' ') {
                textoMorse.append(" ");
            }
        }

        return textoMorse.toString().trim();
    }
}
