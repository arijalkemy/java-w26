public class Main {
    public static void main(String[] args) {
        //declaración de vector y matriz
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

        int menorTemperatura = temperaturas[0][0];
        int mayorTemperatura = temperaturas[0][1];
        String ciudadMenorTemperatura = ciudades[0];
        String ciudadMayorTemperatura = ciudades[0];
// recorrer la matriz de temperaturas y evaluar si es la mayor o menor temperatura
        for (int i = 1; i < ciudades.length; i++) {
            if (temperaturas[i][0] < menorTemperatura) {
                menorTemperatura = temperaturas[i][0];
                ciudadMenorTemperatura = ciudades[i];
            }
            if (temperaturas[i][1] > mayorTemperatura) {
                mayorTemperatura = temperaturas[i][1];
                ciudadMayorTemperatura = ciudades[i];
            }
        }
        // imprimir los resultados
        System.out.println("La menor temperatura la tuvo " + ciudadMenorTemperatura + " con " + menorTemperatura + "°C");
        System.out.println("La mayor temperatura la tuvo " + ciudadMayorTemperatura + " con " + mayorTemperatura + "°C");
    }
}