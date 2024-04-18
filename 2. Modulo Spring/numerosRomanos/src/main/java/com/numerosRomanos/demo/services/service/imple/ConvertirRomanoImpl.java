package com.numerosRomanos.demo.services.service.imple;

import com.numerosRomanos.demo.services.IConvertirRomanoService;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.Map;


@Service
public class ConvertirRomanoImpl implements IConvertirRomanoService {
    private static final Map<Integer, String> numerosRomano = new LinkedHashMap<>();
    static {
        numerosRomano.put(1000, "M");
        numerosRomano.put(900, "CM");
        numerosRomano.put(500, "D");
        numerosRomano.put(400, "CD");
        numerosRomano.put(100, "C");
        numerosRomano.put(90, "XC");
        numerosRomano.put(50, "L");
        numerosRomano.put(40, "XL");
        numerosRomano.put(10, "X");
        numerosRomano.put(9, "IX");
        numerosRomano.put(5, "V");
        numerosRomano.put(4, "IV");
        numerosRomano.put(1, "I");
    }
    @Override
    public String convertirRomano(Integer romano) {
        StringBuilder resultado = new StringBuilder();
        for (Map.Entry<Integer, String> entry : numerosRomano.entrySet()) {
            int valor = entry.getKey();
            String simboloRomano = entry.getValue();
            while (romano >= valor) {
                resultado.append(simboloRomano);
                romano -= valor;
            }
        }
        return resultado.toString();
    }
}
