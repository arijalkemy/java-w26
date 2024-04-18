package org.example.integradormorse.service.impl;

import org.example.integradormorse.service.IConversorService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;



@Service
public class ConversorServiceImpl implements IConversorService {

    private final Map<String, String> conversionMap;
    public ConversorServiceImpl(){

        conversionMap = new HashMap<>(){{
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
            put(".", ".-.-.-");
            put(",", "--..--");
            put("?", "..--..");
            put("!", "-.-.--");
            put(":", "---...");
            put(";", "-.-.-.");
            put("-", "-....-");
            put("/", "-..-.");
            put("'", ".----.");
            put("(", "-.--.");
            put(")", "-.--.-");
            put("[", "-.--.");
            put("]", "-.--.-");
            put("{", "-.--.");
            put("}", "-.--.-");
            put("=", "-...-");
            put("+", ".-.-.");
            put("*", "-..-");
            put("@", ".--.-.");
            put("$", "...-..-");
            put("&", ".-...");
            put("#", "-.-.--");
        }};
    }


    // From morse to text
    @Override
    public String convertToText(String text) {
        text = text + " ";

        String result = "";
        String concat = "";
        String compare = "";
        int blankSpaces = 0;

        for (int i = 0; i < text.length(); i++) {
            String currentCharacter = String.valueOf(text.charAt(i));

            if (currentCharacter.equals(" ")) {
                blankSpaces++;
                compare = concat;
                concat = "";

                for (Map.Entry<String, String> entry: conversionMap.entrySet() ){
                    if (compare.equals(entry.getValue())){
                        result = result + entry.getKey();
                        blankSpaces = 0;
                    }
                }
            } else {
                concat = concat + currentCharacter;
            }

            if (blankSpaces >=3){
                result = result + " ";
                blankSpaces = 0;
            }
        }
        return result;
    }


    // From text to morse
    @Override
    public String convertToMorse(String text) {
        String result = "";
        String currentChar = "";

        for (int i = 0; i < text.length(); i++) {
            currentChar = String.valueOf(text.charAt(i));

            if (currentChar.equals(" ")){
                result = result + "   ";
            }

            for (Map.Entry<String, String> entry: conversionMap.entrySet() ){
                if (currentChar.equals(entry.getKey())){
                    result = result + entry.getValue() + " ";
                }
            }
        }
        return result;
    }



}
