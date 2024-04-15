package com.codigoMorse.codigoMorse.service.impl;

import com.codigoMorse.codigoMorse.service.ICodigoMorseService;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class CodigoMorseServiceImpl implements ICodigoMorseService {

    private HashMap<String, Character> morseToCharMap;
    @Override
    public String decodeCodigoMorse(String code) {
        StringBuilder decoded = new StringBuilder();

        String [] splitCodeSpaces = code.split("     ");

        for (String word: splitCodeSpaces) {
            String [] splitCode = word.split(" ");
            for (String letter: splitCode) {
                if(morseToCharMap.containsKey(letter))
                {
                    decoded.append(morseToCharMap.get(letter));
                }
            }
        }
        return decoded.toString();
    }


    public CodigoMorseServiceImpl() {
        morseToCharMap = new HashMap<>();
        morseToCharMap.put(".-", 'A');
        morseToCharMap.put("-...", 'B');
        morseToCharMap.put("-.-.", 'C');
        morseToCharMap.put("-..", 'D');
        morseToCharMap.put(".", 'E');
        morseToCharMap.put("..-.", 'F');
        morseToCharMap.put("--.", 'G');
        morseToCharMap.put("....", 'H');
        morseToCharMap.put("..", 'I');
        morseToCharMap.put(".---", 'J');
        morseToCharMap.put("-.-", 'K');
        morseToCharMap.put(".-..", 'L');
        morseToCharMap.put("--", 'M');
        morseToCharMap.put("-.", 'N');
        morseToCharMap.put("---", 'O');
        morseToCharMap.put(".--.", 'P');
        morseToCharMap.put("--.-", 'Q');
        morseToCharMap.put(".-.", 'R');
        morseToCharMap.put("...", 'S');
        morseToCharMap.put("-", 'T');
        morseToCharMap.put("..-", 'U');
        morseToCharMap.put("...-", 'V');
        morseToCharMap.put(".--", 'W');
        morseToCharMap.put("-..-", 'X');
        morseToCharMap.put("-.--", 'Y');
        morseToCharMap.put("--..", 'Z');
    }
}
