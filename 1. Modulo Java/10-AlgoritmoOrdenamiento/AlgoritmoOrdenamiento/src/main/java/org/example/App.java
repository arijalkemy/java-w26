package org.example;

import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        SerieMultiplos serieMultiplos = new SerieMultiplos();
        System.out.println("Ingrese un numero para hacer su serie");
        Scanner scanner = new Scanner(System.in);
        serieMultiplos.numeroInicial(scanner.nextInt());
        Integer siguiente = serieMultiplos.siguienteNumero(serieMultiplos.getValorInicial().intValue());
        do {
            System.out.println(siguiente);
            siguiente = serieMultiplos.siguienteNumero(siguiente);
        } while (siguiente <30);

        /*System.out.println("¿Desea otro número? (Y/N)");
        String rta = scanner.next();
        if(rta == "Y"){

        }*/
    }
}
