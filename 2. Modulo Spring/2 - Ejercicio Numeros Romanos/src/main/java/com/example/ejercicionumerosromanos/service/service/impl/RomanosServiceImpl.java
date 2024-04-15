package com.example.ejercicionumerosromanos.service.service.impl;

import com.example.ejercicionumerosromanos.service.IRomanosService;
import org.springframework.stereotype.Service;

@Service
public class RomanosServiceImpl implements IRomanosService {
    @Override
    public int convertToDecimal(String romanNumber) {
        romanNumber = romanNumber.toUpperCase();

        int decimal = 0;
        int nuevoNumero = 0;
        int anterior = 0;

        //Recorro cada caracer del string recibido
        for (int i = 0; i < romanNumber.length(); i++) {
            nuevoNumero = charToInt( romanNumber.charAt(i) );
            decimal = decimal + nuevoNumero;

            //se calcula el valor en decimal para el número romano pasado como parámetro
            if(anterior < nuevoNumero)
            {
                decimal = decimal - anterior*2;
            }

            anterior = nuevoNumero;

        }

        return decimal;
    }

    private int charToInt( char c ){
        int nuevoNumero = 0;
        switch (c) {
            case 'I':
                nuevoNumero = 1;
                break;
            case 'V':
                nuevoNumero = 5;
                break;
            case 'X':
                nuevoNumero = 10;
                break;
            case 'L':
                nuevoNumero = 50;
                break;
            case 'C':
                nuevoNumero = 100;
                break;
            case 'D':
                nuevoNumero = 500;
                break;
            case 'M':
                nuevoNumero = 1000;
                break;
            default:
                nuevoNumero = 0;
        }
        return nuevoNumero;
    }
}
