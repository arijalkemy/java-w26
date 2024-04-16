package org.ejercicio.codigomorse.services;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class MorseImpl implements IMorse{
    private Map<Character,String> mapMorse;
    private Map<String,Character> mapFrase;

    public MorseImpl() {
        this.mapMorse = new HashMap<Character, String>();
        mapMorse.put('a',".-");
        mapMorse.put('b',"-...");
        mapMorse.put('c',"-.-.");
        mapMorse.put('d',"-..");
        mapMorse.put('e',".");
        mapMorse.put('f',"..-.");
        mapMorse.put('g',"--.");
        mapMorse.put('h',"....");
        mapMorse.put('i',"..");
        mapMorse.put('j',".---");
        mapMorse.put('k',"-.-");
        mapMorse.put('l',".-..");
        mapMorse.put('m',"--");
        mapMorse.put('n',"-.");
        mapMorse.put('o',"---");
        mapMorse.put('p',".--.");
        mapMorse.put('q',"--.-");
        mapMorse.put('r',".-.");
        mapMorse.put('s',"...");
        mapMorse.put('t',"-");
        mapMorse.put('u',"..-");
        mapMorse.put('v',"...-");
        mapMorse.put('w',".--");
        mapMorse.put('x',"-..-");
        mapMorse.put('y',"-.--");
        mapMorse.put('z',"--..");
        mapMorse.put('1',".----");
        mapMorse.put('2',"..---");
        mapMorse.put('3',"...--");
        mapMorse.put('4',"....-");
        mapMorse.put('5',".....");
        mapMorse.put('6',"-....");
        mapMorse.put('7',"--...");
        mapMorse.put('8',"---..");
        mapMorse.put('9',"----.");
        mapMorse.put('0',"-----");
        mapMorse.put('?',"..--..");
        mapMorse.put('!',"-.-.--");
        mapMorse.put('.',".-.-.-");
        mapMorse.put(',',"--..--");

        this.mapFrase = new HashMap<String, Character>();
        for(Map.Entry<Character, String> entry : mapMorse.entrySet()){
            mapFrase.put(entry.getValue(),entry.getKey());
        }
    }

    @Override
    public String obtenerMorse(String frase) {
        frase = frase.toLowerCase();
        String fraseReturn = "";
        for(int i=0;i<frase.length();i++){
            if(mapMorse.containsKey(frase.charAt(i))){
                fraseReturn += mapMorse.get(frase.charAt(i)) + " ";
                continue;
            }
            fraseReturn += "  ";
        }
        return fraseReturn.trim();
    }

    @Override
    public String obtenerFrase(String morse) {
        String fraseReturn = "";
        String[] palabras = morse.split(" ");

        for(int i=0;i<palabras.length;i++){
            if(mapFrase.containsKey(palabras[i])){
                fraseReturn += mapFrase.get(palabras[i]);
             }else{
                fraseReturn += " ";
                i += 1;
             }
        }
        return fraseReturn;
    }
}
