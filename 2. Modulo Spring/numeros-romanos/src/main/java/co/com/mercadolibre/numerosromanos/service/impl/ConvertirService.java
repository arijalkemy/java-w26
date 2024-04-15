package co.com.mercadolibre.numerosromanos.service.impl;

import co.com.mercadolibre.numerosromanos.service.IConvertirService;
import org.springframework.stereotype.Service;

@Service
public class ConvertirService implements IConvertirService {

    @Override
    public String convertir(Integer numero) {
        String numeroRomano = "";
        if (validarRangoNumero(numero)) {
            numeroRomano = convertirRomano(numero);
        }
        return numeroRomano;
    }

    private Boolean validarRangoNumero(Integer numero) {
        if (numero < 1 || numero > 3999) {
            return false;
        }
        return true;
    }

    private String convertirRomano(Integer numero) {
        String[] unidades = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
        String[] decenas = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        String[] centenas = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
        String[] miles = {"", "M", "MM", "MMM"};
        Integer indexMil, indexCen, indexDec, indexUni;

        indexMil = numero / 1000;
        numero = numero % 1000;
        indexCen = numero / 100;
        numero = numero % 100;
        indexDec = numero / 10;
        numero = numero % 10;
        indexUni = numero;

        return miles[indexMil] + centenas[indexCen] + decenas[indexDec] + unidades[indexUni];
    }
}
