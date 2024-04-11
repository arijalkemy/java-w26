public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        String[] ciudades = {
                "Londres", "Madrid", "Nueva York", "Buenos Aires", "Asunción",
                "São Paulo", "Lima", "Santiago de Chile", "Lisboa", "Tokio"
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

        int indiceTemperaturaMaxima = 0;
        int indiceTemperaturaMinima = 0;
        int temperaturaMaxima = temperaturas[0][1];
        int temperaturaMinima = temperaturas[0][0];

        for (int i = 0; i < ciudades.length;i++){
            if (temperaturas[i][1] > temperaturaMaxima){
                temperaturaMaxima = temperaturas[i][1];
                indiceTemperaturaMaxima = i;
            }
            if (temperaturas[0][0] < temperaturaMinima){
                temperaturaMinima = temperaturas[i][0];
                indiceTemperaturaMinima = i;
            }
        }

        String ciudadTemperaturaMin = ciudades[indiceTemperaturaMinima];
        String ciudadTemperaturaMax = ciudades[indiceTemperaturaMaxima];

        System.out.println("La menor temperatura la tuvo "+ciudadTemperaturaMin+" con "+temperaturaMinima+".");
        System.out.println("La máxima temperatura la tuvo "+ciudadTemperaturaMax+" con "+temperaturaMaxima+".");

    }
}