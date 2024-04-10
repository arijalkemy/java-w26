public class Main {
    public static void main(String[] args) {
        String ciudades[] = {
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

        int temperaturas[][] = {
                {-2, -3, -8, 4, 6, 5, 0, -7, -1, -10},
                {33, 32, 27, 37, 42, 43, 39, 26, 31, 35}
        };
        int ciudadesLen = ciudades.length;
        int maxTemp = temperaturas[1][0];
        int maxCiudad=0; // indice de la ciudad con temperatura mas alta

        int minTemp = temperaturas[0][0];
        int minCiudad=0;

            //buscamos la mas alta

            for (int k =0; k<ciudadesLen;k++){
                if (maxTemp<temperaturas[1][k]){
                    maxTemp= temperaturas[1][k];
                    maxCiudad= k;
                }
            }
            //buscamos la mas chica

            for (int k =0; k<ciudadesLen;k++){
                if (minTemp>temperaturas[0][k]){
                    minTemp= temperaturas[0][k];
                    minCiudad= k;
                }
            }

        System.out.println(ciudades[minCiudad]+" tuvo la temperatura mas baja con " + minTemp + " grados y "+ ciudades[maxCiudad] + " la mas alta con " + maxTemp + " grados.");
    }
}
