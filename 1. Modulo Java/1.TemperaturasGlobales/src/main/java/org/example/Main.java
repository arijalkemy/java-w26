package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// k the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static void main(String[] args) {
        // se establecen las ciudades
        String[] ciudades = {"Londres", "Madrid", "Nueva York", "Buenos Aires", "Asunción", "São Paulo", "Lima", "Santiago de Chile", "Lisboa", "Tokio"};
        // se establecen las tempraturas
        int[][] temperaturas = {{-2, -3, -8, 4, 6, 5, 0, -7, -1, -10}, {33, 32, 27, 37, 42, 43, 39, 26, 31, 35}};

        //cadenas para guardar el nombre de la ciudad con el maximo y el minimo, se eincializa con la primera
        String ciudadMaximoGlobal = ciudades[0];
        String ciudadMinimoGlobal = ciudades[0];
        //se setea la primera temperatura minmima y maxima como las maximas globales
        double tempMinGlobal = temperaturas[0][0];
        double tempMaxGlobal = temperaturas[1][0];


        for (int i = 0; i < ciudades.length; i++) {

            int temperaturaMinimaLocal = temperaturas[0][i];
            int temperaturaMaximaLocal = temperaturas[1][i];

            if (temperaturaMinimaLocal < tempMinGlobal) {
                tempMinGlobal = temperaturaMinimaLocal;
                ciudadMinimoGlobal = ciudades[i];
            }

            if (temperaturaMaximaLocal > tempMaxGlobal) {
                tempMaxGlobal = temperaturaMaximaLocal;
                ciudadMaximoGlobal = ciudades[i];
            }

        }

        System.out.println("ciudad de temperatura Minima: " + ciudadMinimoGlobal + " con " + tempMinGlobal + "°");
        System.out.println("ciudad de temperatura Maxima: " + ciudadMaximoGlobal + " con " + tempMaxGlobal + "°");
    }
}