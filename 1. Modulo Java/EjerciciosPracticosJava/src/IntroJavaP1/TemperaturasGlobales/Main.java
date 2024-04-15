package IntroJavaP1.TemperaturasGlobales;

public class Main {
    public static void main(String[] args) {
        String[] ciudades = {
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

        int indiceMax = 0;
        int indiceMin = 0;
        int temperaturaMax = temperaturas[0][1];
        int temperaturaMin = temperaturas[0][0];

        for(int i = 1; i < ciudades.length; i++) {
            if(temperaturas[i][1] > temperaturaMax) {
                indiceMax = i;
                temperaturaMax = temperaturas[i][1];
            }

            if(temperaturas[i][0] < temperaturaMin) {
                indiceMin = i;
                temperaturaMin = temperaturas[i][0];
            }
        }

        System.out.println("Ciudad con menor temperatura: " + ciudades[indiceMin] + " (" + temperaturas[indiceMin][0] + ")");
        System.out.println("Ciudad con mayor temperatura: " + ciudades[indiceMax] + " (" + temperaturas[indiceMax][1] + ")");
    }
}
