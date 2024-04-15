package org.miprimerproyecto.numerosromanos;

public class Conversor {

    public static String convertirANumeroRomano(int numero) {
        if (numero < 1 || numero > 1000) {
            throw new IllegalArgumentException("El número debe estar entre 1 y 1000.");
        }

        String[] unidades = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
        String[] decenas = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        String[] centenas = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
        String[] miles = {"", "M", "MM", "MMM"};

        int unidad = numero % 10;
        int decena = (numero / 10) % 10;
        int centena = (numero / 100) % 10;
        int millar = (numero / 1000) % 10;

        return miles[millar] + centenas[centena] + decenas[decena] + unidades[unidad];
    }
}
