package org.example;

import org.example.Clases.SerieProgresiva;

import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {

        SerieProgresiva serie = new SerieProgresiva(1.0);

        int opcion = -1;
        Scanner d = new Scanner(System.in);
        System.out.println("Ingrese cada cuanto quiere que se realice la serie");
        int paso = d.nextInt();
        serie.setPaso(paso);
        System.out.println("Ingrese Valor inicial de la serie");
        serie.setValorInicial(d.nextInt());
        serie.valorSiguiente();

        while (opcion != 0)
        {

            System.out.println("Menu");
            System.out.println("1. Siguiente Valor de la serie");
            System.out.println("2. Setear Valor inicial (Reinicia toda la serie)");
            System.out.println("3. Reiniciar Serie");
            System.out.println("4. Cambiar cada cuanto quiere que se realice la serie (Paso), Se debe setear un nuevo valor inicial!!!!");
            System.out.println("0. Cerrar programa");

            System.out.println("Ingrese opcion");
            opcion = d.nextInt();

            switch (opcion){
                case 1:
                    System.out.println(serie.valorSiguiente());
                    break;

                case 2:
                    System.out.println("Ingrese nuevo valor inicial");
                    int valorInicial = d.nextInt();
                    serie.setValorInicial(valorInicial);
                    serie.valorSiguiente();
                    System.out.println("Valor inicial establecido en: " + valorInicial);
                    break;
                case 3:
                    serie.reiniciarSerie();
                    System.out.println("Serie reiniciada");
                    System.out.println("Ingrese nuevo valor inicial");
                    serie.setValorInicial(d.nextInt());
                    serie.valorSiguiente();
                    break;
                case 4:
                    System.out.println("Ingrese nuevo Paso");
                    int nuevoPaso = d.nextInt();
                    serie.setPaso(nuevoPaso);
                    System.out.println("Ingrese nuevo valor inicial");
                    serie.setValorInicial(d.nextInt());
                    serie.valorSiguiente();
                    break;
                case 0:
                    opcion = 0;
                    break;
                default:
                    System.out.println("Opcion no valida ingrese otra");
            }
        }

    }
}
