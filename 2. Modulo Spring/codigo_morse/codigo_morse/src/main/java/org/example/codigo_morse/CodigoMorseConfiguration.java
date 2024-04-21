package org.example.codigo_morse;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;
import java.util.TreeMap;

@Configuration
public class CodigoMorseConfiguration {
    @Bean
    Map<String, String> morseToLetter () 
    {
        return new TreeMap<String, String>() {{
            put(".-","A");
            put("-...","B");
            put("-.-.","C");
            put("-..","D");
            put(".","E");
            put("..-.","F");
            put("--.","G");
            put("....","H");
            put("..","I");
            put(".---","J");
            put("-.-","K");
            put(".-..","L");
            put("--","M");
            put("-.","N");
            put("---","O");
            put(".--.","P");
            put("--.-","Q");
            put(".-.","R");
            put("...","S");
            put("-","T");
            put("..-","U");
            put("...-","V");
            put(".--","W");
            put("-..-","X");
            put("-.--","Y");
            put("--..","Z");
            put(".----","1");
            put("..---","2");
            put("...--","3");
            put("....-","4");
            put(".....","5");
            put("-....","6");
            put("--...","7");
            put("---..","8");
            put("----.","9");
            put("-----","0");
            put(".-.-.-",".");
            put("..--..","?");
            put("-.-.--","!");
            put("--..--",",");
        }} ;

    };
    @Bean
    Map<String, String> letterToMorse ()
    {
        return new TreeMap<String, String>() {{
            put("A",".-");
            put("B","-...");
            put("C","-.-.");
            put("D","-..");
            put("E",".");
            put("F","..-.");
            put("G","--.");
            put("H","....");
            put("I","..");
            put("J",".---");
            put("K","-.-");
            put("L",".-..");
            put("M","--");
            put("N","-.");
            put("O","---");
            put("P",".--.");
            put("Q","--.-");
            put("R",".-.");
            put("S","...");
            put("T","-");
            put("U","..-");
            put("V","...-");
            put("W",".--");
            put("X","-..-");
            put("Y","-.--");
            put("Z","--..");
            put("1",".----");
            put("2","..---");
            put("3","...--");
            put("4","....-");
            put("5",".....");
            put("6","-....");
            put("7","--...");
            put("8","---..");
            put("9","----.");
            put("0","-----");
            put(".",".-.-.-");
            put("?","..--..");
            put("!","-.-.--");
            put(",","--..--");
        }} ;
    }

}
