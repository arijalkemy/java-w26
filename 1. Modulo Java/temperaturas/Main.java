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

        int temperaturaMinima = temperaturas[0][0];
        int temperaturaMaxima = temperaturas[0][1];

        String ciudadTemperaturaMinima = "";
        String ciudadTemperaturaMaxima = "";

        for (int i = 0; i < temperaturas.length; i++) {
            if (temperaturas[i][0] < temperaturaMinima) {
                ciudadTemperaturaMinima = ciudades[i];
                temperaturaMinima = temperaturas[i][0];
            }
            if (temperaturas[i][1] > temperaturaMaxima) {
                ciudadTemperaturaMaxima = ciudades[i];
                temperaturaMaxima = temperaturas[i][1];
            }
        }

        System.out.println("La menor temperatura la tuvo " + ciudadTemperaturaMinima +" con "+ temperaturaMinima + "°C" );
        System.out.println("La mayor temperatura la tuvo " + ciudadTemperaturaMaxima +" con "+ temperaturaMaxima + "°C" );

    }
}