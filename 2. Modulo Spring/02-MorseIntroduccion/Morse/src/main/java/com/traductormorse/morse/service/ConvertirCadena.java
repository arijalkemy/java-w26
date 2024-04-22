package com.traductormorse.morse.service;

import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ConvertirCadena implements IConversion{
    private static List<String> codigosMorse = Arrays.asList(
            ".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..",
            ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.",
            "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--..",
            "-----", ".----", "..---", "...--", "....-", ".....", "-....", "--...",
            "---..", "----.", ".-.-.-", "--..--", "..--.."
            );

    private static List<String> caracteres = Arrays.asList(
            "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M",
            "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z",
            "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", ".", ",", "?"
            );

    @Override
    public String convertirAAlfabetico(String morse) {
        /**
         * Convierte codigo morse al alfabeto latino.
         */
        Map<String, String> diccionarioMorse = new HashMap<>();

        //se agrega cada combinacion con su equivalente
        for (int i=0; i<caracteres.size(); i++){
            diccionarioMorse.put(codigosMorse.get(i), caracteres.get(i));
        }

        StringBuilder resultado = new StringBuilder();
        String[] palabras = morse.split(" {3}"); //separa a cada palabra por 3 espacios
        for (String palabra : palabras){
            String[] caracterPalabra = palabra.split(" "); //separa cada caracter por espacios
            for (String caracter : caracterPalabra){
                resultado.append(diccionarioMorse.get(caracter));
            }
            resultado.append(" ");
        }
        return resultado.toString().trim();
    }

    @Override
    public String convertirAMorse(String palabras) {
        /**
         * Convierte palabras a codigo morse
         */

        Map<String, String> diccionarioMorse = new HashMap<>();

        //se agrega cada combinacion con su equivalente
        for (int i=0; i<caracteres.size(); i++){
            diccionarioMorse.put(caracteres.get(i), codigosMorse.get(i));
        }

        StringBuilder resultado = new StringBuilder();
        List<String> palabrasSeparadas = List.of(palabras.split(" "));
        for (String palabra : palabrasSeparadas) {
            List<String> listaCaracteres = List.of(palabra.split(""));
            for (String caracter : listaCaracteres) {
                resultado.append(diccionarioMorse.get(caracter));
                resultado.append(" ");
            }
            resultado.append("   ");
        }
        return resultado.toString().trim();
    }

}
