package Java.Bootcamp;

import java.util.Scanner;

public class PracticeBasic {

    public static void main(String[] args) {

        String[] cities = {
                "Londres", "Madrid",
                "Nueva York", "Buenos Aires",
                "Asunción", "Sao Paulo",
                "Lima", "Santiago de Chile",
                "Lisboa", "Tokio"
        };

        int[][] temperatures = {
                { -2, 33 },
                { -3, 32 },
                { -8, 27 },
                { 4, 37 },
                { 6, 42 },
                { 5, 43 },
                { 0, 39 },
                { -7, 26 },
                { -1, 31 },
                { -10, 35 } };

        Scanner scn = new Scanner(System.in);
        boolean op = true;

        int cityIndex = 0;
        int higherTemp = Integer.MIN_VALUE;
        int lowerTemp = Integer.MAX_VALUE;

        while (op) {
            System.out.println();
            System.out.println("Bienvenido al ejercicio número 1" + "\n" +
                    "Elige una opción: " + "\n" +
                    "1. Consultar temperatura máxima y mínima de una ciudad" + "\n" +
                    "2. Consultar mayor temperatura" + "\n" +
                    "3. Consultar menor temperatura" + "\n" +
                    "4. Salir");
            System.out.print(">_ ");
            int option = scn.nextInt();
            scn.nextLine();

            switch (option) {
                case 1:
                    System.out.println();
                    System.out.println("¿De qué ciudad quieres saber la temperatura?");
                    String city = scn.nextLine();

                    for (int i = 0; i < cities.length; i++) {
                        if (city.equalsIgnoreCase(cities[i])) {
                            cityIndex = i;
                        } else {
                            System.out.println("La ciudad no fue encontrada en la lista");
                        }
                    }

                    for (int i = 0; i < temperatures.length; i++) {
                        if (cityIndex == i) {
                            System.out.println();
                            System.out.println("Las temperaturas en " + city + " son: " + "\n"
                                    + "Min: " + temperatures[i][0] + "\n"
                                    + "Max: " + temperatures[i][1] + "\n");
                        }
                    }

                    break;

                case 2:
                    for (int i = 0; i < temperatures.length; i++) {
                        if (temperatures[i][1] > higherTemp) {
                            higherTemp = temperatures[i][1];
                            cityIndex = i;
                        }
                    }

                    System.out.println();
                    System.out.println("La temperatura máxima se encontró en " + cities[cityIndex]
                            + ", con una temperatura de " + higherTemp);

                    break;
                case 3:
                    for (int i = 0; i < temperatures.length; i++) {
                        if (temperatures[i][0] < lowerTemp) {
                            lowerTemp = temperatures[i][0];
                            cityIndex = i;
                        }
                    }

                    System.out.println();
                    System.out.println("La temperatura mínima se encontró en " + cities[cityIndex]
                            + ", con una temperatura de " + lowerTemp);
                    break;
                case 4:
                    op = false;
                    break;

                default:
                    System.out.println("Opción incorrecta!");
                    break;
            }
        }

        scn.close();

    }

}
