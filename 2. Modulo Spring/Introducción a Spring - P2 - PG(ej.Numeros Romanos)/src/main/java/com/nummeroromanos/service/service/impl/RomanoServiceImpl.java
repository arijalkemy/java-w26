package com.nummeroromanos.service.service.impl;

import com.nummeroromanos.service.IRomanosService;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class RomanoServiceImpl implements IRomanosService {
    @Override
    public String convertirDeDecimalANumeroRomano(int numero) {
        HashMap<Integer, String> map = new HashMap<>();
        map.put(1, "I");
        map.put(4, "IV");
        map.put(5, "V");
        map.put(9, "IX");
        map.put(10, "X");
        map.put(40, "XL");
        map.put(50, "L");
        map.put(90, "XC");
        map.put(100, "C");
        map.put(400, "CD");
        map.put(500, "D");
        map.put(900, "CM");
        map.put(1000, "M");

        StringBuilder resultado = new StringBuilder();

        // Array de los dígitos del número decimal
        int[] digitos = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};

        // Convertir el número decimal a romano
        for (int i : digitos) {
            while (numero >= i) {
                resultado.append(map.get(i));
                numero -= i;
            }
        }

        return resultado.toString();
    }
}
