package org.bootcamp;

import org.bootcamp.domain.Persona;

/**
 * @author Jhonatan Sanchez
 * @author Aldo Bornacelly
 */
public class Main
{
    public static void main(String[] args) {
        // Se instancian los objetos
        Persona persona1 = new Persona();
        Persona persona2 = new Persona("juan", 23, "1233123");
        Persona persona3 = new Persona("juan", 23, "1233123", 60, 1.70);
        // Persona que no es posible instancia porque el metodo constructor no existe
        //Persona persona4 = new Persona("JUAN", 23);
        // Persona que genera exception por la altura en 0
        //Persona persona5 = new Persona("juan", 23, "1233123", 60, 0);
        //int valorIMC = persona5.calcularIMC();

        // Se imprime la informacion de la persona y se valida si es mayor de edad
        imprimir(persona3.toString());
        imprimir(persona3.esMayorDeEdad() ? "Es mayor de edad" : "No es mayor de edad");

        // Se realiza el calculo del IMC de la persona
        switch (persona3.calcularIMC()) {
            case -1:
                System.out.println("La persona esta por debajo de su peso ideal.");
                break;
            case 0:
                System.out.println("La persona esta en su peso ideal.");
                break;
            case 1:
                System.out.println("La persona esta por encima de su peso ideal.");
                break;
        }
    }

    /**
     * Metodo que realiza la impresion por pantalla de un texto
     * @param texto de valor String a imprimir
     */
    private static void imprimir(String texto){
        System.out.println(texto);
    }
}
