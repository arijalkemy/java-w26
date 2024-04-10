package meli.bootcamp;

public class Main {
    public static void main(String[] args) {
        exercise2();
    }

    private static void exercise1() {
        String[] cities = {
                "Londres",
                "Madrid",
                "Nueva York",
                "Buenos Aires",
                "Asuncion",
                "Sao Paulo",
                "Lima",
                "Santiago de Chile",
                "Lisboa",
                "Tokio"
        };

        int[][] temperatures = {
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

        int[] highest = {/* city index */ 0, temperatures[0][1]};
        int[] lowest = {/* city index */ 0, temperatures[0][0]};

        for (int i = 0; i < temperatures.length; i++) {
            if (temperatures[i][1] > highest[1]) {
                highest[1] = temperatures[i][1];
                highest[0] = i;
            }

            if (temperatures[i][0] < lowest[1]) {
                lowest[1] = temperatures[i][0];
                lowest[0] = i;
            }
        }

        System.out.println("La temperatura más alta es: " + highest[1] + " en : " + cities[highest[0]]);
        System.out.println("La temperatura más baja es: " + lowest[1] + " en : " + cities[lowest[0]]);
    }


    public static void exercise2() {
        int[] serviciosCli = {1,1,2,2,2,1,2};
        double totalFactura;
        double seguridadConCamaras = 1500;
        double patrullaje = 700;

        for (int j : serviciosCli) {
            totalFactura = seguridadConCamaras;

            if (j != 1) {
                totalFactura += patrullaje;
            }

            System.out.println("El tipo de servicio es: " + j);
            System.out.println("El monto de la factura es de: " + totalFactura);
        }
    }

}