package com.example.numerosromanos.service.serviceimp;

import org.springframework.stereotype.Service;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;

@Service
public class NumerosRomanosService implements INumerosRomanos {
    @Override
    public String convertirDecimalARomanos(int decimal) {
        final List<AbstractMap.SimpleEntry<Integer, String>> NUMEROS_ROMANOS = new ArrayList<>() {{
            add(new AbstractMap.SimpleEntry<>(1000, "M"));
            add(new AbstractMap.SimpleEntry<>(900, "CM"));
            add(new AbstractMap.SimpleEntry<>(500, "D"));
            add(new AbstractMap.SimpleEntry<>(400, "CD"));
            add(new AbstractMap.SimpleEntry<>(100, "C"));
            add(new AbstractMap.SimpleEntry<>(90, "XC"));
            add(new AbstractMap.SimpleEntry<>(50, "L"));
            add(new AbstractMap.SimpleEntry<>(40, "XL"));
            add(new AbstractMap.SimpleEntry<>(10, "X"));
            add(new AbstractMap.SimpleEntry<>(9, "IX"));
            add(new AbstractMap.SimpleEntry<>(5, "V"));
            add(new AbstractMap.SimpleEntry<>(4, "IV"));
            add(new AbstractMap.SimpleEntry<>(1, "I"));
        }};

        int maxValue = 3999;
        int minValue = 1;

        StringBuilder resultado = new StringBuilder();

        if (decimal < minValue || decimal > maxValue) {
            return ("El valor maximo es " + maxValue + " y el valor del minimo es " + minValue + ".");
        }

        for (AbstractMap.SimpleEntry<Integer, String> numeroRomano : NUMEROS_ROMANOS) {
            int valor = numeroRomano.getKey();
            String letraRomana = numeroRomano.getValue();
            while (decimal >= valor) {
                resultado.append(letraRomana); // Agregar el símbolo romano al resultado
                decimal -= valor; // Restar el valor romano del número
            }
        }

        return resultado.toString();
    }

}
