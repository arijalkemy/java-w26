package org.example.spring_demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

@RestController
public class MainController {

    @GetMapping("/{param}")
    public String getMain(@PathVariable String param){
        return fromDecimalToRoman(param);
    }

    private static String fromDecimalToRoman(String numero){
        StringBuilder numeroRomano = new StringBuilder();
        Map<Character, String> unidades = new HashMap<>();
        unidades.put('0', "");
        unidades.put('1', "I");
        unidades.put('2', "II");
        unidades.put('3', "III");
        unidades.put('4', "IV");
        unidades.put('5', "V");
        unidades.put('6', "VI");
        unidades.put('7', "VII");
        unidades.put('8', "VIII");
        unidades.put('9', "IX");

        Map<Character, String> decenas = new LinkedHashMap<>();
        decenas.put('0', "");
        decenas.put('1', "X");
        decenas.put('2', "XX");
        decenas.put('3', "XXX");
        decenas.put('4', "XL");
        decenas.put('5', "L");
        decenas.put('6', "LX");
        decenas.put('7', "LXX");
        decenas.put('8', "LXXX");
        decenas.put('9', "XC");

        Map<Character, String> centenas = new LinkedHashMap<>();
        centenas.put('0', "");
        centenas.put('1', "C");
        centenas.put('2', "CC");
        centenas.put('3', "CCC");
        centenas.put('4', "CD");
        centenas.put('5', "D");
        centenas.put('6', "DC");
        centenas.put('7', "DCC");
        centenas.put('8', "DCCC");
        centenas.put('9', "CM");

        Map<Character, String> milesimas = new LinkedHashMap<>();
        milesimas.put('1', "M");
        milesimas.put('2', "MM");
        milesimas.put('3', "MMM");

        int i = numero.length();
        int loopCounter = 1;
        String[] listaNumerosRomanos = new String[numero.length()];

        while (i != 0)
        {
            switch(loopCounter){
                case 1:
                    listaNumerosRomanos[loopCounter - 1] = unidades.get(numero.charAt(i - 1));
                    break;
                case 2:
                    listaNumerosRomanos[loopCounter - 1] = decenas.get(numero.charAt(i - 1));
                    break;

                case 3:
                    listaNumerosRomanos[loopCounter - 1] = centenas.get(numero.charAt(i - 1));
                    break;
                case 4:
                    listaNumerosRomanos[loopCounter - 1] = milesimas.get(numero.charAt(i - 1));
                    break;
            }
            i -- ;
            loopCounter += 1;
        }
        for (int j = listaNumerosRomanos.length -1; j >= 0; j--){
            numeroRomano.append(listaNumerosRomanos[j]);
        }
        return numeroRomano.toString();
    }

}