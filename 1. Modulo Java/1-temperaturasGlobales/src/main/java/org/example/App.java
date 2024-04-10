package org.example;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {

        // Consigna: Se necesita conocer la mayor y la menor temperatura entre todas las ciudades; al mismo tiempo se deberá especificar el nombre de la ciudad.

        String ciudades[] = {"Londres","Madrid","Nueva York","Buenos Aires","Asunción","São Paulo","Lima","Santiago de Chile","Lisboa","Tokio"};
        int temps[][] = {{-2,33},{-3,32},{-8,27},{4,37},{6,42},{5,43},{0,39},{-7,26},{-1,31},{-10,35}};

        int menorTemp = temps[0][0];
        int mayorTemp = temps[0][1];

        int iCiudadMenor = 0;
        int iCiudadMayor = 0;

        for (int i = 0; i < ciudades.length ; i++) {
            if (temps[i][0] < menorTemp) {
                menorTemp = temps[i][0];
                iCiudadMenor = i;
            }
            if (temps[i][1] > mayorTemp) {
                mayorTemp = temps[i][1];
                iCiudadMayor = i;
            }
        }

        System.out.println("La ciudad con menor temperatura es: " + ciudades[iCiudadMenor] + " con " + menorTemp + " grados");
        System.out.println("La ciudad con mayor temperatura es: " + ciudades[iCiudadMayor] + " con " + mayorTemp + " grados");

    }
}
