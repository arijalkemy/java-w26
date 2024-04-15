package org.example;

public class Main {
    public static void main(String[] args) {
        String ciudades[] = {"Londres","Madrid","Nueva York","Buenos Aires","Asunción","Sao Paulo","Lima","Santiago de Chile","Lisboa","Tokio"};
        int temperaturas[][] = {{-2,33},{-3,32},{-8,27},{4,37},{6,42},{5,43},{0,39},{-7,26},{-1,31},{-10,35}};

        int temperaturaMinima = 0;
        int temperaturaMaxima = 0;
        int indiceMaximo = 0;
        int indiceMinimo = 0;
        for(int f = 0; f<temperaturas.length; f++){
            for(int c = 0; c<temperaturas[f].length;c++)
            {
                if(c==0)
                {
                    if(temperaturaMinima>temperaturas[f][c])
                    {
                        temperaturaMinima = temperaturas[f][c];
                        indiceMinimo = f;
                    }
                }
                else
                {
                    if(temperaturaMaxima<temperaturas[f][c])
                    {
                        temperaturaMaxima = temperaturas[f][c];
                        indiceMaximo = f;
                    }
                }


            }
        }
        System.out.println("La menor temperatura la tuvo " + ciudades[indiceMinimo] + " con " + temperaturaMinima);
        System.out.println("La mayor temperatura la tuvo " + ciudades[indiceMaximo] + " con " + temperaturaMaxima);

    }
}