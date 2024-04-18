package com.spring.numerosromanos.Services;

import com.spring.numerosromanos.Interfaces.INumeroRomano;
import com.spring.numerosromanos.Utils.NumeroRomanoConverter;
import org.springframework.stereotype.Service;

@Service
public class NumeroRomanoService implements INumeroRomano {

    @Override
    public String intToRomano(int numero) {

        return NumeroRomanoConverter.intToRoman(numero);
    }
}
