package org.example;

/**
 * Hello world!
 *
 */
public class Main
{
    public static void main( String[] args )
    {
        Persona Alejandra = new Persona();
        Persona Nicolas = new Persona("Nombre", 28, "1083637378");
        Persona Mario = new Persona("Mario", 28, "1292937372", 71.5, 1.76);

        //Persona Ivan = new Persona("Ivan", 23); Error, no encuentra costrucctor


        System.out.println(Mario.calcularIMC());
        System.out.println(Mario.esMayorDeEdad());

        System.out.println(Mario);

    }
}
