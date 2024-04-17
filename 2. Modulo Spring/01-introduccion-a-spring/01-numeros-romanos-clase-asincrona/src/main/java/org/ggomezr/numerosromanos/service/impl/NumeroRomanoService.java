package org.ggomezr.numerosromanos.service.impl;

import org.ggomezr.numerosromanos.service.INumeroRomanoService;
import org.springframework.stereotype.Service;

@Service
public class NumeroRomanoService implements INumeroRomanoService {

    @Override
    public String convertirANumeroRomano(int numero) {
        int[] valores = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] simbolos = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        int indice = 0;


        if(numero <= 0 || numero > 3999){
            return "<h1>El numero " + numero +" esta fuera de rango</h1>";
        }

        StringBuilder resultado = new StringBuilder("<h1>Numero Romano de " + numero + ": ");

        while (numero > 0) {
            if (numero - valores[indice] >= 0) {
                resultado.append(simbolos[indice]);
                numero -= valores[indice];
            } else {
                indice++;
            }
        }
        resultado.append("</h1>");
        return resultado.toString();
    }
}