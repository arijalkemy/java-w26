package com.w26.romanos.components;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.w26.romanos.entity.NumericComposition;
import com.w26.romanos.exception.ConversionException;
import com.w26.romanos.repository.RomanConversionMapRepository;

@Component
public class RomanConversorComponent {


    /**
     * Take a number and this is descompose with base 10.
     * 
     * @param number int
     * @return List of NumericComposition Objects. Ej: [[3000, 1000], [500, 100],
     *         [20, 10]]
     */

    @Autowired
    private RomanConversionMapRepository romanMapRepository;

    private List<NumericComposition> numberDescompose(int number) {
        List<NumericComposition> numerosDescompuestos = new ArrayList<>();

        int potencia = 1; // Unidades, *10 Centena
        while (number > 0) {

            Integer digito = number % 10;
            Integer parte = digito * potencia;

            if (parte > 0) {
                numerosDescompuestos.add(NumericComposition.of(parte, potencia));
            }
            number = number / 10;
            potencia = potencia * 10;
        }
        return numerosDescompuestos;
    }

    /**
     * Allow convert Decimal to Roman
     * @param numero
     * @return roman number
     * @throws ConversionException if number to convert is not between 1 and 3999
     */
    public String integerToRoman(int numero) {
        if (!(numero >= 1 && numero <= 3999)) {
            throw new ConversionException("The integer to convert only can be from 1 until 3999.");
        }

        List<NumericComposition> numerosDescompuestos = this.numberDescompose(numero);
        
        String toRoman = "";

        for (int i = numerosDescompuestos.size() - 1; i >= 0; i--) {

            NumericComposition valorPotencia = numerosDescompuestos.get(i);
            int valor = valorPotencia.getNumero();
            int potencia = valorPotencia.getPotencia();

            int unidad = (valor / potencia) % 10;
            String representacion = null;
            if (unidad != 9 && unidad != 4) {

                representacion = this.romanMapRepository.getRoman(valor);

                if (representacion != null) {
                    toRoman += representacion;
                    continue;
                }

                if (unidad <= 3) {
                    representacion = this.romanMapRepository.getRoman(potencia).repeat(unidad);
                    toRoman += representacion;
                    continue;
                }
                int cantidadResta = 0;
                String base = null;
                String complemento = null;

                while (base == null) {
                    int paraProbar = valor - potencia;
                    base = this.romanMapRepository.getRoman(paraProbar);
                    valor = paraProbar;
                    cantidadResta++;
                }
                complemento = this.romanMapRepository.getRoman(potencia).repeat(cantidadResta);
                representacion = base + complemento;
                toRoman += representacion;
                continue;
            }

            String base = this.romanMapRepository.getRoman(valor + potencia);
            String simboloResta = this.romanMapRepository.getRoman(potencia);
            representacion = simboloResta + base;
            toRoman += representacion;
        }

        return toRoman; 
    }
}
