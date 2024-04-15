package com.miprimirproyecto.pruebaspring.Clases;

import java.util.HashMap;

public class NumeroRomano {

    String unidad[] = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"}; //Declaro un array el cual pongo los numero romano los cuales voy a usar
    String decena[] = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
    String centena[] = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
    String miles = "";
    public NumeroRomano() {

    }

    public String convertirNumeroARomano(Integer number) {
        Integer m ;
        String result ;
        Integer resto = number;
        m = resto / 1000; //3950/1000=3
        resto = resto % 1000;  //950

        int c = resto / 100; //9
        resto = resto % 100; // 50

        int d = resto / 10; //5
        resto = resto % 10; // 0

        int u = resto;
        for (int i = 1; i <= m; i++) {
            miles += "M";
        }
        if (number >= 1000) {
            result = miles + centena[c] + decena[d] + unidad[u];
        } else if (number >= 100) {
            result = centena[c] + decena[d] + unidad[u];
        } else {
            if (number>= 10) {
                result = decena[d] + unidad[u];
            } else {
                result =  unidad[number];
            }
        }
        return  result;
    }

}
