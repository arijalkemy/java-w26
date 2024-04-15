package org.example;

import java.util.Arrays;

public class App
{
    public static void main( String[] args )
    {
        int[] arregloEnteros = {5, 7, 3, 2, 0, 1, 9};
        arregloEnteros=burbuja(arregloEnteros);

        System.out.println("Ordenamiento de valores de un arreglo");
        for (int i = 0; i < arregloEnteros.length; i++) {
            System.out.println(arregloEnteros[i]);
        }
    }

    public static int[] burbuja (int[] var){
        return Arrays.stream(var).sorted().toArray();
    }
}
