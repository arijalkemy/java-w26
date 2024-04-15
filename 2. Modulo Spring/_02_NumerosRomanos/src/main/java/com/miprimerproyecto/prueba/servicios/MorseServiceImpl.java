package com.miprimerproyecto.prueba.servicios;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class MorseServiceImpl implements IRomano {
    @Override
    public String obtenerResultadoEnRomano(int decimal) {
        Map<Integer, String> decimalARomano = new HashMap<>();
        decimalARomano.put(1, "I");
        decimalARomano.put(2, "II");
        decimalARomano.put(3, "III");
        decimalARomano.put(4, "IV");
        decimalARomano.put(5, "V");
        decimalARomano.put(6, "VI");
        decimalARomano.put(7, "VII");
        decimalARomano.put(8, "VIII");
        decimalARomano.put(9, "IX");
        decimalARomano.put(10, "X");
        decimalARomano.put(40, "XL");
        decimalARomano.put(50, "L");
        decimalARomano.put(90, "XC");
        decimalARomano.put(100, "C");
        decimalARomano.put(400, "CD");
        decimalARomano.put(500, "D");
        decimalARomano.put(900, "CM");
        decimalARomano.put(1000, "M");

        StringBuilder romano = new StringBuilder();
        int[] valores = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        for (int valor : valores) {
            while (decimal >= valor) {
                romano.append(decimalARomano.get(valor));
                decimal -= valor;
            }
        }
        return romano.toString();
    }
}
