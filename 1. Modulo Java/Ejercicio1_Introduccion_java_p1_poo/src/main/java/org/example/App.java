package org.example;

/**
 * Nombre del Ejercicio de Consola: “Diseño de Clases y Métodos”
 */
public class App 
{
    public static void main( String[] args )
    {
        //Creacion del objeto
        Automovil miAutomovil = new Automovil("Suzuki", "Negro", 100);
        System.out.println(miAutomovil.mostrarMarcaYColor());

    }
}
