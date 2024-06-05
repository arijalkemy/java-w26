package org.example;

/**
 * Estructuras de control y Arreglos
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        // Declaracion e inicializacion del vector que almacenan ciudades, y de la matriz con temperaturas minimas y maximas
        String vec_ciudades []= {"Londres", "Madrid", "Nueva York", "Buenos Aires", "Asuncion", "Sao Paulo", "Lima", "Santiago de Chile", "Lisboa", "Tokio"};
        int ma_temperatura [][] = {{-2, 33}, {-3, 32}, {-8,27}, {4,37}, {6,42}, {5, 43}, {0, 39}, {-7, 26}, {-1, 31}, {-10, 35}};
        //Asignacion de valores de menor y mayor temperatura
        int menor_temperatura = ma_temperatura [0][0];
        int mayor_temperatura = ma_temperatura [0][1];

        int pos_menor = 0;
        int pos_mayor = 0;

        for(int j = 0; j < vec_ciudades.length; j++){
            //Verifica la menor temperatura
            if(ma_temperatura [j][0]<menor_temperatura){
                menor_temperatura = ma_temperatura [j][0];
                pos_menor = j;
            }
            //Verifica la mayor temperatura
            if(ma_temperatura [j][1]>mayor_temperatura){
                mayor_temperatura = ma_temperatura [j][1];
                pos_mayor = j;
            }
        }

        System.out.println("La menor temperatura la tuvo " + vec_ciudades[pos_menor] +", con "+ menor_temperatura +"º C.");
        System.out.println("la mayor temperatura la tuvo " + vec_ciudades[pos_mayor] +", con "+ mayor_temperatura +"º C.");
    }
}
