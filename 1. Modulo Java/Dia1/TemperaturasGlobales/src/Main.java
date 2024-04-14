public class Main {
    public static void main(String[] args) {
        // Declarar los nombres de las ciudades
        String[] ciudades = {"Londres", "Madrid", "Nueva York", "Buenos Aires", "Asunción", "São Paulo", "Lima", "Santiago de Chile", "Lisboa", "Tokio"};

        // Declarar la matriz de temperaturas máximas y mínimas
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

        // Inicializar variables para almacenar la temperatura máxima y mínima y sus respectivas ciudades
        int temperaturaMaxima = Integer.MIN_VALUE;
        int temperaturaMinima = Integer.MAX_VALUE;
        String ciudadTemperaturaMaxima = "";
        String ciudadTemperaturaMinima = "";

        // Iterar sobre la matriz para encontrar la temperatura máxima y mínima, junto con el nombre de la ciudad correspondiente
        for (int i = 0; i < temperaturas.length; i++) {
            if (temperaturas[i][1] > temperaturaMaxima) {
                temperaturaMaxima = temperaturas[i][1];
                ciudadTemperaturaMaxima = ciudades[i];
            }
            if (temperaturas[i][0] < temperaturaMinima) {
                temperaturaMinima = temperaturas[i][0];
                ciudadTemperaturaMinima = ciudades[i];
            }
        }

        // Imprimir los resultados
        System.out.println("La temperatura máxima registrada fue de " + temperaturaMaxima + " ºC en la ciudad de " + ciudadTemperaturaMaxima);
        System.out.println("La temperatura mínima registrada fue de " + temperaturaMinima + " ºC en la ciudad de " + ciudadTemperaturaMinima);
    }
}

