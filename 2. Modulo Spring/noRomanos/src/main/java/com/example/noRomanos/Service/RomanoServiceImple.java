package com.example.noRomanos.Service;

import org.springframework.stereotype.Service;

@Service
public class RomanoServiceImple implements RomanoService {


    @Override
    public String numeroARomano(int decimal) {
        if(decimal == 0){
            return "NULLA";
        }
        int[] valores = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String[] letrasRomanos = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        StringBuilder romano = new StringBuilder();
        for(int i=0;i<valores.length;i++)
        {
            while(decimal >= valores[i])
            {
                decimal = decimal - valores[i];
                romano.append(letrasRomanos[i]);
            }
        }
        return romano.toString();
    }
}
