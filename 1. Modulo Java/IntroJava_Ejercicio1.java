public class IntroJava_Ejercicio1 {
    public static void main(String[] args) {
        // Ejercicio

        String[] ciudades = {"Londres", "Madrid", "Nueva York", "Buenos Aires", "Asunción", "São Paulo", "Lima", "Santiago de Chile", "Lisboa", "Tokio"};

        int[][] temperaturas = {
            {-2, 33},
            {-3, 32},
            {-8, 27},
            {4, 37},
            {6, 42},
            {5,43},
            {0,39},
            {-7,26},
            {-1,31},
            {-10,35}
        };

        int tempMax = Integer.MIN_VALUE;
        int tempMin = Integer.MAX_VALUE;
        String ciudadMax = "";
        String ciudadMin = "";

        for (int i = 0; i < ciudades.length; i++) {
            int tempMaxCiudad = temperaturas[i][0];
            int tempMinCiudad = temperaturas[i][1];

            if (tempMaxCiudad > tempMax) {
                tempMax = tempMaxCiudad;
                ciudadMax = ciudades[i];
            }

            if (tempMinCiudad < tempMin) {
                tempMin = tempMinCiudad;
                ciudadMin = ciudades[i];
            }
        }

        System.out.println("La ciudad con la temperatura más alta es: " + ciudadMax + " con " + tempMax + " grados");
        System.out.println("La ciudad con la temperatura más baja es: " + ciudadMin + " con " + tempMin + " grados");
    }
}
