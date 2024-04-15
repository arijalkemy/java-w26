package org.example;

public class App 
{
    public static void main( String[] args )
    {
        String ciudades[] = {"Londres","Madrid","Nueva York","Buenos Aires","Asunción","São Paulo","Lima","Santiago de Chile","Lisboa","Tokio"}; //declaracion y asignar ciudades
        int temperaturas[][] = {{-2,33},{-3,32},{-8,27},{4,37},{6,42},{5,43},{0,39},{-7,26},{-1,31},{-10,35}};//declaracion e inicializacion de temperaturas
        int temperaturaMax=temperaturas[0][1]; //variable para temperatura max
        int temperaturaMin=temperaturas[0][0]; //variable para temperatura minima
        int cMax=0,cMin=0; //variable para indice de variables
        for(int i=0; i<temperaturas.length;i++){ //array para recorrer las temperaturas
            if(temperaturas[i][0]<temperaturaMin){ //if para buscar la temperatura minima
                temperaturaMin=temperaturas[i][0];
                cMin=i;
            }
            if(temperaturas[i][1]>temperaturaMax){ //if para buscar la temperatura maxima
                temperaturaMax=temperaturas[i][1];
                cMax=i;
            }
        }
        //imprimimos en pantalla
        System.out.println("La temperatura Maxima es de "+temperaturaMax+" en "+ ciudades[cMax]);
        System.out.println("La temperatura Minima es de "+temperaturaMin+" en "+ ciudades[cMin]);
    }
}
