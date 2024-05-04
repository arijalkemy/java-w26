package com.meli;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase principal de la aplicación.
 */
public class Main {
    /**
     * Método principal de la aplicación.
     * @param args Los argumentos de la línea de comandos.
     */
    public static void main(String[] args) {

        // Crear tres instancias de la clase Persona
        Persona persona1 = new Persona("Juan", 30, "12345678", 80, 1.80);
        Persona persona2 = new Persona("Pedro", 40, "87654321");
        Persona persona3 = new Persona();

        // Crear una lista para almacenar las instancias de Persona
        List<Persona> personas = new ArrayList<>();

        // Agregar las instancias de Persona a la lista
        personas.add(persona1);
        personas.add(persona2);
        personas.add(persona3);

        // Inicializar un contador para el bucle
        int i = 1;

        // Bucle a través de la lista de Personas
        for(Persona persona : personas){

            // Imprimir los detalles de cada Persona
            System.out.println("------ Persona "+i+" -----");
            System.out.println(persona.toString());
            System.out.println(persona.esMayorDeEdad() ? "Es mayor de edad" : "No es mayor de edad");

            // Calcular e imprimir el estado del IMC de cada Persona
            switch (persona.calcularIMC()) {
                case -1:
                    System.out.println("La persona está por debajo de su peso ideal");
                    break;
                case 0:
                    System.out.println("La persona está en su peso ideal");
                    break;
                case 1:
                    System.out.println("La persona está por encima de su peso ideal");
                    break;
            }

            // Incrementar el contador
            i++;
        }
    }
}