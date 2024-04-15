package com.example.codigoMorse.services;

import org.springframework.stereotype.Service;

@Service
public class MorseParserServiceImpl implements IMorseParserService {
    @Override
    public String translation(String code) {
        String[] list = code.split(" {3}");
        StringBuilder spanishPhrase = new StringBuilder();
        for (String word : list) {
            String[] splittedWord = word.split(" ");
            for (String letter : splittedWord) {
                switch (letter) {
                    case ".-" -> spanishPhrase.append("A");
                    case "-..." -> spanishPhrase.append("B");
                    case "-.-." -> spanishPhrase.append("C");
                    case "-.." -> spanishPhrase.append("D");
                    case "." -> spanishPhrase.append("E");
                    case "..-." -> spanishPhrase.append("F");
                    case "--." -> spanishPhrase.append("G");
                    case "...." -> spanishPhrase.append("H");
                    case ".." -> spanishPhrase.append("I");
                    case ".---" -> spanishPhrase.append("J");
                    case "-.-" -> spanishPhrase.append("K");
                    case ".-.." -> spanishPhrase.append("L");
                    case "--" -> spanishPhrase.append("M");
                    case "-." -> spanishPhrase.append("N");
                    case "---" -> spanishPhrase.append("O");
                    case ".--." -> spanishPhrase.append("P");
                    case "--.-" -> spanishPhrase.append("Q");
                    case ".-." -> spanishPhrase.append("R");
                    case "..." -> spanishPhrase.append("S");
                    case "-" -> spanishPhrase.append("T");
                    case "..-" -> spanishPhrase.append("U");
                    case "...-" -> spanishPhrase.append("V");
                    case ".--" -> spanishPhrase.append("W");
                    case "-..-" -> spanishPhrase.append("X");
                    case "-.--" -> spanishPhrase.append("Y");
                    case "--.." -> spanishPhrase.append("Z");
                    //numbers
                    case ".----" -> spanishPhrase.append("1");
                    case "..---" -> spanishPhrase.append("2");
                    case "...--" -> spanishPhrase.append("3");
                    case "....-" -> spanishPhrase.append("4");
                    case "....." -> spanishPhrase.append("5");
                    case "-...." -> spanishPhrase.append("6");
                    case "--...." -> spanishPhrase.append("7");
                    case "---.." -> spanishPhrase.append("8");
                    case "----." -> spanishPhrase.append("9");
                    case "-----" -> spanishPhrase.append("0");
                    //signs
                    case "..--.." -> spanishPhrase.append("?");
                    case "-.-.--" -> spanishPhrase.append("!");
                    case ".-.-.--" -> spanishPhrase.append(".");
                    case "--..--" -> spanishPhrase.append(",");
                    //signos no reconocidos
                    default -> spanishPhrase.append("-");
                }
            }
            //spanishPhrase.append(asd);
            spanishPhrase.append(" ");
        }

        return spanishPhrase.toString();
    }
}
