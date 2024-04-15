package com.numeros.romanos.service.impl;

import com.numeros.romanos.service.INumerosRomanosService;
import org.springframework.stereotype.Service;

@Service
public class NumerosRomanosServiceImpl implements INumerosRomanosService {

    @Override
    public String getNumeroRomano(Integer numero){

        StringBuilder numeroRomano = new StringBuilder();
        int[] numerosAComparar = {1000,900,500,400,100,90,50,40,10, 9, 5, 4, 1};
        String[] numerosRomanosList = {"M","CM","D","CD","C","XC","L","XL", "X", "IX", "V", "IV", "I"};

        for (int i = 0; i < numerosAComparar.length; i++)
            for (;numero >= numerosAComparar[i]; numero -= numerosAComparar[i])
                numeroRomano.append(numerosRomanosList[i]);

        return numeroRomano.toString();

    }
}
