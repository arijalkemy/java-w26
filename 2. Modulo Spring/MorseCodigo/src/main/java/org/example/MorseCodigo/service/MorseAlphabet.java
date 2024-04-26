package org.example.MorseCodigo.service;
import java.util.Map;
import java.util.HashMap;

public class MorseAlphabet {
    public static final Map<String, String> alphabet = new HashMap<>();
    static{
        alphabet.put(".-", "A");
        alphabet.put("-...","B");
        alphabet.put("-.-.","C");
        alphabet.put("-..","D");
        alphabet.put(".","E");
        alphabet.put("..-.","F");
        alphabet.put("--.","G");
        alphabet.put("....","H");
        alphabet.put("..","I");
        alphabet.put(".---","J");
        alphabet.put("-.-","K");
        alphabet.put(".-..","L");
        alphabet.put("--","M");
        alphabet.put("-.","N");
        alphabet.put("---","O");
        alphabet.put(".--.","P");
        alphabet.put("--.-","Q");
        alphabet.put(".-.","R");
        alphabet.put("...","S");
        alphabet.put("-","T");
        alphabet.put("..-","U");
        alphabet.put("...-","V");
        alphabet.put(".--","W");
        alphabet.put("-..-","X");
        alphabet.put("-.--","Y");
        alphabet.put("--..","Z");
        alphabet.put("----","0");
        alphabet.put(".----","1");
        alphabet.put("..---","2");
        alphabet.put("...--","3");
        alphabet.put("....-","4");
        alphabet.put(".....","5");
        alphabet.put("-....","6");
        alphabet.put("--...","7");
        alphabet.put("---..","8");
        alphabet.put("----.","9");
        alphabet.put("-.-.--","!");
        alphabet.put("--..--",",");
        alphabet.put(".-.-.-",".");
        alphabet.put("..--..","?");
    }
    public static Map<String, String> getAlphabet(){
        return alphabet;
    }
}
