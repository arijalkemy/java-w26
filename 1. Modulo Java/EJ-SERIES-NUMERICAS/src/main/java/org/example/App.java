package org.example;

import modelo.Serie;
import modelo.SumatoriaDe2;
import modelo.SumatoriaDe3;

public class App
{
    public static void main( String[] args )
    {
        Serie sumarDos = new SumatoriaDe2(0);

        Serie sumarTres = new SumatoriaDe3(0);

        System.out.println("IMPRIMIR CUATRO VEZ SUMATORIA DE 2, VALOR INICIAL 0 (DEFECTO)");
        for (int i = 0; i<4; i++){
            System.out.println(sumarDos.valorSiguiente());
        }


        System.out.println("IMPRIMIR CUATRO VEZ SUMATORIA DE 2, VALOR INICIAL 1");
        sumarDos.setearValorInicial(1);
        sumarDos.reiniciar();
        for (int i = 0; i<4; i++){
            System.out.println(sumarDos.valorSiguiente());
        }

        System.out.println("IMPRIMIR CUATRO VEZ SUMATORIA DE 3, VALOR INICIAL CERO");
        for (int i = 0; i<4; i++){
            System.out.println(sumarTres.valorSiguiente());
        }

    }
}
