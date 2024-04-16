package com.mercadolibre.codigomorse.service.implementation;

import com.mercadolibre.codigomorse.service.IMorseCodeService;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class MorseCodeServiceImpl implements IMorseCodeService {

    private Map<Character,String> morseDictionary;
    private Map<String,Character> inversedDictionary;

    public MorseCodeServiceImpl() {
        morseDictionary = new HashMap<>();
        morseDictionary.put(' ', "   ");
        morseDictionary.put('a', ".-");
        morseDictionary.put('b', "-...");
        morseDictionary.put('c',  "-.-");
        morseDictionary.put('d',  "-..");
        morseDictionary.put('e',    ".");
        morseDictionary.put('f', "..-.");
        morseDictionary.put('g',  "--.");
        morseDictionary.put('h', "....");
        morseDictionary.put('i',   "..");
        morseDictionary.put('j', ".---");
        morseDictionary.put('k',   "-.");
        morseDictionary.put('l', ".-..");
        morseDictionary.put('m',   "--");
        morseDictionary.put('n',   "-.");
        morseDictionary.put('o',  "---");
        morseDictionary.put('p', ".--.");
        morseDictionary.put('q', "--.-");
        morseDictionary.put('r', ".-.");
        morseDictionary.put('s',  "...");
        morseDictionary.put('t',   "-");
        morseDictionary.put('u',  "..-");
        morseDictionary.put('v', "...-");
        morseDictionary.put('w',  ".--");
        morseDictionary.put('x', "-..-");
        morseDictionary.put('y', "-.--");
        morseDictionary.put('z', "--..");
        morseDictionary.put('1', ".----");
        morseDictionary.put('2',"..---");
        morseDictionary.put('3', "...--");
        morseDictionary.put('4', "....-");
        morseDictionary.put('5', ".....");
        morseDictionary.put('6', "-....");
        morseDictionary.put('7', "--...");
        morseDictionary.put('8', "---..");
        morseDictionary.put('9', "----.");
        morseDictionary.put('0', "-----");
        inversedDictionary = getInverseDictionary();
    }

    @Override
    public String convertToMorse(String input) {
        StringBuilder result = new StringBuilder();
        input = input.toLowerCase();
        for (Character c : input.toCharArray()) {
            result.append(morseDictionary.get(c)).append(" ");
        }
        return result.toString();
    }

    @Override
    public String convertFromMorse(String input) {
        StringBuilder result = new StringBuilder();
        String[] words = input.split(" {3}");
        for( String word : words ) {
            for (String morse : word.split(" ")) {
                result.append(inversedDictionary.get(morse));
            }
            result.append(" ");
        }
        return result.toString().toUpperCase();
    }
    private Map<String, Character> getInverseDictionary() {
        Map<String, Character> inversedDictionary = new HashMap<>();
        for(Map.Entry<Character, String> entry : morseDictionary.entrySet()){
            inversedDictionary.put(entry.getValue(), entry.getKey());
        }
        return inversedDictionary;
    }
}
