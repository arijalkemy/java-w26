package com.meli.morse.servicies;

import com.meli.morse.servicies.interfaces.ITraductorARomanos;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class TraductorRomanosImp implements ITraductorARomanos {

    static  Map<Character, Integer> romanToDecimal = new LinkedHashMap<>();
    static {
        romanToDecimal.put('M', 1000);
        romanToDecimal.put('D', 500);
        romanToDecimal.put('C', 100);
        romanToDecimal.put('L', 50);
        romanToDecimal.put('X', 10);
        romanToDecimal.put('V', 5);
        romanToDecimal.put('I', 1);
    }
    @Override
    public String deDecimalARomano(Integer numeroDecimal) {
        if (numeroDecimal <= 0 || numeroDecimal > 5000) {
            return "Dato fuera de rango";
        }

        String  resultado = "";
        for (Map.Entry<Character, Integer> entry : romanToDecimal.entrySet()) {
            char letraRomana = entry.getKey();
            int valorDecimal = entry.getValue();

            while (numeroDecimal >= valorDecimal) {
                resultado += (letraRomana);
                numeroDecimal -= valorDecimal;
            }
        }
        return resultado;
    }

    @Override
    public Integer deRomanoADecimal(String numeroRomano) {


        int decimal = 0;
        int prevValue = 0;

        for (int i = numeroRomano.length() - 1; i >= 0; i--) {
            if (romanToDecimal.containsKey(numeroRomano.charAt(i))) {
                int value = romanToDecimal.get(numeroRomano.charAt(i));

                if (value < prevValue) {
                    decimal -= value;
                } else {
                    decimal += value;
                }
                prevValue = value;
            } else {
                decimal = 0;
                break;
            }
        }

        return decimal;
    }
}
