package com.example.EjercicioCodigoMorse.Service.impl;

import com.example.EjercicioCodigoMorse.Service.IToWordsService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class ToWordsServiceImpl implements IToWordsService {
    private static final Map<Character, String> translates = new HashMap<>();
    static{
        translates.put('A', ".-");
        translates.put('B', "-...");
        translates.put('C', "-.-.");
        translates.put('D', "-..");
        translates.put('E', ".");
        translates.put('F', "..-.");
        translates.put('G', "--.");
        translates.put('H', "....");
        translates.put('I', "..");
        translates.put('J', ".---");
        translates.put('K', "-.-");
        translates.put('L', ".-..");
        translates.put('M', "--");
        translates.put('N', "-.");
        translates.put('O', "---");
        translates.put('P', ".--.");
        translates.put('Q', "--.-");
        translates.put('R', ".-.");
        translates.put('S', "...");
        translates.put('T', "-");
        translates.put('U', "..-");
        translates.put('V', "...-");
        translates.put('W', ".--");
        translates.put('X', "-..-");
        translates.put('Y', "-.--");
        translates.put('Z', "--..");
        translates.put('0', "-----");
        translates.put('1', ".----");
        translates.put('2', "..---");
        translates.put('3', "...--");
        translates.put('4', "....-");
        translates.put('5', ".....");
        translates.put('6', "-....");
        translates.put('7', "--...");
        translates.put('8', "---..");
        translates.put('9', "----.");
        translates.put('?', "..--..");
        translates.put('!', "-.-.--");
        translates.put('.', ".-.-.-");
        translates.put(',', "--..--");
    }

    @Override
    public String encode(String traduction) {
        System.out.println("llamando al metodo desde la peticion ");
        StringBuilder response = new StringBuilder();
        String[] words = traduction.toUpperCase().split(" ");

        for (String word : words) {
            for (char letter : word.toCharArray()) {
                String morseCode = translates.get(letter);
                if (morseCode != null) {
                    response.append(morseCode).append(" ");
                }
            }
            response.append("  ");
        }

        return response.toString().trim();
    }

    @Override
    public String decode(String text) {
        String[] listaMorsePalabrasInput = text.split("   ");
        String finalText = "";

        for (String string : listaMorsePalabrasInput) {
            String[] listaMorseLetraInput = string.split(" ");

            for (String s : listaMorseLetraInput) {

                for (Map.Entry<Character, String> entry : translates.entrySet()) {
                    if (entry.getValue().equals(s)) {
                        finalText += entry.getKey();
                        break;
                    }
                }
            }
            finalText += " ";
        }

        return finalText;
    }
}
