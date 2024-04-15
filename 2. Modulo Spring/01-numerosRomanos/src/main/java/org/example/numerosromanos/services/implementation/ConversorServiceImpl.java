package org.example.numerosromanos.services.implementation;

import org.example.numerosromanos.services.IConversorService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ConversorServiceImpl implements IConversorService {

    @Override
    public String convertirARomano(int num) {
        StringBuilder numeroRomano = new StringBuilder();

        Map<Integer, String> mapRomanos = getMapRomanos();
        List<Integer> decimales = new ArrayList<>(List.of(1000,900,500,400,100,90,50,40,10,9,5,4,1));

        for (Integer decimal : decimales) {
            // chequea si el numero es mayor o menor a ese decimal, para ver que letras componen al numero romano
            while (num >= decimal) {
                numeroRomano.append(mapRomanos.get(decimal));
                num = num - decimal;
            }
        }

        return numeroRomano.toString();
    }

    private Map<Integer, String> getMapRomanos() {
        Map<Integer, String> mapRomanos = new HashMap<>();
        mapRomanos.put(1, "I");
        mapRomanos.put(4, "IV");
        mapRomanos.put(5, "V");
        mapRomanos.put(9, "IX");
        mapRomanos.put(10, "X");
        mapRomanos.put(40, "XL");
        mapRomanos.put(50, "L");
        mapRomanos.put(90, "XC");
        mapRomanos.put(100, "C");
        mapRomanos.put(400, "CD");
        mapRomanos.put(500, "D");
        mapRomanos.put(900, "CM");
        mapRomanos.put(1000, "M");
        return mapRomanos;
    }
}
