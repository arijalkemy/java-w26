package com.example.ejercicio_introduccion_a_spring_p2.service.impl;

import com.example.ejercicio_introduccion_a_spring_p2.service.IConversorDecimalService;
import org.springframework.stereotype.Service;

@Service
public class ConversorDecimalRomanoService implements IConversorDecimalService {
    public String convertir(Integer decimal) {
        String numeroRomano = "";
        Integer decimalAux = decimal;

        // Miles
        while(decimalAux >= 1000) {
            numeroRomano = numeroRomano + "M";
            decimalAux = decimalAux - 1000;
        }

        // Centenas
        if(decimalAux >= 900) {
            numeroRomano = numeroRomano + "CM";
            decimalAux = decimalAux - 900;
        } else {
            if(decimalAux >= 500) {
                numeroRomano = numeroRomano + "D";
                while(decimalAux % 500 > 100) {
                    numeroRomano = numeroRomano + "C";
                    decimalAux = decimalAux - 100;
                }
                decimalAux = decimalAux - 500;
            } else {
                if(decimalAux >= 400) {
                    numeroRomano = numeroRomano + "CD";
                    decimalAux = decimalAux - 400;
                } else {
                    while(decimalAux > 100) {
                        numeroRomano = numeroRomano + "C";
                        decimalAux = decimalAux - 100;
                    }
                }
            }
        }

        // Decenas
        if(decimalAux >= 90) {
            numeroRomano = numeroRomano + "XC";
            decimalAux = decimalAux - 90;
        } else {
            if(decimalAux >= 50) {
                numeroRomano = numeroRomano + "L";
                while(decimalAux % 50 > 10) {
                    numeroRomano = numeroRomano + "X";
                    decimalAux = decimalAux - 10;
                }
                decimalAux = decimalAux - 50;
            } else {
                if(decimalAux >= 40) {
                    numeroRomano = numeroRomano + "XL";
                    decimalAux = decimalAux - 40;
                } else {
                    while(decimalAux >= 10) {
                        numeroRomano = numeroRomano + "X";
                        decimalAux = decimalAux - 10;
                    }
                }
            }
        }

        // Unidades
        if(decimalAux == 9) {
            numeroRomano = numeroRomano + "IX";
        } else {
            if(decimalAux >= 5) {
                numeroRomano = numeroRomano + "V";
                while(decimalAux % 5 >= 1) {
                    numeroRomano = numeroRomano + "I";
                    decimalAux = decimalAux - 1;
                }
            } else {
                if(decimalAux == 4) {
                    numeroRomano = numeroRomano + "IV";
                } else {
                    while(decimalAux % 5 >= 1) {
                        numeroRomano = numeroRomano + "I";
                        decimalAux = decimalAux - 1;
                    }
                }
            }
        }

        return numeroRomano;
    }
}
