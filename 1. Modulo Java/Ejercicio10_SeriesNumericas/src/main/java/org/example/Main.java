package org.example;

import java.util.Scanner;

public class Main {

    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int opcion;
        while (true) {
            System.out.println("------------------------------------");
            System.out.println("Bienvido, seleccione un tipo de dato");
            System.out.println("------------------------------------");
            System.out.println("1. Integer");
            System.out.println("2. Float");
            System.out.println("3. Double");
            System.out.println("4. Salir");
            opcion = scanner.nextInt();
            if (opcion < 1 || opcion > 4) {
                System.out.println("Opción invalida, vuelva a intenetarlo");
                continue;
            }
            if (opcion == 4) {
                break;
            }
            subMenu(opcion);
        }
    }

    public static void subMenu(int tipoDato) {
        int opcion;
        int rango;
        System.out.println("Seleccione un rango: ");
        rango = scanner.nextInt();

        SerieNumerica serieNumerica;
        if (tipoDato == 1) {
            serieNumerica = new SerieNumericaEnteros(rango);
        } else if (tipoDato == 2) {
            serieNumerica = new SerieNumericaFloat(Float.parseFloat(rango + ""));
        } else {
            serieNumerica = new SerieNumericaDouble(Double.parseDouble(rango + ""));
        }

        while (true) {
            System.out.println("------------------------------------");
            System.out.println("Seleccione una opción");
            System.out.println("------------------------------------");
            System.out.println("1. Obtener siguiente valor");
            System.out.println("2. Reiniciar serie");
            System.out.println("3. Establecer valor inicial");
            System.out.println("4. Salir");
            opcion = scanner.nextInt();
            if (opcion < 1 || opcion > 4) {
                System.out.println("Opción invalida, vuelva a intenetarlo");
                continue;
            }
            if (opcion == 4) {
                break;
            }
            resolverSubMenu(opcion, serieNumerica);
        }
    }

    public static void resolverSubMenu(int opcion, SerieNumerica serieNumerica) {
        if (opcion == 1) {
            System.out.println("\nSiguiente valor: " + serieNumerica.getSiguienteValor() + "\n");
        } else if (opcion == 2) {
            serieNumerica.reiniciarSerie();
        } else {
            System.out.printf("Ingrese el valor inicial: ");
            String valor = scanner.nextLine();
            valor = scanner.nextLine();
            serieNumerica.establecerValorInicial(valor);
        }
    }
}