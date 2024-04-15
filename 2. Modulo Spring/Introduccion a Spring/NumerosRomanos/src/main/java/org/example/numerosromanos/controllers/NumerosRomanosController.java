package org.example.numerosromanos.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NumerosRomanosController {

    final String[] letrasRomanas = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
    final int[] valoresLetrasRomanas = {1000,900,500,400,100,90,50,40,10,9,5,4,1};


    @GetMapping("/{numeroDecimal}")
    public String convertir(@PathVariable int numeroDecimal){
        StringBuilder ret = new StringBuilder();
        for (int i = 0; i < letrasRomanas.length; i++) {
            while (numeroDecimal >= valoresLetrasRomanas[i]) {
                numeroDecimal = numeroDecimal - valoresLetrasRomanas[i];
                ret.append(letrasRomanas[i]);
            }
        }
        return String.valueOf(ret);
    }
}
