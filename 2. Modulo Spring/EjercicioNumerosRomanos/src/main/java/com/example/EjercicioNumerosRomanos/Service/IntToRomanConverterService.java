package com.example.EjercicioNumerosRomanos.Service;

import org.springframework.stereotype.Service;

@Service
public class IntToRomanConverterService {
    public String convertIntToRoman(int num) {
        int[] valores={1000,900,500,400,100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] valoresRomanos={"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        StringBuilder resultado=new StringBuilder();
        for(int i=0; i<valores.length; i++){
            while(num>=valores[i]){
                num-=valores[i];
                resultado.append(valoresRomanos[i]);
            }
        }
        return resultado.toString();
    }
}
