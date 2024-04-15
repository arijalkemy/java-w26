package org.example;

import java.util.Scanner;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        /*
         * # Agregar una clase que permita realizar las siguientes consultas sobre los localizadores vendidos, empleando diferentes métodos que muestren:
         *
         * - Cantidad de localizadores vendidos.
         * - Cantidad total de reservas.
         * - Obtener un diccionario de todas las reservas clasificados por tipo (hotel, boleto,comida,transporte).
         * - Total de ventas.
         * - Promedio de todas las ventas.
         */
        Scanner userInput = new Scanner(System.in);
        Repository repo = new Repository();
        boolean runApp = true;
        while (runApp) {
            System.out.println("1) Registrar paquete\n" +
                    "2) Ver resumen\n" +
                    "3) Salir");
            System.out.println("Selecciona una opcion:");
            short option = userInput.nextShort();
            if (option == 1) {
                repo.appFlow();
            } else if(option == 2){
                System.out.println(repo.getSummary());
            } else {
                runApp = false;
            }
        }
    }
}
