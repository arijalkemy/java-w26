package org.example;


/**
 * Hello world!
 *
 */
public class Main
{
    public static void main( String[] args )
    {
        Persona persona1 = new Persona();
        Persona persona2 = new Persona("juan", 23, "1233123");
        Persona persona3 = new Persona("juan", 23, "1233123", 60, 1.70);
        //Persona persona4 = new Persona("JUAN", 23); -> NO ES POSIBLE PORQUE EL CONSTRUCTOR NO EXISTE
        System.out.println(persona3.esMayorDeEdad() ? "Es mayor de edad" : "No es mayor de edad");

        System.out.println("------ Persona 1 -----");
        System.out.println(persona3.toString());
        System.out.println(persona3.esMayorDeEdad() ? "Es mayor de edad" : "No es mayor de edad");
        switch (persona3.calcularImc()) {
            case -1:
                System.out.println("La persona esta por debajo de su peso ideal");
                break;
            case 0:
                System.out.println("La persona esta en su peso ideal");
                break;
            case 1:
                System.out.println("La persona esta por encima de su peso ideal");
                break;
        }
    }
}
