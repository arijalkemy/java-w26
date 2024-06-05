package org.example.ejercicio2_introduccion_spring_boot_p1_decimal_romano.controladores;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControladorNumeroRomano {

    //Metodo que convierte un numero en base decimal a su equivalente en romano
    @GetMapping("/{numero}")
    public String generarRomano(@PathVariable Integer numero) {
        //Vector de equivalencia en base 10
        int[] vecotor_base_10 = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        //Vector de equivalencia sistema numerico romano
        String[] vector_base_romana = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        //Almacena la cadena numerica en numero romano
        String numeroRomano = "";
        if (numero>0){
            //Recorre el vector base 10
            for (int i = 0; i < vecotor_base_10.length; i++) {
                //conversion
                if(numero >= vecotor_base_10[i]) {
                    numero -= vecotor_base_10[i];
                    numeroRomano = numeroRomano + vector_base_romana[i];
                    i--;
                }
            }
        }else{
            numeroRomano = "No comparable...";
        }
        return numeroRomano;
    }
}