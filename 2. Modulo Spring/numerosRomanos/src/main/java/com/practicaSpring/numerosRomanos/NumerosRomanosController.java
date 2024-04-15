package com.practicaSpring.numerosRomanos;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NumerosRomanosController {

    @GetMapping("/{number}")
    public String toNumeroRomano(@PathVariable int number){
        return toMiles(Math.floorDiv(number, 1000)) +
                toCentenas(Math.floorDiv(number, 100) % 10) +
                toDecenas(Math.floorDiv(number, 10) % 10) +
                toUnidades(number % 10);
    }

    private String toUnidades(int i) {
        return switch (i) {
            case 1 -> "I";
            case 2 -> "II";
            case 3 -> "III";
            case 4 -> "IV";
            case 5 -> "V";
            case 6 -> "VI";
            case 7 -> "VII";
            case 8 -> "VIII";
            case 9 -> "IX";
            default -> "";
        };
    }

    private String toDecenas(int i) {
        return switch (i) {
            case 1 -> "X";
            case 2 -> "XX";
            case 3 -> "XXX";
            case 4 -> "XL";
            case 5 -> "L";
            case 6 -> "LX";
            case 7 -> "LXX";
            case 8 -> "LXXX";
            case 9 -> "XC";
            default -> "";
        };
    }

    private String toCentenas(int i) {
        return switch (i) {
            case 1 -> "C";
            case 2 -> "CC";
            case 3 -> "CCC";
            case 4 -> "CD";
            case 5 -> "D";
            case 6 -> "DC";
            case 7 -> "DCC";
            case 8 -> "DCCC";
            case 9 -> "CM";
            default -> "";
        };
    }

    private String toMiles(int i) {
        StringBuilder ms = new StringBuilder();
        for(int j = 0; j < i; j++) {
            ms.append("M");
        }
        return ms.toString();
        // No sé cómo hace M con raya arriba, eso ayudaría para números grandes.
    }

}
