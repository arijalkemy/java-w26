package org.ggomezr.codigomorse.service.imp;

import org.ggomezr.codigomorse.service.ICodigoMorseService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class CodigoMorseService implements ICodigoMorseService {

    private static final String[] codigoMorse = {
            ".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..",
            "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-",
            "-.--", "--.."
    };

    private static final String[] alfabeto = {
            "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L",
            "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X",
            "Y", "Z"
    };

    @Override
    public String decodificarCodigoMorse(String mensaje) {
        StringBuilder mensajeDecodificado = new StringBuilder();

        mensajeDecodificado.append("<h1>Decodificador de mensajes</h1>");

        mensajeDecodificado.append("<p><strong>Mensaje a decodificar: </strong>" + mensaje +  "</p>");

        mensajeDecodificado.append("<p><strong>Mensaje decodificado: </strong>");


        String[] palabras = mensaje.split(" {3}");

        for (String palabra: palabras){
            String[] letras = palabra.split(" ");
            for(String letra : letras){
                for (int i = 0; i < codigoMorse.length; i++) {
                    if(letra.equalsIgnoreCase(codigoMorse[i])){
                        mensajeDecodificado.append(alfabeto[i]);
                        break;
                    }
                }

            }
            mensajeDecodificado.append(" ");
        }
        mensajeDecodificado.append("</p>");
        return mensajeDecodificado.toString();
    }

    @Override
    public String codificarACodigoMorse(String mensaje) {

        StringBuilder mensajeCodificado = new StringBuilder();

        mensajeCodificado.append("<h1>Codificador de mensajes</h1>");

        mensajeCodificado.append("<p><strong>Mensaje a codificar: </strong>" + mensaje.toUpperCase() +  "</p>");

        mensajeCodificado.append("<p><strong>Mensaje codificado: </strong>");

        String[] palabras = mensaje.toUpperCase().split(" ");
        for(String palabra : palabras){
            for(char letra: palabra.toCharArray()){
                for (int i = 0; i < alfabeto.length; i++) {
                    if(letra == alfabeto[i].charAt(0)){
                        mensajeCodificado.append(codigoMorse[i]).append(" ");
                        break;
                    }
                }
            }
            mensajeCodificado.append(" ");
        }
        mensajeCodificado.append("</p>");
        return mensajeCodificado.toString();
    }
}
