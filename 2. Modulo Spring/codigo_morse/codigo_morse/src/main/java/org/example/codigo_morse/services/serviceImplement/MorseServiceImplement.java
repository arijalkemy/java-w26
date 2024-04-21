package org.example.codigo_morse.services.serviceImplement;

import org.example.codigo_morse.services.IMorseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.*;

@Service
public class MorseServiceImplement implements IMorseService {

    Map<String, String> morseToLetter;
    Map<String, String> letterToMorse;
    public MorseServiceImplement(@Autowired Map<String, String> morseToLetter, @Autowired Map<String, String> letterToMorse) {
        this.morseToLetter = morseToLetter;
        this.letterToMorse = letterToMorse;
    }

    @Override
    public String translateToWords(String code) {
        String finalText = "";
        /*
        String [] palabras = texto.split(" {3}");

        for (String palabra : palabras) {
            String[] letras = palabra.split(" ");
            Map<String , String> mapa = new HashMap<>();
            for (String letra : letras) {
                if(letra.equals(" ")){
                    finalText += letra;
                }
                else {
                    if(! this.morseToLetter.containsKey(letra)) throw
                            new IllegalArgumentException("La frase contiene una letra o caracter no controlado");
                    finalText += this.morseToLetter.get(letra);
                }
                finalText += " ";
            }
        }*/
        List<String> result = new ArrayList<>();
        Arrays.stream(code.split(" {3}")).forEach(currentWord ->{
                List<String> word = Arrays.stream(currentWord.split(" ")).map(String::trim).toList();
                result.add(String.join("",word.stream().map(x-> {
                    if (!this.morseToLetter.containsKey(x)) throw new IllegalArgumentException("El texto tiene un caracter no controlado");
                    return this.morseToLetter.get(x);
                }).toList()));
        });
        return String.join(" ", result);
    }



    @Override
    public String translateToMorse(String text) {
        text=text.toUpperCase();
        String finalText = "";
        List<String> words = Arrays.stream(text.split(" ")).map(word ->
            String.join(" ", Arrays.stream(word.split("")).map( letter -> {
                if(!this.letterToMorse.containsKey(letter)) throw new IllegalArgumentException("El texto tiene un caracter no controlado");
                return this.letterToMorse.get(letter);
            }).toList())).toList();
        finalText = String.join("   ", words);

        /*
        String[] letters = text.split("");

        for (String letter : letters) {

            if (letter.equals(" ")) {
                textoFinal += "  ";
            }
            else {
                if(!this.letterToMorse.containsKey(letter)) throw new IllegalArgumentException("El texto tiene un caracter no controlado");
                finalText += this.letterToMorse.get(letter)+" ";
            }

        }*/
        return finalText;
    }
}
