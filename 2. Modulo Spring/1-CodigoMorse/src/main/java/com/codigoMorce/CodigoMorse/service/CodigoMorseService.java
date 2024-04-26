package com.codigoMorce.CodigoMorse.service;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class CodigoMorseService implements ICodigoMorseService {

    static Map<String, String> collection;

    static {
        collection = new HashMap<String, String>();
        collection.put("A", ".-");
        collection.put("B", "-...");
        collection.put("C", "-.-.");
        collection.put("D", "-..");
        collection.put("E", ".");
        collection.put("F", "..-.");
        collection.put("G", "--.");
        collection.put("H", "....");
        collection.put("I", "..");
        collection.put("J", ".---");
        collection.put("K", "-.-");
        collection.put("L", ".-..");
        collection.put("M", "--");
        collection.put("N", "-.");
        collection.put("O", "---");
        collection.put("P", ".--.");
        collection.put("Q", "--.-");
        collection.put("R", ".-.");
        collection.put("S", "...");
        collection.put("T", "-");
        collection.put("U", "..-");
        collection.put("V", "...-");
        collection.put("W", ".--");
        collection.put("X", "-..-");
        collection.put("Y", "-.--");
        collection.put("Z", "--..");
        collection.put(" ", " ");
    }

    @Override
    public String convertToMorse(String text) {

        text = text.toUpperCase();
        String[] arrayText =  text.split("");
        StringBuilder textResult = new StringBuilder();

        for (int i = 0; i < arrayText.length; i++) {
            String letter = arrayText[i];
            textResult.append(collection.get(letter));
            if (i < arrayText.length-1) {
                textResult.append(" ");
            }
        }
        return textResult.toString();
    }

    @Override
    public String convertToText(String text) {
        String[] arrayText =  text.split(" ");
        StringBuilder textResult = new StringBuilder();

        for (int i = 0; i < arrayText.length; i++) {
            String letter = arrayText[i];
                for (Map.Entry<String, String> entry : collection.entrySet()) {
                    System.out.println( "Valor Buscado:"+letter + "en :"+entry.getValue());


                    if (entry.getValue() == letter) {

                        System.out.println(entry.getKey());
                        textResult.append(entry.getKey());
                    }
                }
        }
        return textResult.toString();
    }

}



