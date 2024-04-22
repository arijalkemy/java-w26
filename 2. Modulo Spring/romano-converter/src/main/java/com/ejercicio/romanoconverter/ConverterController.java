package com.ejercicio.romanoconverter;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConverterController {

    @GetMapping("/convertirARomano")
    public String hello(@RequestParam int numeroDecimal){

        int unidades = numeroDecimal % 10;
        numeroDecimal /= 10;

        int decenas = numeroDecimal % 10;
        numeroDecimal /= 10;

        int centenas = numeroDecimal % 10;
        numeroDecimal /= 10;

        int millares = numeroDecimal;

        String numeroConvertido = "";
        if (millares != 0 && millares <= 3){
            if(millares == 1){
                numeroConvertido +=  "M";
            }else if(millares == 2){
                numeroConvertido +=  "MM";
            }else if(millares == 3){
                numeroConvertido +=  "MMM";
            }
        }
        if(centenas !=0 ){
            switch (centenas){
                case 1: numeroConvertido += "C";
                break;
                case 2: numeroConvertido += "CC";
                break;
                case 3: numeroConvertido += "CCC";
                break;
                case 4: numeroConvertido += "CD";
                break;
                case 5: numeroConvertido += "D";
                break;
                case 6: numeroConvertido += "DC";
                break;
                case 7: numeroConvertido += "DCC";
                break;
                case 8: numeroConvertido += "DCCC";
                break;
                case 9: numeroConvertido += "CM";
                break;


            }

        }
        if(decenas !=0 ){
            switch (decenas){
                case 1: numeroConvertido += "X";
                    break;
                case 2: numeroConvertido += "XX";
                    break;
                case 3: numeroConvertido += "XXX";
                    break;
                case 4: numeroConvertido += "XL";
                    break;
                case 5: numeroConvertido += "L";
                    break;
                case 6: numeroConvertido += "LX";
                    break;
                case 7: numeroConvertido += "LXX";
                    break;
                case 8: numeroConvertido += "LXXX";
                    break;
                case 9: numeroConvertido += "XC";
                    break;


            }

        }
        if(unidades !=0 ){
            switch (unidades){
                case 1: numeroConvertido += "I";
                    break;
                case 2: numeroConvertido += "II";
                    break;
                case 3: numeroConvertido += "III";
                    break;
                case 4: numeroConvertido += "IV";
                    break;
                case 5: numeroConvertido += "V";
                    break;
                case 6: numeroConvertido += "VI";
                    break;
                case 7: numeroConvertido += "VII";
                    break;
                case 8: numeroConvertido += "VIII";
                    break;
                case 9: numeroConvertido += "IX";
                    break;


            }

        }



        return "el numero es "  + numeroConvertido;


    }
}
