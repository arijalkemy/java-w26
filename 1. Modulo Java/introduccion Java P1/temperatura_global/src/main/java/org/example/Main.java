package org.example;

public class Main {
    public static void main(String[] args) {
        int mayor[] = {-1,(int) Double.NEGATIVE_INFINITY};
        int menor[] = {-1, (int) Double.POSITIVE_INFINITY};
        String ciudades[] = {"Londres","Madrid","Nueva York","Buenos Aires","Asunción","São Paulo","Lima","Santiago de Chile","Lisboa","Tokio"};
        int temperaturas[][] = {{-2,33},{-3,32},{-8,27},{4,37},{6,42},{5,43},{0,39},{-7,26},{-1,31},{-10,35}};

        for(int f=0; f < temperaturas.length; f++){

            if(temperaturas[f][0] < menor[1]){
                menor[0]=f;
                menor[1]=temperaturas[f][0];
            }
            if(temperaturas[f][1] > mayor[1]){
                mayor[0]=f;
                mayor[1]=temperaturas[f][1];
            }
        }
        System.out.println("La menor temperatura la tuvo "+ciudades[menor[0]]+", con "+menor[1]+" º C.");
        System.out.println("La mayor temperatura la tuvo "+ciudades[mayor[0]]+", con "+mayor[1]+" º C.");
    }
}