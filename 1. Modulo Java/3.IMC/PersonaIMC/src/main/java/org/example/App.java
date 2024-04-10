package org.example;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Persona persona1 = new Persona();
        Persona persona2 = new Persona(20, "Luis", "055");
        Persona persona3 = new Persona(15, "Txai", "056", 1.90, 110);

        System.out.println(persona3);
        String mayorEdad = (persona3.esMayorDeEdad()) ? "Es mayor de edad" : "Es menor edad";
        System.out.println(mayorEdad);

        switch (persona3.calcularIMC()){
            case -1:
                System.out.println("Peso bajo");
                break;
            case 0:
                System.out.println("Peso saludable");
                break;
            case 1:
                System.out.println("Sobrepeso");
                break;
            default:
                System.out.println("NONE DATA");
        }
    }
}
