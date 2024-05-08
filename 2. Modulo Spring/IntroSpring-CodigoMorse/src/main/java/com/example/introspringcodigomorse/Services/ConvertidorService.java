package com.example.introspringcodigomorse.Services;

import com.example.introspringcodigomorse.Interfaces.IConvertidor;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;


@Service
public class ConvertidorService implements IConvertidor {

        private Map<String,String> textToMorseMap = new HashMap<>();

        private void llenarHasMap(){


            textToMorseMap.put( ".-","A");
            textToMorseMap.put( "-...","B");
            textToMorseMap.put( "-.-.","C");
            textToMorseMap.put( "-..","D");
            textToMorseMap.put( ".","E");
            textToMorseMap.put( "..-.","F");
            textToMorseMap.put( "--.","G");
            textToMorseMap.put( "....","H");
            textToMorseMap.put( "..","I");
            textToMorseMap.put( ".---","J");
            textToMorseMap.put( "-.-","K");
            textToMorseMap.put( ".-..","L");
            textToMorseMap.put( "--","M");
            textToMorseMap.put( "-.","N");
            textToMorseMap.put( "---","O");
            textToMorseMap.put( ".--.","P");
            textToMorseMap.put( "--.-","Q");
            textToMorseMap.put( ".-.","R");
            textToMorseMap.put( "...","S");
            textToMorseMap.put( "-","T");
            textToMorseMap.put( "..-","U");
            textToMorseMap.put( "...-","V");
            textToMorseMap.put( ".--","W");
            textToMorseMap.put( "-..-","X");
            textToMorseMap.put( "-.--","Y");
            textToMorseMap.put( "--..","Z");
            textToMorseMap.put( ".----","1");
            textToMorseMap.put( "..---","2");
            textToMorseMap.put( "...--","3");
            textToMorseMap.put( "....-","4");
            textToMorseMap.put( ".....","5");
            textToMorseMap.put( "-....","6");
            textToMorseMap.put( "--...","7");
            textToMorseMap.put( "---..","8");
            textToMorseMap.put( "----.","9");
            textToMorseMap.put( "-----","0");
        }

        public ConvertidorService(){
            this.llenarHasMap();
        }

    @Override
    public String convertirAMorse(String texto) {
        return "Convertido a codigo morse";
    }

    @Override
    public String convertirATexto(String codigoMorse) {

        String[] palabras = codigoMorse.split("   ");
        String respuesta = "";
        for (String palabra : palabras){

            String [] letras = palabra.split(" ");

            for (String letra : letras){

                respuesta += textToMorseMap.get(letra);
            }

            respuesta+=" ";

        }

        return respuesta;
    }




}
