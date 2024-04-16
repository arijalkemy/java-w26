package com.meli.meli.Modelo;

import java.util.HashMap;
import java.util.Map;

public class MorseDiccionary {

    public static final Map<Character,String> morseDiccionary = new HashMap<Character,String>();
    static {
        morseDiccionary.put('A', ".-");
        morseDiccionary.put('B', "-...");
        morseDiccionary.put('C', "-.-.");
        morseDiccionary.put('D', "-..");
        morseDiccionary.put('E', ".");
        morseDiccionary.put('F', "..-.");
        morseDiccionary.put('G', "--.");
        morseDiccionary.put('H', "....");
        morseDiccionary.put('I', "..");
        morseDiccionary.put('J', ".---");
        morseDiccionary.put('K', "-.-");
        morseDiccionary.put('L', ".-..");
        morseDiccionary.put('M', "--");
        morseDiccionary.put('N', "-.");
        morseDiccionary.put('O', "---");
        morseDiccionary.put('P', ".--.");
        morseDiccionary.put('Q', "--.-");
        morseDiccionary.put('R', ".-.");
        morseDiccionary.put('S', "...");
        morseDiccionary.put('T', "-");
        morseDiccionary.put('U', "..-");
        morseDiccionary.put('V', "...-");
        morseDiccionary.put('W', ".--");
        morseDiccionary.put('X', "-..-");
        morseDiccionary.put('Y', "-.--");
        morseDiccionary.put('Z', "--..");
        morseDiccionary.put('1', ".----");
        morseDiccionary.put('2', "..---");
        morseDiccionary.put('3', "...--");
        morseDiccionary.put('4', "....-");
        morseDiccionary.put('5', ".....");
        morseDiccionary.put('6', "-....");
        morseDiccionary.put('7', "--...");
        morseDiccionary.put('8', "---..");
        morseDiccionary.put('9', "----.");
        morseDiccionary.put('0', "-----");
    }

}

