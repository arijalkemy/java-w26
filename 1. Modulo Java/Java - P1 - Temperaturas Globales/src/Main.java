public class Main {
    public static void main(String[] args) {
        String cities[] = {
                "Londres",
                "Madrid",
                "Nueva York",
                "Buenos Aires",
                "Asunción",
                "Sao Paulo",
                "Lima",
                "Santiago de Chile",
                "Lisboa",
                "Tokio"
        };
        int temps[][] = {
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

        int min = 9999;
        int max = -9999;

        int cityMin = 0;
        int cityMax = 0;

        for (int i = 0; i < temps.length; i++) {
            if (min > temps[i][0]) {
                min = temps[i][0];
                cityMin = i;
            }

            if (max < temps[i][1]) {
                max = temps[i][1];
                cityMax = i;
            }
        }

        System.out.println("La temperatura mínima se resgitró en " + cities[cityMin] + " y fue de: " + min);
        System.out.println("La temperatura máxima se registró en " + cities[cityMax] + " y fue de: " + max);
    }
}