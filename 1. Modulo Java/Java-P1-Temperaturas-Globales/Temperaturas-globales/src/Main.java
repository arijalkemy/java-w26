import java.util.*;

public class Main {

    public static void main(String[] args) {
        String[] ciudades = new String[]{"Londres", "Madrid", "Nueva York","Buenos Aires","Asunción","São Paulo",
                "Lima", "Santiago de Chile", "Lisboa","Tokio"};

        int[][] temperaturas = new int[][]{{-2, 33},{-3, 32},{-8, 27},{4, 37},{6, 42},{5, 43},{0, 39},
                {-7, 26},{-1, 31},{-10 ,35}};

        String ciudadMinima = "";
        String ciudadMaxima = "";

        // Inicializo temperaturas minimas y maximas
        int temperaturaMinima = Integer.MAX_VALUE;
        int temperaturaMaxima = Integer.MIN_VALUE;

        // Itera sobre las ciudades y sus temperaturas
        for (int i = 0; i < ciudades.length; i++) {
            int temperaturaMinimaCiudad = temperaturas[i][0];
            int temperaturaMaximaCiudad = temperaturas[i][1];

            // Comprueba temperatura minima
            if (temperaturaMinimaCiudad < temperaturaMinima) {
                temperaturaMinima = temperaturaMinimaCiudad;
                ciudadMinima = ciudades[i];
            }

            // Comprueba temperatura maxima
            if (temperaturaMaximaCiudad > temperaturaMaxima) {
                temperaturaMaxima = temperaturaMaximaCiudad;
                ciudadMaxima = ciudades[i];
            }
        }

        // Imprime los resultados finales
        System.out.println("La temperatura mínima fue " + temperaturaMinima + " en " + ciudadMinima);
        System.out.println("La temperatura máxima fue " + temperaturaMaxima + " en " + ciudadMaxima);
    }
}