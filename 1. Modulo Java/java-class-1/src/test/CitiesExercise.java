package test;

public class CitiesExercise {
    public static void main(String[] args) {
        String[] cities = {
                "Londres",
                "Madrid",
                "Nueva York",
                "Buenos Aires",
                "Asunción",
                "São Paulo",
                "Lima",
                "Santiago de Chile",
                "Lisboa",
                "Tokio"
        };

        int[][] temperatures = {
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

        int maxValue = Integer.MIN_VALUE;
        String maxCity = "";
        int minValue = Integer.MAX_VALUE;
        String minCity = "";

        for (int f = 0; f < temperatures.length; f++) {
                if (temperatures[f][0] < minValue) {
                    minValue = temperatures[f][0];
                    minCity = cities[f];
                }
                if (temperatures[f][1] > maxValue) {
                    maxValue = temperatures[f][1];
                    maxCity = cities[f];
                }
        }

        System.out.println("La temperatura máxima entre todas las ciudades fue en " + maxCity + ", con " + maxValue + " grados.");
        System.out.println("La temperatura mínima entre todas las ciudades fue en " + minCity + ", con " + minValue + " grados.");
    }
}
