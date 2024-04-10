public class Main {
    public static void main(String[] args) {

//      Vector de ciudades
        String[] ciudades = {"Londres", "Madrid", "Nueva York", "Buenos Aires", "Asunción", "Sao Paulo", "Lima", "Santiago de Chile", "Lisboa", "Tokio"};

//      Matriz de temperatura
        int[][] temperaturas = {
                {-2, 33},
                {-3, 32},
                {-8, 27},
                {4, 37},
                {6, 42},
                {5, 43},
                {0, 39},
                {-7, 26},
                {-1, 31},
                {-10, 35}
        };

//      Inicializacion de variables de temperatura minima y maxima con sus respectivas ciudades
        double tempMax = temperaturas[0][0];
        double tempMin = temperaturas[0][1];
        String ciudadTempMax = ciudades[0];
        String ciudadTempMin = ciudades[1];

//      Iteracion de la matriz de temperatura
        for (int i = 0; i < temperaturas.length; i++) {

//          Buscar entre las temperaturas mas altas
            if (temperaturas[i][1] > tempMax) {

//              Asignar la temperatura maxima encontrada a la variable de tempMax
                tempMax = temperaturas[i][1];

//              Asignar la ciudad correspondiente a la temperatura maxima encontrada
                ciudadTempMax = ciudades[i];
            }

//          Buscar entre las temperaturas mas bajas
            if(temperaturas[i][0] < tempMin){

//              Asignar la temperatura minima encontrada a la variable de tempMin
                tempMin = temperaturas[i][0];

//              Asignar la ciudad correspondiente a la temperatura minima encontrada
                ciudadTempMin = ciudades[i];
            }
        }

//      Mostrar las temperaturas con la ciudad correspondiente
        System.out.println("La temperatura mas baja es de " + tempMin + " en la ciudad " + ciudadTempMin);
        System.out.println("La temperatura mas alta es de " + tempMax + " en la ciudad " + ciudadTempMax);
    }
}