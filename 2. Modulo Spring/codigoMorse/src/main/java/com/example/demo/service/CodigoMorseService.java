package com.example.demo.service;

import org.springframework.stereotype.Service;

@Service
public class CodigoMorseService implements ICodigoMorseService{

    @Override
    public String traducirAEspanol(String codigoMorse) {
        String[] listaDePalabras = codigoMorse.split(" {3}");
        StringBuilder fraseEnEspanol = new StringBuilder();
        for(String palabra : listaDePalabras) {
            String[] listaDeLetras = palabra.split(" ");
            for(String letra : listaDeLetras) {
                switch (letra) {
                    case ".-" -> fraseEnEspanol.append("A");
                    case "-..." -> fraseEnEspanol.append("B");
                    case "-.-." -> fraseEnEspanol.append("C");
                    case "-.." -> fraseEnEspanol.append("D");
                    case "." -> fraseEnEspanol.append("E");
                    case "..-." -> fraseEnEspanol.append("F");
                    case "--." -> fraseEnEspanol.append("G");
                    case "...." -> fraseEnEspanol.append("H");
                    case ".." -> fraseEnEspanol.append("I");
                    case ".---" -> fraseEnEspanol.append("J");
                    case "-.-" -> fraseEnEspanol.append("K");
                    case ".-.." -> fraseEnEspanol.append("L");
                    case "--" -> fraseEnEspanol.append("M");
                    case "-." -> fraseEnEspanol.append("N");
                    case "---" -> fraseEnEspanol.append("O");
                    case ".--." -> fraseEnEspanol.append("P");
                    case "--.-" -> fraseEnEspanol.append("Q");
                    case ".-." -> fraseEnEspanol.append("R");
                    case "..." -> fraseEnEspanol.append("S");
                    case "-" -> fraseEnEspanol.append("T");
                    case "..-" -> fraseEnEspanol.append("U");
                    case "...-" -> fraseEnEspanol.append("V");
                    case ".--" -> fraseEnEspanol.append("W");
                    case "-..-" -> fraseEnEspanol.append("X");
                    case "-.--" -> fraseEnEspanol.append("Y");
                    case "--.." -> fraseEnEspanol.append("Z");
                    //numbers
                    case ".----" -> fraseEnEspanol.append("1");
                    case "..---" -> fraseEnEspanol.append("2");
                    case "...--" -> fraseEnEspanol.append("3");
                    case "....-" -> fraseEnEspanol.append("4");
                    case "....." -> fraseEnEspanol.append("5");
                    case "-...." -> fraseEnEspanol.append("6");
                    case "--...." -> fraseEnEspanol.append("7");
                    case "---.." -> fraseEnEspanol.append("8");
                    case "----." -> fraseEnEspanol.append("9");
                    case "-----" -> fraseEnEspanol.append("0");
                    //signs
                    case "..--.." -> fraseEnEspanol.append("?");
                    case "-.-.--" -> fraseEnEspanol.append("!");
                    case ".-.-.--" -> fraseEnEspanol.append(".");
                    case "--..--" -> fraseEnEspanol.append(",");
                    //signos no reconocidos
                    default -> fraseEnEspanol.append("-");
                }
            }
            fraseEnEspanol.append(" ");
        }
        return fraseEnEspanol.toString();
    }

    @Override
    public String traducirAMorse(String fraseEnEspanol) {
        String[] listaDePalabras = fraseEnEspanol.split(" ");
        StringBuilder fraseMorse = new StringBuilder();
        for(String palabra : listaDePalabras) {
            String[] listaDeLetras = palabra.split("");
            for(String letra : listaDeLetras) {
                switch (letra) {
                    case "A": fraseMorse.append(".-");
                    case "B": fraseMorse.append("-...");
                    case "C": fraseMorse.append("-.-.");
                    case "D": fraseMorse.append("-..");
                    case "E": fraseMorse.append(".");
                    case "F": fraseMorse.append("..-.");
                    case "G": fraseMorse.append("--.");
                    case "H": fraseMorse.append("....");
                    case "I": fraseMorse.append("..");
                    case "J": fraseMorse.append(".---");
                    case "K": fraseMorse.append("-.-");
                    case "L": fraseMorse.append(".-..");
                    case "M": fraseMorse.append("--");
                    case "N": fraseMorse.append("-.");
                    case "O": fraseMorse.append("---");
                    case "P": fraseMorse.append(".--.");
                    case "Q": fraseMorse.append("--.-");
                    case "R": fraseMorse.append(".-.");
                    case "S": fraseMorse.append("...");
                    case "T": fraseMorse.append("-");
                    case "U": fraseMorse.append("..-");
                    case "V": fraseMorse.append("...-");
                    case "W": fraseMorse.append(".--");
                    case "X": fraseMorse.append("-..-");
                    case "Y": fraseMorse.append("-.--");
                    case "Z": fraseMorse.append("--..");
                    case "1": fraseMorse.append(".----");
                    case "2": fraseMorse.append("..---");
                    case "3": fraseMorse.append("...--");
                    case "4": fraseMorse.append("....-");
                    case "5": fraseMorse.append(".....");
                    case "6": fraseMorse.append("-....");
                    case "7": fraseMorse.append("--....");
                    case "8": fraseMorse.append("---..");
                    case "9": fraseMorse.append("----.");
                    case "0": fraseMorse.append("-----");
                    case "?": fraseMorse.append("..--..");
                    case "!": fraseMorse.append("-.-.--");
                    case ".": fraseMorse.append(".-.-.--");
                    case ",": fraseMorse.append("--..--");
                }
            }
            fraseMorse.append(" ");
        }
        return fraseMorse.toString();
    }
}
