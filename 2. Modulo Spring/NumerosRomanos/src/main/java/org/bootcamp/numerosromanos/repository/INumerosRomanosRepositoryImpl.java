package org.bootcamp.numerosromanos.repository;

import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.HashMap;
import java.util.Map;

@Repository
public class INumerosRomanosRepositoryImpl implements INumerosRomanosRepository {

        private static final Map<Integer, String> nroDecimalARomano = new LinkedHashMap<>();
        private static final Map<String, Integer> romanosADecimal = new HashMap<>();

        static {
            nroDecimalARomano.put(1000, "M");
            nroDecimalARomano.put(900, "CM");
            nroDecimalARomano.put(500, "D");
            nroDecimalARomano.put(400, "CD");
            nroDecimalARomano.put(100, "C");
            nroDecimalARomano.put(90, "XC");
            nroDecimalARomano.put(50, "L");
            nroDecimalARomano.put(40, "XL");
            nroDecimalARomano.put(10, "X");
            nroDecimalARomano.put(9, "IX");
            nroDecimalARomano.put(5, "V");
            nroDecimalARomano.put(4, "IV");
            nroDecimalARomano.put(1, "I");

            for (Map.Entry<Integer, String> entry : nroDecimalARomano.entrySet()) {
                romanosADecimal.put(entry.getValue(), entry.getKey());
            }
        }
        @Override
        public String convertirNroDecimalARomano(Integer numeroDecimal) {
            StringBuilder nroRomano = new StringBuilder();
            for (Map.Entry<Integer, String> entry : nroDecimalARomano.entrySet()) {
                while (numeroDecimal >= entry.getKey()) {
                    nroRomano.append(entry.getValue());
                    numeroDecimal -= entry.getKey();
                }
            }
            return nroRomano.toString();
        }



    @Override
    public Integer convertirNroRomanoADecimal(String numeroRomano) {
        int decimal = 0;
        for (int i = 0; i < numeroRomano.length(); i++) {
            String simboloActual = numeroRomano.substring(i, i + 1);
            Integer valorActual = romanosADecimal.get(simboloActual);

            if (i + 1 < numeroRomano.length()) {
                String simboloSiguiente = numeroRomano.substring(i + 1, i + 2);
                Integer valorSiguiente = romanosADecimal.get(simboloSiguiente);

                if (valorActual < valorSiguiente) {
                    decimal -= valorActual;
                } else {
                    decimal += valorActual;
                }
            } else {
                decimal += valorActual;
            }
        }
        return decimal;
    }
}
