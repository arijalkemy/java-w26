package org.example;

public class App 
{
    public static void main( String[] args )
    {
        String ciudades[] = {"Londres","Madrid","Nueva York","Buenos Aires","Asunción","São Paulo","Lima","Santiago de Chile","Lisboa","Tokio"};
        int temperaturas[][] = {{-2,33},{-3,32},{-8,27},{4,37},{6,42},{5,43},{0,39},{-7,26},{-1,31},{-10,35}};
        int menor = temperaturas[0][0]; //f,c
        int mayor = temperaturas[0][1];
        String nombreMenor = "";
        String nombreMayor = "";

        for (int i = 0; i < temperaturas.length; i++) {
            if (temperaturas[i][0] < menor) {
                nombreMenor = ciudades[i];
                menor = temperaturas[i][0];
            }
            if (temperaturas[i][1] > mayor) {
                nombreMayor = ciudades[i];
                mayor = temperaturas[i][1];
            }
        }
        System.out.println(temperaturas.length);
        System.out.println("La temperatura menor es: " + menor + " de la ciudad: " + nombreMenor);
        System.out.println("La temperatura mayor es: " + mayor + " de la ciudad: " + nombreMayor);
    }
}
