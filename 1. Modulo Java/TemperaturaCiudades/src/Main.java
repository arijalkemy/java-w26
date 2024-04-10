

public class Main {
    public static void main(String[] args) {
        String[] ciudades = {"Londres", "Madrid", "Nueva York", "Buenos Aires", "Asuncion", "Sao Paulo",
                "Lima", "Santiago de Chile", "Lisboa", "Tokio"};

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

        int temperaturaMaxima = temperaturas[0][1];
        int temperaturaMinima = temperaturas[0][0];
        String ciudadTemperaturaMaxima = ciudades[0];
        String ciudadTemperaturaMinima = ciudades[0];

        for (int i = 1; i < ciudades.length; i++) {
            if (temperaturas[i][1] > temperaturaMaxima) {
                temperaturaMaxima = temperaturas[i][1];
                ciudadTemperaturaMaxima = ciudades[i];
            }
            if (temperaturas[i][0] < temperaturaMinima) {
                temperaturaMinima = temperaturas[i][0];
                ciudadTemperaturaMinima = ciudades[i];
            }
        }

        System.out.println("La ciudad " + ciudadTemperaturaMinima + " registra la temperatura mas baja con "
                + temperaturaMinima + " Grados Celsius");
        System.out.println("La ciudad " + ciudadTemperaturaMaxima + " registra la temperatura mas alta con "
                + temperaturaMaxima + " Grados Celsius");
    }
}