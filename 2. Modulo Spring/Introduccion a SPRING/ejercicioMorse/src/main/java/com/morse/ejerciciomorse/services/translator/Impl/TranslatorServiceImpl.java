package com.morse.ejerciciomorse.services.translator.Impl;

import com.morse.ejerciciomorse.services.ITranslator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class TranslatorServiceImpl implements ITranslator{

    Map<String, String> morseMapper = new HashMap<>();
    {
        morseMapper.put(".-", "A");
        morseMapper.put("-...", "B");
        morseMapper.put("-.-.", "C");
        morseMapper.put("-..", "D");
        morseMapper.put(".", "E");
        morseMapper.put("..-.", "F");
        morseMapper.put("--.", "G");
        morseMapper.put("....", "H");
        morseMapper.put("..", "I");
        morseMapper.put(".---", "J");
        morseMapper.put("-.-", "K");
        morseMapper.put(".-..", "L");
        morseMapper.put("--", "M");
        morseMapper.put("-.", "N");
        morseMapper.put("---", "O");
        morseMapper.put(".--.", "P");
        morseMapper.put("--.-", "Q");
        morseMapper.put(".-.", "R");
        morseMapper.put("...", "S");
        morseMapper.put("-", "T");
        morseMapper.put("..-", "U");
        morseMapper.put("...-", "V");
        morseMapper.put(".--", "W");
        morseMapper.put("-..-", "X");
        morseMapper.put("-.--", "Y");
        morseMapper.put("--..", "Z");
        morseMapper.put(".----", "1");
        morseMapper.put("..---", "2");
        morseMapper.put("...--", "3");
        morseMapper.put("....-", "4");
        morseMapper.put(".....", "5");
        morseMapper.put("-....", "6");
        morseMapper.put("--...", "7");
        morseMapper.put("---..", "8");
        morseMapper.put("----.", "9");
        morseMapper.put("-----", "0");
        morseMapper.put("..--..", "?");
        morseMapper.put("-.-.--", "!");
        morseMapper.put(".-.-.-", ".");
        morseMapper.put("--..--", ",");
    }

    @Override
    public String translateToEspa(String str) {
        StringBuilder resultado = new StringBuilder();
        String[] codigos = str.split(" ");
        for (String morse : codigos){
            String string = morseMapper.getOrDefault(morse, " ");
            resultado.append(string);
        }

        return resultado.toString();
    }

    @Override
    public String translateToMorse(String str) {
        StringBuilder resultado = new StringBuilder();

        for(int i = 0; i < str.length(); i++ ){
            char c = str.charAt(i);
            if (c == ' ') {
                resultado.append(" ");
                continue;
            }
            for (Map.Entry<String, String> entry : morseMapper.entrySet()){
                if (entry.getValue().equals(String.valueOf(c))){
                    resultado.append(entry.getKey()).append(" ");
                    break;
                }
            }
        }

        return resultado.toString().trim();

    }
}
