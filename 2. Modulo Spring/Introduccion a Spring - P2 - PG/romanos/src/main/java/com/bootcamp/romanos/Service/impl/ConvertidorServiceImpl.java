package com.bootcamp.romanos.Service.impl;

import com.bootcamp.romanos.Service.IConvertidorService;
import org.springframework.stereotype.Service;

@Service
public class ConvertidorServiceImpl implements IConvertidorService {
    @Override
    public String convertirANumerosRomanos(int numero) {
        StringBuilder romano = new StringBuilder();
        int[] decimales = {1,4,5,9,10,40,50,90,100,400,500,900,1000};
        String[] romanos= {"I","IV","V","IX","X","XL", "L","XC","C","CD","D","CM","M"};
        for (int i=decimales.length-1;i>=0;i--) {
            while (numero>=decimales[i]) {
                numero-=decimales[i];
                romano.append(romanos[i]);
            }
        }
        return romano.toString();
    }
}
