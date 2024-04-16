package com.meli.morse.servicies;

import com.meli.morse.servicies.interfaces.ITraductorMorse;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class TraductorMorseImp implements ITraductorMorse {

    static Map<Character, String> mapaMorse = new HashMap<>();

    static {
        mapaMorse.put('A', ".-");
        mapaMorse.put('B', "-...");
        mapaMorse.put('C', "-.-.");
        mapaMorse.put('D', "-..");
        mapaMorse.put('E', ".");
        mapaMorse.put('F', "..-.");
        mapaMorse.put('G', "--.");
        mapaMorse.put('H', "....");
        mapaMorse.put('I', "..");
        mapaMorse.put('J', ".---");
        mapaMorse.put('K', "-.-");
        mapaMorse.put('L', ".-..");
        mapaMorse.put('M', "--");
        mapaMorse.put('N', "-.");
        mapaMorse.put('O', "---");
        mapaMorse.put('P', ".--.");
        mapaMorse.put('Q', "--.-");
        mapaMorse.put('R', ".-.");
        mapaMorse.put('S', "...");
        mapaMorse.put('T', "-");
        mapaMorse.put('U', "..-");
        mapaMorse.put('V', "...-");
        mapaMorse.put('W', ".--");
        mapaMorse.put('X', "-..-");
        mapaMorse.put('Y', "-.--");
        mapaMorse.put('Z', "--..");
    }

    @Override
    public String convertirAMorse(String caracteres) {

        caracteres = caracteres.toUpperCase(Locale.ROOT);
        String stringMorse = "";
        for (int i = 0; i < caracteres.length(); i++) {
            Character c = caracteres.charAt(i);
            if (c.equals(' ')) {
                stringMorse += "   ";
                continue;
            }
            for (Character entry : mapaMorse.keySet()) {
                if (entry.equals(c)) {
                    stringMorse += mapaMorse.get(entry) + " ";
                    break;
                }
            }
        }


        return stringMorse;
    }

    @Override
    public String convertirACaracter(String morse) {
        String cadena = "";
        String[] palabras = morse.split("\\s{3}");
        for (String palabra : palabras) {
            // Dividir cada palabra en letras morse
            String[] caracteres = palabra.split("\\s{1}");

            for (String caracter : caracteres) {
                for (Map.Entry<Character, String> entry : mapaMorse.entrySet()) {
                    if (entry.getValue().equals(caracter)) {
                        cadena += entry.getKey();
                        break;
                    }
                }
            }
            // Agregar un espacio entre cada palabra
            cadena += " ";
        }

        return cadena.trim(); // Eliminar espacios adicionales al final de la cadena
    }
}
