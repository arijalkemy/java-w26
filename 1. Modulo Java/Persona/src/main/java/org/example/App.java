package org.example;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Persona anonima = new Persona();
        Persona paco = new Persona("Paco",21,"123456789");
        Persona jose = new Persona("Jose",19,"987654321",78,1.78);
        System.out.print(jose.evaluarIMC(jose.calcularIMC()));
        System.out.print(jose.toString());
    }
}
